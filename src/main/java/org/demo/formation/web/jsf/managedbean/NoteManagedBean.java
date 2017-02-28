package org.demo.formation.web.jsf.managedbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.demo.formation.librairie.bean.provider.FactoryServiceProvider;
import org.demo.formation.librairie.service.ICoursService;
import org.demo.formation.librairie.service.IEleveService;
import org.demo.formation.librairie.service.INoteService;
import org.demo.formation.librairie.service.impl.CoursServiceImpl;
import org.demo.formation.librairie.service.impl.EleveServiceImpl;
import org.demo.formation.librairie.service.impl.NoteServiceImpl;
import org.demo.formation.librairie.service.view.CoursView;
import org.demo.formation.librairie.service.view.EleveView;
import org.demo.formation.librairie.service.view.NoteView;
import org.demo.formation.librairie.util.MentionEnum;
import org.demo.formation.web.jsf.util.DemoConstantes;
import org.demo.formation.web.jsf.util.SessionManagerUtils;

@ManagedBean(name = "noteManagedBean")
@RequestScoped
public class NoteManagedBean {
	//Note courante
	private NoteView currentNote;
	//Liste des services d'accès à la couche métier
	private INoteService noteService = FactoryServiceProvider.getService(NoteServiceImpl.class);
	private ICoursService coursService = FactoryServiceProvider.getService(CoursServiceImpl.class);
	private IEleveService eleveService = FactoryServiceProvider.getService(EleveServiceImpl.class);
	private EleveView loginUser;
	//Pour afficher la liste des cours
	private List<CoursView> coursList;
	//Pour alimenter la liste des étudiants presents en base
	private List<EleveView> studentList;
	//Permettant de savoir si une Note est en mode I/U
	private boolean updateMode;
	
	
	public NoteManagedBean(){
		this.currentNote = new NoteView();
		this.loginUser = (EleveView)SessionManagerUtils.getObjectInSession(DemoConstantes.USER_SESSION_KEY);
		this.coursList = this.coursService.findAll();
		this.studentList = this.eleveService.findAll();
	}


	public String addNoteAction(){
		try {
			//On cree l'utilisateur 
			this.noteService.createUpdateView(currentNote);
			//On recupere la liste en base
		} catch (Exception e) {
			System.err.println(e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(), null));
			return DemoConstantes.MSG_KO;
		}
		return DemoConstantes.MSG_OK;
	}

	public String loadNote(NoteView noteViewToLoad){
		this.currentNote = noteViewToLoad;
		this.updateMode = true;
		return DemoConstantes.MSG_OK;
	}

	public MentionEnum[] getMentions() {
		return MentionEnum.values();
	}

	public NoteView getCurrentNote() {
		return currentNote;
	}

	public void setCurrentNote(NoteView currentNote) {
		this.currentNote = currentNote;
	}

	public INoteService getNoteService() {
		return noteService;
	}

	public void setNoteService(INoteService noteService) {
		this.noteService = noteService;
	}

	public EleveView getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(EleveView loginUser) {
		this.loginUser = loginUser;
	}

	public List<CoursView> getCoursList() {
		return coursList;
	}

	public void setCoursList(List<CoursView> coursList) {
		this.coursList = coursList;
	}

	public List<EleveView> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<EleveView> studentList) {
		this.studentList = studentList;
	}


	public boolean isUpdateMode() {
		return updateMode;
	}


	public void setUpdateMode(boolean updateMode) {
		this.updateMode = updateMode;
	}
}
