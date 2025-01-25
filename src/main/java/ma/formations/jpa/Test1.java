package ma.formations.jpa;

import ma.formations.jpa.dao.DaoImpl;
import ma.formations.jpa.dao.IDao;
import ma.formations.jpa.model.Article;
import ma.formations.jpa.model.Categorie;

/**
 * Créer des articles avec leurs catégories
 */
public class Test1 {
    static IDao dao = new DaoImpl();

    public static void main(String[] args) {
        Categorie cat1 = Categorie.builder().categorie("CATEGORIE_1").build();
        Categorie cat2 = Categorie.builder().categorie("CATEGORIE_2").build();

        Article a1 = Article.builder().description("PC PORTAble").categorie(cat1).build();
        Article a2 = Article.builder().description("PC FIXE").categorie(cat1).build();
        Article a3 = Article.builder().description("TV").categorie(cat1).build();
        Article a4 = Article.builder().description("CAMERA").categorie(cat2).build();

        dao.saveArticle(a1);
        dao.saveArticle(a2);
        dao.saveArticle(a3);
        dao.saveArticle(a4);
    }
}
