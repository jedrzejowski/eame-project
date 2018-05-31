package eame.project;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SpiceGenerator {

    private List<String> lines;

    public SpiceGenerator(String path) {
        try {
            lines = Files.readAllLines(Paths.get("assets/" + path));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(String path) {

        try {

            Files.write(Paths.get(path), lines);

            System.out.println("dupa");

        } catch (IOException e) {
            e.printStackTrace();
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
        SpiceGenerator spice = new SpiceGenerator("project.spice");

        ElectricSchema schema = Main.getInstance().getElectricSchema();

        //TODO tu napierdalasz
        spice.setVar("jeden", schema.getCapacitor1().getCapacity());

        spice.save("project.spice.out");
    }
}
