package fr.telecom_st_etienne.fx.kanban.business;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;
@Entity
public class Colonne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//String[] listDeColonne = {"A faire","En cours", "A tester", "Terminé"};
	
	@NotBlank
	private String contenu;
	@OneToMany(mappedBy = "colonne")
	private List <Tache> taches;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
	/*
	public void next() {
		for(int i=0;i<listDeColonne.length-1;i++) {
			if(contenu.equals(listDeColonne[i])) {
				contenu = listDeColonne[i+1];
			}
		}
	}*/
	
}
