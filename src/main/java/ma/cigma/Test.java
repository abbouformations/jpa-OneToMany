package ma.cigma;

import ma.cigma.dao.DaoImpl;
import ma.cigma.dao.IDao;
import ma.cigma.service.model.Article;
import ma.cigma.service.model.Categorie;

public class Test {
	static IDao dao = new DaoImpl();

	public static void main(String[] args) {
		Categorie cat1 = new Categorie(1l, "CATEGORIE_1");
		Categorie cat2 = new Categorie(2l, "CATEGORIE_2");

		Article a1 = new Article("PC PORTABLE");
		Article a2 = new Article("PC FIXE");
		Article a3 = new Article("TV");
		Article a4 = new Article("CAMERA");

		a1.setCategorie(cat1);
		a2.setCategorie(cat1);
		a3.setCategorie(cat2);
		a4.setCategorie(cat2);

		dao.save(a1);
		dao.save(a2);
		dao.save(a3);
		dao.save(a4);
		
		Categorie categorie=dao.getCategorieByName("CATEGORIE_1");
		categorie.getArticles();

		// dao.remove(1l);
	}
}
