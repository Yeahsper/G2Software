package util;

import org.hibernate.Session;
import tables.*;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;

public class ObjectGetter {


    // Gets select list, need to specify which table to get from, return generic/dynamic list depending on what you want.
    public List<Object> getSelectList(String switchString) throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery tq = null;
        List list = null;

        switch(switchString){
            case "Actor":
                 tq = session.createQuery("Select c from Actor c Where c IS not null", Actor.class);
                break;
            case "Address":
                tq = session.createQuery("Select c from Address c Where c IS not null", Address.class);
                break;
            case "Customer":
                tq = session.createQuery("Select c from Customer c Where c IS not null", Customer.class);
                break;
            case "Category":
                tq = session.createQuery("Select c from Category c Where c IS not null", Category.class);
                break;
            case "City":
                tq = session.createQuery("Select c from City c Where c IS not null", City.class);
                break;
            case "Country":
                tq = session.createQuery("Select c from Country c Where c IS not null", Country.class);
                break;
            case "Film":
                tq = session.createQuery("Select c from Film c Where c IS not null", Film.class);
                break;
            case "Inventory":
                tq = session.createQuery("Select c from Inventory c Where c IS not null", Inventory.class);
                break;
            case "Language":
                tq = session.createQuery("Select c from Language c Where c IS not null", Language.class);
                break;
            case "Payment":
                tq = session.createQuery("Select c from Payment c Where c IS not null", Payment.class);
                break;
            case "Rental":
                tq = session.createQuery("Select c from Rental c Where c IS not null", Rental.class);
                break;
            case "Staff":
                tq = session.createQuery("Select c from Staff c Where c IS not null", Staff.class);
                break;
            case "Store":
                tq = session.createQuery("Select c from Store c Where c IS not null", Store.class);
                break;
            default:
                System.out.println("Something went wrong when choosing which table to select from.");
        }
        try {
            list = tq.getResultList();
            list.forEach(ggg ->System.out.println(ggg.toString()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }


}


