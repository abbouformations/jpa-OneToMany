package ma.formations.jpa;

import ma.formations.jpa.dao.DaoImpl;
import ma.formations.jpa.dao.IDao;

public class Test4 {
    static IDao dao = new DaoImpl();

    public static void main(String[] args) {
        final String articleToDelete = "CAMERA";
        boolean isRemoved = dao.removeArticle(articleToDelete);
        if (isRemoved)
            System.out.println("Article removed with success");
        else System.out.println("Article is not removed");
    }
}
