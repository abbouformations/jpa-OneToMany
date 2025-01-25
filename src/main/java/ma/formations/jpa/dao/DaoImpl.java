package ma.formations.jpa.dao;

import ma.formations.jpa.service.model.Article;
import ma.formations.jpa.service.model.Categorie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class DaoImpl implements IDao {
    private static final Logger log = LogManager.getLogger(DaoImpl.class);
    private EntityManager session;
    private EntityTransaction tx;

    @Override
    public <T> T save(T t) {
        try {
            session = SessionBuilder.getSessionfactory().createEntityManager();
            tx = session.getTransaction();
            tx.begin();
            t = session.merge(t);
            tx.commit();
            log.info(t.getClass().getName() + " ajouté avec succés");
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            log.error("erreur dans save()", e);

        } finally {
            if (session != null)
                session.close();
            return t;
        }
    }

    @Override
    public void remove(Long id) {
        try {
            session = SessionBuilder.getSessionfactory().createEntityManager();
            tx = session.getTransaction();
            tx.begin();

            Article a = session.find(Article.class, id);
            if (a != null)
                session.remove(a);
            tx.commit();
            log.info("Article supprimé avec succés");
        } catch (Exception e) {
            log.error("erreur dans remove()", e);
            if (tx != null)
                tx.rollback();

        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public Categorie getCategorieByName(String categorie) {
        Categorie result = null;
        try {
            session = SessionBuilder.getSessionfactory().createEntityManager();
            Query requete = session.createQuery("select c from Categorie c where c.categorie= :categorie");
            requete.setParameter("categorie", categorie);
            List<Categorie> categories = requete.getResultList();
            if (result != null && !categories.isEmpty())
                result = categories.get(0);
        } catch (Exception e) {
            log.error("erreur dans remove()", e);

        } finally {
            if (session != null)
                session.close();
            return result;
        }
    }
}
