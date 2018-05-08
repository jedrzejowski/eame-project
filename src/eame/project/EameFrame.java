package eame.project;

import javax.swing.*;
import java.awt.*;

public class EameFrame extends JFrame {

    public EameFrame(){
        setTitle("EAME - Nawet nie wiem co");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        ElectricSchema schema = new ElectricSchema();
        add(schema,  BorderLayout.CENTER);

    }
}
