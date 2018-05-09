package eame.project.ui;

import eame.project.electric.Capacitor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CapacitorEditor extends JDialog {
    static ImageIcon Icon = new ImageIcon("asstes/capacitor.png");
    static ImageIcon Icon64 = new ImageIcon(Icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
    private Capacitor capacitor;

    public CapacitorEditor() {
        setTitle("Kondensator");
        setSize(400, 300);

        JLabel picLabel = new JLabel(Icon64);
        add(picLabel, BorderLayout.LINE_START);

        JPanel props = new JPanel();
        props.setLayout(new BoxLayout(props, BoxLayout.Y_AXIS));

        props.add(new PropEditor.Double("Pojemność", new PropEditor.IOnEdit<Double>() {
            @Override
            public Double get() {
                return null;
            }

            @Override
            public boolean set(Double newValue) {
                return false;
            }
        }));

        props.add(new PropEditor.Double("Nawet nie wiem co", new PropEditor.IOnEdit<Double>() {
            @Override
            public Double get() {
                return null;
            }

            @Override
            public boolean set(Double newValue) {
                return false;
            }
        }));

        add(props, BorderLayout.CENTER);
    }

    public static JButton EditButton(Capacitor capacitor) {
        JButton button = new JButton();
        CapacitorEditor editor = new CapacitorEditor();
        editor.capacitor = capacitor;

        button.setIcon(Icon64);

        button.addActionListener(e -> {
            editor.setVisible(true);
        });

        return button;
    }

}
