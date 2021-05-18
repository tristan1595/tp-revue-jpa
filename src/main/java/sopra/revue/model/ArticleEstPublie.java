package sopra.revue.model;

public class ArticleEstPublie {
	private Integer pageDebut;
	private Integer pageFin;
	
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
}
