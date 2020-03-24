package sample;

import Util.HibernateUtil;
import org.hibernate.Session;
import tables.Country;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


public class Controller {

    public void GO() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from Country  c WHERE c.id  IS NOT NULL";
        TypedQuery<Country> tq = session.createQuery(query, Country.class);
        List<Country> kons;
        try {
            // Get matching customer object and output
            kons = tq.getResultList();
            kons.forEach(perss ->System.out.println(perss.getCountry()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }


    }
}
