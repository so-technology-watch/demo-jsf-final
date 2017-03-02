package org.demo.formation.web.jsf.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.demo.data.record.NoteRecord;
import org.demo.persistence.CoursPersistence;
import org.demo.persistence.ElevePersistence;
import org.demo.persistence.NotePersistence;
import org.demo.persistence.commons.PersistenceServiceProvider;

@ManagedBean(name= "listNoteManagedBean")
public class ListNotesManagedBean {

	private List<NoteRecord> noteList;
	private ElevePersistence userService = PersistenceServiceProvider.getService(ElevePersistence.class);
	private CoursPersistence coursService = PersistenceServiceProvider.getService(CoursPersistence.class);
	private NotePersistence noteService = PersistenceServiceProvider.getService(NotePersistence.class);
	
	public ListNotesManagedBean(){
		this.noteList = this.noteService.findAll();
	}
	
	public String deleteNote(NoteRecord noteToDelete){
		 this.noteService.deleteById(noteToDelete.getIdCours(), noteToDelete.getIdEleve());
		 this.noteList = this.noteService.findAll();
		return "";
	}

	public String getStudentNameById(Integer id){
		return this.userService.findById(id).getNom();
	}
	
	public String getCourseNameById(Integer id){
		return this.coursService.findById(id).getLibelle();
	}
	public List<NoteRecord> getNoteList() {
		return noteList;
	}

	public void setNoteList(List<NoteRecord> noteList) {
		this.noteList = noteList;
	}
}
