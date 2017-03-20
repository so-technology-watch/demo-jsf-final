package org.demo.formation.web.jsf.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.demo.data.record.EleveRecord;
import org.demo.formation.web.jsf.util.DemoConstantes;
import org.demo.formation.web.jsf.util.SessionManagerUtils;
import org.demo.persistence.ElevePersistence;
import org.demo.persistence.commons.PersistenceServiceProvider;

@ManagedBean(name = "listUserManagedBean")
public class ListUserManagedBean {

	private ElevePersistence userService = PersistenceServiceProvider.getService(ElevePersistence.class);

	private List<EleveRecord> listeUsers;
	private EleveRecord loginUser;

	public ListUserManagedBean() {
		// On recupere la liste en base
		this.listeUsers = this.userService.findAll();
		loginUser = (EleveRecord) SessionManagerUtils.getObjectInSession(DemoConstantes.USER_SESSION_KEY);
	}

	public String deleteUserById(Integer idUser) {
		if (idUser != null) {
			this.userService.deleteById(idUser);
			return "user-list";
		}
		return "";
	}

	public List<EleveRecord> getListeUsers() {
		return listeUsers;
	}

	public void setListeUsers(List<EleveRecord> listeUsers) {
		this.listeUsers = listeUsers;
	}

	public EleveRecord getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(EleveRecord loginUser) {
		this.loginUser = loginUser;
	}
}
