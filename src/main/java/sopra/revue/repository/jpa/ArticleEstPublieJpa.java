package sopra.revue.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.revue.Application;
import sopra.revue.model.ArticleEstPublie;
import sopra.revue.repository.IArticleEstPublieRepository;

public class ArticleEstPublieJpa implements IArticleEstPublieRepository{

	@Override
	public List<ArticleEstPublie> findAll() {

			List<ArticleEstPublie> articlesPublies = new ArrayList<ArticleEstPublie>();
			
			EntityManager em = null;
			EntityTransaction tx = null;
			
			try {
				em = Application.getInstance().getEmf().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				TypedQuery<ArticleEstPublie> query = em.createQuery("select a from ArticleEstPublie a", ArticleEstPublie.class);

				articlesPublies = query.getResultList();

				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}

			} finally {
				if (em != null) {
					em.close();
				}
			}

			return articlesPublies;
	}

	@Override
	public ArticleEstPublie findById(Long id) {
		
		ArticleEstPublie articleEstPublie = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			articleEstPublie = em.find(ArticleEstPublie.class, id);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

		return articleEstPublie;
	}
}


