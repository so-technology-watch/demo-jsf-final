package org.demo.formation.web.jsf.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.demo.formation.librairie.bean.provider.FactoryServiceProvider;
import org.demo.formation.librairie.entity.NoteId;
import org.demo.formation.librairie.service.ICoursService;
import org.demo.formation.librairie.service.IEleveService;
import org.demo.formation.librairie.service.INoteService;
import org.demo.formation.librairie.service.impl.CoursServiceImpl;
import org.demo.formation.librairie.service.impl.EleveServiceImpl;
import org.demo.formation.librairie.service.impl.NoteServiceImpl;
import org.demo.formation.librairie.service.view.NoteView;

@ManagedBean(name= "listNoteManagedBean")
public class ListNotesManagedBean {

	private INoteService noteService = FactoryServiceProvider.getService(NoteServiceImpl.class);
	private ICoursService coursService = FactoryServiceProvider.getService(CoursServiceImpl.class);
	private IEleveService eleveService = FactoryServiceProvider.getService(EleveServiceImpl.class);
	private List<NoteView> noteList;
	
	public ListNotesManagedBean(){
		this.noteList = this.noteService.findAll();
	}
	
	public String deleteNote(NoteView noteViewToDelete){
		NoteId noteId = new NoteId(noteViewToDelete.getIdCours(), noteViewToDelete.getIdEleve());
		 this.noteService.deleteById(noteId);
		 this.noteList = this.noteService.findAll();
		return "";
		
	}

	public String getStudentNameById(Long id){
		return this.eleveService.getViewById(id).getNom();
	}
	
	public String getCourseNameById(Long id){
		return this.coursService.getViewById(id).getLibelle();
	}
	public List<NoteView> getNoteList() {
		return noteList;
	}

	public void setNoteList(List<NoteView> noteList) {
		this.noteList = noteList;
	}
}
