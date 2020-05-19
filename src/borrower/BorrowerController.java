/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borrower;

import dbconn.connecteddb;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Educ
 */
public class BorrowerController implements Initializable {

    @FXML
    private ToggleGroup GENDER;
    @FXML
    private TextField idborrowertextfirld;
    @FXML
    private TextField fnameborrowertextfirld;
    @FXML
    private TableView<borroweritems> tableviwe;
    @FXML
    private TableColumn<borroweritems, Integer> idcolumn;
    @FXML
    private TableColumn<borroweritems, String> fnamecolumn;
    @FXML
    private TableColumn<borroweritems, String> lnamecolumn;
    @FXML
    private TableColumn<borroweritems, Integer> mobilecolumn;
    @FXML
    private TableColumn<borroweritems, String> emailcolumn;
    @FXML
    private TableColumn<borroweritems, String> addresscolumn;
    @FXML
    private TableColumn<borroweritems, String> gendercolumn;
    @FXML
    private Button buttonaddborrower;
    @FXML
    private TextField lnameborrowertextfirld;
    @FXML
    private TextField mobileborrowertextfirld;
    @FXML
    private TextField emailborrowertextfirld;
    @FXML
    private TextField addressborrowertextfirld;
    @FXML
    private RadioButton maillogin;
    @FXML
    private RadioButton femaillogin;
    @FXML
    private Button buttonupdate;
    @FXML
    private RadioButton femailupdate;
    @FXML
    private RadioButton mailupdate;
    @FXML
    private TextField updateaddresstextfield;
    @FXML
    private TextField updateemailtextfield;
    @FXML
    private TextField updatemobiletextfield;
    @FXML
    private TextField updatelnametextfield;
    @FXML
    private TextField updatefnametextfield;
    @FXML
    private TextField updateidtextfield;
    @FXML
    private TextField iddeletetextfield;
    @FXML
    private Button buttondeleteborrower;
    @FXML
    private Button buttonsearch;
    @FXML
    private TextField idsearchborrower;
    @FXML
    private TextArea outputsearchtextarea;
    private String radiolable;
    /**
     * Initializes the controller class.
     */
    connecteddb c = new connecteddb();
    @FXML
    private Button buttonshowborrower;
    @FXML
    private Button buttonresetborrower1;
    @FXML
    private Button buttonreset;
    @FXML
    private Button buttonback;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        c.getconnectiondb();

        idcolumn.setCellValueFactory(new PropertyValueFactory("id"));
        fnamecolumn.setCellValueFactory(new PropertyValueFactory("fname"));
        lnamecolumn.setCellValueFactory(new PropertyValueFactory("lname"));
        mobilecolumn.setCellValueFactory(new PropertyValueFactory("mobile"));
        emailcolumn.setCellValueFactory(new PropertyValueFactory("email"));
        addresscolumn.setCellValueFactory(new PropertyValueFactory("address"));
        gendercolumn.setCellValueFactory(new PropertyValueFactory("gender"));

