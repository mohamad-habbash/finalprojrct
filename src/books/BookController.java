/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books;

import dbconn.connecteddb;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Educ
 */
public class BookController implements Initializable {

    @FXML
    private TextField bookidtextfield;
    @FXML
    private TextField booknametextfield;
    @FXML
    private TextArea bookdestextarea;
    @FXML
    private TableView<bookitem> tabelview;
    @FXML
    private TableColumn<bookitem, Integer> idcolumn;
    @FXML
    private TableColumn<bookitem, String> namecolumn;
    @FXML
    private TableColumn<bookitem, String> descolumn;
    @FXML
    private Button buttonaddbook;
    @FXML
    private Button buttonupdatebook;
    @FXML
    private TextField idtextfieldupdate;
    @FXML
    private TextField nametextfieldupdate;
    @FXML
    private TextArea desctextareaupdate;
    @FXML
    private TextField idtextfielddelete;
    @FXML
    private Button buttondeletebook;
    @FXML
    private Button buttonsearchbook;
    @FXML
    private TextField idsearchbook;
    @FXML
    private TextArea textareaoutputsearch;
    @FXML
    private Label error;
    Statement statement;
    @FXML
    private Button buttonshowbook1;

    connecteddb c = new connecteddb();

    ObservableList<bookitem> oblist = FXCollections.observableArrayList();
    @FXML
    private Button buttonreset;
    @FXML
    private Button buttonback;
    @FXML
    private Button buttonresets;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c.getconnectiondb();

        idcolumn.setCellValueFactory(new PropertyValueFactory("id"));
        namecolumn.setCellValueFactory(new PropertyValueFactory("name"));
        descolumn.setCellValueFactory(new PropertyValueFactory("description"));
        tabelview.getSelectionModel().selectedItemProperty().addListener(
                event -> showSelectedbook());
    }

    @FXML
    private void buttonaddbookHandle(ActionEvent event) throws SQLException {

        int bo = Integer.parseInt(bookidtextfield.getText());
        String bo1 = booknametextfield.getText();
        String bo2 = bookdestextarea.getText();
        int stuts = c.addbo(bo, bo1, bo2);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ADD BOOK  ");
        alert.setHeaderText("Do you really want to add the book ?");
        alert.setContentText("add book");
        alert.showAndWait();
        //
        switch (stuts) {
            case 0: {
                System.out.println("done addeed");
            }
            break;
            case -1:
                Alert alerts = new Alert(Alert.AlertType.ERROR);
                alerts.setTitle("error retrive");
                alerts.setContentText("error to add book");
                break;
            case 1:
                Alert aler = new Alert(Alert.AlertType.ERROR);
                aler.setTitle("susses retrive");
                aler.setContentText("sussesful to add book");
                break;
        }

    }

    @FXML
    private void buttonsearchbookHandle(ActionEvent event) throws SQLException {

        int sc = Integer.parseInt(idsearchbook.getText());
        bookitem book = c.searchbook(sc);
        if (book != null) {
            textareaoutputsearch.setText("ID :" + book.getId() + "\n Name : " + book.getName() + "\n Description : " + book.getDescription());
        } else {
            System.out.println("No result!");
        }

    }

    @FXML
    private void buttonupdatebookHandle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("UPDATE BOOK  ");
        alert.setHeaderText("Do you really want to update the book ?");
        alert.setContentText("update book");
        alert.showAndWait();
        //
        int up = Integer.parseInt(idtextfieldupdate.getText());
        String up1 = nametextfieldupdate.getText();
        String up2 = desctextareaupdate.getText();
        int asd = c.updatabook(up, up1, up2);

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
    private void buttondeletebookHandle(ActionEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("DELETE BOOK  ");
        alert.setHeaderText("Do you really want to delete the book ?");
        alert.setContentText("delete book");
        alert.showAndWait();
        //
        String id = idtextfielddelete.getText();
        c.delete(id);
    }

    @FXML
    private void buttonshowbookHandle(ActionEvent event) throws SQLException {

        ObservableList<bookitem> items = FXCollections.observableArrayList(c.showAll());

        tabelview.getItems().clear();

        tabelview.setItems(items);

    }

    private void showSelectedbook() {
        bookitem bbo = tabelview.getSelectionModel().getSelectedItem();
        if (bbo != null) {
            bookidtextfield.setText(String.valueOf(bbo.getId()));
            booknametextfield.setText(bbo.getName());
            bookdestextarea.setText(bbo.getDescription());

        }
    }

    @FXML
    private void buttonresetHandle(ActionEvent event) {
        bookidtextfield.setText("");
        booknametextfield.setText("");
        bookdestextarea.setText("");
        tabelview.getItems().clear();
    }

    @FXML
    private void buttonresetupdatafieldHandle(ActionEvent event) {
        idtextfieldupdate.setText("");
        nametextfieldupdate.setText("");
        desctextareaupdate.setText("");
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
