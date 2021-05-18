package sopra.revue.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.revue.Application;
import sopra.revue.model.Publication;
import sopra.revue.repository.IPublicationRepository;

public class PublicationJpa implements IPublicationRepository {

	@Override
	public List<Publication> findAll() {
		List<Publication> publications = new ArrayList<Publication>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Publication> query = em.createQuery("select p from Publication p", Publication.class);

			publications = query.getResultList();

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
		return publications;
	}

	@Override
	public Publication findById(Long id) {
		Publication publication = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			publication = em.find(Publication.class, id);

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

		return publication;
	}

}
