package sopra.revue.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sopra.revue.Application;
import sopra.revue.model.Periodicite;
import sopra.revue.model.Revue;
import sopra.revue.repository.IRevueRepository;




public class TestJunitRevue {

	@Test	
	public void revueCreate() {
		
		IRevueRepository revueRepo = Application.getInstance().getRevueRepo();
		
		Revue revue1 = new Revue("sopranews", Periodicite.M);
		
		revue1 = revueRepo.save(revue1);
		
		Revue passFind = revueRepo.findById(revue1.getId());
		
		
		
		Assert.assertEquals("sopranews", passFind.getNom());
		Assert.assertEquals(Periodicite.M, passFind.getPeriodicite());
				
		revueRepo.delete(revue1);
		
	}
	
	@Test	
	public void revueUpdate() {
		
		IRevueRepository revueRepo = Application.getInstance().getRevueRepo();
		
		Revue revue1 = new Revue("sopranews", Periodicite.M);
		
		revue1 = revueRepo.save(revue1);
		
		
		
		revue1.setNom("news");
		revue1.setPeriodicite(Periodicite.H);	
		revue1 = revueRepo.save(revue1);
		Revue revuFind = revueRepo.findById(revue1.getId());
		
		Assert.assertEquals("news", revuFind.getNom());
		Assert.assertEquals(Periodicite.H, revuFind.getPeriodicite());
				
		revueRepo.delete(revue1);
	}
	
	@Test
	public void revueFindAllAndDelete() {
		IRevueRepository revueRepo = Application.getInstance().getRevueRepo();
		
		Revue revue1 = new Revue();
		revue1.setNom("news");
		revue1.setPeriodicite(Periodicite.H);
		

		Revue revue2 = new Revue();
		revue2.setNom("sopranews");
		revue2.setPeriodicite(Periodicite.M);

		
		revue1 = revueRepo.save(revue1);
		revue2 = revueRepo.save(revue2);
		
		
		List<Revue> revues = revueRepo.findAll();
		
		Assert.assertEquals(2, revues.size());
		
		revueRepo.delete(revue1);
		revueRepo.delete(revue2);
		
		
		revues = revueRepo.findAll();
		
		Assert.assertEquals(0, revues.size());
	}
}
