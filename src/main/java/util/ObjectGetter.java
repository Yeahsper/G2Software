package util;

import org.hibernate.Session;
import tables.Customer;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class ObjectGetter {








    public void getCustomer() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from Customer c Where c IS not null";
        TypedQuery<Customer> tq = session.createQuery(query, Customer.class);
        List<Customer> customerList;
        try {
            // Get matching customer object and output
            customerList = tq.getResultList();
            customerList.forEach(ggg ->System.out.println(ggg.toString()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }


    }

    public void getasd() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from Customer c Where c IS not null";
        TypedQuery<Customer> tq = session.createQuery(query, Customer.class);
        List<Customer> customerList;
        try {
            // Get matching customer object and output
            customerList = tq.getResultList();
            customerList.forEach(ggg ->System.out.println(ggg.toString()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }


    }












}


