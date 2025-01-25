package ma.formations.jpa;

import ma.formations.jpa.dao.DaoImpl;
import ma.formations.jpa.dao.IDao;

/**
 * Consulter les articles par une catégorie donnée.
 */
public class Test2 {
    static IDao dao = new DaoImpl();

    public static void main(String[] args) {
        final String categorie = "CATEGORIE_1";
        dao.getArticlesByCategorie(categorie).forEach(System.out::println);
    }
}
