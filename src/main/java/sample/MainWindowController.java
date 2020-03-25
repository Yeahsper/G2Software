package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

    private ObservableList<String> databaseTablesList = FXCollections.observableArrayList("Actor",
            "Address", "Category", "City", "Country", "Customer", "Film",
            "Inventory", "Language", "Payment", "Rental", "Staff", "Store");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.setItems(FXCollections.observableArrayList(databaseTablesList));
        choiceBox2.setItems(FXCollections.observableArrayList(databaseTablesList));
        choiceBox4.setItems(FXCollections.observableArrayList(databaseTablesList));
        choiceBox5.setItems(FXCollections.observableArrayList(databaseTablesList));
        choiceBox6.setItems(FXCollections.observableArrayList(databaseTablesList));
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

            idCol.setCellValueFactory(new PropertyValueFactory<>("actor_id"));
            firstNameCol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
            lastNameCol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));


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

            idCol.setCellValueFactory(new PropertyValueFactory<>("address_id"));
            addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
            secondAddressCol.setCellValueFactory(new PropertyValueFactory<>("address2"));
            districtCol.setCellValueFactory(new PropertyValueFactory<>("district"));
            cityCol.setCellValueFactory(new PropertyValueFactory<>("city_id"));
            postcodeCol.setCellValueFactory(new PropertyValueFactory<>("postal_code"));
            phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
            locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            tableView.getColumns().addAll(idCol, addressCol, secondAddressCol, districtCol, cityCol,
                    postcodeCol, phoneCol, locationCol, lastUpdateCol);

        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("Category")) {
            TableColumn idCol = new TableColumn("Category id");
            TableColumn nameCol = new TableColumn("Name");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("category_id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            tableView.getColumns().addAll(idCol, nameCol, lastUpdateCol);

        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("City")) {
            TableColumn idCol = new TableColumn("City id");
            TableColumn nameCol = new TableColumn("Name");
            TableColumn countryIdCol = new TableColumn("Country id");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("city_id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("city"));
            countryIdCol.setCellValueFactory(new PropertyValueFactory<>("country_id"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            tableView.getColumns().addAll(idCol, nameCol, lastUpdateCol);

        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("Country")) {
            TableColumn idCol = new TableColumn("Country id");
            TableColumn nameCol = new TableColumn("Country");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("country_id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("country"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));


            tableView.getColumns().addAll(idCol, nameCol, lastUpdateCol);

        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("Customer")) {
            TableColumn customerIdCol = new TableColumn("Customer id");
            TableColumn storeIdCol = new TableColumn("Store id");
            TableColumn firstNameCol = new TableColumn("First Name");
            TableColumn lastNameCol = new TableColumn("Last Name");
            TableColumn emailCol = new TableColumn("Email");
            TableColumn addressIdCol = new TableColumn("Address id");
            TableColumn activeCol = new TableColumn("Active");
            TableColumn createdCol = new TableColumn("Created date");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
            storeIdCol.setCellValueFactory(new PropertyValueFactory<>("store_id"));
            firstNameCol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
            lastNameCol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
            emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
            addressIdCol.setCellValueFactory(new PropertyValueFactory<>("address_id"));
            activeCol.setCellValueFactory(new PropertyValueFactory<>("active"));
            createdCol.setCellValueFactory(new PropertyValueFactory<>("create_date"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));


            tableView.getColumns().addAll(customerIdCol, storeIdCol, firstNameCol, lastNameCol, emailCol,
                    activeCol, createdCol, lastUpdateCol);

        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("Film")) {
            TableColumn filmIdCol = new TableColumn("Film id");
            TableColumn titleCol = new TableColumn("Title");
            TableColumn descriptionCol = new TableColumn("Description");
            TableColumn releasedCol = new TableColumn("Release year");
            TableColumn languageIdCol = new TableColumn("Language id");
            TableColumn originalLanguageCol = new TableColumn("Original language id");
            TableColumn rentalDurationCol = new TableColumn("Rental Duration Col");
            TableColumn rentalRateCol = new TableColumn("Rental rate");
            TableColumn lengthCol = new TableColumn("Length");
            TableColumn replacementCostCol = new TableColumn("Replacement cost");
            TableColumn ratingCol = new TableColumn("Rating");
            TableColumn specialFeaturesCol = new TableColumn("Special features");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            filmIdCol.setCellValueFactory(new PropertyValueFactory<>("film_id"));
            titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
            descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
            releasedCol.setCellValueFactory(new PropertyValueFactory<>("release_year"));
            languageIdCol.setCellValueFactory(new PropertyValueFactory<>("language_id"));
            originalLanguageCol.setCellValueFactory(new PropertyValueFactory<>("original_language_id"));
            rentalDurationCol.setCellValueFactory(new PropertyValueFactory<>("rental_duration"));
            rentalRateCol.setCellValueFactory(new PropertyValueFactory<>("rental_rate"));
            originalLanguageCol.setCellValueFactory(new PropertyValueFactory<>("original_language_id"));
            lengthCol.setCellValueFactory(new PropertyValueFactory<>("length"));
            replacementCostCol.setCellValueFactory(new PropertyValueFactory<>("replacement_cost"));
            ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
            specialFeaturesCol.setCellValueFactory(new PropertyValueFactory<>("special_features"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            tableView.getColumns().addAll(filmIdCol, titleCol, descriptionCol, releasedCol, languageIdCol, originalLanguageCol,
                    rentalDurationCol, rentalRateCol, lengthCol, replacementCostCol, ratingCol, specialFeaturesCol, lastUpdateCol);

        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("Inventory")) {
            TableColumn inventoryIdCol = new TableColumn("Inventory id");
            TableColumn filmIdCol = new TableColumn("Film id");
            TableColumn storeIdCol = new TableColumn("Store id");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            inventoryIdCol.setCellValueFactory(new PropertyValueFactory<>("inventory_id"));
            filmIdCol.setCellValueFactory(new PropertyValueFactory<>("film_id"));
            storeIdCol.setCellValueFactory(new PropertyValueFactory<>("store_id"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            tableView.getColumns().addAll(inventoryIdCol, filmIdCol, storeIdCol, lastUpdateCol);

        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("Language")) {
            TableColumn idCol = new TableColumn("Language id");
            TableColumn nameCol = new TableColumn("Name");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("language_id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            tableView.getColumns().addAll(idCol, nameCol, lastUpdateCol);

        } else if (choiceBox.getSelectionModel().getSelectedItem().equals("Payment")) {
            TableColumn paymentIdCol = new TableColumn("Payment id");
            TableColumn customerIdCol = new TableColumn("Customer id");
            TableColumn staffIdCol = new TableColumn("Staff id");
            TableColumn rentalIdCol = new TableColumn("Rental id");
            TableColumn amountCol = new TableColumn("Amount");
            TableColumn paymentDateCol = new TableColumn("Payment date");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            paymentIdCol.setCellValueFactory(new PropertyValueFactory<>("payment_id"));
            customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
            staffIdCol.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
            rentalIdCol.setCellValueFactory(new PropertyValueFactory<>("rental_id"));
            amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
            paymentDateCol.setCellValueFactory(new PropertyValueFactory<>("payment_date"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));



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
