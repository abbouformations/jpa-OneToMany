package ma.formations.jpa.dao;

import ma.formations.jpa.model.Article;
import ma.formations.jpa.model.Categorie;
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


    public void saveArticle(Article article) {
        try {
            String categorieDescription = article.getCategorie().getCategorie();
            session = SessionBuilder.getSessionfactory().createEntityManager();
            tx = session.getTransaction();
            tx.begin();
            if (categorieDescription == null) {
                session.merge(article);
                tx.commit();
                return;
            }
            Query requete = session.createQuery("select c from Categorie c where c.categorie= :categorie");
            requete.setParameter("categorie", article.getCategorie().getCategorie());
            List<Categorie> categorieList = requete.getResultList();
            if (categorieList == null || categorieList.isEmpty()) {
                session.merge(article);
                tx.commit();
                return;
            }
            article.setCategorie(categorieList.get(0));
            session.merge(article);
            tx.commit();
            log.info("saveArticle OK", article);
        } catch (Exception e) {
            log.error("erreur dans saveArticle()", e);
            if (tx == null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public List<Article> getArticlesByCategorie(String categorie) {
        List<Article> result = null;
        try {
            session = SessionBuilder.getSessionfactory().createEntityManager();
            Query requete = session.createQuery("select a from Article a where a.categorie.categorie= :categorie");
            requete.setParameter("categorie", categorie);
            result = requete.getResultList();
            log.info("getArticlesByCategorie", categorie);
        } catch (Exception e) {
            log.error("erreur dans getArticlesByCategorie()", e);
        } finally {
            if (session != null)
                session.close();
            return result;
        }
    }

    @Override
    public boolean removeArticle(String articleDescription) {
        boolean isRemoved = false;
        try {
            session = SessionBuilder.getSessionfactory().createEntityManager();
            tx = session.getTransaction();
            tx.begin();
            Query requete = session.createQuery("select a from Article a where a.description=:articleDescription");
            requete.setParameter("articleDescription", articleDescription);
            Article articleFound = (Article) requete.getSingleResult();
            if (articleFound != null)
                session.remove(articleFound);
            tx.commit();
            isRemoved = true;
            log.info("removeArticle() OK", articleDescription);
        } catch (Exception e) {
            log.error("erreur dans removeArticle()", e);
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
            return isRemoved;
        }
    }

    @Override
    public boolean removeCategorie(String categorieDescription) {
        boolean isRemoved = false;
        try {
            session = SessionBuilder.getSessionfactory().createEntityManager();
            tx = session.getTransaction();
            tx.begin();
            Query requete = session.createQuery("select c from Categorie c where c.categorie=:categorieDescription");
            requete.setParameter("categorieDescription", categorieDescription);
            Categorie categorieFound = (Categorie) requete.getSingleResult();
            if (categorieFound != null)
                session.remove(categorieFound);
            tx.commit();
            isRemoved = true;
            log.info("removeCategore() OK", categorieDescription);
        } catch (Exception e) {
            log.error("erreur dans removeCategore()", e);
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
            return isRemoved;
        }
    }
}
