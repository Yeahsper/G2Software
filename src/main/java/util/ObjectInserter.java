package util;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ObjectInserter {


    public void addKonsert(String artist, String date) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        try {
            // Get transaction and start
            session.beginTransaction();

            // Create and set values for new customer

            Konsert konsert = new Konsert();
            konsert.setArtist(artist);
            konsert.setDate(date);

            // Save the customer object
            em.persist(konsert);
            et.commit();
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            session.close();
        }
    }
}


