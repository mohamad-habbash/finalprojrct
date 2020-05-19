
package mangment;

import dbconn.connecteddb;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Educ
 */
public class MangmentController implements Initializable {

    @FXML
    private Button buttonbookmang;
    @FXML
    private Button buttonborrowermang;
    @FXML
    private Button buttonbackmang;
    @FXML
    private Button buttonborrowerbook;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connecteddb c = new connecteddb();
        c.getconnectiondb();
    }    

    @FXML
    private void buttonbookmangHandle(ActionEvent event) throws IOException {
                Parent v1 = FXMLLoader.load(getClass().getClassLoader().getResource("books/book.fxml"));
                Scene s = new Scene(v1);
                Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                s1.hide();
                s1.setScene(s);
                s1.show();        
//   
       
    }

    @FXML
    private void buttonborrowermangHandle(ActionEvent event) throws IOException {
          Parent v1 = FXMLLoader.load(getClass().getClassLoader().getResource("borrower/borrower.fxml"));
                Scene s = new Scene(v1);
                Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                s1.hide();
                s1.setScene(s);
                s1.show();
    }
 @FXML
    private void buttonborrowerbookHandle(ActionEvent event)  throws IOException{
         Parent v1 = FXMLLoader.load(getClass().getClassLoader().getResource("borrowerbook/borrowerbook.fxml"));
                Scene s = new Scene(v1);
                Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                s1.hide();
                s1.setScene(s);
                s1.show();
    }
    @FXML
    private void buttonbackmangHandle(ActionEvent event) {
       Platform.exit();
        System.exit(0);
    }

   
    
}
