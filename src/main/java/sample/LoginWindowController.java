package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import util.HibernateUtil;

public class LoginWindowController {

    @FXML
    private TextField usernameTF;

    @FXML
    private Button loginBtn;

  //  @FXML
   // private TextField databaseTF;

    @FXML
    private TextField passwordTF;

    @FXML
    void login(ActionEvent event) {

        //Set credentials and store it static to keep them through the opened programs lifecycle.
        HibernateUtil.setUsername(usernameTF.getText());
        HibernateUtil.setPassword(passwordTF.getText());

        String tempDB = "jdbc:mysql://localhost/sakila?serverTimezone=UTC";
        HibernateUtil.setDbConnection(tempDB);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.getTransaction().commit();
            if (session.isConnected()) {

                Parent root;
                root = FXMLLoader.load(getClass().getClassLoader().getResource("mainWindow.fxml"));
                Stage stage = new Stage();
                stage.setTitle("");
                stage.setResizable(false);
                stage.setScene(new Scene(root, 1200, 600));

                stage.setAlwaysOnTop(true);
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
