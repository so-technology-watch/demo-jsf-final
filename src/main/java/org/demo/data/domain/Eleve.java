/*
 * Java domain class for entity "Eleve" 
 * Created on 2017-02-28 ( Date ISO 2017-02-28 - Time 17:40:55 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
package org.demo.data.domain;

import java.io.Serializable;

import java.util.Date;

 import java.util.List;

/**
 * Domain class for entity "Eleve"
 *
 * @author Telosys Tools Generator
 *
 */
public class Eleve implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY 
    //----------------------------------------------------------------------
    private Integer    idEleve      ;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    private String     nom          ;
    private String     prenom       ;
    private String     email        ;
    private String     password     ;
    private Integer    codePostal   ;
    private Integer    codeDepartement ;
    private Integer    sexe         ;
    private Date       dateInscription ;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    private List<Note> listOfNote   ;

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Eleve() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR "KEY FIELD(S)"
    //----------------------------------------------------------------------
    public void setIdEleve( Integer idEleve ) {
        this.idEleve = idEleve ;
    }
    public Integer getIdEleve() {
        return this.idEleve;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR "DATA FIELDS"
    //----------------------------------------------------------------------
    public void setNom( String nom ) {
        this.nom = nom ;
    }
    public String getNom() {
        return this.nom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom ;
    }
    public String getPrenom() {
        return this.prenom;
    }

    public void setEmail( String email ) {
        this.email = email ;
    }
    public String getEmail() {
        return this.email;
    }

    public void setPassword( String password ) {
        this.password = password ;
    }
    public String getPassword() {
        return this.password;
    }

    public void setCodePostal( Integer codePostal ) {
        this.codePostal = codePostal ;
    }
    public Integer getCodePostal() {
        return this.codePostal;
    }

    public void setCodeDepartement( Integer codeDepartement ) {
        this.codeDepartement = codeDepartement ;
    }
    public Integer getCodeDepartement() {
        return this.codeDepartement;
    }

    public void setSexe( Integer sexe ) {
        this.sexe = sexe ;
    }
    public Integer getSexe() {
        return this.sexe;
    }

    public void setDateInscription( Date dateInscription ) {
        this.dateInscription = dateInscription ;
    }
    public Date getDateInscription() {
        return this.dateInscription;
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
        sb.append(codeDepartement);
        sb.append("|");
        sb.append(sexe);
        sb.append("|");
        sb.append(dateInscription);
        return sb.toString(); 
    } 

}
