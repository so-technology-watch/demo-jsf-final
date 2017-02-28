/*
 * Java bean class for entity "note" 
 * Created on 2017-02-28 ( Date ISO 2017-02-28 - Time 11:50:45 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package org.demo.basic.bean;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Java bean for entity "note"
 * 
 * @author Telosys Tools Generator
 *
 */
public class Note implements Serializable
{
    private static final long serialVersionUID = 1L;


    private Integer    idCours      ;
    private Integer    idEleve      ;
    private BigDecimal noteObtenue  ;
    private Date       dateExamen   ;
    private Integer    codeMention  ;

    /**
     * Default constructor
     */
    public Note() {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR ID OR PRIMARY KEY 
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR OTHER DATA FIELDS
    //----------------------------------------------------------------------
    /**
     * Set the "idCours" field value
     * This field is mapped on the database column "ID_COURS" ( type "INT", NotNull : true ) 
     * @param idCours
     */
    public void setIdCours( Integer idCours ) {
        this.idCours = idCours;
    }
    /**
     * Get the "idCours" field value
     * This field is mapped on the database column "ID_COURS" ( type "INT", NotNull : true ) 
     * @return the field value
     */
    public Integer getIdCours() {
        return this.idCours;
    }

    /**
     * Set the "idEleve" field value
     * This field is mapped on the database column "ID_ELEVE" ( type "INT", NotNull : true ) 
     * @param idEleve
     */
    public void setIdEleve( Integer idEleve ) {
        this.idEleve = idEleve;
    }
    /**
     * Get the "idEleve" field value
     * This field is mapped on the database column "ID_ELEVE" ( type "INT", NotNull : true ) 
     * @return the field value
     */
    public Integer getIdEleve() {
        return this.idEleve;
    }

    /**
     * Set the "noteObtenue" field value
     * This field is mapped on the database column "NOTE_OBTENUE" ( type "DECIMAL", NotNull : true ) 
     * @param noteObtenue
     */
    public void setNoteObtenue( BigDecimal noteObtenue ) {
        this.noteObtenue = noteObtenue;
    }
    /**
     * Get the "noteObtenue" field value
     * This field is mapped on the database column "NOTE_OBTENUE" ( type "DECIMAL", NotNull : true ) 
     * @return the field value
     */
    public BigDecimal getNoteObtenue() {
        return this.noteObtenue;
    }

    /**
     * Set the "dateExamen" field value
     * This field is mapped on the database column "DATE_EXAMEN" ( type "DATETIME", NotNull : true ) 
     * @param dateExamen
     */
    public void setDateExamen( Date dateExamen ) {
        this.dateExamen = dateExamen;
    }
    /**
     * Get the "dateExamen" field value
     * This field is mapped on the database column "DATE_EXAMEN" ( type "DATETIME", NotNull : true ) 
     * @return the field value
     */
    public Date getDateExamen() {
        return this.dateExamen;
    }

    /**
     * Set the "codeMention" field value
     * This field is mapped on the database column "CODE_MENTION" ( type "INT", NotNull : false ) 
     * @param codeMention
     */
    public void setCodeMention( Integer codeMention ) {
        this.codeMention = codeMention;
    }
    /**
     * Get the "codeMention" field value
     * This field is mapped on the database column "CODE_MENTION" ( type "INT", NotNull : false ) 
     * @return the field value
     */
    public Integer getCodeMention() {
        return this.codeMention;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
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
