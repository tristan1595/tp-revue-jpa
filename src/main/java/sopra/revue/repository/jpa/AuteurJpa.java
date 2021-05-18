package sopra.revue.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.revue.Application;
import sopra.revue.model.Auteur;
import sopra.revue.repository.IAuteurRepository;

public class AuteurJpa implements IAuteurRepository {

	@Override
	public List<Auteur> findAll() {
		List<Auteur> auteurs = new ArrayList<Auteur>();

		EntityManager em = null;  
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Auteur> query = em.createQuery("select a from Auteur a", Auteur.class);

			auteurs = query.getResultList();

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

		return auteurs;
	}

	@Override
	public Auteur findById(Long id) {
		Auteur auteur = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			auteur = em.find(Auteur.class, id);

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

		return auteur;
	}
}
