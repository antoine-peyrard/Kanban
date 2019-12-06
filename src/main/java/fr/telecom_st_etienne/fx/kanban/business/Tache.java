package fr.telecom_st_etienne.fx.kanban.business;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tache {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // Auto-increment
	private Long id;

	private String intitule;

	@JsonIgnore
	private Date dateCreation;
	
	private int nbHeuresPrevues;
	
	private int nbHeuresEffectives;
	
	@ManyToMany
	private List <Developpeur> developpeurs;
	@ManyToOne
	private TypeTache typeTache;
	
	@ManyToOne
	private Projet projet;
	
	@ManyToOne
	private Colonne colonne;
	
	public int getNbHeuresPrevues() {
		return nbHeuresPrevues;
	}

	public void setNbHeuresPrevues(int nbHeuresPrevues) {
		this.nbHeuresPrevues = nbHeuresPrevues;
	}

	public int getNbHeuresEffectives() {
		return nbHeuresEffectives;
	}

	public void setNbHeuresEffectives(int nbHeuresEffectives) {
		this.nbHeuresEffectives = nbHeuresEffectives;
	}

	public List<Developpeur> getDeveloppeurs() {
		return developpeurs;
	}

	public void setDeveloppeurs(List<Developpeur> developpeurs) {
		this.developpeurs = developpeurs;
	}

	public TypeTache getTypeTache() {
		return typeTache;
	}

	public void setTypeTache(TypeTache typeTache) {
		this.typeTache = typeTache;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Colonne getColonne() {
		return colonne;
	}

	public void setColonne(Colonne colonne) {
		this.colonne = colonne;
	}
	
	public void setColonneName(String name) {
		this.colonne.setContenu(name);
	}
/*	
	public void nextColonne() {
		colonne.next();
	}*/

	public Tache() {
		this.dateCreation= new Date();
	}
	
	public Tache(String intitule, TypeTache typeTache,Colonne colonne) {
		this();
		this.intitule = intitule;
		this.typeTache = typeTache;
		this.colonne = colonne;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Tache(String intitule, int nbHeuresPrevues, List<Developpeur> developpeurs, TypeTache typeTache,
			Projet projet) {
		super();
		this.dateCreation= new Date();
		this.intitule = intitule;
		this.nbHeuresPrevues = nbHeuresPrevues;
		this.developpeurs = developpeurs;
		this.typeTache = typeTache;
		this.projet = projet;
	}

	@Override
	public String toString() {
		return "Tache [id=" + id + ", intitule=" + intitule + ", dateCreation=" + dateCreation + "]";
	}
		
}