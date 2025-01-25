package ma.formations.jpa;

import ma.formations.jpa.service.IService;
import ma.formations.jpa.service.ServiceImpl;
import ma.formations.jpa.service.model.Article;
import ma.formations.jpa.service.model.Categorie;

public class Test {
    static IService service = new ServiceImpl();

    public static void main(String[] args) {
        Categorie cat1 = Categorie.builder().categorie("CATEGORIE_1").build();
        Categorie cat2 = Categorie.builder().categorie("CATEGORIE_2").build();

        Article a1 = Article.builder().description("PC PORTAble").build();
        Article a2 = Article.builder().description("PC FIXE").build();
        Article a3 = Article.builder().description("TV").build();
        Article a4 = Article.builder().description("CAMERA").build();

        service.saveArticle(cat1, a1, a2, a3);
        service.saveArticle(cat2, a4);

    }
}
