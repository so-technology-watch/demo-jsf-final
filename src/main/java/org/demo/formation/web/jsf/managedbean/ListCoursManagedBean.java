package org.demo.formation.web.jsf.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.demo.data.record.CoursRecord;
import org.demo.data.record.EleveRecord;
import org.demo.formation.web.jsf.util.DemoConstantes;
import org.demo.formation.web.jsf.util.SessionManagerUtils;
import org.demo.persistence.CoursPersistence;
import org.demo.persistence.commons.PersistenceServiceProvider;

@ManagedBean(name= "listCoursManagedBean")
public class ListCoursManagedBean {

private CoursPersistence coursService = PersistenceServiceProvider.getService(CoursPersistence.class);

private List<CoursRecord> listeCours;
private EleveRecord loginUser;
	
	
	public ListCoursManagedBean(){
		//On recupere la liste en base
		this.listeCours = this.coursService.findAll();
        loginUser = (EleveRecord)SessionManagerUtils.getObjectInSession(DemoConstantes.USER_SESSION_KEY);
	}

	public String deleteCoursById(Integer idUser){
		if (idUser != null){
			this.coursService.deleteById(idUser);
			this.listeCours = this.coursService.findAll();
		}
		return "";
	}

	public EleveRecord getLoginUser() {
		return loginUser;
	}


	public void setLoginUser(EleveRecord loginUser) {
		this.loginUser = loginUser;
	}

	public List<CoursRecord> getListeCours() {
		return listeCours;
	}

	public void setListeCours(List<CoursRecord> listeCours) {
		this.listeCours = listeCours;
	}
}
