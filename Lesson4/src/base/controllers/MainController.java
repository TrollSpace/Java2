package base.controllers;

import base.interfaces.AddressBook;
import base.interfaces.impl.CollectionAddressBook;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import base.objects.Person;
import javafx.stage.StageStyle;

import java.io.IOException;


public class MainController {

    private AddressBook db;
    private ObservableList personList;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField txtSearch;

    @FXML
    private TableView tableAddressBook;

    @FXML
    private TableColumn<Person, String> columnFIO;

    @FXML
    private TableColumn<Person, String> columnBirthday;

    @FXML
    private TableColumn<Person, String> columnAddress;

    @FXML
    private TableColumn<Person, String> columnPhone;


    @FXML
    private Label labelCount;


    @FXML
    private void initialize() {
        columnFIO.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        columnBirthday.setCellValueFactory(new PropertyValueFactory<Person, String>("birthday"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<Person, String>("address"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
        db = new CollectionAddressBook();
        personList = FXCollections.observableArrayList();
        initListeners();
        tableAddressBook.setItems(personList);
        personList.addAll(db.getListPerson());
        FilteredList<Person> searchComp = new FilteredList<Person>(personList, p -> true);
        txtSearch.textProperty().addListener(((observable, oldValue, newValue) -> {
            searchComp.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (person.getFio().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        }));
        SortedList<Person> sortedData = new SortedList<>(searchComp);
        sortedData.comparatorProperty().bind(tableAddressBook.comparatorProperty());
        tableAddressBook.setItems(sortedData);
        updateCountLabel();
    }


    private void initListeners() {
        personList.addListener((ListChangeListener<Person>) personList -> {
            System.out.println(personList);
            updateCountLabel();

        });
    }


    private void updateCountLabel() {
        labelCount.setText("Total persons: " + db.getListPerson().size());
    }

    public void showDialogAdd(ActionEvent actionEvent) {

        try {


            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "../fxml/edit.fxml"
                    )
            );

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(
                    new Scene(
                            (Pane) loader.load()
                    )
            );

            EditDialogController controller =
                    loader.<EditDialogController>getController();
            Person person = new Person("", "", "", "");
            controller.setPerson(person);


            stage.setTitle("Add person date");
            stage.setMinHeight(200);
            stage.setMinWidth(300);
            stage.setResizable(false);

            stage.showAndWait();
            person = controller.getPerson();  // TODO check if needed
            if (person != null) {
                personList.add(person);
                db.add(person);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        updateCountLabel();
    }

    public void showDialogEdit(ActionEvent actionEvent) {
        if (tableAddressBook.getSelectionModel().getSelectedItem() != null) {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "../fxml/edit.fxml"
                        )
                );
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setScene(
                        new Scene(
                                (Pane) loader.load()
                        )
                );
                EditDialogController controller =
                        loader.<EditDialogController>getController();
                Person selectedPerson = (Person) tableAddressBook.getSelectionModel().getSelectedItem();
                Person person = new Person(selectedPerson.getFio(), selectedPerson.getBirthday(),
                        selectedPerson.getAddress(), selectedPerson.getPhone());
                controller.setPerson(person);
                stage.setTitle("Edit person date");
                stage.setMinHeight(200);
                stage.setMinWidth(300);
                stage.setResizable(false);
                stage.showAndWait();
                person = controller.getPerson();  // TODO check if needed
                System.out.println(">>>>> " + selectedPerson.getFio());
                personList.add(person);
                personList.remove(selectedPerson);
                db.save(person);
                db.add(person);
                db.delete(selectedPerson);
                updateCountLabel();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void deletePerson(ActionEvent actionEvent) {
        if (tableAddressBook.getSelectionModel().getSelectedItem() != null) {
            Person selectedPerson = (Person) tableAddressBook.getSelectionModel().getSelectedItem();
            personList.remove(selectedPerson);
            db.delete(selectedPerson);
            updateCountLabel();
        } else {
            return;
        }
    }
}
