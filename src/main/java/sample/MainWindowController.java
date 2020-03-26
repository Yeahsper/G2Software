package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.NumberStringConverter;
import tables.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

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

    public void clearTableView(int tableNumber){
        switch (tableNumber) {
            case 1:
                tableView1.getColumns().clear();
                tableView1.getItems().clear();
                break;
            case 2:
                tableView2.getColumns().clear();
                tableView2.getItems().clear();
                break;
            case 3:
                tableView3.getColumns().clear();
                tableView3.getItems().clear();
                break;
            case 4:
                tableView4.getColumns().clear();
                tableView4.getItems().clear();
                break;
        }
    }

    public TableView sortToTableView(int tableNumber) {

        switch (tableNumber) {
            case 1:
                return tableView1;
            case 2:
                return tableView2;
            case 3:
                return tableView3;
            case 4:
                return tableView4;
            default:
                return null;
        }
    }


    private void selectTable(String table, int tableNumber) {

        clearTableView(tableNumber);

        if (table.equals("Actor")) {
            TableColumn<Actor, Number> idCol = new TableColumn("Actor id");
            TableColumn<Actor, String> firstNameCol = new TableColumn("First Name");
            TableColumn<Actor, String> lastNameCol = new TableColumn("Last Name");
            TableColumn<Actor, String> lastUpdateCol = new TableColumn("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("actor_id"));
            firstNameCol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
            lastNameCol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(idCol, firstNameCol, lastNameCol, lastUpdateCol);

            //sortToTableView(tableNumber).setItems();  //TO-DO: put observablelist in setItems

            firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            firstNameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setFirst_name(t.getNewValue());});

            lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastNameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_name(t.getNewValue());});

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());});


        } else if (table.equals("Address")) {
            TableColumn<Address, Number> idCol = new TableColumn("Address id");
            TableColumn<Address, String> addressCol = new TableColumn("Address");
            TableColumn<Address, String> secondAddressCol = new TableColumn("Address 2");
            TableColumn<Address, String> districtCol = new TableColumn("District");
            TableColumn<Address, Number> cityIdCol = new TableColumn("City id");
            TableColumn<Address, String> postcodeCol = new TableColumn("Postal code");
            TableColumn<Address, String> phoneCol = new TableColumn("Phone");
            TableColumn<Address, String> locationCol = new TableColumn("Location");
            TableColumn<Address, String> lastUpdateCol = new TableColumn("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("address_id"));
            addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
            secondAddressCol.setCellValueFactory(new PropertyValueFactory<>("address2"));
            districtCol.setCellValueFactory(new PropertyValueFactory<>("district"));
            cityIdCol.setCellValueFactory(new PropertyValueFactory<>("city_id"));
            postcodeCol.setCellValueFactory(new PropertyValueFactory<>("postal_code"));
            phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
            locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(idCol, addressCol, secondAddressCol, districtCol, cityIdCol,
                    postcodeCol, phoneCol, locationCol, lastUpdateCol);

            // sortToTableView(tableNumber).setItems();  //TO-DO: put observablelist in setItems

            addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
            addressCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setAddress(t.getNewValue());});

            secondAddressCol.setCellFactory(TextFieldTableCell.forTableColumn());
            secondAddressCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setAddress2(t.getNewValue());});

            districtCol.setCellFactory(TextFieldTableCell.forTableColumn());
            districtCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setDistrict(t.getNewValue());});

            cityIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            cityIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setCity_id(t.getNewValue().intValue());});

            postcodeCol.setCellFactory(TextFieldTableCell.forTableColumn());
            postcodeCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setPostal_code(t.getNewValue());});

            phoneCol.setCellFactory(TextFieldTableCell.forTableColumn());
            phoneCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setPhone(t.getNewValue());});

            locationCol.setCellFactory(TextFieldTableCell.forTableColumn());
            locationCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLocation(t.getNewValue());});

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());});

        } else if (table.equals("Category")) {
            TableColumn idCol = new TableColumn("Category id");
            TableColumn nameCol = new TableColumn("Name");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("category_id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(idCol, nameCol, lastUpdateCol);

            // sortToTableView(tableNumber).setItems();  //TO-DO: put observablelist in setItems

            /*
            nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            nameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setName(t.getNewValue());});

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());});
             */



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
            // sortToTableView(tableNumber).setItems();  //TO-DO: put observablelist in setItems

            /*
            nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            nameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setName(t.getNewValue());});

            countryIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            countryIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setCountry_id(t.getNewValue().intValue());});

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());});

             */

        } else if (table.equals("Country")) {
            TableColumn idCol = new TableColumn("Country id");
            TableColumn nameCol = new TableColumn("Country");
            TableColumn lastUpdateCol = new TableColumn("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("country_id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("country"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));


            sortToTableView(tableNumber).getColumns().addAll(idCol, nameCol, lastUpdateCol);

            // sortToTableView(tableNumber).setItems();  //TO-DO: put observablelist in setItems

            /*
            nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            nameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setCountry(t.getNewValue().intValue());});

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());});

             */

        } else if (table.equals("Customer")) {
            TableColumn<Customer, Number> customerIdCol = new TableColumn("Customer id");
            TableColumn<Customer, Number> storeIdCol = new TableColumn("Store id");
            TableColumn<Customer, String> firstNameCol = new TableColumn("First Name");
            TableColumn<Customer, String> lastNameCol = new TableColumn("Last Name");
            TableColumn<Customer, String> emailCol = new TableColumn("Email");
            TableColumn<Customer, String> addressIdCol = new TableColumn("Address id");
            TableColumn<Customer, Number> activeCol = new TableColumn("Active");
            TableColumn<Customer, String> createdCol = new TableColumn("Created date");
            TableColumn<Customer, String> lastUpdateCol = new TableColumn("Last update");

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
            // sortToTableView(tableNumber).setItems();  //TO-DO: put observablelist in setItems

            firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            firstNameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setFirst_name(t.getNewValue());});

            lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastNameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_name(t.getNewValue());});

            emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
            emailCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setEmail(t.getNewValue());});

            //TO-DO check if these two really works,there's no get/set for ID
            /*
            addressIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            addressIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setAddress_OBJ(t.getNewValue().intValue());});

            storeIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            storeIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setStore_OBJ(t.getNewValue().intValue());});

             */

            activeCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            activeCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setActive(t.getNewValue().intValue());});

            createdCol.setCellFactory(TextFieldTableCell.forTableColumn());
            createdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setCreate_date(t.getNewValue());});

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());});

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

            // sortToTableView(tableNumber).setItems();  //TO-DO: put observablelist in setItems

            /*
            titleCol.setCellFactory(TextFieldTableCell.forTableColumn());
            titleCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setTitle(t.getNewValue());});

            descriptionCol.setCellFactory(TextFieldTableCell.forTableColumn());
            descriptionCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setDescription(t.getNewValue());});

            releasedCol.setCellFactory(TextFieldTableCell.forTableColumn());
            releasedCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setRelease_year(t.getNewValue());});

            languageIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            languageIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLanguage_id(t.getNewValue().intValue());});

            originalLanguageCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            originalLanguageCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setOriginal_language_id(t.getNewValue().intValue());});

            rentalRateCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            rentalRateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setRental_rate(t.getNewValue().doubleValue);});

            lengthCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            lengthCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLength(t.getNewValue().intValue());});

            ratingCol.setCellFactory(TextFieldTableCell.forTableColumn());
            ratingCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setRating(t.getNewValue());});

            specialFeaturesCol.setCellFactory(TextFieldTableCell.forTableColumn());
            specialFeaturesCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSpecial_features(t.getNewValue());});

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());});

             */

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
            // sortToTableView(tableNumber).setItems();  //TO-DO: put observablelist in setItems

            /*
            filmIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            filmIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setFilm_id(t.getNewValue().intValue());});

            storeIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            storeIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setStore_id(t.getNewValue().intValue());});

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());});

             */

        } else if (table.equals("Language")) {
            TableColumn<Language, Number> idCol = new TableColumn("Language id");
            TableColumn<Language, String> nameCol = new TableColumn("Name");
            TableColumn<Language, String> lastUpdateCol = new TableColumn("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("language_id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(idCol, nameCol, lastUpdateCol);

            //sortToTableView(tableNumber).setItems();  //TO-DO: put observablelist in setItems

            nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            nameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setName(t.getNewValue());});

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());});


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
            // sortToTableView(tableNumber).setItems();  //TO-DO: put observablelist in setItems

            /*
            customerIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            customerIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setCustomer_id(t.getNewValue().intValue());});

            staffIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            staffIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setStaff_id(t.getNewValue().intValue());});

            rentalIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            rentalIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setRental_id(t.getNewValue().intValue());});

            amountCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            amountCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setAmount(t.getNewValue().doubleValue);});

            paymentDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            paymentDateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setPayment_date(t.getNewValue());});

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());});

             */

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
            // sortToTableView(tableNumber).setItems();  //TO-DO: put observablelist in setItems

            /*
            rentalDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            rentalDateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setRental_date(t.getNewValue());});

            inventoryIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            inventoryIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setInventory_id(t.getNewValue().intValue());});

            customerIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            customerIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setCustomer_id(t.getNewValue().intValue());});

            returnDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            returnDateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setReturn_date(t.getNewValue());});

            staffIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            staffIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setStaff_id(t.getNewValue().intValue());});

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());});

             */

        } else if (table.equals("Staff")) {
            TableColumn idCol = new TableColumn("Staff id");
            TableColumn firstNameCol = new TableColumn("First Name");
            TableColumn lastNameCol = new TableColumn("Last Name");
            TableColumn addressIdCol = new TableColumn("Address id");
            TableColumn pictureCol = new TableColumn("Picture");
            TableColumn emailCol = new TableColumn("Email");
            TableColumn storeIdCol = new TableColumn("Store id");
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
            storeIdCol.setCellValueFactory(new PropertyValueFactory<>("store_id"));
            activeCol.setCellValueFactory(new PropertyValueFactory<>("active"));
            usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
            passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(idCol, firstNameCol, lastNameCol, addressIdCol, pictureCol, emailCol,
                    storeIdCol, activeCol, usernameCol, passwordCol, lastUpdateCol);
            // sortToTableView(tableNumber).setItems();  //TO-DO: put observablelist in setItems

            /*

            firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            firstNameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setFirst_name(t.getNewValue());});

            lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastNameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_name(t.getNewValue());});

            addressIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            addressIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setAddress_id(t.getNewValue().intValue());});

            emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
            emailCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setEmail(t.getNewValue());});

            storeIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            storeIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setStore_OBJ(t.getNewValue().intValue());});

            activeCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            activeCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setActive(t.getNewValue().intValue());});

            usernameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            usernameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setUsername(t.getNewValue());});

            passwordCol.setCellFactory(TextFieldTableCell.forTableColumn());
            passwordCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setPassword(t.getNewValue());});

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());});

             */

        } else if (table.equals("Store")) {
            TableColumn<Store, Number> storeIdCol = new TableColumn("Store id");
            TableColumn<Store, Number> managerStaffIdCol = new TableColumn("Manager staff id");
            TableColumn<Store, Number> addressIdCol = new TableColumn("Address id");
            TableColumn<Store, String> lastUpdateCol = new TableColumn("Last update");

            storeIdCol.setCellValueFactory(new PropertyValueFactory<>("store_id"));
            managerStaffIdCol.setCellValueFactory(new PropertyValueFactory<>("manager_staff_id"));
            addressIdCol.setCellValueFactory(new PropertyValueFactory<>("address_id"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(storeIdCol, managerStaffIdCol, addressIdCol, lastUpdateCol);
            // sortToTableView(tableNumber).setItems();  //TO-DO: put observablelist in setItems

            /*
            managerStaffIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            managerStaffIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setManager_staff_id(t.getNewValue().intValue());});

            addressIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            addressIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setAddress_id(t.getNewValue().intValue());});

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());});

             */
        } else {
            System.out.println("Nothing");
            tableView1.getColumns().clear();
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

        tableView2.setEditable(true);
        tableView3.setEditable(true);
        tableView4.setEditable(true);
        makeTextFieldsInvisible();
    }
}
