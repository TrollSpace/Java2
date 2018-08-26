package base.controllers;

import base.objects.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class EditDialogController {

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtFIO;

    @FXML
    private TextField txtBirthday;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtAddress;
    private Person person;

    @FXML
    public void clickOK(ActionEvent actionEvent) {
        person.setFio(txtFIO.getText());
        person.setBirthday(txtBirthday.getText());
        person.setPhone(txtPhone.getText());
        person.setAddress(txtAddress.getText());
        close(actionEvent);
    }

    @FXML
    public void close (ActionEvent actionEvent){
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void setPerson(Person person) {
        this.person = person;
        txtFIO.setText(person.getFio());
        txtAddress.setText(person.getAddress());
        txtBirthday.setText(person.getBirthday());
        txtPhone.setText(person.getPhone());
    }

    public void clickCancel(ActionEvent actionEvent) {
        person = null;
        close(actionEvent);

    }

    public Person getPerson() {
        return person;
    }
}
