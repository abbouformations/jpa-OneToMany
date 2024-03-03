package ma.cigma.service.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Article implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	public Article(String description) {
		super();
		this.description = description;
	}

	private String description;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "categorie")
	private Categorie categorie=new Categorie();

}
