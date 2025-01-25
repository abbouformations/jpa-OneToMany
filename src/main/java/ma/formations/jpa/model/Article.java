package ma.formations.jpa.model;

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
    @Column(nullable = false, unique = true)
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categorie")
    private Categorie categorie = new Categorie();
}
