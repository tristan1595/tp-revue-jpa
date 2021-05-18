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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "article_fait_reference")
public class ArticleFaitReference {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "ArticleId_Src")
	private Long ArticleIdSrc;
	@Column(name = "ArticleId_Ref")
	private Long ArticleIdRef;
	@ManyToMany
	@JoinTable(name = "article_fait_reference", joinColumns = @JoinColumn(name = "article_fait_reference_id"), inverseJoinColumns = @JoinColumn(name = "article_id"))
	private List<Article> articles  = new ArrayList<Article>();;

	
	public ArticleFaitReference() {
		super();
	}

	public Long getArticleIdSrc() {
		return ArticleIdSrc;
	}
public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setArticleIdSrc(Long articleIdSrc) {
		ArticleIdSrc = articleIdSrc;
	}

	public Long getArticleIdRef() {
		return ArticleIdRef;
	}

	public void setArticleIdRef(Long articleIdRef) {
		ArticleIdRef = articleIdRef;
	}
	
	
	
	

}
