package org.demo.formation.web.jsf.managedbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.demo.data.record.CoursRecord;
import org.demo.data.record.EleveRecord;
import org.demo.data.record.NoteRecord;
import org.demo.formation.web.jsf.util.DemoConstantes;
import org.demo.formation.web.jsf.util.SessionManagerUtils;
import org.demo.persistence.CoursPersistence;
import org.demo.persistence.ElevePersistence;
import org.demo.persistence.NotePersistence;
import org.demo.persistence.commons.PersistenceServiceProvider;

@ManagedBean(name = "noteManagedBean")
@RequestScoped
public class NoteManagedBean {
	//Note courante
	private NoteRecord currentNote;
	//Liste des services d'accès à la couche métier
	private ElevePersistence userService = PersistenceServiceProvider.getService(ElevePersistence.class);
	private CoursPersistence coursService = PersistenceServiceProvider.getService(CoursPersistence.class);
	private NotePersistence noteService = PersistenceServiceProvider.getService(NotePersistence.class);
	private EleveRecord loginUser;
	//Pour afficher la liste des cours
	private List<CoursRecord> coursList;
	//Pour alimenter la liste des étudiants presents en base
	private List<EleveRecord> studentList;
	//Permettant de savoir si une Note est en mode I/U (utile dans ce cas puisqu'on a une clé doublon)
	private boolean updateMode;


	public NoteManagedBean(){
		this.currentNote = new NoteRecord();
		this.loginUser = (EleveRecord)SessionManagerUtils.getObjectInSession(DemoConstantes.USER_SESSION_KEY);
		this.coursList = this.coursService.findAll();
		this.studentList = this.userService.findAll();
	}


	public String addNoteAction(){
		try {
			//On cree l'utilisateur 
			if (this.updateMode){
				this.noteService.update(currentNote);
			}else {
				NoteRecord noteRecordExistant = this.noteService.findById(currentNote.getIdCours(), currentNote.getIdEleve());
				if (noteRecordExistant == null) { //On ne cree que s'il n'en existait déjà pas en base
					this.noteService.create(currentNote);
				}else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"UNE NOTE EXISTE DEJA POUR CE COURS ET CET ELEVE", null));
					return DemoConstantes.MSG_KO;
				}
			}
		} catch (Exception e) {
			System.err.println(e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(), null));
			return DemoConstantes.MSG_KO;
		}
		return DemoConstantes.MSG_OK;
	}

	public String loadNote(NoteRecord noteRecordToLoad){
		this.currentNote = noteRecordToLoad;
		this.updateMode = true;
		return DemoConstantes.MSG_OK;
	}

	public NoteRecord getCurrentNote() {
		return currentNote;
	}

	public void setCurrentNote(NoteRecord currentNote) {
		this.currentNote = currentNote;
	}

	public EleveRecord getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(EleveRecord loginUser) {
		this.loginUser = loginUser;
	}

	public List<CoursRecord> getCoursList() {
		return coursList;
	}

	public void setCoursList(List<CoursRecord> coursList) {
		this.coursList = coursList;
	}

	public List<EleveRecord> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<EleveRecord> studentList) {
		this.studentList = studentList;
	}


	public boolean isUpdateMode() {
		return updateMode;
	}


	public void setUpdateMode(boolean updateMode) {
		this.updateMode = updateMode;
	}
}
