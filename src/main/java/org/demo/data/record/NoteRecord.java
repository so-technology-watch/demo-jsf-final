/*
 * Created on 2017-03-08 ( Date ISO 2017-03-08 - Time 14:25:23 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */


package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Java bean for entity "note" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 * 
 * @author Telosys Tools Generator
 *
 */
public class NoteRecord implements Serializable
{
    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer idCours ; // Integer // Id or Primary Key
    @NotNull
    private Integer idEleve ; // Integer // Id or Primary Key

    @NotNull
    private BigDecimal noteObtenue ;  // BigDecimal 
    @NotNull
    private Date dateExamen ;  // Date 

    private Integer codeMention ;  // Integer 

    /**
     * Default constructor
     */
    public NoteRecord() {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR ID OR PRIMARY KEY 
    //----------------------------------------------------------------------
    /**
     * Set the "idCours" field value
     * This field is mapped on the database column "ID_COURS" ( type "INT", NotNull : true ) 
     * @param idCours
     */
	public void setIdCours( Integer idCours ) {
        this.idCours = idCours ;
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
        this.idEleve = idEleve ;
    }
    /**
     * Get the "idEleve" field value
     * This field is mapped on the database column "ID_ELEVE" ( type "INT", NotNull : true ) 
     * @return the field value
     */
	public Integer getIdEleve() {
        return this.idEleve;
    }

    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR OTHER DATA FIELDS 
    //----------------------------------------------------------------------

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
