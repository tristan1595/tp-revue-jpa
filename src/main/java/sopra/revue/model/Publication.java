package sopra.revue.model;

import java.util.Date;

public class Publication {
	private Long id;
	private Date annee;
	private Integer nbPages;
	
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
}
