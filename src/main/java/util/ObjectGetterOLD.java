package util;

import org.hibernate.Session;
import tables.*;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;

public class ObjectGetterOLD {


    public List<Customer> getCustomer() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from Customer c Where c IS not null";
        TypedQuery<Customer> tq = session.createQuery(query, Customer.class);
        List<Customer> customerList = new ArrayList<>();
        try {
            // Get matching customer object and output
            customerList = tq.getResultList();
//            customerList.forEach(ggg ->System.out.println(ggg.toString()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }


        return customerList;
    }

    public List<Actor> getActor() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from Actor c Where c IS not null";
        TypedQuery<Actor> tq = session.createQuery(query, Actor.class);
        List<Actor> actorList = new ArrayList<>();
        try {
            // Get matching customer object and output
            actorList = tq.getResultList();
            actorList.forEach(ggg ->System.out.println(ggg.toString()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return actorList;
    }

    public List<Address> getAddress() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from Address c Where c IS not null";
        TypedQuery<Address> tq = session.createQuery(query, Address.class);
        List<Address> addressList = new ArrayList<>();
        try {
            // Get matching customer object and output
            addressList = tq.getResultList();
            addressList.forEach(ggg ->System.out.println(ggg.toString()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return addressList;
    }

    public List<Language> getLanguage() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from Language c Where c IS not null";
        TypedQuery<Language> tq = session.createQuery(query, Language.class);
        List<Language> languageList = new ArrayList<>();
        try {
            // Get matching customer object and output
            languageList = tq.getResultList();
            languageList.forEach(ggg ->System.out.println(ggg.toString()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return languageList;
    }

    public List<Film> getFilm() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from Film c Where c IS not null";
        TypedQuery<Film> tq = session.createQuery(query, Film.class);
        List<Film> filmList = new ArrayList<>();
        try {
            // Get matching customer object and output
            filmList = tq.getResultList();
            filmList.forEach(ggg ->System.out.println(ggg.toString()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return filmList;
    }

    public List<Payment> getPayment() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from Payment c Where c IS not null";
        TypedQuery<Payment> tq = session.createQuery(query, Payment.class);
        List<Payment> paymentList = new ArrayList<>();
        try {
            // Get matching customer object and output
            paymentList = tq.getResultList();
            paymentList.forEach(ggg ->System.out.println(ggg.toString()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return paymentList;
    }

    public List<Rental> getRental() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from Rental c Where c IS not null";
        TypedQuery<Rental> tq = session.createQuery(query, Rental.class);
        List<Rental> rentalList = new ArrayList<>();
        try {
            // Get matching customer object and output
            rentalList = tq.getResultList();
            rentalList.forEach(ggg ->System.out.println(ggg.toString()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return rentalList;
    }

    public List<Staff> getStaff() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from Staff c Where c IS not null";
        TypedQuery<Staff> tq = session.createQuery(query, Staff.class);
        List<Staff> staffList = new ArrayList<>();
        try {
            // Get matching customer object and output
            staffList = tq.getResultList();
            staffList.forEach(ggg ->System.out.println(ggg.toString()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return staffList;
    }

    public List<Category> getCategory() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from Category c Where c IS not null";
        TypedQuery<Category> tq = session.createQuery(query, Category.class);
        List<Category> categoryList = new ArrayList<>();
        try {
            // Get matching customer object and output
            categoryList = tq.getResultList();
            categoryList.forEach(ggg ->System.out.println(ggg.toString()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return categoryList;
    }

    public List<City> getCity() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from City c Where c IS not null";
        TypedQuery<City> tq = session.createQuery(query, City.class);
        List<City> cityList = new ArrayList<>();
        try {
            // Get matching customer object and output
            cityList = tq.getResultList();
            cityList.forEach(ggg ->System.out.println(ggg.toString()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return cityList;
    }

    public List<Country> getCountry() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from Country c Where c IS not null";
        TypedQuery<Country> tq = session.createQuery(query, Country.class);
        List<Country> countryList = new ArrayList<>();
        try {
            // Get matching customer object and output
            countryList = tq.getResultList();
            countryList.forEach(ggg ->System.out.println(ggg.toString()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return countryList;
    }

    public List<Inventory> getInventory() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from Inventory c Where c IS not null";
        TypedQuery<Inventory> tq = session.createQuery(query, Inventory.class);
        List<Inventory> inventoryList = new ArrayList<>();
        try {
            // Get matching customer object and output
            inventoryList = tq.getResultList();
            inventoryList.forEach(ggg ->System.out.println(ggg.toString()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return inventoryList;
    }

    public List<Store> getStore() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String query = "Select c from Store c Where c IS not null";
        TypedQuery<Store> tq = session.createQuery(query, Store.class);
        List<Store> storeList = new ArrayList<>();
        try {
            // Get matching customer object and output
            storeList = tq.getResultList();
            storeList.forEach(ggg ->System.out.println(ggg.toString()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return storeList;
    }


    // Gets select list, need to specify which table to get from.
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
//                tq = session.createQuery("Select c from Payment c Where c IS not null", Payment.class);
                break;
            case "Rental":
//                tq = session.createQuery("Select c from Rental c Where c IS not null", Rental.class);
                break;
            case "Staff":
//                tq = session.createQuery("Select c from Staff c Where c IS not null", Staff.class);
                break;
            case "Store":
                tq = session.createQuery("Select c from Store c Where c IS not null", Store.class);
                break;
            default:
                System.out.println("Something went wrong when choosing which table to select from.");
        }

        try {
            // Get matching customer object and output
            list = tq.getResultList();
            list.forEach(ggg ->System.out.println(ggg.toString()));
        } catch (
                NoResultException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        List<Object> genericList = new ArrayList<>();
        genericList.addAll(list);

        return genericList;
    }


}


