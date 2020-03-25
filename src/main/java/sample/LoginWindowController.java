package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import util.HibernateUtil;

public class LoginWindowController {

    @FXML
    private TextField usernameTF;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField databaseTF;

    @FXML
    private TextField passwordTF;

    @FXML
    void login(ActionEvent event) {

        //Set credentials and store it static to keep them through the opened programs lifecycle.
        HibernateUtil.setUsername(usernameTF.getText());
        HibernateUtil.setPassword(passwordTF.getText());

        String tempDB = "jdbc:mysql://localhost/" + databaseTF.getText() + "?serverTimezone=UTC";
        HibernateUtil.setDbConnection(tempDB);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.getTransaction().commit();
            if (session.isConnected()) {
                // MainGUI mainGUI = new MainGUI();
                // mainGUI.display();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
