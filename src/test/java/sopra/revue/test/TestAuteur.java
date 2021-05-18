package sopra.revue.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sopra.revue.Application;
import sopra.revue.model.Auteur;
import sopra.revue.repository.IAuteurRepository;

public class TestAuteur {
	
	@Test
	public void auteurCreate() {
		IAuteurRepository auteurRepo = Application.getInstance().getAuteurRepo();
		
		Auteur auteur = new Auteur();
		auteur.setNom("Hugo");
		auteur.setPrenom("Victor");
		auteur.setEmail("victor.hugo@hotmail.fr");
		
		auteur = auteurRepo.save(auteur);
		
		Auteur auteurFind = auteurRepo.findById(auteur.getId());
		
		Assert.assertEquals("Hugo", auteurFind.getNom());
		Assert.assertEquals("Victor", auteurFind.getPrenom());
		Assert.assertEquals("victor.hugo@hotmail.fr", auteurFind.getEmail());
		
		auteurRepo.delete(auteur);
	}
	
	@Test
	public void auteurUpdate() {
		IAuteurRepository auteurRepo = Application.getInstance().getAuteurRepo();
		
		Auteur auteur = new Auteur();
		auteur.setNom("Hugo");
		auteur.setPrenom("Victor");
		auteur.setEmail("victor.hugo@hotmail.fr");
		
		auteur = auteurRepo.save(auteur);
		
		auteur.setNom("Proust");
		auteur.setPrenom("Marcel");
		auteur.setEmail("marcel.proust@gmail.com");
		
		auteur = auteurRepo.save(auteur);
		
		Auteur auteurFind = auteurRepo.findById(auteur.getId());
		
		Assert.assertEquals("Proust", auteurFind.getNom());
		Assert.assertEquals("Marcel", auteurFind.getPrenom());
		Assert.assertEquals("marcel.proust@gmail.com", auteurFind.getEmail());
		
		auteurRepo.delete(auteur);
	}
	
	@Test
	public void auteurFindAllAndDelete() {
		IAuteurRepository auteurRepo = Application.getInstance().getAuteurRepo();
		
		Auteur auteur1 = new Auteur();
		auteur1.setNom("Hugo");
		auteur1.setPrenom("Victor");
		auteur1.setEmail("victor.hugo@hotmail.fr");
		
		Auteur auteur2 = new Auteur();
		auteur2.setNom("Proust");
		auteur2.setPrenom("Marcel");
		auteur2.setEmail("marcel.proust@gmail.com");
		
		Auteur auteur3 = new Auteur();
		auteur3.setNom("De la Fontaine");
		auteur3.setPrenom("Jean");
		auteur3.setEmail("jean.delafontaine@yahoo.fr");
		
		auteur1 = auteurRepo.save(auteur1);
		auteur2 = auteurRepo.save(auteur2);
		auteur3 = auteurRepo.save(auteur3);
		
		List<Auteur> auteurs = auteurRepo.findAll();
		
		Assert.assertEquals(3, auteurs.size());
		
		auteurRepo.delete(auteur1);
		auteurRepo.delete(auteur2);
		auteurRepo.delete(auteur3);
		
		Assert.assertEquals(0, auteurs.size());
	}
}
