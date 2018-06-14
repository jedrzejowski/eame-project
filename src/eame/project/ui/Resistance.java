package eame.project.ui;

import eame.project.ui.prop.ElectricElement;
import eame.project.ui.prop.TextProp;

public class Resistance extends ElectricElement {

    private TextProp resistance;

    public Resistance() {

    }

    @Override
    protected void initProps() {

        // Pojemność
        resistance = new TextProp();
        resistance.setLabel("Rezystancja[Ohm]");
//        resistance.setInputInterface(TextProp.DoubleInputI);
        addProp(resistance);
    }

    public void setResistance(String num) {
        resistance.setValue(num);
    }

    public String getResistance() {
        return  resistance.getValue().toString();
    }
}
