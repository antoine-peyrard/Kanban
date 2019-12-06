package fr.telecom_st_etienne.fx.kanban.business;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class HistoriqueDeplacement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne
	private Tache tache;
	@ManyToOne
	private Colonne colonne;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Tache getTache() {
		return tache;
	}
	public void setTache(Tache tache) {
		this.tache = tache;
	}
	public Colonne getColonne() {
		return colonne;
	}
	public void setColonne(Colonne colonne) {
		this.colonne = colonne;
	}
	
	
}
