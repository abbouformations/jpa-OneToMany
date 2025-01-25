package ma.formations.jpa.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categorie {
    @Id
    @GeneratedValue
    private Long id;
    private String categorie;
    //  @OneToMany(mappedBy = "categorie")
    //  private List<Article> articles = new ArrayList<>();

}
