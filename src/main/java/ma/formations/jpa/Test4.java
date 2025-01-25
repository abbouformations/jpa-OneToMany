package ma.formations.jpa;

import ma.formations.jpa.dao.DaoImpl;
import ma.formations.jpa.dao.IDao;

/**
 * Supprimer en cascade un article donné avec sa catégorie à condition qu'il n'existe
 * pas dans la base de données des articles ayant la même catégorie.
 */
public class Test4 {
    static IDao dao = new DaoImpl();

    public static void main(String[] args) {
        final String articleToDelete = "CAMERA";
        boolean isRemoved = dao.removeArticle(articleToDelete);
        if (isRemoved)
            System.out.println("Article removed with success");
        else System.out.println("Article is not removed");
    }
}
