package eame.project;

import eame.project.ui.Capacitor;
import eame.project.ui.Resistance;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ElectricSchema extends ScrollPane {

    @FXML
    private ImageView imageView;
    @FXML
    public AnchorPane content;

    private Capacitor[] C = new Capacitor[15];
    private Resistance[] R = new Resistance[21];

    public ElectricSchema() throws FileNotFoundException {
        Loader.loadFX(this);

        Image image = new Image(new FileInputStream("assets/pic/schemat.png"));
        imageView.setImage(image);


        for (int i = 1; i < C.length; i++) {
            C[i] = new Capacitor();
            C[i].setTitle("Kondensator C" + i);
            C[i].setCapacity(100d);
        }


        for (int i = 1; i < R.length; i++) {
            R[i] = new Resistance();
            R[i].setTitle("Rezystor R" + i);
            R[i].setResistance(10000d);
        }

        initSchema();
    }

    private void initSchema() {
        C[1].appendAvatar(this, 315, 118.0, 55, 60);
        C[2].appendAvatar(this, 315, 118.0, 55, 60);
        C[3].appendAvatar(this, 315, 118.0, 55, 60);
        C[4].appendAvatar(this, 315, 118.0, 55, 60);
        C[5].appendAvatar(this, 315, 118.0, 55, 60);
        C[6].appendAvatar(this, 315, 118.0, 55, 60);
        C[7].appendAvatar(this, 315, 118.0, 55, 60);
        C[8].appendAvatar(this, 315, 118.0, 55, 60);
        C[9].appendAvatar(this, 315, 118.0, 55, 60);
        C[10].appendAvatar(this, 315, 118.0, 55, 60);
        C[11].appendAvatar(this, 315, 118.0, 55, 60);
        C[12].appendAvatar(this, 315, 118.0, 55, 60);
        C[13].appendAvatar(this, 315, 118.0, 55, 60);
        C[14].appendAvatar(this, 315, 118.0, 55, 60);

        R[1].appendAvatar(this, 240, 118.0, 55, 60);
        R[2].appendAvatar(this, 505, 50, 55, 60);
        R[3].appendAvatar(this, 505, 50, 55, 60);
        R[4].appendAvatar(this, 505, 50, 55, 60);
        R[5].appendAvatar(this, 505, 50, 55, 60);
        R[6].appendAvatar(this, 505, 50, 55, 60);
        R[7].appendAvatar(this, 505, 50, 55, 60);
        R[8].appendAvatar(this, 505, 50, 55, 60);
        R[9].appendAvatar(this, 505, 50, 55, 60);
        R[10].appendAvatar(this, 240, 118.0, 55, 60);
        R[11].appendAvatar(this, 240, 118.0, 55, 60);
        R[12].appendAvatar(this, 505, 50, 55, 60);
        R[13].appendAvatar(this, 505, 50, 55, 60);
        R[14].appendAvatar(this, 505, 50, 55, 60);
        R[15].appendAvatar(this, 505, 50, 55, 60);
        R[16].appendAvatar(this, 505, 50, 55, 60);
        R[17].appendAvatar(this, 505, 50, 55, 60);
        R[18].appendAvatar(this, 505, 50, 55, 60);
        R[19].appendAvatar(this, 505, 50, 55, 60);
        R[20].appendAvatar(this, 505, 50, 55, 60);
    }

}
