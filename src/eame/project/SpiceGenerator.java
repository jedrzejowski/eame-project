package eame.project;

import eame.project.ui.Capacitor;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SpiceGenerator {

    private List<String> lines;

    public SpiceGenerator() {
        try {
            lines = Files.readAllLines(Paths.get(getClass().getResource("Spice.template").getFile()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(String path) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Zapisz plik do Spica");
        File selectedFile = fileChooser.showSaveDialog(Main.getInstance().getStage());


        if (selectedFile != null) {
            try {

                Files.write(Paths.get(path), lines);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setVar(String name, Object value) {
        String temp, val = value.toString();


        for (int i = 0; i < lines.size(); i++) {
            temp = lines.get(i);
            temp = temp.replace("{{" + name + "}}", val);
            lines.set(i, temp);
        }
    }

    static void GenerateProject() {
        SpiceGenerator spice = new SpiceGenerator();

        ElectricSchema schema = Main.getInstance().getElectricSchema();

        for (int i = 1; i < schema.C.length; i++) {
            spice.setVar("C" + i + ".c", schema.C[i].getCapacity());
        }


        for (int i = 1; i < schema.R.length; i++) {
            spice.setVar("R" + i + ".r", schema.R[i].getResistance());
        }

        spice.save("project.spice.out");
    }
}
