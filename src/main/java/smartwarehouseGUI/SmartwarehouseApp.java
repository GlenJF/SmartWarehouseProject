package smartwarehouseGUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.net.URL;
import java.util.Objects;

public class SmartwarehouseApp extends Application {

    public static void main(String[] args) {

        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        Group root= new Group();
       Scene scene= new Scene(root, Color.BLACK);
       stage.setScene(scene);
       stage.setTitle("Smart Warehouse");
       stage.setWidth(600);
       stage.setHeight(600);
       stage.setFullScreen(true);
       stage.setFullScreenExitHint("Press Q to exit");

       stage.show();
    }
}
