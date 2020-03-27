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
import util.ObjectGetter;
import util.ObjectGetterOLD;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private TextField textField1, textField2, textField3, textField4, textField5, textField6;
    @FXML
    private TextField textField7, textField8, textField9, textField10, textField11, textField12;
    @FXML
    private ChoiceBox<String> choiceBox1, choiceBox2, choiceBox3, choiceBox4, choiceBox5, insertChoiceBox;
    @FXML
    private TableView<?> tableView1, tableView2, tableView3, tableView4;
    @FXML
    private Button insertPictureBtn;
    @FXML
    private ListView listView;

    private ObservableList<String> databaseTablesList = FXCollections.observableArrayList("Actor",
            "Address", "Category", "City", "Country", "Customer", "Film",
            "Inventory", "Language", "Payment", "Rental", "Staff", "Store");

    private TextField[] textFieldsArray;
    private String[] promptTextActorArray = new String[]{"First name", "Last name", "Last update"};
    private String[] promptTextAddressArray = new String[]{"Address", "Second address", "District", "City_id",
            "Postal code", "Phone", "Location", "Last update"};
    private String[] promptTextCategoryArray = new String[]{"Category", "Last update"};
    private String[] promptTextCityArray = new String[]{"City", "Country id", "Last update"};
    private String[] promptTextCountryArray = new String[]{"Country", "Last update"};
    private String[] promptTextCustomerArray = new String[]{"Store id", "First name", "Last name", "Email",
            "Address id", "Active", "Create date", "Last update"};
    private String[] promptTextFilmArray = new String[]{"Title", "Description", "Release year", "Language id",
            "Original language id", "Rental duration", "Rental rate", "Length", "Replacement cost", "Rating",
            "Special features", "Last update"};
    private String[] promptTextInventoryArray = new String[]{"Film id", "Store id", "Last update"};
    private String[] promptTextLanguageArray = new String[]{"Language", "Last update"};
    private String[] promptTextPaymentArray = new String[]{"Customer id", "Staff id", "Rental id", "Amount",
            "Payment date", "Last update"};
    private String[] promptTextRentalArray = new String[]{"Rental date", "Inventory id", "Customer id", "Return date",
            "Staff id", "Last update"};
    private String[] promptTextStaffArray = new String[]{"First name", "Last name", "Address id", "Email",
            "Store id", "Active", "Username", "Password", "Last update"};
    private String[] promptTextStoreArray = new String[]{"Manager staff id", "Address id", "Last update"};


    @FXML
    void insert(ActionEvent event) {


        insertPictureBtn.setVisible(false);
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
    void insertStaffPicture(ActionEvent event) {

    }

    @FXML
    void openToFirstTableView(ActionEvent event) throws Exception {
        selectTable(choiceBox1.getSelectionModel().getSelectedItem(), 1);
    }

    @FXML
    void openToSecondTableView(ActionEvent event) throws Exception {
        selectTable(choiceBox2.getSelectionModel().getSelectedItem(), 2);
    }

    @FXML
    void openToThirdTableView(ActionEvent event) throws Exception {
        selectTable(choiceBox3.getSelectionModel().getSelectedItem(), 3);
    }

    @FXML
    void openToFourthTableView(ActionEvent event) throws Exception {
        selectTable(choiceBox4.getSelectionModel().getSelectedItem(), 4);
    }

    @FXML
    void adjustVisibleTextFields(ActionEvent event) {
        makeTextFieldsInvisible();

        switch (insertChoiceBox.getSelectionModel().getSelectedItem().toUpperCase()) {
            case "ACTOR":
                makeTextFieldsVisible(promptTextActorArray);
                break;
            case "ADDRESS":
                makeTextFieldsVisible(promptTextAddressArray);
                break;
            case "CATEGORY":
                makeTextFieldsVisible(promptTextCategoryArray);
                break;
            case "CITY":
                makeTextFieldsVisible(promptTextCityArray);
                break;
            case "COUNTRY":
                makeTextFieldsVisible(promptTextCountryArray);
                break;
            case "CUSTOMER":
                makeTextFieldsVisible(promptTextCustomerArray);
                break;
            case "FILM":
                makeTextFieldsVisible(promptTextFilmArray);
                break;
            case "INVENTORY":
                makeTextFieldsVisible(promptTextInventoryArray);
                break;
            case "LANGUAGE":
                makeTextFieldsVisible(promptTextLanguageArray);
                break;
            case "PAYMENT":
                makeTextFieldsVisible(promptTextPaymentArray);
                break;
            case "RENTAL":
                makeTextFieldsVisible(promptTextRentalArray);
                break;
            case "STAFF":
                makeTextFieldsVisible(promptTextStaffArray);
                insertPictureBtn.setVisible(true);
                break;
            case "STORE":
                makeTextFieldsVisible(promptTextStoreArray);
                break;
        }
    }


    public void makeTextFieldsVisible(String[] promptText) {
        for (int i = 0; i < promptText.length; i++) {
            textFieldsArray[i].setVisible(true);
            textFieldsArray[i].setPromptText(promptText[i]);
        }
    }

    public void makeTextFieldsInvisible() {
        for (TextField textField : textFieldsArray) {
            textField.setVisible(false);
        }
    }

    public void clearTableView(int tableNumber) {
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


    private void selectTable(String table, int tableNumber) throws Exception {

        clearTableView(tableNumber);

        if (table.equals("Actor")) {
            TableColumn<Actor, Number> idCol = new TableColumn<>("Actor id");
            TableColumn<Actor, String> firstNameCol = new TableColumn<>("First Name");
            TableColumn<Actor, String> lastNameCol = new TableColumn<>("Last Name");
            TableColumn<Actor, String> lastUpdateCol = new TableColumn<>("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("actor_id"));
            firstNameCol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
            lastNameCol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(idCol, firstNameCol, lastNameCol, lastUpdateCol);

            ObservableList<Actor> actors = FXCollections.observableList(new ObjectGetterOLD().getActor());
            sortToTableView(tableNumber).setItems(actors);

            firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            firstNameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setFirst_name(t.getNewValue());
            });

            lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastNameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_name(t.getNewValue());
            });

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());
            });


        } else if (table.equals("Address")) {
            TableColumn<Address, Number> idCol = new TableColumn<>("Address id");
            TableColumn<Address, String> addressCol = new TableColumn<>("Address");
            TableColumn<Address, String> secondAddressCol = new TableColumn<>("Address 2");
            TableColumn<Address, String> districtCol = new TableColumn<>("District");
            TableColumn<Address, Number> cityIdCol = new TableColumn<>("City id");
            TableColumn<Address, String> postcodeCol = new TableColumn<>("Postal code");
            TableColumn<Address, String> phoneCol = new TableColumn<>("Phone");
            TableColumn<Address, String> locationCol = new TableColumn<>("Location");
            TableColumn<Address, String> lastUpdateCol = new TableColumn<>("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("address_id"));
            addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
            secondAddressCol.setCellValueFactory(new PropertyValueFactory<>("address2"));
            districtCol.setCellValueFactory(new PropertyValueFactory<>("district"));
            cityIdCol.setCellValueFactory(new PropertyValueFactory<>("city_obj_id"));
            postcodeCol.setCellValueFactory(new PropertyValueFactory<>("postal_code"));
            phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
            locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(idCol, addressCol, secondAddressCol, districtCol, cityIdCol,
                    postcodeCol, phoneCol, locationCol, lastUpdateCol);

            ObservableList<Address> addresses = FXCollections.observableList(new ObjectGetterOLD().getAddress());
            sortToTableView(tableNumber).setItems(addresses);

            addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
            addressCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setAddress(t.getNewValue());
            });

            secondAddressCol.setCellFactory(TextFieldTableCell.forTableColumn());
            secondAddressCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setAddress2(t.getNewValue());
            });

            districtCol.setCellFactory(TextFieldTableCell.forTableColumn());
            districtCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setDistrict(t.getNewValue());
            });

            cityIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            cityIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setCity_id(t.getNewValue().intValue());
            });

            postcodeCol.setCellFactory(TextFieldTableCell.forTableColumn());
            postcodeCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setPostal_code(t.getNewValue());
            });

            phoneCol.setCellFactory(TextFieldTableCell.forTableColumn());
            phoneCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setPhone(t.getNewValue());
            });

            /*
            locationCol.setCellFactory(TextFieldTableCell.forTableColumn());
            locationCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLocation(t.getNewValue());
            });

             */

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());
            });

        } else if (table.equals("Category")) {
            TableColumn<Category, Number> idCol = new TableColumn<>("Category id");
            TableColumn<Category, String> nameCol = new TableColumn<>("Name");
            TableColumn<Category, String> lastUpdateCol = new TableColumn<>("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("category_id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(idCol, nameCol, lastUpdateCol);

            ObservableList<Category> categories = FXCollections.observableList(new ObjectGetterOLD().getCategory());
            sortToTableView(tableNumber).setItems(categories);

            nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            nameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setName(t.getNewValue());
            });

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());
            });

        } else if (table.equals("City")) {
            TableColumn<City, Number> idCol = new TableColumn<>("City id");
            TableColumn<City, String> nameCol = new TableColumn<>("City");
            TableColumn<City, Number> countryIdCol = new TableColumn<>("Country id");
            TableColumn<City, String> lastUpdateCol = new TableColumn<>("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("city_id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("city"));
            countryIdCol.setCellValueFactory(new PropertyValueFactory<>("country_obj_id"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(idCol, nameCol, countryIdCol, lastUpdateCol);

            ObservableList<City> cities = FXCollections.observableList(new ObjectGetterOLD().getCity());
            sortToTableView(tableNumber).setItems(cities);

            nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            nameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setCity(t.getNewValue());
            });

            countryIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            countryIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setCountry_id(t.getNewValue().intValue());
            });

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());
            });


        } else if (table.equals("Country")) {
            TableColumn<Country, Number> idCol = new TableColumn<>("Country id");
            TableColumn<Country, String> nameCol = new TableColumn<>("Country");
            TableColumn<Country, String> lastUpdateCol = new TableColumn<>("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("country_id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("country"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));


            sortToTableView(tableNumber).getColumns().addAll(idCol, nameCol, lastUpdateCol);

            ObservableList<Country> countries = FXCollections.observableList(new ObjectGetterOLD().getCountry());
            sortToTableView(tableNumber).setItems(countries);

            nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            nameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setCountry(t.getNewValue());
            });

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());
            });

        } else if (table.equals("Customer")) {
            TableColumn<Customer, Number> customerIdCol = new TableColumn<>("Customer id");
            TableColumn<Customer, Number> storeIdCol = new TableColumn<>("Store id");
            TableColumn<Customer, String> firstNameCol = new TableColumn<>("First Name");
            TableColumn<Customer, String> lastNameCol = new TableColumn<>("Last Name");
            TableColumn<Customer, String> emailCol = new TableColumn<>("Email");
            TableColumn<Customer, Number> addressIdCol = new TableColumn<>("Address id");
            TableColumn<Customer, Number> activeCol = new TableColumn<>("Active");
            TableColumn<Customer, String> createdCol = new TableColumn<>("Created date");
            TableColumn<Customer, String> lastUpdateCol = new TableColumn<>("Last update");

            customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
            storeIdCol.setCellValueFactory(new PropertyValueFactory<>("store_obj_id"));
            firstNameCol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
            lastNameCol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
            emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
            addressIdCol.setCellValueFactory(new PropertyValueFactory<>("address_obj_id"));
            activeCol.setCellValueFactory(new PropertyValueFactory<>("active"));
            createdCol.setCellValueFactory(new PropertyValueFactory<>("create_date"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));


            sortToTableView(tableNumber).getColumns().addAll(customerIdCol, storeIdCol, firstNameCol, lastNameCol, emailCol,
                   addressIdCol, activeCol, createdCol, lastUpdateCol);

            ObservableList<Customer> customers = FXCollections.observableList(new ObjectGetterOLD().getCustomer());
            sortToTableView(tableNumber).setItems(customers);

            firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            firstNameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setFirst_name(t.getNewValue());
            });

            lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastNameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_name(t.getNewValue());
            });

            emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
            emailCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setEmail(t.getNewValue());
            });

            addressIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            addressIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setAddress_id(t.getNewValue().intValue());
            });

            storeIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            storeIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setStore_id(t.getNewValue().intValue());
            });

            activeCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            activeCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setActive(t.getNewValue().intValue());
            });

            createdCol.setCellFactory(TextFieldTableCell.forTableColumn());
            createdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setCreate_date(t.getNewValue());
            });

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());
            });

        } else if (table.equals("Film")) {
            TableColumn<Film, Number> filmIdCol = new TableColumn<>("Film id");
            TableColumn<Film, String> titleCol = new TableColumn<>("Title");
            TableColumn<Film, String> descriptionCol = new TableColumn<>("Description");
            TableColumn<Film, String> releasedCol = new TableColumn<>("Release year");
            TableColumn<Film, Number> languageIdCol = new TableColumn<>("Language id");
            TableColumn<Film, Number> originalLanguageCol = new TableColumn<>("Original language id");
            TableColumn<Film, Number> rentalDurationCol = new TableColumn<>("Rental Duration");
            TableColumn<Film, Number> rentalRateCol = new TableColumn<>("Rental rate");
            TableColumn<Film, Number> lengthCol = new TableColumn<>("Length");
            TableColumn<Film, Number> replacementCostCol = new TableColumn<>("Replacement cost");
            TableColumn<Film, String> ratingCol = new TableColumn<>("Rating");
            TableColumn<Film, String> specialFeaturesCol = new TableColumn<>("Special features");
            TableColumn<Film, String> lastUpdateCol = new TableColumn<>("Last update");

            filmIdCol.setCellValueFactory(new PropertyValueFactory<>("film_id"));
            titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
            descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
            releasedCol.setCellValueFactory(new PropertyValueFactory<>("release_year"));
            languageIdCol.setCellValueFactory(new PropertyValueFactory<>("language_obj_id"));
            originalLanguageCol.setCellValueFactory(new PropertyValueFactory<>("original_language_obj_id"));
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

            ObservableList<Film> films = FXCollections.observableList(new ObjectGetterOLD().getFilm());
            sortToTableView(tableNumber).setItems(films);

            titleCol.setCellFactory(TextFieldTableCell.forTableColumn());
            titleCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setTitle(t.getNewValue());
            });

            descriptionCol.setCellFactory(TextFieldTableCell.forTableColumn());
            descriptionCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setDescription(t.getNewValue());
            });

            releasedCol.setCellFactory(TextFieldTableCell.forTableColumn());
            releasedCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setRelease_year(t.getNewValue());
            });

            languageIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            languageIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLanguage_id(t.getNewValue().intValue());
            });

            originalLanguageCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            originalLanguageCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setOriginal_language_id(t.getNewValue().intValue());
            });

            rentalDurationCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            rentalDurationCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setRental_duration(t.getNewValue().intValue());
            });

            rentalRateCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            rentalRateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setRental_rate(t.getNewValue().doubleValue());
            });

            lengthCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            lengthCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLength(t.getNewValue().intValue());
            });

            replacementCostCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            replacementCostCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setReplacement_cost(t.getNewValue().doubleValue());
            });

            ratingCol.setCellFactory(TextFieldTableCell.forTableColumn());
            ratingCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setRating(t.getNewValue());
            });

            specialFeaturesCol.setCellFactory(TextFieldTableCell.forTableColumn());
            specialFeaturesCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setSpecial_features(t.getNewValue());
            });

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());
            });


        } else if (table.equals("Inventory")) {
            TableColumn<Inventory, Number> inventoryIdCol = new TableColumn<>("Inventory id");
            TableColumn<Inventory, Number> filmIdCol = new TableColumn<>("Film id");
            TableColumn<Inventory, Number> storeIdCol = new TableColumn<>("Store id");
            TableColumn<Inventory, String> lastUpdateCol = new TableColumn<>("Last update");

            inventoryIdCol.setCellValueFactory(new PropertyValueFactory<>("inventory_id"));
            filmIdCol.setCellValueFactory(new PropertyValueFactory<>("film_obj_id"));
            storeIdCol.setCellValueFactory(new PropertyValueFactory<>("store_obj_id"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(inventoryIdCol, filmIdCol, storeIdCol, lastUpdateCol);

            ObservableList<Inventory> inventories = FXCollections.observableList(new ObjectGetterOLD().getInventory());
            sortToTableView(tableNumber).setItems(inventories);

            filmIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            filmIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setFilm_id(t.getNewValue().intValue());
            });

            storeIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            storeIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setStore_id(t.getNewValue().intValue());
            });

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());
            });


        } else if (table.equals("Language")) {
            TableColumn<Language, Number> idCol = new TableColumn<>("Language id");
            TableColumn<Language, String> nameCol = new TableColumn<>("Name");
            TableColumn<Language, String> lastUpdateCol = new TableColumn<>("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("language_id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(idCol, nameCol, lastUpdateCol);

            ObservableList<Language> languages = FXCollections.observableList(new ObjectGetterOLD().getLanguage());
            sortToTableView(tableNumber).setItems(languages);

            nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            nameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setName(t.getNewValue());
            });

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());
            });


        } else if (table.equals("Payment")) {
            TableColumn<Payment, Number> paymentIdCol = new TableColumn("Payment id");
            TableColumn<Payment, Number> customerIdCol = new TableColumn("Customer id");
            TableColumn<Payment, Number> staffIdCol = new TableColumn("Staff id");
            TableColumn<Payment, Number> rentalIdCol = new TableColumn("Rental id");
            TableColumn<Payment, String> amountCol = new TableColumn("Amount");
            TableColumn<Payment, String> paymentDateCol = new TableColumn("Payment date");
            TableColumn<Payment, String> lastUpdateCol = new TableColumn("Last update");

            paymentIdCol.setCellValueFactory(new PropertyValueFactory<>("payment_id"));
            customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customer_obj_id"));
            staffIdCol.setCellValueFactory(new PropertyValueFactory<>("staff_obj_id"));
            rentalIdCol.setCellValueFactory(new PropertyValueFactory<>("rental_obj_id"));
            amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
            paymentDateCol.setCellValueFactory(new PropertyValueFactory<>("payment_date"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(paymentIdCol, customerIdCol, staffIdCol, rentalIdCol,
                    amountCol, paymentDateCol, lastUpdateCol);

            // sortToTableView(tableNumber).setItems();  //TO-DO: put observablelist in setItems
            ObservableList<Payment> payments = FXCollections.observableList(new ObjectGetterOLD().getPayment());
            sortToTableView(tableNumber).setItems(payments);

            customerIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            customerIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setCustomer_id(t.getNewValue().intValue());
            });

            staffIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            staffIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setStaff_id(t.getNewValue().intValue());
            });

            rentalIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            rentalIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setRental_id(t.getNewValue().intValue());
            });

            amountCol.setCellFactory(TextFieldTableCell.forTableColumn());
            amountCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setAmount(t.getNewValue());
            });

            paymentDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            paymentDateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setPayment_date(t.getNewValue());
            });

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());
            });

        } else if (table.equals("Rental")) {
            TableColumn<Rental, Number> rentalIdCol = new TableColumn("Rental id");
            TableColumn<Rental, String> rentalDateCol = new TableColumn("Rental date");
            TableColumn<Rental, Number> inventoryIdCol = new TableColumn("Inventory id");
            TableColumn<Rental, Number> customerIdCol = new TableColumn("Customer id");
            TableColumn<Rental, String> returnDateCol = new TableColumn("Return date");
            TableColumn<Rental, Number> staffIdCol = new TableColumn("Staff id");
            TableColumn<Rental, String> lastUpdateCol = new TableColumn("Last update");

            rentalIdCol.setCellValueFactory(new PropertyValueFactory<>("rental_id"));
            rentalDateCol.setCellValueFactory(new PropertyValueFactory<>("rental_date"));
            inventoryIdCol.setCellValueFactory(new PropertyValueFactory<>("inventory_obj_id"));
            customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customer_obj_id"));
            returnDateCol.setCellValueFactory(new PropertyValueFactory<>("return_date"));
            staffIdCol.setCellValueFactory(new PropertyValueFactory<>("staff_obj_id"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(rentalIdCol, rentalDateCol, inventoryIdCol, customerIdCol,
                    returnDateCol, staffIdCol, lastUpdateCol);
            ObservableList<Rental> rentals = FXCollections.observableList(new ObjectGetterOLD().getRental());
            sortToTableView(tableNumber).setItems(rentals);

            rentalDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            rentalDateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setRental_date(t.getNewValue());
            });

            inventoryIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            inventoryIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setInventory_id(t.getNewValue().intValue());
            });

            customerIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            customerIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setCustomer_id(t.getNewValue().intValue());
            });

            returnDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            returnDateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setReturn_date(t.getNewValue());
            });

            staffIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            staffIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setStaff_id(t.getNewValue().intValue());
            });

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());
            });

        } else if (table.equals("Staff")) {
            TableColumn<Staff, Number> idCol = new TableColumn<>("Staff id");
            TableColumn<Staff, String> firstNameCol = new TableColumn<>("First Name");
            TableColumn<Staff, String> lastNameCol = new TableColumn<>("Last Name");
            TableColumn<Staff, Number> addressIdCol = new TableColumn<>("Address id");
            TableColumn pictureCol = new TableColumn<>("Picture");
            TableColumn<Staff, String> emailCol = new TableColumn<>("Email");
            TableColumn<Staff, Number> storeIdCol = new TableColumn<>("Store id");
            TableColumn<Staff, Number> activeCol = new TableColumn<>("Active");
            TableColumn<Staff, String> usernameCol = new TableColumn<>("Username");
            TableColumn<Staff, String> passwordCol = new TableColumn<>("Password");
            TableColumn<Staff, String> lastUpdateCol = new TableColumn<>("Last update");

            idCol.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
            firstNameCol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
            lastNameCol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
            addressIdCol.setCellValueFactory(new PropertyValueFactory<>("address_obj_id"));
            pictureCol.setCellValueFactory(new PropertyValueFactory<>("picture"));
            emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
            storeIdCol.setCellValueFactory(new PropertyValueFactory<>("store_obj_id"));
            activeCol.setCellValueFactory(new PropertyValueFactory<>("active"));
            usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
            passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(idCol, firstNameCol, lastNameCol, addressIdCol, pictureCol, emailCol,
                    storeIdCol, activeCol, usernameCol, passwordCol, lastUpdateCol);

            ObservableList<Staff> staff = FXCollections.observableList(new ObjectGetterOLD().getStaff());
            sortToTableView(tableNumber).setItems(staff);

            firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            firstNameCol.setOnEditCommit(t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setFirst_name(t.getNewValue()));

            lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastNameCol.setOnEditCommit(t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_name(t.getNewValue()));

            addressIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            addressIdCol.setOnEditCommit(t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setAddress_id(t.getNewValue().intValue()));

            emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
            emailCol.setOnEditCommit(t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setEmail(t.getNewValue()));

            storeIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            storeIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setStore_id(t.getNewValue().intValue());
            });

            activeCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            activeCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setActive(t.getNewValue().intValue());
            });

            usernameCol.setCellFactory(TextFieldTableCell.forTableColumn());
            usernameCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setUsername(t.getNewValue());
            });

            passwordCol.setCellFactory(TextFieldTableCell.forTableColumn());
            passwordCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setPassword(t.getNewValue());
            });

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());
            });

        } else if (table.equals("Store")) {
            TableColumn<Store, Number> storeIdCol = new TableColumn<>("Store id");
            TableColumn<Store, Number> managerStaffIdCol = new TableColumn<>("Manager staff id");
            TableColumn<Store, Number> addressIdCol = new TableColumn<>("Address id");
            TableColumn<Store, String> lastUpdateCol = new TableColumn<>("Last update");

            storeIdCol.setCellValueFactory(new PropertyValueFactory<>("store_id"));
            managerStaffIdCol.setCellValueFactory(new PropertyValueFactory<>("manager_staff_obj_id"));
            addressIdCol.setCellValueFactory(new PropertyValueFactory<>("address_obj_id"));
            lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("last_update"));

            sortToTableView(tableNumber).getColumns().addAll(storeIdCol, managerStaffIdCol, addressIdCol, lastUpdateCol);

            ObservableList<Store> stores = FXCollections.observableList(new ObjectGetterOLD().getStore());
            sortToTableView(tableNumber).setItems(stores);


            managerStaffIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            managerStaffIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setManager_staff_id(t.getNewValue().intValue());
            });

            addressIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
            addressIdCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setAddress_id(t.getNewValue().intValue());
            });

            lastUpdateCol.setCellFactory(TextFieldTableCell.forTableColumn());
            lastUpdateCol.setOnEditCommit(t -> {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setLast_update(t.getNewValue());
            });

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
        choiceBox3.setItems(FXCollections.observableArrayList("Actor", "Film"));
        choiceBox4.setItems(FXCollections.observableArrayList("Film", "Category"));
        choiceBox5.setItems(FXCollections.observableArrayList(
                "Actors in movies", "Film & categories", "Film & description"));

        textFieldsArray = new TextField[]{textField1, textField2, textField3, textField4, textField5, textField6,
                textField7, textField8, textField9, textField10, textField11, textField12};

        insertPictureBtn.setVisible(false);
        tableView2.setEditable(true);
        makeTextFieldsInvisible();
    }
}
