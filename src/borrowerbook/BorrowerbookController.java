/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borrowerbook;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Educ
 */
public class BorrowerbookController implements Initializable {

    @FXML
    private TextField textfiledbookid;
    @FXML
    private TextField textfiledborrowerid;
    @FXML
    private Button buttonshowallbook;
    @FXML
    private Button buttonshowallborrower;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void buttonshowallbookhandle(ActionEvent event) {
    }

    @FXML
    private void buttonshowallborrowerhandle(ActionEvent event) {
    }
    
}
