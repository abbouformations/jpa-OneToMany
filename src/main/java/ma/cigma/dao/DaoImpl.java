package ma.cigma.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import ma.cigma.service.model.Article;
import ma.cigma.service.model.Categorie;

public class DaoImpl implements IDao {
	private EntityManager session;
	private static final Logger log = Logger.getLogger("DaoImpl");

	@Override
	public <T> void save(T t) {
		try {
			session = SessionBuilder.getSessionfactory().createEntityManager();
			EntityTransaction tx = session.getTransaction();
			tx.begin();
			/*
			 * merge : pour insérer ou modifier. persist : pour insérer.
			 * 
			 * session.persist vs session.merge : - persist permet d'ajouter un objet et son
			 * résultat est void. - merge permet de fusionner l'objet en paramètre avec
			 * celui au niveau de la base de données et attacher l'objet résultat à la
			 * session.
			 */
			session.merge(t);
			tx.commit();
			log.info(t.getClass().getName() + " ajouté avec succés");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("erreur dans save()", e);

		} finally {
			session.close();
		}
	}

	@Override
	public void remove(Long id) {
		try {
			session = SessionBuilder.getSessionfactory().createEntityManager();
			EntityTransaction tx = session.getTransaction();
			tx.begin();
			/*
			 * merge : pour insérer ou modifier. persist : pour insérer.
			 * 
			 * session.persist vs session.merge : - persist permet d'ajouter un objet et son
			 * résultat est void. - merge permet de fusionner l'objet en paramètre avec
			 * celui au niveau de la base de données et attacher l'objet résultat à la
			 * session.
			 */
			Article a = session.find(Article.class, id);
			if (a != null)
				session.remove(a);
			tx.commit();
			log.info("Article supprimé avec succés");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("erreur dans remove()", e);

		} finally {
			session.close();
		}
	}

	@Override
	public Categorie getCategorieByName(String categorie) {
		Categorie result = null;
		try {
			session = SessionBuilder.getSessionfactory().createEntityManager();
			EntityTransaction tx = session.getTransaction();
			tx.begin();
			Query requete = session.createQuery("select c from Categorie c where c.categorie :categorie");
			requete.setParameter("categorie", categorie);
			List<Categorie> categories = requete.getResultList();
			if (result != null && !categories.isEmpty())
				result = categories.get(0);
			tx.commit();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("erreur dans remove()", e);

		} finally {
			session.close();
		}
		return result;
	}
}
