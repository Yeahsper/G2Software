package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import tables.*;
import util.HibernateUtil;
import util.ObjectGetter;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Objects;

public class Main extends Application {
    private static ObjectGetter objectGetter = new ObjectGetter();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample.fxml")));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void getAddresses(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String strQuery = "SELECT p FROM Inventory p WHERE p IS NOT NULL";

        TypedQuery<Inventory> tq = session.createQuery(strQuery, Inventory.class);
        List<Inventory> list;
        try {
            list = tq.getResultList();
            for (Inventory a:list)
            {
                System.out.println(a.getStore());
            }
        }
        catch(NoResultException ex) {
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(objectGetter.getCustomer());
//        getAddresses();
//        launch(args);
    }
}
