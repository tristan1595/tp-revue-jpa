package sopra.revue.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.Test;

import sopra.revue.repository.IPublicationRepository;
import sopra.revue.Application;
import sopra.revue.model.Publication;

public class TestClassePublication {

	@Test
	public void publicationCreate() throws ParseException {		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		
		IPublicationRepository publicationRepo = Application.getInstance().getPublicationRepo();
		Publication publication1 = new Publication(sdf.parse("1995"),15);
		try {
			publication1 = publicationRepo.save(publication1);
		} catch(PersistenceException e) {
		}
		Publication publicationFind = publicationRepo.findById(publication1.getId());
		Assert.assertEquals(sdf.parse("1995"), publicationFind.getAnnee());
		Assert.assertEquals((Integer)15, publicationFind.getNbPages());
		
		publicationRepo.delete(publication1);
	}
	
	@Test
	public void villeUpdate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		
		IPublicationRepository publicationRepo = Application.getInstance().getPublicationRepo();
		Publication publication1 = new Publication(sdf.parse("2001"),15);
		publication1 = publicationRepo.save(publication1);
		
		publication1 = publicationRepo.findById(publication1.getId());
		publication1.setAnnee(sdf.parse("1995"));
		Assert.assertEquals(sdf.parse("1995"), publication1.getAnnee());
		publication1.setNbPages(35);
		Assert.assertEquals((Integer)35, publication1.getNbPages());
		
		publicationRepo.delete(publication1);
		
	}	
}
