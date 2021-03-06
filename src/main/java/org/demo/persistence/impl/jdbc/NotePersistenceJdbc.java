/*
 * Created on 2017-03-08 ( Date ISO 2017-03-08 - Time 14:27:11 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Named;


import org.demo.data.record.NoteRecord ;
import org.demo.persistence.NotePersistence;
import org.demo.persistence.impl.jdbc.commons.GenericDAO;

/**
 * Note persistence implementation 
 * 
 * @author Telosys
 *
 */
@Named("NotePersistence")
public class NotePersistenceJdbc extends GenericDAO<NoteRecord> implements NotePersistence {

	private final static String SQL_SELECT_ALL = 
		"select ID_COURS, ID_ELEVE, NOTE_OBTENUE, DATE_EXAMEN, CODE_MENTION from note"; 

	private final static String SQL_SELECT = 
		"select ID_COURS, ID_ELEVE, NOTE_OBTENUE, DATE_EXAMEN, CODE_MENTION from note where ID_COURS = ? and ID_ELEVE = ?";

	private final static String SQL_INSERT = 
		"insert into note ( ID_COURS, ID_ELEVE, NOTE_OBTENUE, DATE_EXAMEN, CODE_MENTION ) values ( ?, ?, ?, ?, ? )";

	private final static String SQL_UPDATE = 
		"update note set NOTE_OBTENUE = ?, DATE_EXAMEN = ?, CODE_MENTION = ? where ID_COURS = ? and ID_ELEVE = ?";

	private final static String SQL_DELETE = 
		"delete from note where ID_COURS = ? and ID_ELEVE = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from note";

