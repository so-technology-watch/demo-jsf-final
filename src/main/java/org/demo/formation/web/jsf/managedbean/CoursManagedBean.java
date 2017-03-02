package org.demo.formation.web.jsf.managedbean;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.demo.data.record.CoursRecord;
import org.demo.data.record.EleveRecord;
import org.demo.formation.web.jsf.util.DemoConstantes;
import org.demo.formation.web.jsf.util.DepartementEnum;
import org.demo.formation.web.jsf.util.SessionManagerUtils;
import org.demo.persistence.CoursPersistence;
import org.demo.persistence.commons.PersistenceServiceProvider;

@ManagedBean(name = "coursManagedBean")
@ViewScoped
public class CoursManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8437951921380040419L;
	private CoursRecord currentCourse;
	private EleveRecord loginUser;

	private CoursPersistence coursService = PersistenceServiceProvider.getService(CoursPersistence.class);

	public CoursManagedBean() {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String idCoursParam = params.get("idCoursParam");
		if (StringUtils.isNotBlank(idCoursParam)){//On affiche en mode modification
			Integer idCours = Integer.parseInt(idCoursParam);
			this.currentCourse = this.coursService.findById(idCours);
		}else {//On affiche en mode creation
			this.currentCourse = new CoursRecord();
		}
		loginUser = (EleveRecord)SessionManagerUtils.getObjectInSession(DemoConstantes.USER_SESSION_KEY);
	}


	public String addLessonAction(){
		//On cree l'utilisateur 
		try {
			if (currentCourse.getIdCours() != null && currentCourse.getIdCours() >0){
				this.coursService.update(currentCourse);
			}else {
				this.coursService.create(currentCourse);
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(), null));
			return DemoConstantes.MSG_KO;
		}	
		//On recupere la liste en base
		return DemoConstantes.MSG_OK;
	}

	public String loadUserAction(Integer idCours){
		if (idCours != null){
			this.currentCourse = this.coursService.findById(idCours);
		}
		return DemoConstantes.MSG_OK;
	}

	public DepartementEnum[] getDepartements() {
		return DepartementEnum.values();
	}

	public EleveRecord getLoginUser() {
		return loginUser;
	}



	public void setLoginUser(EleveRecord loginUser) {
		this.loginUser = loginUser;
	}


	public CoursRecord getCurrentCourse() {
		return currentCourse;
	}


	public void setCurrentCourse(CoursRecord currentCourse) {
		this.currentCourse = currentCourse;
	}
}
