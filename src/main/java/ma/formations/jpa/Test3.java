package ma.formations.jpa;

import ma.formations.jpa.dao.DaoImpl;
import ma.formations.jpa.dao.IDao;

/**
 * Supprimer en cascade une catégorie donnée avec tous les articles correspondants.
 */
public class Test3 {
    static IDao dao = new DaoImpl();

    public static void main(String[] args) {
        final String categorieToDelete = "CATEGORIE_1";
        boolean isRemoved = dao.removeCategorie(categorieToDelete);
        if (isRemoved)
            System.out.println("Categorie with all articles removed with success");
        else System.out.println("Categorie is not removed");
    }
}
