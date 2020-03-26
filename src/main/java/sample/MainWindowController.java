package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import tables.Actor;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private Button updateBtn, deleteBtn, insertBtn, addToJointTableBtn, removeBtn;
    @FXML
    private Button selectBtnOne,selectBtnTwo,selectBtnThree,selectBtnFour;

    @FXML
    private TextField textField1, textField2, textField3, textField4, textField5, textField6;
    @FXML
    private TextField textField7, textField8, textField9, textField10, textField11, textField12, textField13;

    @FXML
    private ChoiceBox<String> choiceBox1, choiceBox2, insertChoiceBox, choiceBox3, choiceBox4, choiceBox5;

    @FXML
    private TableView<?> tableView1, tableView2, tableView3, tableView4;

    @FXML
    private ListView listView;

    private ObservableList<String> databaseTablesList = FXCollections.observableArrayList("Actor",
            "Address", "Category", "City", "Country", "Customer", "Film",
            "Inventory", "Language", "Payment", "Rental", "Staff", "Store");

    private TextField[] textFieldsArray;

    @FXML
    void insert(ActionEvent event) {

    }

    public void makeTextFieldsVisible(int nr) {
        for (int i = 0; i < nr; i++) {
            textFieldsArray[i].setVisible(true);
        }
    }

    public void makeTextFieldsInvisible() {
        for (TextField textField : textFieldsArray) {
            textField.setVisible(false);
        }
    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }

    @FXML
    void addToJointTable(ActionEvent event) {

    }

    @FXML
    void showJointTables(ActionEvent event) {

    }

    @FXML
    void openToFirstTableView(ActionEvent event) {
        selectTable(choiceBox1.getSelectionModel().getSelectedItem(), 1);
    }

    @FXML
    void openToSecondTableView(ActionEvent event) {
        selectTable(choiceBox2.getSelectionModel().getSelectedItem(), 2);
    }

    @FXML
    void openToThirdTableView(ActionEvent event) {
        selectTable(choiceBox3.getSelectionModel().getSelectedItem(), 3);
    }

    @FXML
    void openToFourthTableView(ActionEvent event) {
        selectTable(choiceBox4.getSelectionModel().getSelectedItem(), 4);
    }

    @FXML
    void adjustVisibleTextFields(ActionEvent event) {
        makeTextFieldsInvisible();

        switch (insertChoiceBox.getSelectionModel().getSelectedItem().toUpperCase()) {
            case "ACTOR":
                makeTextFieldsVisible(4);
                break;
            case "ADDRESS":
                makeTextFieldsVisible(9);
                break;
            case "CATEGORY":
                makeTextFieldsVisible(3);
                break;
            case "CITY":
                makeTextFieldsVisible(4);
                break;
            case "COUNTRY":
                makeTextFieldsVisible(3);
                break;
            case "CUSTOMER":
                makeTextFieldsVisible(9);
                break;
            case "FILM":
                makeTextFieldsVisible(13);
                break;
            case "INVENTORY":
                makeTextFieldsVisible(4);
                break;
            case "LANGUAGE":
                makeTextFieldsVisible(3);
                break;
            case "PAYMENT":
                makeTextFieldsVisible(7);
                break;
            case "RENTAL":
                makeTextFieldsVisible(7);
                break;
            case "STAFF":
                makeTextFieldsVisible(11);
                break;
            case "STORE":
                makeTextFieldsVisible(4);
                break;
        }
    }

    private void selectTable(String table, int tableNumber) {

        if (table.equals("Actor")) {
            TableColumn idCol = new TableColumn("Actor id");
            TableColumn firstNameCol = new TableColumn("First Name");
            TableColumn lastNameCol = new TableColumn("Last Name");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("actor_id"));
            firstNameCol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
            lastNameCol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));


            sortToTableView(tableNumber).getColumns().addAll(idCol, firstNameCol, lastNameCol, lastUpdateCol);

        } else if (table.equals("Address")) {
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

            sortToTableView(tableNumber).getColumns().addAll(idCol, addressCol, secondAddressCol, districtCol, cityCol,
                    postcodeCol, phoneCol, locationCol, lastUpdateCol);

        } else if (table.equals("Category")) {
            TableColumn idCol = new TableColumn("Category id");
            TableColumn nameCol = new TableColumn("Name");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("category_id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(idCol, nameCol, lastUpdateCol);

        } else if (table.equals("City")) {
            TableColumn idCol = new TableColumn("City id");
            TableColumn nameCol = new TableColumn("Name");
            TableColumn countryIdCol = new TableColumn("Country id");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("city_id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("city"));
            countryIdCol.setCellValueFactory(new PropertyValueFactory<>("country_id"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(idCol, nameCol, countryIdCol, lastUpdateCol);

        } else if (table.equals("Country")) {
            TableColumn idCol = new TableColumn("Country id");
            TableColumn nameCol = new TableColumn("Country");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("country_id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("country"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));


            sortToTableView(tableNumber).getColumns().addAll(idCol, nameCol, lastUpdateCol);

        } else if (table.equals("Customer")) {
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


            sortToTableView(tableNumber).getColumns().addAll(customerIdCol, storeIdCol, firstNameCol, lastNameCol, emailCol,
                    activeCol, createdCol, lastUpdateCol);

        } else if (table.equals("Film")) {
            TableColumn filmIdCol = new TableColumn("Film id");
            TableColumn titleCol = new TableColumn("Title");
            TableColumn descriptionCol = new TableColumn("Description");
            TableColumn releasedCol = new TableColumn("Release year");
            TableColumn languageIdCol = new TableColumn("Language id");
            TableColumn originalLanguageCol = new TableColumn("Original language id");
            TableColumn rentalDurationCol = new TableColumn("Rental Duration");
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

            sortToTableView(tableNumber).getColumns().addAll(filmIdCol, titleCol, descriptionCol, releasedCol, languageIdCol, originalLanguageCol,
                    rentalDurationCol, rentalRateCol, lengthCol, replacementCostCol, ratingCol, specialFeaturesCol, lastUpdateCol);

        } else if (table.equals("Inventory")) {
            TableColumn inventoryIdCol = new TableColumn("Inventory id");
            TableColumn filmIdCol = new TableColumn("Film id");
            TableColumn storeIdCol = new TableColumn("Store id");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            inventoryIdCol.setCellValueFactory(new PropertyValueFactory<>("inventory_id"));
            filmIdCol.setCellValueFactory(new PropertyValueFactory<>("film_id"));
            storeIdCol.setCellValueFactory(new PropertyValueFactory<>("store_id"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(inventoryIdCol, filmIdCol, storeIdCol, lastUpdateCol);

        } else if (table.equals("Language")) {
            TableColumn idCol = new TableColumn("Language id");
            TableColumn nameCol = new TableColumn("Name");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("language_id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(idCol, nameCol, lastUpdateCol);

        } else if (table.equals("Payment")) {
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

            sortToTableView(tableNumber).getColumns().addAll(paymentIdCol, customerIdCol, staffIdCol, rentalIdCol,
                    amountCol, paymentDateCol, lastUpdateCol);

        } else if (table.equals("Rental")) {
            TableColumn rentalIdCol = new TableColumn("Rental id");
            TableColumn rentalDateCol = new TableColumn("Rental date");
            TableColumn inventoryIdCol = new TableColumn("Inventory id");
            TableColumn customerIdCol = new TableColumn("Customer id");
            TableColumn returnDateCol = new TableColumn("Return date");
            TableColumn staffIdCol = new TableColumn("Staff id");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            rentalIdCol.setCellValueFactory(new PropertyValueFactory<>("rental_id"));
            rentalDateCol.setCellValueFactory(new PropertyValueFactory<>("rental_date"));
            inventoryIdCol.setCellValueFactory(new PropertyValueFactory<>("inventory_id"));
            customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
            returnDateCol.setCellValueFactory(new PropertyValueFactory<>("return_date"));
            staffIdCol.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(rentalIdCol, rentalDateCol, inventoryIdCol, customerIdCol,
                    returnDateCol, staffIdCol, lastUpdateCol);

        } else if (table.equals("Staff")) {
            TableColumn idCol = new TableColumn("Staff id");
            TableColumn firstNameCol = new TableColumn("First Name");
            TableColumn lastNameCol = new TableColumn("Last Name");
            TableColumn addressIdCol = new TableColumn("Address id");
            TableColumn pictureCol = new TableColumn("Picture");
            TableColumn emailCol = new TableColumn("Email");
            TableColumn storeIDCol = new TableColumn("Store id");
            TableColumn activeCol = new TableColumn("Active");
            TableColumn usernameCol = new TableColumn("Username");
            TableColumn passwordCol = new TableColumn("Password");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
            firstNameCol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
            lastNameCol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
            addressIdCol.setCellValueFactory(new PropertyValueFactory<>("address_id"));
            pictureCol.setCellValueFactory(new PropertyValueFactory<>("picture"));
            emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
            storeIDCol.setCellValueFactory(new PropertyValueFactory<>("store_id"));
            activeCol.setCellValueFactory(new PropertyValueFactory<>("active"));
            usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
            passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(idCol, firstNameCol, lastNameCol, addressIdCol, pictureCol, emailCol,
                    storeIDCol, activeCol, usernameCol, passwordCol, lastNameCol);

        } else if (table.equals("Store")) {
            TableColumn storeIdCol = new TableColumn("Store id");
            TableColumn managerStaffIdCol = new TableColumn("Manager staff id");
            TableColumn addressIdCol = new TableColumn("Address id");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            storeIdCol.setCellValueFactory(new PropertyValueFactory<>("store_id"));
            managerStaffIdCol.setCellValueFactory(new PropertyValueFactory<>("manager_staff_id"));
            addressIdCol.setCellValueFactory(new PropertyValueFactory<>("address_id"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(storeIdCol, managerStaffIdCol, addressIdCol, lastUpdateCol);

        } else {
            System.out.println("Nothing");
            tableView1.getColumns().clear();
        }
    }

    public TableView sortToTableView(int tableNumber) {

        System.out.println("in sort to tableView");
        switch (tableNumber) {
            case 1:
                tableView1.getColumns().clear();
                return tableView1;
            case 2:
                tableView2.getColumns().clear();
                return tableView2;
            case 3:
                tableView3.getColumns().clear();
                return tableView3;
            case 4:
                tableView4.getColumns().clear();
                return tableView4;
            default:
                return null;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox1.setItems(FXCollections.observableArrayList(databaseTablesList));
        choiceBox2.setItems(FXCollections.observableArrayList(databaseTablesList));
        insertChoiceBox.setItems(FXCollections.observableArrayList(databaseTablesList));
        choiceBox3.setItems(FXCollections.observableArrayList(databaseTablesList));
        choiceBox4.setItems(FXCollections.observableArrayList(databaseTablesList));
        choiceBox5.setItems(FXCollections.observableArrayList(
                "Actors in movies", "Film & categories", "Film & text"));

        textFieldsArray = new TextField[]{textField1, textField2, textField3, textField4, textField5, textField6,
                textField7, textField8, textField9, textField10, textField11, textField12, textField13};

        makeTextFieldsInvisible();
    }
}
