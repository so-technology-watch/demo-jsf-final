/*
 * Created on 2017-02-28 ( Date ISO 2017-02-28 - Time 11:57:42 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Named;


import org.demo.data.record.CoursRecord ;
import org.demo.persistence.CoursPersistence;
import org.demo.persistence.impl.jdbc.commons.GenericDAO;

/**
 * Cours persistence implementation 
 * 
 * @author Telosys
 *
 */
@Named("CoursPersistence")
public class CoursPersistenceJdbc extends GenericDAO<CoursRecord> implements CoursPersistence {

	private final static String SQL_SELECT_ALL = 
		"select ID_COURS, LIBELLE, NB_HEURES from cours"; 

	private final static String SQL_SELECT = 
		"select ID_COURS, LIBELLE, NB_HEURES from cours where ID_COURS = ?";

	private final static String SQL_INSERT = 
		"insert into cours ( ID_COURS, LIBELLE, NB_HEURES ) values ( ?, ?, ? )";

	private final static String SQL_UPDATE = 
		"update cours set LIBELLE = ?, NB_HEURES = ? where ID_COURS = ?";

	private final static String SQL_DELETE = 
		"delete from cours where ID_COURS = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from cours";

	private final static String SQL_COUNT = 
		"select count(*) from cours where ID_COURS = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public CoursPersistenceJdbc() {
		super();
	}

    //----------------------------------------------------------------------
	@Override
	protected void setValuesForPrimaryKey(PreparedStatement ps, int i, CoursRecord cours) throws SQLException {
		//--- Set PRIMARY KEY from bean to PreparedStatement ( SQL "WHERE key=?, ..." )
		setValue(ps, i++, cours.getIdCours() ) ; // "ID_COURS" : java.lang.Integer
	}

    //----------------------------------------------------------------------
	@Override
	protected void setValuesForInsert(PreparedStatement ps, int i, CoursRecord cours) throws SQLException {
		//--- Set PRIMARY KEY and DATA from bean to PreparedStatement ( SQL "SET x=?, y=?, ..." )
		setValue(ps, i++, cours.getIdCours() ) ; // "ID_COURS" : java.lang.Integer
		setValue(ps, i++, cours.getLibelle() ) ; // "LIBELLE" : java.lang.String
		setValue(ps, i++, cours.getNbHeures() ) ; // "NB_HEURES" : java.lang.Integer
	}

    //----------------------------------------------------------------------
	@Override
	protected void setValuesForUpdate(PreparedStatement ps, int i, CoursRecord cours) throws SQLException {
		//--- Set DATA from bean to PreparedStatement ( SQL "SET x=?, y=?, ..." )
		setValue(ps, i++, cours.getLibelle() ) ; // "LIBELLE" : java.lang.String
		setValue(ps, i++, cours.getNbHeures() ) ; // "NB_HEURES" : java.lang.Integer
		//--- Set PRIMARY KEY from bean to PreparedStatement ( SQL "WHERE key=?, ..." )
		setValue(ps, i++, cours.getIdCours() ) ; // "ID_COURS" : java.lang.Integer
	}

	//----------------------------------------------------------------------
	/**
	 * Creates a new instance of the bean and populates it with the given primary value(s)
	 * @param idCours;
	 * @return the new instance
	 */
	private CoursRecord newInstanceWithPrimaryKey( Integer idCours ) {
		CoursRecord cours = new CoursRecord();
		cours.setIdCours( idCours );
		return cours ;
	}

	//----------------------------------------------------------------------
	@Override
	protected CoursRecord newInstance() {
		return new CoursRecord() ;
	}

    //----------------------------------------------------------------------
	@Override
	protected CoursRecord populateBean(ResultSet rs, CoursRecord cours) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		cours.setIdCours(rs.getInt("ID_COURS")); // java.lang.Integer
		if ( rs.wasNull() ) { cours.setIdCours(null); }; // not primitive number => keep null value if any
		cours.setLibelle(rs.getString("LIBELLE")); // java.lang.String
		cours.setNbHeures(rs.getInt("NB_HEURES")); // java.lang.Integer
		if ( rs.wasNull() ) { cours.setNbHeures(null); }; // not primitive number => keep null value if any
		return cours ;
	}

	//----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public CoursRecord findById( Integer idCours ) {
		CoursRecord cours = newInstanceWithPrimaryKey( idCours ) ;
		if ( super.doSelect(cours) ) {
			return cours ;
		}
		else {
			return null ; // Not found
		}
	}
	//----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public List<CoursRecord> findAll() {
		return super.doSelectAll();
	}

	//----------------------------------------------------------------------
	/**
	 * Loads the given bean, it is supposed to contains the primary key value(s) in its attribute(s)<br>
	 * If found, the given instance is populated with the values retrieved from the database<br>
	 * If not found, the given instance remains unchanged
	 * @param cours
	 * @return true if found, false if not found
	 */
	//@Override
	public boolean load( CoursRecord cours ) {
		return super.doSelect(cours) ;
	}

    //----------------------------------------------------------------------
	/**
	 * Inserts the given bean in the database 
	 * @param cours
	 */
	public long insert(CoursRecord cours) {
		super.doInsert(cours);
		return 0L ;
	}

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public CoursRecord create(CoursRecord cours) {
		insert(cours);
		return cours ;
	}	

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public boolean update(CoursRecord cours) {
		int r = super.doUpdate(cours);
		return r > 0 ;

	}	

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public CoursRecord save(CoursRecord cours) {
		if ( super.doExists(cours) ) {
			super.doUpdate(cours);
		}
		else {
			super.doInsert(cours);
		}
		return cours ;
	}	

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public boolean deleteById( Integer idCours ) {
		CoursRecord cours = newInstanceWithPrimaryKey( idCours ) ;
		int r = super.doDelete(cours);
		return r > 0 ;
	}

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public boolean delete( CoursRecord cours ) {
		int r = super.doDelete(cours);
		return r > 0 ;
	}

    //----------------------------------------------------------------------
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param idCours;
	 * @return
	 */
	// @Override
	public boolean exists( Integer idCours ) {
		CoursRecord cours = newInstanceWithPrimaryKey( idCours ) ;
		return super.doExists(cours);
	}
    //----------------------------------------------------------------------
	/**
	 * Checks the existence of the given bean in the database 
	 * @param cours
	 * @return
	 */
	// @Override
	public boolean exists( CoursRecord cours ) {
		return super.doExists(cours);
	}

    //----------------------------------------------------------------------
	/**
	 * Counts all the records present in the database
	 * @return
	 */
	@Override
	public long countAll() {
		return super.doCountAll();
	}

    //----------------------------------------------------------------------
	@Override
	protected String getSqlSelect() {
		return SQL_SELECT ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlSelectAll() {
		return SQL_SELECT_ALL;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlInsert() {
		return SQL_INSERT ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlUpdate() {
		return SQL_UPDATE ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlDelete() {
		return SQL_DELETE ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlCount() {
		return SQL_COUNT ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlCountAll() {
		return SQL_COUNT_ALL ;
	}

}