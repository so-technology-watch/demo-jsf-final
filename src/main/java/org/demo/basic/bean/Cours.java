/*
 * Java bean class for entity "cours" 
 * Created on 2017-02-28 ( Date ISO 2017-02-28 - Time 11:50:45 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package org.demo.basic.bean;

import java.io.Serializable;


/**
 * Java bean for entity "cours"
 * 
 * @author Telosys Tools Generator
 *
 */
public class Cours implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer    idCours      ; // Id or Primary Key

    private String     libelle      ;
    private Integer    nbHeures     ;

    /**
     * Default constructor
     */
    public Cours() {
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

    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR OTHER DATA FIELDS
    //----------------------------------------------------------------------
    /**
     * Set the "libelle" field value
     * This field is mapped on the database column "LIBELLE" ( type "VARCHAR", NotNull : false ) 
     * @param libelle
     */
    public void setLibelle( String libelle ) {
        this.libelle = libelle;
    }
    /**
     * Get the "libelle" field value
     * This field is mapped on the database column "LIBELLE" ( type "VARCHAR", NotNull : false ) 
     * @return the field value
     */
    public String getLibelle() {
        return this.libelle;
    }

    /**
     * Set the "nbHeures" field value
     * This field is mapped on the database column "NB_HEURES" ( type "INT", NotNull : false ) 
     * @param nbHeures
     */
    public void setNbHeures( Integer nbHeures ) {
        this.nbHeures = nbHeures;
    }
    /**
     * Get the "nbHeures" field value
     * This field is mapped on the database column "NB_HEURES" ( type "INT", NotNull : false ) 
     * @return the field value
     */
    public Integer getNbHeures() {
        return this.nbHeures;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
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
