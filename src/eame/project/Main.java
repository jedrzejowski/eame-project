package eame.project;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    //region Singleton

    private static Main ourInstance = null;

    public static Main getInstance() {
        return ourInstance;
    }

    //endregion

    private BorderPane root;
    @FXML
    private Button saveButton;
    @FXML
    private ElectricSchema electricSchema;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ourInstance = this;

        root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        saveButton = (Button) root.lookup("#saveButton");
        electricSchema = (ElectricSchema) root.lookup("#electricSchema");

        saveButton.setOnAction(actionEvent -> {
            SpiceGenerator.GenerateProject();
        });

        stage.setTitle("EAME - Projekt");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public BorderPane getRoot() {
        return root;
    }

    public ElectricSchema getElectricSchema(){
        return electricSchema;
    }
}
