package fr.telecom_st_etienne.fx.kanban.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.telecom_st_etienne.fx.kanban.business.Colonne;
import fr.telecom_st_etienne.fx.kanban.business.Tache;
import fr.telecom_st_etienne.fx.kanban.business.TypeTache;
import fr.telecom_st_etienne.fx.kanban.service.ClientService;
import fr.telecom_st_etienne.fx.kanban.service.ColonneService;
import fr.telecom_st_etienne.fx.kanban.service.DeveloppeurService;
import fr.telecom_st_etienne.fx.kanban.service.ProjetService;
import fr.telecom_st_etienne.fx.kanban.service.TacheService;
import fr.telecom_st_etienne.fx.kanban.service.TypeTacheService;

@Controller
@RequestMapping("/")
public class KanbanController {

	@Autowired
	private TacheService tacheService;
	@Autowired
	private DeveloppeurService developpeurService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private ProjetService projetService;
	@Autowired
	private ColonneService colonneService;
	@Autowired
	private TypeTacheService typeTacheService;
	
	public KanbanController(TacheService tacheService, DeveloppeurService developpeurService) {
		super();
		this.tacheService = tacheService;
		this.developpeurService = developpeurService;
	}

	@RequestMapping(value = { "/index", "/" })
	public ModelAndView accueil(Pageable pageable) {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("pageDeTaches", tacheService.recupererTaches(pageable));
		mav.addObject("developpeurs", developpeurService.recupererDeveloppeurs());
		mav.addObject("typeTaches", typeTacheService.recupererTypeTaches());
		mav.addObject("projets", projetService.recupererProjets());
		mav.addObject("clients", clientService.recupererClients());
		mav.addObject("colonnes",colonneService.recupererColonnes());
		return mav;
	}
	/***
	 * 
	 * @param pageable
	 * @return
	 */
	@GetMapping(value = { "/ajouterTache"})
	public ModelAndView ajouterTacheGet(@RequestParam("idProjet") Long ID_Projet) {
		System.out.println("L'utilisateur demande l'access au formulaire pour creer une tache");
		ModelAndView mav = new ModelAndView("ajouterTache");
		mav.addObject("typeTaches", typeTacheService.recupererTypeTaches());	// il faut ajouter tout les objets nécessaires dans la page en cours.
		mav.addObject("developpeurs", developpeurService.recupererDeveloppeurs());
		mav.addObject("colonnes",colonneService.recupererColonnes());
		mav.addObject("projet",projetService.recupererProjet(ID_Projet));
		return mav;
	}
	
	@PostMapping("/ajouterTache")
	public ModelAndView ajouterTachePost(@RequestParam("idProjet") Long ID_Projet,
			@RequestParam("intitule") String intitule,
			@RequestParam("colonne") Long id_colonne,
			@RequestParam("typeTache") Long id_typeTache,
			@RequestParam("developpeur_id") List<Long> id_developpeurs,
			@RequestParam("heuresEstimees") String heuresEstimees ){
		Tache tache = new Tache(intitule,typeTacheService.recupererTypeTache(id_typeTache),colonneService.recupererColonne(id_colonne));
		tache.setColonne(colonneService.recupererColonne(id_colonne));
		tache.setNbHeuresPrevues(Integer.parseInt(heuresEstimees));
		tache.setTypeTache(typeTacheService.recupererTypeTache(id_typeTache));
		tache.setProjet(projetService.recupererProjet(ID_Projet));
		tacheService.ajouterTache(tache);
		System.out.println("Nouvelle tache crée");
		return new ModelAndView("redirect:/index");
	}
	
	@PostMapping("/modifColonne")
	public ModelAndView modifColonne(@RequestParam(name="id") Long id ) {
		Tache tache = tacheService.recupererTache(id);
		
		System.out.println("Colonne actuelle: " + tache.getColonne().getContenu());
		//tache.setColonne(colonneService.recupererColonne(1l));
		//tacheService.deplacerTache(1, id);
		tache.setColonne(colonneService.recupererColonne(tache.getColonne().getId()+1));
		tacheService.enregistrerTache(tache);
		System.out.println("Après enregistrement: " + tache.getColonne().getContenu());
 
		System.out.println("id: "+id);
		return new ModelAndView("redirect:/index");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Dans init()");
		if(developpeurService.recupererDeveloppeurs().isEmpty()) {
			developpeurService.ajouterDeveloppeur("DIDIER","Jean");
			developpeurService.ajouterDeveloppeur("ANTOINE","Marc");
			developpeurService.ajouterDeveloppeur("CHAN","Jacky");
			developpeurService.ajouterDeveloppeur("LEBLANC","Elaine");
			developpeurService.ajouterDeveloppeur("JARVAN","Henry");
			developpeurService.ajouterDeveloppeur("GAREN","Jack");
			developpeurService.ajouterDeveloppeur("VAYNE","Marie");
			developpeurService.ajouterDeveloppeur("DARIUS","Rodolf");
			developpeurService.ajouterDeveloppeur("LEONA","Pauline");
			developpeurService.ajouterDeveloppeur("EKKO","Paul");
		}
		if(projetService.recupererProjets().isEmpty()) {
			projetService.ajouterProjet("Projet 1");
		}
		if(typeTacheService.recupererTypeTaches().isEmpty()) {
			typeTacheService.ajouterTypeTache(0);//	Fonctionnalité
			typeTacheService.ajouterTypeTache(1);//	Bugs
			typeTacheService.ajouterTypeTache(2);// Spike
			typeTacheService.ajouterTypeTache(3);// Amélioration
		}
		if(clientService.recupererClients().isEmpty()) {
			clientService.ajouterClient("Client 1");
		}
		if(colonneService.recupererColonnes().isEmpty()) {
			colonneService.ajouterColonne("A faire");// A faire
			colonneService.ajouterColonne("En cours");// En cours
			colonneService.ajouterColonne("A tester");// A tester
			colonneService.ajouterColonne("Terminé");// Terminé
		}
		if (tacheService.recupererTaches().isEmpty()) {
			tacheService.ajouterTache("Développer Métier",typeTacheService.recupererTypeTache(1l),colonneService.recupererColonne(1l));
			tacheService.ajouterTache("Développer DAO",typeTacheService.recupererTypeTache(2l),colonneService.recupererColonne(2l));
			tacheService.ajouterTache("Développer Services",typeTacheService.recupererTypeTache(3l),colonneService.recupererColonne(3l));
			tacheService.ajouterTache("Développer Contrôleur",typeTacheService.recupererTypeTache(1l),colonneService.recupererColonne(1l));
		}
	}
}