package sample;

import Util.HibernateUtil;
import Util.ObjectGetter;
import org.hibernate.Session;
import tables.Address;
import tables.Store;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


public class Controller {

    public void GO() throws Exception{

        ObjectGetter ogm = new ObjectGetter();

/*
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from Address c Where c IS not null";
        TypedQuery<Address> tq = session.createQuery(query, Address.class);
        List<Address> kons;
        try {
            // Get matching customer object and output
            kons = tq.getResultList();
            kons.forEach(perss -> System.out.println(perss.getAddress()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

 */

        //ogm.getAddress();
        //ogm.getActor();
        //ogm.getCategory();
        //ogm.getCity();
        //ogm.getCountry();
        //ogm.getCustomer();
        //ogm.getFilm();
        //ogm.getInventory();
       //ogm.getLanguage();
        //ogm.getStore();

       //ogm.getRental();
        //ogm.getStaff();
        //ogm.getPayment();




    }
}
