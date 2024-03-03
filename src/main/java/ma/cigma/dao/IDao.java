package ma.cigma.dao;

import ma.cigma.service.model.Categorie;

public interface IDao {
	<T> void save(T t);
	void remove(Long id);
	Categorie getCategorieByName(String categorieName);
}
