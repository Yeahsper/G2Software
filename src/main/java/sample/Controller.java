package sample;

import Util.HibernateUtil;
import org.hibernate.Session;
import tables.City;
import tables.Country;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


public class Controller {

    public void GO() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from City c Join c.country_list t Where t.country_id = 2";
        TypedQuery<City> tq = session.createQuery(query, City.class);
        List<City> kons;
        try {
            // Get matching customer object and output
            kons = tq.getResultList();
            kons.forEach(perss ->System.out.println(perss.getCity()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }


    }
}
