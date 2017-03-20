package org.demo.formation.web.jsf.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.demo.data.record.EleveRecord;
import org.demo.data.record.TypesexeRecord;
import org.demo.data.record.listitem.TypesexeListItem;
import org.demo.formation.web.jsf.util.DemoConstantes;
import org.demo.formation.web.jsf.util.SessionManagerUtils;
import org.demo.persistence.ElevePersistence;
import org.demo.persistence.TypesexePersistence;
import org.demo.persistence.commons.PersistenceServiceProvider;

@ManagedBean(name = "userManagedBean")
@ViewScoped
public class UserManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8437951921380040419L;
	private EleveRecord userCourant;
	private boolean isUpdate;
	private EleveRecord loginUser;

	private static List<TypesexeListItem> listTypesexeListItem;
	private TypesexePersistence typesexePersistence = PersistenceServiceProvider.getService(TypesexePersistence.class);
	private ElevePersistence userService = PersistenceServiceProvider.getService(ElevePersistence.class);

	public UserManagedBean() {
		if (listTypesexeListItem == null) {
			initListTypesexeListItem();
		}

		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String idUserParam = params.get("idUserParam");

		if (StringUtils.isNotBlank(idUserParam)) {
			// On affiche en mode modification
			this.userCourant = this.userService.findById(Integer.parseInt(idUserParam));
			this.setUpdate(true);
		} else {
			// On affiche en mode creation
			creatNewUser();
		}
		loginUser = (EleveRecord) SessionManagerUtils.getObjectInSession(DemoConstantes.USER_SESSION_KEY);
	}

	public void creatNewUser() {
		this.userCourant = new EleveRecord();
		this.setUpdate(false);
	}

	public void initListTypesexeListItem() {
		listTypesexeListItem = new ArrayList<TypesexeListItem>();
		for (TypesexeRecord iterateur : typesexePersistence.findAll()) {
			listTypesexeListItem.add(new TypesexeListItem(iterateur));
		}
	}

	public void addUserAction() {
		try {
			if (isUpdate) {
				this.userService.update(userCourant);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "élément mis à jour", null));

			} else {
				userCourant.setDateInscription(new Date());
				this.userService.create(userCourant);
				this.isUpdate = true;
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "élément créer", null));

			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	// Getter & Setter

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

	public static List<TypesexeListItem> getListTypesexeListItem() {
		return listTypesexeListItem;
	}

	public boolean getIsUpdate() {
		return isUpdate;
	}

	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
}
