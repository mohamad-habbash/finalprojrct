/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import dbconn.connecteddb;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Educ
 */
public class LoginController implements Initializable {

    @FXML
    private TextField Textfieldusername;
    @FXML
    private PasswordField Textfieldpassword;
    @FXML
    private Button loginbutton;
    @FXML
    private Label laabelerror;

    /**
     * Initializes the controller class.
     */
    connecteddb c = new connecteddb();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        c.getconnectiondb();
    }

    @FXML
    private void loginbuttonHandle(ActionEvent event) throws IOException {
        String name = Textfieldusername.getText();
        String pass = Textfieldpassword.getText();

        int stuts = c.chechlogin(name, pass);

          
                
        switch (stuts) {
            case 0: {
                 System.out.println("ssss");
              Parent v1 = FXMLLoader.load(getClass().getClassLoader().getResource("mangment/mangment.fxml"));
                Scene s = new Scene(v1);
                Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                s1.hide();
                s1.setScene(s);
                s1.show();
                
            }
            break;
            case -1:
                System.out.println("-1");
                break;
            case 1:
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Error");
                alert.setHeaderText("Username or Password are invaild");
                alert.setContentText("ERROR MASSEGE");
                alert.showAndWait();
                break;
        }

    }
}
