package ma.cigma.service.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Categorie implements Serializable {
	@Id
	private Long id;
	private String categorie;
	@Basic(fetch = FetchType.LAZY)
	@OneToMany(mappedBy = "categorie", cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	private List<Article> articles = new ArrayList<>();

	public void addArticle(Article a) {
		a.setCategorie(this);
		articles.add(a);
	}

	public Categorie(String categorie) {
		super();
		this.categorie = categorie;
	}

	public Categorie(Long id, String categorie) {
		super();
		this.id = id;
		this.categorie = categorie;
	}
}
