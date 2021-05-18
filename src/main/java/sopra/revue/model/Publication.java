package sopra.revue.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "publication")
public class Publication {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "year")
	private Date annee;
	@Column(name = "nbOfpages")
	private Integer nbPages;
	@ManyToOne
	@JoinColumn(name = "revue_id")
	private Revue revue;
	
	public Publication() {
		super();
	}
	
	public Publication(Date annee, Integer nbPages) {
		super();
		this.annee = annee;
		this.nbPages = nbPages;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAnnee() {
		return annee;
	}

	public void setAnnee(Date annee) {
		this.annee = annee;
	}

	public Integer getNbPages() {
		return nbPages;
	}

	public void setNbPages(Integer nbPages) {
		this.nbPages = nbPages;
	}

	public Revue getRevue() {
		return revue;
	}

	public void setRevue(Revue revue) {
		this.revue = revue;
	}
	
}
