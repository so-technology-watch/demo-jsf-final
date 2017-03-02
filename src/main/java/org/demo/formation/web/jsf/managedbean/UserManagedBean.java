package org.demo.formation.web.jsf.managedbean;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.demo.data.record.EleveRecord;
import org.demo.formation.web.jsf.util.DemoConstantes;
import org.demo.formation.web.jsf.util.DepartementEnum;
import org.demo.formation.web.jsf.util.SessionManagerUtils;
import org.demo.persistence.ElevePersistence;
import org.demo.persistence.commons.PersistenceServiceProvider;

@ManagedBean(name = "userManagedBean")
@ViewScoped
public class UserManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8437951921380040419L;
	private EleveRecord userCourant;
	private EleveRecord loginUser;

	private ElevePersistence userService = PersistenceServiceProvider.getService(ElevePersistence.class);

	public UserManagedBean() {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String idUserParam = params.get("idUserParam");
		if (StringUtils.isNotBlank(idUserParam)){//On affiche en mode modification
			Integer idUser = Integer.parseInt(idUserParam);
			this.userCourant = this.userService.findById(idUser);
		}else {//On affiche en mode creation
			this.userCourant = new EleveRecord();
		}
		loginUser = (EleveRecord)SessionManagerUtils.getObjectInSession(DemoConstantes.USER_SESSION_KEY);
	}


	public String addUserAction(){
		//On cree l'utilisateur 
		try {
			if (userCourant.getIdEleve() != null && userCourant.getIdEleve() >0){
				this.userService.update(userCourant);
			}else {
				userCourant.setDateInscription(new Date());
				this.userService.create(userCourant);
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(), null));
			return DemoConstantes.MSG_KO;
		}	
		//On recupere la liste en base
		return DemoConstantes.MSG_OK;
	}

	public String loadUserAction(Integer idUser){
		if (idUser != null){
			this.userCourant = this.userService.findById(idUser);
		}
		return DemoConstantes.MSG_OK;
	}

	public DepartementEnum[] getDepartements() {
		return DepartementEnum.values();
	}

	public EleveRecord getUserCourant() {
		return userCourant;
	}

	public void setUserCourant(EleveRecord userCourant) {
		this.userCourant = userCourant;
	}



	public EleveRecord getLoginUser() {
		return loginUser;
	}



	public void setLoginUser(EleveRecord loginUser) {
		this.loginUser = loginUser;
	}
}
