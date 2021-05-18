package sopra.revue.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
	@Table(name = "article")

public class Article {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "titre")
	private String titre;
	@Column(name = "contenu")
	private String contenu;
	
	public Article() {
		super();
	}

	public Article(String titre, String contenu) {
		super();
		this.titre = titre;
		this.contenu = contenu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	
	
	

}
