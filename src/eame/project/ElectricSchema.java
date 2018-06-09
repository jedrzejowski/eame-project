package eame.project;

import eame.project.ui.Capacitor;
import eame.project.ui.Resistance;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ElectricSchema extends AnchorPane {

    @FXML
    private ImageView imageView;

    private Capacitor C1 = new Capacitor();
    private Resistance R1 = new Resistance();
    private Resistance R2 = new Resistance();

    public ElectricSchema() throws FileNotFoundException {
        Loader.loadFX(this);

        Image image = new Image(new FileInputStream("assets/pic/schemat.png"));
        imageView.setImage(image);

        C1.setTitle("Kondensator C1");
        R1.setTitle("Rezystor R1");
        R2.setTitle("Rezystor R2");

        initSchema();
    }

    private void initSchema() {
        C1.appendAvatar(this, 315, 118.0, 55, 60);
        R1.appendAvatar(this, 240, 118.0, 55, 60);
        R2.appendAvatar(this, 505, 50, 55, 60);
    }

    public Capacitor getC1() {
        return C1;
    }
}
