package org.demo.formation.web.jsf.util;

public enum DepartementEnum {

	DEP_INFORMATIQUE(0,"Informatique"),
	DEP_COMPTABILITE(1,"Comptabilit�"),
	DEP_ENTRETIEN(2,"Entretien"),
	DEP_MARKETING(3,"Marketing");
	
	private Integer codeDepartement;
	private String libDepartement;
	
	DepartementEnum(int code,String lib){
		this.codeDepartement = code;
		this.libDepartement = lib;
	}
	public Integer getCodeDepartement() {
		return codeDepartement;
	}
	public void setCodeDepartement(Integer codeDepartement) {
		this.codeDepartement = codeDepartement;
	}
	public String getLibDepartement() {
		return libDepartement;
	}
	public void setLibDepartement(String libDepartement) {
		this.libDepartement = libDepartement;
	}
	
	/**
	 * Renvoie le libell� du departement en fonction du code
	 * @param codeDep : Code du departement pour lequel on cherche le libell�
	 * @return
	 */
	public static String getLibByCodeDepartement(int codeDep){
		for (DepartementEnum depCourant : values()) {
			if (depCourant.getCodeDepartement().equals(codeDep)){
				return depCourant.getLibDepartement();
			}
		}
		return null;
	}
	
}
