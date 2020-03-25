package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    TableView tableView;
    @FXML
    Button goBtn;

    @FXML
    private ChoiceBox<String> choiceBox2;

    @FXML
    private ChoiceBox<String> choiceBox4;
    @FXML
    private ChoiceBox<String> choiceBox5;
    @FXML
    private ChoiceBox<String> choiceBox6;
    @FXML
    private ChoiceBox<String> choiceBox7;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.setItems(FXCollections.observableArrayList(
                "Actor", "Address", "Category", "City", "Country", "Customer", "Film",
                "Inventory", "Language", "Payment", "Rental", "Staff", "Store"));
        choiceBox2.setItems(FXCollections.observableArrayList(
                "Actor", "Address", "Category", "City", "Country", "Customer", "Film",
                "Inventory", "Language", "Payment", "Rental", "Staff", "Store"));
        choiceBox4.setItems(FXCollections.observableArrayList(
                "Actor", "Address", "Category", "City", "Country", "Customer", "Film",
                "Inventory", "Language", "Payment", "Rental", "Staff", "Store"));
        choiceBox5.setItems(FXCollections.observableArrayList(
                "Actor", "Address", "Category", "City", "Country", "Customer", "Film",
                "Inventory", "Language", "Payment", "Rental", "Staff", "Store"));
        choiceBox6.setItems(FXCollections.observableArrayList(
                "Actor", "Address", "Category", "City", "Country", "Customer", "Film",
                "Inventory", "Language", "Payment", "Rental", "Staff", "Store"));
        choiceBox7.setItems(FXCollections.observableArrayList(
                "Actors in movies", "Film & categories", "Film & text"));
    }

    public void go() {
        tableView.getColumns().clear();
        //tableView.setEditable(true);

        if (choiceBox.getSelectionModel().getSelectedItem().equals("Actor")) {
            TableColumn idCol = new TableColumn("Actor id");
            TableColumn firstNameCol = new TableColumn("First Name");
            TableColumn lastNameCol = new TableColumn("Last Name");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            tableView.getColumns().addAll(idCol, firstNameCol, lastNameCol, lastUpdateCol);
        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("Address")) {
            TableColumn idCol = new TableColumn("Address id");
            TableColumn addressCol = new TableColumn("Address");
            TableColumn secondAddressCol = new TableColumn("Address 2");
            TableColumn districtCol = new TableColumn("District");
            TableColumn cityCol = new TableColumn("City id");
            TableColumn postcodeCol = new TableColumn("Postal code");
            TableColumn phoneCol = new TableColumn("Phone");
            TableColumn locationCol = new TableColumn("Location");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            tableView.getColumns().addAll(idCol, addressCol, secondAddressCol, districtCol, cityCol,
                    postcodeCol, phoneCol, locationCol, lastUpdateCol);
        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("Category")) {
            TableColumn idCol = new TableColumn("Category id");
            TableColumn nameCol = new TableColumn("Name");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            tableView.getColumns().addAll(idCol, nameCol, lastUpdateCol);
        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("City")) {
            TableColumn idCol = new TableColumn("City id");
            TableColumn nameCol = new TableColumn("Name");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            tableView.getColumns().addAll(idCol, nameCol, lastUpdateCol);
        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("Country")) {
            TableColumn idCol = new TableColumn("Country id");
            TableColumn nameCol = new TableColumn("Country");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            tableView.getColumns().addAll(idCol, nameCol, lastUpdateCol);
        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("Customer")) {
            TableColumn customerIdCol = new TableColumn("Customer id");
            TableColumn storeIdCol = new TableColumn("Store id");
            TableColumn firstNameCol = new TableColumn("First Name");
            TableColumn lastNameCol = new TableColumn("Last Name");
            TableColumn emailCol = new TableColumn("Email");
            TableColumn activeCol = new TableColumn("Active");
            TableColumn createdCol = new TableColumn("Created date");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            tableView.getColumns().addAll(customerIdCol, storeIdCol, firstNameCol, lastNameCol, emailCol,
                    activeCol, createdCol, lastUpdateCol);
        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("Film")) {
            TableColumn filmIdCol = new TableColumn("Film id");
            TableColumn titleCol = new TableColumn("Title");
            TableColumn descriptionCol = new TableColumn("Description");
            TableColumn releasedCol = new TableColumn("Release year");
            TableColumn languageIdCol = new TableColumn("Language id");
            TableColumn originalLanguageCol = new TableColumn("Original language");
            TableColumn rentalDurationCol = new TableColumn("Rental Duration Col");
            TableColumn rentalRateCol = new TableColumn("Rental rate");
            TableColumn lengthCol = new TableColumn("Length");
            TableColumn replacementCostCol = new TableColumn("Replacement cost");
            TableColumn ratingCol = new TableColumn("Rating");
            TableColumn specialFeaturesCol = new TableColumn("Special features");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            tableView.getColumns().addAll(filmIdCol, titleCol, descriptionCol, releasedCol, languageIdCol, originalLanguageCol,
                    rentalDurationCol, rentalRateCol, lengthCol, replacementCostCol, ratingCol, specialFeaturesCol, lastUpdateCol);

        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("Inventory")) {
            TableColumn inventoryIdCol = new TableColumn("Inventory id");
            TableColumn filmIdCol = new TableColumn("Film id");
            TableColumn storeIdCol = new TableColumn("Store id");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            tableView.getColumns().addAll(inventoryIdCol, filmIdCol, storeIdCol, lastUpdateCol);
        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("Language")) {
            TableColumn idCol = new TableColumn("Language id");
            TableColumn nameCol = new TableColumn("Name");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            tableView.getColumns().addAll(idCol, nameCol, lastUpdateCol);
        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("Payment")) {
            TableColumn paymentIdCol = new TableColumn("Payment id");
            TableColumn customerIdCol = new TableColumn("Customer id");
            TableColumn staffIdCol = new TableColumn("Staff id");
            TableColumn rentalIdCol = new TableColumn("Rental id");
            TableColumn amountCol = new TableColumn("Amount");
            TableColumn paymentDateCol = new TableColumn("Payment date");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            tableView.getColumns().addAll(paymentIdCol, customerIdCol, staffIdCol, rentalIdCol,
                    amountCol, paymentDateCol, lastUpdateCol);
        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("Rental")) {
            TableColumn rentalIdCol = new TableColumn("Rental id");
            TableColumn rentalDateCol = new TableColumn("Rental date");
            TableColumn inventoryIdCol = new TableColumn("Inventory id");
            TableColumn customerIdCol = new TableColumn("Customer id");
            TableColumn returnDateCol = new TableColumn("Return date");
            TableColumn staffIdCol = new TableColumn("Staff id");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            tableView.getColumns().addAll(rentalIdCol, rentalDateCol, inventoryIdCol, customerIdCol,
                    returnDateCol, staffIdCol, lastUpdateCol);
        } else {
            System.out.println("Nothing");
            tableView.getColumns().clear();
        }
    }
}
