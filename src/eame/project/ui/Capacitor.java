package eame.project.ui;

import eame.project.ui.prop.ElectricElement;
import eame.project.ui.prop.TextProp;

public class Capacitor extends ElectricElement {

    private TextProp capacity;

    public Capacitor() {


    }

    @Override
    protected void initProps() {
        setIcon("capacitor.png");

        // Pojemność
        capacity = new TextProp();
        capacity.setLabel("Pojemność");
        capacity.setInputInterface(TextProp.DoubleInputI);
        addProp(capacity);
    }

    public Double getCapacity() {
        return (Double) capacity.getValue();
    }
}
