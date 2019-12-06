package fr.telecom_st_etienne.fx.kanban.business;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
@Entity
public class TypeTache {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	String[] listTypeTaches = {"Fonctionnalité","Bugs","Spike","Amélioration"};
	String[] listCouleurs = {"primary","warning","secondary","info"};
	@NotBlank
	private String nom;
	@Column(length=10)
	private String couleur;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(int i) {
		this.nom = listTypeTaches[i];
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(int i) {
		this.couleur = listCouleurs[i];
	}
	
	public TypeTache() {
	}
	public TypeTache(int nom) {
		if(nom<4) {
			this.couleur = listCouleurs[nom];
			this.nom = listTypeTaches[nom];
		}
		this.couleur = listCouleurs[0];
		this.nom = listTypeTaches[0];
		
	}
	
}
