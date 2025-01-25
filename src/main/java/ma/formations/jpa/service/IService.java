package ma.formations.jpa.service;

import ma.formations.jpa.service.model.Article;
import ma.formations.jpa.service.model.Categorie;

public interface IService {
    void saveArticle(Categorie c, Article... articles);
}
