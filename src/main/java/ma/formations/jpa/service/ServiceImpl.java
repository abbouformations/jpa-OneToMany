package ma.formations.jpa.service;

import ma.formations.jpa.dao.DaoImpl;
import ma.formations.jpa.dao.IDao;
import ma.formations.jpa.service.model.Article;
import ma.formations.jpa.service.model.Categorie;

import java.util.Arrays;

public class ServiceImpl implements IService {
    private final IDao dao = new DaoImpl();

    @Override
    public void saveArticle(Categorie c, Article... articles) {
        Categorie categoriePersist = dao.getCategorieByName(c.getCategorie());
        if (categoriePersist != null) {
            Arrays.stream(articles).forEach(
                    a -> {
                        a.setCategorie(categoriePersist);
                        dao.save(a);
                    }
            );

        } else {
            Categorie cPersist = dao.save(c);
            Arrays.stream(articles).forEach(a -> {
                a.setCategorie(cPersist);
                dao.save(a);
            });
        }
    }
}
