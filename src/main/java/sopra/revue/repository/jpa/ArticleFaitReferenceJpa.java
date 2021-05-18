package sopra.revue.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.revue.Application;
import sopra.revue.model.ArticleFaitReference;
import sopra.revue.repository.IArticleFaitReferenceRepository;


public class ArticleFaitReferenceJpa implements IArticleFaitReferenceRepository {

	@Override
	public List<ArticleFaitReference> findAll() {
		List<ArticleFaitReference> ArticlesReference = new ArrayList<ArticleFaitReference>();
		
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<ArticleFaitReference> query = em.createQuery("select a from ArticleFaitReference a", ArticleFaitReference.class);

			ArticlesReference = query.getResultList();

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

		return ArticlesReference;
	}

	@Override
	public ArticleFaitReference findById(Long id) {
		
		ArticleFaitReference articleFaitReference = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			articleFaitReference = em.find(ArticleFaitReference.class, id);

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

		return articleFaitReference;
	}

}