	private final static String SQL_COUNT = 
		"select count(*) from note where ID_COURS = ? and ID_ELEVE = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public NotePersistenceJdbc() {
		super();
	}

    //----------------------------------------------------------------------
	@Override
	protected void setValuesForPrimaryKey(PreparedStatement ps, int i, NoteRecord note) throws SQLException {
		//--- Set PRIMARY KEY from bean to PreparedStatement ( SQL "WHERE key=?, ..." )
		setValue(ps, i++, note.getIdCours() ) ; // "ID_COURS" : java.lang.Integer
		setValue(ps, i++, note.getIdEleve() ) ; // "ID_ELEVE" : java.lang.Integer
	}

    //----------------------------------------------------------------------
	@Override
	protected void setValuesForInsert(PreparedStatement ps, int i, NoteRecord note) throws SQLException {
		//--- Set PRIMARY KEY and DATA from bean to PreparedStatement ( SQL "SET x=?, y=?, ..." )
		setValue(ps, i++, note.getIdCours() ) ; // "ID_COURS" : java.lang.Integer
		setValue(ps, i++, note.getIdEleve() ) ; // "ID_ELEVE" : java.lang.Integer
		setValue(ps, i++, note.getNoteObtenue() ) ; // "NOTE_OBTENUE" : java.math.BigDecimal
		setValue(ps, i++, note.getDateExamen() ) ; // "DATE_EXAMEN" : java.util.Date
		setValue(ps, i++, note.getCodeMention() ) ; // "CODE_MENTION" : java.lang.Integer
	}

    //----------------------------------------------------------------------
	@Override
	protected void setValuesForUpdate(PreparedStatement ps, int i, NoteRecord note) throws SQLException {
		//--- Set DATA from bean to PreparedStatement ( SQL "SET x=?, y=?, ..." )
		setValue(ps, i++, note.getNoteObtenue() ) ; // "NOTE_OBTENUE" : java.math.BigDecimal
		setValue(ps, i++, note.getDateExamen() ) ; // "DATE_EXAMEN" : java.util.Date
		setValue(ps, i++, note.getCodeMention() ) ; // "CODE_MENTION" : java.lang.Integer
		//--- Set PRIMARY KEY from bean to PreparedStatement ( SQL "WHERE key=?, ..." )
		setValue(ps, i++, note.getIdCours() ) ; // "ID_COURS" : java.lang.Integer
		setValue(ps, i++, note.getIdEleve() ) ; // "ID_ELEVE" : java.lang.Integer
	}

	//----------------------------------------------------------------------
	/**
	 * Creates a new instance of the bean and populates it with the given primary value(s)
	 * @param idCours;
	 * @param idEleve;
	 * @return the new instance
	 */
	private NoteRecord newInstanceWithPrimaryKey( Integer idCours, Integer idEleve ) {
		NoteRecord note = new NoteRecord();
		note.setIdCours( idCours );
		note.setIdEleve( idEleve );
		return note ;
	}

	//----------------------------------------------------------------------
	@Override
	protected NoteRecord newInstance() {
		return new NoteRecord() ;
	}

    //----------------------------------------------------------------------
	@Override
	protected NoteRecord populateBean(ResultSet rs, NoteRecord note) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		note.setIdCours(rs.getInt("ID_COURS")); // java.lang.Integer
		if ( rs.wasNull() ) { note.setIdCours(null); }; // not primitive number => keep null value if any
		note.setIdEleve(rs.getInt("ID_ELEVE")); // java.lang.Integer
		if ( rs.wasNull() ) { note.setIdEleve(null); }; // not primitive number => keep null value if any
		note.setNoteObtenue(rs.getBigDecimal("NOTE_OBTENUE")); // java.math.BigDecimal
		if ( rs.wasNull() ) { note.setNoteObtenue(null); }; // not primitive number => keep null value if any
		note.setDateExamen(rs.getDate("DATE_EXAMEN")); // java.util.Date
		note.setCodeMention(rs.getInt("CODE_MENTION")); // java.lang.Integer
		if ( rs.wasNull() ) { note.setCodeMention(null); }; // not primitive number => keep null value if any
		return note ;
	}

	//----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public NoteRecord findById( Integer idCours, Integer idEleve ) {
		NoteRecord note = newInstanceWithPrimaryKey( idCours, idEleve ) ;
		if ( super.doSelect(note) ) {
			return note ;
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
	public List<NoteRecord> findAll() {
		return super.doSelectAll();
	}

	//----------------------------------------------------------------------
	/**
	 * Loads the given bean, it is supposed to contains the primary key value(s) in its attribute(s)<br>
	 * If found, the given instance is populated with the values retrieved from the database<br>
	 * If not found, the given instance remains unchanged
	 * @param note
	 * @return true if found, false if not found
	 */
	//@Override
	public boolean load( NoteRecord note ) {
		return super.doSelect(note) ;
	}

    //----------------------------------------------------------------------
	/**
	 * Inserts the given bean in the database 
	 * @param note
	 */
	public long insert(NoteRecord note) {
		super.doInsert(note);
		return 0L ;
	}

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public NoteRecord create(NoteRecord note) {
		insert(note);
		return note ;
	}	

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public boolean update(NoteRecord note) {
		int r = super.doUpdate(note);
		return r > 0 ;

	}	

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public NoteRecord save(NoteRecord note) {
		if ( super.doExists(note) ) {
			super.doUpdate(note);
		}
		else {
			super.doInsert(note);
		}
		return note ;
	}	

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public boolean deleteById( Integer idCours, Integer idEleve ) {
		NoteRecord note = newInstanceWithPrimaryKey( idCours, idEleve ) ;
		int r = super.doDelete(note);
		return r > 0 ;
	}

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public boolean delete( NoteRecord note ) {
		int r = super.doDelete(note);
		return r > 0 ;
	}

    //----------------------------------------------------------------------
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param idCours;
	 * @param idEleve;
	 * @return
	 */
	// @Override
	public boolean exists( Integer idCours, Integer idEleve ) {
		NoteRecord note = newInstanceWithPrimaryKey( idCours, idEleve ) ;
		return super.doExists(note);
	}
    //----------------------------------------------------------------------
	/**
	 * Checks the existence of the given bean in the database 
	 * @param note
	 * @return
	 */
	// @Override
	public boolean exists( NoteRecord note ) {
		return super.doExists(note);
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
