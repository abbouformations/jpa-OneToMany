package ma.formations.jpa.dao;

import ma.formations.jpa.model.Article;

import java.util.List;

public interface IDao {
    void saveArticle(Article article);

    boolean removeArticle(String articleDescription);

    boolean removeCategorie(String categorieDescription);

    List<Article> getArticlesByCategorie(String categorieName);

}
