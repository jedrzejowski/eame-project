package eame.project;

import eame.project.ui.Capacitor;
import eame.project.ui.Resistance;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ElectricSchema extends ScrollPane {

    @FXML
    private ImageView imageView;
    @FXML
    public AnchorPane content;

    public Capacitor[] C = new Capacitor[15];
    public Resistance[] R = new Resistance[21];

    public ElectricSchema()  {
        Loader.loadFX(this);

        Image image = new Image(String.valueOf(getClass().getResource("ElectricSchema.png")));
        imageView.setImage(image);


        for (int i = 1; i < C.length; i++) {
            C[i] = new Capacitor();
            C[i].setTitle("Kondensator C" + i);
            C[i].setCapacity("100n");
        }


        for (int i = 1; i < R.length; i++) {
            R[i] = new Resistance();
            R[i].setTitle("Rezystor R" + i);
            R[i].setResistance("30k");
        }

        initSchema();
    }

    private void initSchema() {
        C[1].appendAvatar(this, 650, 125, 55, 60);
        C[2].appendAvatar(this, 775, 125, 55, 60);
        C[3].appendAvatar(this, 705, 335, 55, 60);
        C[4].appendAvatar(this, 1100, 190, 55, 60);
        C[5].appendAvatar(this, 1200, 100, 55, 60);
        C[6].appendAvatar(this, 1330, 197, 55, 60);
        C[7].appendAvatar(this, 1525, 100, 55, 60);
        C[8].appendAvatar(this, 1868, 290, 55, 60);
        C[9].appendAvatar(this, 2270, 290, 55, 60);
        C[10].appendAvatar(this, 1815, 115, 55, 60);
        C[11].appendAvatar(this, 2190, 115, 55, 60);
        C[12].appendAvatar(this, 2515, 100, 55, 60);
        C[13].appendAvatar(this, 2650, 100, 55, 60);
        C[14].appendAvatar(this, 2595, 270, 55, 60);

        R[1].appendAvatar(this, 230, 40, 55, 60);
        R[2].appendAvatar(this, 230, 125, 55, 60);
        R[3].appendAvatar(this, 230, 220, 55, 60);
        R[4].appendAvatar(this, 315, 5, 55, 60);
        R[5].appendAvatar(this, 315, 245, 55, 60);
        R[6].appendAvatar(this, 640, 240, 55, 60);
        R[7].appendAvatar(this, 775, 240, 55, 60);
        R[8].appendAvatar(this, 435, 5, 55, 60);
        R[9].appendAvatar(this, 435, 245, 55, 60);
        R[10].appendAvatar(this, 840, 40, 55, 60);
        R[11].appendAvatar(this, 1195, 25, 55, 60);
        R[12].appendAvatar(this, 1420, 200, 55, 60);
        R[13].appendAvatar(this, 1527, 30, 55, 60);
        R[14].appendAvatar(this, 1665, 210, 55, 60);
        R[15].appendAvatar(this, 1815, 210, 55, 60);
        R[16].appendAvatar(this, 2085, 200, 55, 60);
        R[17].appendAvatar(this, 2202, 200, 55, 60);
        R[18].appendAvatar(this, 2522, 200, 55, 60);
        R[19].appendAvatar(this, 2640, 200, 55, 60);
        R[20].appendAvatar(this, 2705, 30, 55, 60);
    }

}
