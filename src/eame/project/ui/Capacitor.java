package eame.project.ui;

import eame.project.ui.prop.ElectricElement;
import eame.project.ui.prop.TextProp;

public class Capacitor extends ElectricElement {

    private TextProp capacity;

    public Capacitor() {

    }

    @Override
    protected void initProps() {

        // Pojemność
        capacity = new TextProp();
        capacity.setLabel("Pojemność[nF]");
        capacity.setInputInterface(TextProp.DoubleInputI);
        addProp(capacity);
    }

    public void setCapacity(Double num) {
        capacity.setValue(num);
    }

    public Double getCapacity() {
        return (Double) capacity.getValue();
    }
}
