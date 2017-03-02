package org.demo.formation.web.jsf.util;

public enum MentionEnum {

	FAIBLE(1,"Faible"),
	INSUFFISANT(2,"Insuffisant"),
	PASSABLE(3,"Passable"),
	ASSEZ_BIEN(4,"Assez bien"),
	BIEN(5,"Bien"),
	TRES_BIEN(6,"Tr�s Bien"),
	EXCELLENT(7,"Excellent");
	
	MentionEnum(Integer code,String lib){
		this.code = code;
		this.libelle = lib;
	}
	
	private Integer code;
	private String libelle;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	/**
	 * Renvoie le libell� de la mention en fonction du code
	 * @param codeMention : Code de la mention pour lequel on cherche le libell�
	 * @return
	 */
	public static String getLibByCodeMention(int codeMention){
		for (MentionEnum mentionCourant : values()) {
			if (mentionCourant.getCode().equals(codeMention)){
				return mentionCourant.getLibelle();
			}
		}
		return null;
	}
	
}
