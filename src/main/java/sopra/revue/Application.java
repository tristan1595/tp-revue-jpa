package sopra.revue;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.revue.repository.IArticleEstPublieRepository;
import sopra.revue.repository.IArticleFaitReferenceRepository;
import sopra.revue.repository.IArticleRepository;
import sopra.revue.repository.IAuteurRepository;
import sopra.revue.repository.IPeriodiciteRepository;
import sopra.revue.repository.IPublicationRepository;
import sopra.revue.repository.IRevueRepository;
import sopra.revue.repository.jpa.ArticleEstPublieJpa;
import sopra.revue.repository.jpa.ArticleFaitReferenceJpa;
import sopra.revue.repository.jpa.ArticleJpa;
import sopra.revue.repository.jpa.AuteurJpa;
import sopra.revue.repository.jpa.PeriodiciteJpa;
import sopra.revue.repository.jpa.PublicationJpa;
import sopra.revue.repository.jpa.RevueJpa;


public class Application {
	
	private static Application instance = null;
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");
	
	private final IArticleEstPublieRepository articleEstPublieRepo = new ArticleEstPublieJpa();
	private final IArticleFaitReferenceRepository articleFaitReferenceRepo = new ArticleFaitReferenceJpa();
	private final IArticleRepository articleRepo = new ArticleJpa();
	private final IAuteurRepository auteurRepo = new AuteurJpa();
	private final IPeriodiciteRepository periodiciteRepo = new PeriodiciteJpa();
	private final IPublicationRepository publicationRepo = new PublicationJpa();
	private final IRevueRepository revueRepo = new RevueJpa();
	
	private Application() {

	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IArticleEstPublieRepository getArticleEstPublieRepo() {
		return articleEstPublieRepo;
	}

	public IArticleFaitReferenceRepository getArticleFaitReferenceRepo() {
		return articleFaitReferenceRepo;
	}

	public IArticleRepository getArticleRepo() {
		return articleRepo;
	}

	public IAuteurRepository getAuteurRepo() {
		return auteurRepo;
	}

	public IPeriodiciteRepository getPeriodiciteRepo() {
		return periodiciteRepo;
	}

	public IPublicationRepository getPublicationRepo() {
		return publicationRepo;
	}

	public IRevueRepository getRevueRepo() {
		return revueRepo;
	}

	public static void setInstance(Application instance) {
		Application.instance = instance;
	}
		
}
