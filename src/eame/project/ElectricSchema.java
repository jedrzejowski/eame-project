package eame.project;

import eame.project.electric.Capacitor;
import eame.project.ui.CapacitorEditor;

import javax.swing.*;

public class ElectricSchema extends JPanel {

    private Capacitor capacitor1;

    public ElectricSchema() {
        setBorder(BorderFactory.createTitledBorder("Lista pacjentów"));
        setLayout(null);

        initSchema();
    }

    private void initSchema() {
        JButton b1 = new JButton("two");
        add(b1);

        JButton capacitorEditor1 = CapacitorEditor.EditButton(capacitor1);
        capacitorEditor1.setBounds(20, 50, 100, 50);
        add(capacitorEditor1);
    }
}
