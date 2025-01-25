package ma.formations.jpa.dao;

import ma.formations.jpa.service.model.Categorie;

public interface IDao {
    <T> T save(T t);

    void remove(Long id);

    Categorie getCategorieByName(String categorieName);
}
