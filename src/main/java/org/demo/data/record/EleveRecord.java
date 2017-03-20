/*
 * Created on 2017-03-08 ( Date ISO 2017-03-08 - Time 14:25:23 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */


package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

import java.util.Date;

/**
 * Java bean for entity "eleve" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 * 
 * @author Telosys Tools Generator
 *
 */
public class EleveRecord implements Serializable
{
    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer idEleve ; // Integer // Id or Primary Key

    @NotNull
    @Size( min = 1, max = 250 )
    private String nom ;  // String 
    @Size( max = 250 )
    private String prenom ;  // String 
    @NotNull
    @Size( min = 1, max = 150 )
    private String email ;  // String 
    @Size( max = 254 )
    private String password ;  // String 

    private Integer codePostal ;  // Integer 
    @NotNull
    private Integer sexe ;  // Integer 

    private Date dateInscription ;  // Date 

    /**
     * Default constructor
     */
    public EleveRecord() {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR ID OR PRIMARY KEY 
    //----------------------------------------------------------------------
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
     * Set the "nom" field value
     * This field is mapped on the database column "NOM" ( type "VARCHAR", NotNull : true ) 
     * @param nom
     */
    public void setNom( String nom ) {
        this.nom = nom;
    }
    /**
     * Get the "nom" field value
     * This field is mapped on the database column "NOM" ( type "VARCHAR", NotNull : true ) 
     * @return the field value
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Set the "prenom" field value
     * This field is mapped on the database column "PRENOM" ( type "VARCHAR", NotNull : false ) 
     * @param prenom
     */
    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }
    /**
     * Get the "prenom" field value
     * This field is mapped on the database column "PRENOM" ( type "VARCHAR", NotNull : false ) 
     * @return the field value
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * Set the "email" field value
     * This field is mapped on the database column "EMAIL" ( type "VARCHAR", NotNull : true ) 
     * @param email
     */
    public void setEmail( String email ) {
        this.email = email;
    }
    /**
     * Get the "email" field value
     * This field is mapped on the database column "EMAIL" ( type "VARCHAR", NotNull : true ) 
     * @return the field value
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Set the "password" field value
     * This field is mapped on the database column "PASSWORD" ( type "VARCHAR", NotNull : false ) 
     * @param password
     */
    public void setPassword( String password ) {
        this.password = password;
    }
    /**
     * Get the "password" field value
     * This field is mapped on the database column "PASSWORD" ( type "VARCHAR", NotNull : false ) 
     * @return the field value
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Set the "codePostal" field value
     * This field is mapped on the database column "CODE_POSTAL" ( type "INT", NotNull : false ) 
     * @param codePostal
     */
    public void setCodePostal( Integer codePostal ) {
        this.codePostal = codePostal;
    }
    /**
     * Get the "codePostal" field value
     * This field is mapped on the database column "CODE_POSTAL" ( type "INT", NotNull : false ) 
     * @return the field value
     */
    public Integer getCodePostal() {
        return this.codePostal;
    }

    /**
     * Set the "sexe" field value
     * This field is mapped on the database column "SEXE" ( type "INT", NotNull : true ) 
     * @param sexe
     */
    public void setSexe( Integer sexe ) {
        this.sexe = sexe;
    }
    /**
     * Get the "sexe" field value
     * This field is mapped on the database column "SEXE" ( type "INT", NotNull : true ) 
     * @return the field value
     */
    public Integer getSexe() {
        return this.sexe;
    }

    /**
     * Set the "dateInscription" field value
     * This field is mapped on the database column "DATE_INSCRIPTION" ( type "DATETIME", NotNull : false ) 
     * @param dateInscription
     */
    public void setDateInscription( Date dateInscription ) {
        this.dateInscription = dateInscription;
    }
    /**
     * Get the "dateInscription" field value
     * This field is mapped on the database column "DATE_INSCRIPTION" ( type "DATETIME", NotNull : false ) 
     * @return the field value
     */
    public Date getDateInscription() {
        return this.dateInscription;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idEleve);
        sb.append("|");
        sb.append(nom);
        sb.append("|");
        sb.append(prenom);
        sb.append("|");
        sb.append(email);
        sb.append("|");
        sb.append(password);
        sb.append("|");
        sb.append(codePostal);
        sb.append("|");
        sb.append(sexe);
        sb.append("|");
        sb.append(dateInscription);
        return sb.toString(); 
    } 



}
