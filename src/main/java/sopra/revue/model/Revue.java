package sopra.revue.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "magazine")

public class Revue {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "name")
	private String nom;
	@Column(name = "periodicity")
	private Periodicite periodicite;
	
	public Revue() {
		super();
	}
	
	public Revue(String nom, Periodicite periodicite) {
		super();
		this.nom = nom;
		this.periodicite = periodicite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Periodicite getPeriodicite() {
		return periodicite;
	}

	public void setPeriodicite(Periodicite periodicite) {
		this.periodicite = periodicite;
	}
			
}
