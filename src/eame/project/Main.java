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

    Stage stage;

    public Stage getStage() {
        return stage;
    }

    @FXML
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
        this.stage = stage;


        root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        saveButton = (Button) root.lookup("#saveButton");
        electricSchema = (ElectricSchema) root.lookup("#electricSchema");
        Loader.loadCSS(root, getClass().getResource("Main.css"));

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
