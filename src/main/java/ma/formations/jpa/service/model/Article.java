package ma.formations.jpa.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categorie")
    private Categorie categorie = new Categorie();
}
