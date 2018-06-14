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
        capacity.setLabel("Pojemność[F]");
//        capacity.setInputInterface(TextProp.DoubleInputI);
        addProp(capacity);
    }

    public void setCapacity(String num) {
        capacity.setValue(num);
    }

    public String getCapacity() {
        return capacity.getValue().toString();
    }
}
