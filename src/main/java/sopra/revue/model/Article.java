package sopra.revue.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	@ManyToMany(mappedBy = "articles") 
	private List<ArticleFaitReference> ArticleReferences = new ArrayList<ArticleFaitReference>();
	@ManyToMany 
	@JoinTable(name = "auteur", joinColumns = @JoinColumn(name = "article_id"), inverseJoinColumns = @JoinColumn(name = "auteur_id"))
	private List<Auteur> auteurs = new ArrayList<Auteur>();
	@OneToMany
	@JoinColumn(name = "article_id")
	private List<ArticleEstPublie> ArticlePublies = new ArrayList<ArticleEstPublie>();
		
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