        tableviwe.getSelectionModel().selectedItemProperty().addListener(
                event -> showSelectedbook());
    }

    @FXML
    private void buttonaddborrowerHandle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ADD BORROWER  ");
        alert.setHeaderText("Do you really want to add the borrower ?");
        alert.setContentText("add borrower");
        alert.showAndWait();
        //
        maillogin.setOnAction(e -> {
            radiolable = maillogin.getText();
        });
        femaillogin.setOnAction(e -> {
            radiolable = femaillogin.getText();
        });

        int add = Integer.parseInt(idborrowertextfirld.getText());
        String add1 = fnameborrowertextfirld.getText();
        String add2 = lnameborrowertextfirld.getText();
        int add3 = Integer.parseInt(mobileborrowertextfirld.getText());
        String add4 = emailborrowertextfirld.getText();
        String add5 = addressborrowertextfirld.getText();
        String add6 = radiolable;

        int stuts = c.addborrow(add, add1, add2, add3, add4, add5, add6);
        switch (stuts) {
            case 0: {
                idcolumn.setText("database connected");

            }
            break;
            case -1:
                JOptionPane.showMessageDialog(null, "connection faild");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "username or password wrong");
                break;
        }

    }

    @FXML
    private void buttonupdateHandle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("UPDATE BORROWER  ");
        alert.setHeaderText("Do you really want to update the borrower ?");
        alert.setContentText("update borrower");
        alert.showAndWait();
        //
        int uupp = Integer.parseInt(updateidtextfield.getText());
        String uupp1 = updatefnametextfield.getText();
        String uupp2 = updatelnametextfield.getText();
        int uupp3 = Integer.parseInt(updatemobiletextfield.getText());
        String uupp4 = updateemailtextfield.getText();
        String uupp5 = updateaddresstextfield.getText();
        int asd = c.updataborrower(uupp, uupp1, uupp2, uupp3, uupp4, uupp5, null);
        switch (asd) {
            case 0: {
                System.out.println("database connected");
            }
            break;
            case -1:
                System.out.println("failed");
                break;
            case 1:
                System.out.println("not done");
                break;
        }
    }

    @FXML
    private void buttondeleteborrowerHandle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("DELETE BORROWER  ");
        alert.setHeaderText("Do you really want to delete the borrower ?");
        alert.setContentText("delete borrower");
        alert.showAndWait();
        //
        String id = iddeletetextfield.getText();

        c.deleteborroer(id);
    }

    @FXML
    private void buttonsearchborrowerHandle(ActionEvent event) {
        int sc = Integer.parseInt(idsearchborrower.getText());
        borroweritems borrower = c.searchborrower(sc);
        if (borrower != null) {
            outputsearchtextarea.setText("ID : " + borrower.getId() + "\n FName : " + borrower.getFname() + "\n LName" + borrower.getLname() + "\n"
                    + borrower.getMobile() + "\n" + borrower.getEmail() + "\n" + borrower.getAddress() + "\n" + borrower.getGender());
        } else {
            System.out.println("No result!");
        }

    }

    @FXML
    private void buttonshowborrowerHandle(ActionEvent event) {
        ObservableList<borroweritems> items = FXCollections.observableArrayList(c.showAllborrower());

        tableviwe.getItems().clear();

        tableviwe.setItems(items);

    }

    private void showSelectedbook() {
        borroweritems bbo = tableviwe.getSelectionModel().getSelectedItem();
        if (bbo != null) {
            idborrowertextfirld.setText(String.valueOf(bbo.getId()));
            fnameborrowertextfirld.setText(bbo.getFname());
            lnameborrowertextfirld.setText(bbo.getLname());
            mobileborrowertextfirld.setText(String.valueOf(bbo.getMobile()));
            emailborrowertextfirld.setText(bbo.getEmail());
            addressborrowertextfirld.setText(bbo.getAddress());

        }
    }

    @FXML
    private void buttonresetborrowerHandle(ActionEvent event) {
        idborrowertextfirld.setText("");
        fnameborrowertextfirld.setText("");
        lnameborrowertextfirld.setText("");
        mobileborrowertextfirld.setText("");
        emailborrowertextfirld.setText("");
        addressborrowertextfirld.setText("");
        tableviwe.getItems().clear();
    }

    @FXML
    private void buttonresetHandle(ActionEvent event) {
        updateidtextfield.setText("");
        updatefnametextfield.setText("");
        updatelnametextfield.setText("");
        updatemobiletextfield.setText("");
        updateemailtextfield.setText("");
        updateaddresstextfield.setText("");
    }

    @FXML
    private void buttonbackHandle(ActionEvent event) throws IOException {
        Parent v1 = FXMLLoader.load(getClass().getClassLoader().getResource("mangment/mangment.fxml"));
        Scene s = new Scene(v1);
        Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        s1.hide();
        s1.setScene(s);
        s1.show();
    }
}
