/*
 * Java domain class for entity "Note" 
 * Created on 2017-02-28 ( Date ISO 2017-02-28 - Time 17:40:55 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
package org.demo.data.domain;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;


/**
 * Domain class for entity "Note"
 *
 * @author Telosys Tools Generator
 *
 */
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY 
    //----------------------------------------------------------------------
    private Integer    idCours      ;
    private Integer    idEleve      ;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    private BigDecimal noteObtenue  ;
    private Date       dateExamen   ;
    private Integer    codeMention  ;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    private Eleve      eleve        ;
    private Cours      cours        ;

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Note() {
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

    public void setIdEleve( Integer idEleve ) {
        this.idEleve = idEleve ;
    }
    public Integer getIdEleve() {
        return this.idEleve;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR "DATA FIELDS"
    //----------------------------------------------------------------------
    public void setNoteObtenue( BigDecimal noteObtenue ) {
        this.noteObtenue = noteObtenue ;
    }
    public BigDecimal getNoteObtenue() {
        return this.noteObtenue;
    }

    public void setDateExamen( Date dateExamen ) {
        this.dateExamen = dateExamen ;
    }
    public Date getDateExamen() {
        return this.dateExamen;
    }

    public void setCodeMention( Integer codeMention ) {
        this.codeMention = codeMention ;
    }
    public Integer getCodeMention() {
        return this.codeMention;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setEleve( Eleve eleve ) {
        this.eleve = eleve;
    }
    public Eleve getEleve() {
        return this.eleve;
    }

    public void setCours( Cours cours ) {
        this.cours = cours;
    }
    public Cours getCours() {
        return this.cours;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idCours);
        sb.append("|");
        sb.append(idEleve);
        sb.append("|");
        sb.append(noteObtenue);
        sb.append("|");
        sb.append(dateExamen);
        sb.append("|");
        sb.append(codeMention);
        return sb.toString(); 
    } 

}
