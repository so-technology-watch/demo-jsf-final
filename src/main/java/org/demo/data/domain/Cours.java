/*
 * Java domain class for entity "Cours" 
 * Created on 2017-02-28 ( Date ISO 2017-02-28 - Time 17:40:55 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
package org.demo.data.domain;

import java.io.Serializable;


 import java.util.List;

/**
 * Domain class for entity "Cours"
 *
 * @author Telosys Tools Generator
 *
 */
public class Cours implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY 
    //----------------------------------------------------------------------
    private Integer    idCours      ;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    private String     libelle      ;
    private Integer    nbHeures     ;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    private List<Note> listOfNote   ;

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Cours() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR "KEY FIELD(S)"
    //----------------------------------------------------------------------
    public void setIdCours( Integer idCours ) {
        this.idCours = idCours ;
    }
    public Integer getIdCours() {
        return this.idCours;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR "DATA FIELDS"
    //----------------------------------------------------------------------
    public void setLibelle( String libelle ) {
        this.libelle = libelle ;
    }
    public String getLibelle() {
        return this.libelle;
    }

    public void setNbHeures( Integer nbHeures ) {
        this.nbHeures = nbHeures ;
    }
    public Integer getNbHeures() {
        return this.nbHeures;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfNote( List<Note> listOfNote ) {
        this.listOfNote = listOfNote;
    }
    public List<Note> getListOfNote() {
        return this.listOfNote;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idCours);
        sb.append("|");
        sb.append(libelle);
        sb.append("|");
        sb.append(nbHeures);
        return sb.toString(); 
    } 

}
