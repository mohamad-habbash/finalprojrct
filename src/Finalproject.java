

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Finalproject extends Application {

    @Override
    public void start(Stage s1) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("login/login.fxml"));
//          Parent root = FXMLLoader.load(getClass().getResource("mangment/mangment.fxml"));
//          Parent root = FXMLLoader.load(getClass().getResource("books/book.fxml"));
//          Parent root = FXMLLoader.load(getClass().getResource("borrower/borrower.fxml"));
        Scene scene = new Scene(root);
        s1.setScene(scene);
        s1.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
