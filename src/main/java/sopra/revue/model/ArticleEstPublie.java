package sopra.revue.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "articleIsPublished")
public class ArticleEstPublie {
	@Id
	@GeneratedValue	
	private Long id;
	@Column(name = "pageStart")
	private Integer pageDebut;
	@Column(name = "pageEnd")
	private Integer pageFin;
	@ManyToOne
	@JoinColumn(name = "publication")
	private Publication publication;
	@ManyToOne
	@JoinColumn(name = "article")
	private Article article;

	
	public ArticleEstPublie() {
		super();
	}
	
	public ArticleEstPublie(Integer pageDebut, Integer pageFin) {
		super();
		this.pageDebut = pageDebut;
		this.pageFin = pageFin;
	}

	public Integer getPageDebut() {
		return pageDebut;
	}

	public void setPageDebut(Integer pageDebut) {
		this.pageDebut = pageDebut;
	}

	public Integer getPageFin() {
		return pageFin;
	}

	public void setPageFin(Integer pageFin) {
		this.pageFin = pageFin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	
}
