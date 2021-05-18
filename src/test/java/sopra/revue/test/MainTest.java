package sopra.revue.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp-revue-jpa");

		emf.close();
	}

}
