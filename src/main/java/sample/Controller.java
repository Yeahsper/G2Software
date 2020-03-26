package sample;

import Util.HibernateUtil;
import org.hibernate.Session;
import tables.Address;
import tables.Store;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


public class Controller {

    public void GO() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from Address c Where c IS not null";
        TypedQuery<Address> tq = session.createQuery(query, Address.class);
        List<Address> kons;
        try {
            // Get matching customer object and output
            kons = tq.getResultList();

            kons.forEach(perss -> System.out.println(perss.getAddress().toString());
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }


    }
}
