package sopra.revue.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.revue.Application;
import sopra.revue.model.Revue;
import sopra.revue.repository.IRevueRepository;



public class RevueJpa implements IRevueRepository{

	@Override
	public List<Revue> findAll() {
		List<Revue> revues = new ArrayList<Revue>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Revue> query = em.createQuery("select r from Revue r", Revue.class);

			revues = query.getResultList();

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

		return revues;
	}


	@Override
	public Revue findById(Long id) {
		Revue revue = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			revue = em.find(Revue.class, id);

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

		return revue;
	}
	
}
