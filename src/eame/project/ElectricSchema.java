package eame.project;

import eame.project.ui.Capacitor;
import javafx.scene.layout.AnchorPane;


public class ElectricSchema extends AnchorPane {

    private Capacitor capacitor1 = new Capacitor();

    public ElectricSchema() {
        Loader.loadFX(this);

        initSchema();
    }

    private void initSchema() {
        capacitor1.appendAvatar(this, 16.0, 16.0);
    }

    public Capacitor getCapacitor1() {
        return capacitor1;
    }
}
