package eame.project.ui.prop;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class TextProp extends HBox {

    private int maxLength = -1;

    private Label label;
    private TextField textField;

    public TextProp() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TextProp.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();

            label = (Label) lookup("#label");
            textField = (TextField) lookup("#textField");
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (maxLength > -1 && newValue.length() > maxLength) {
                textField.setText(oldValue);
            }

            if (!inputInterface.onChange(oldValue, newValue)) {
                textField.setText(oldValue);
            }
        });

    }

    //region Props

    public String getLabel() {
        return label.getText();
    }

    public void setLabel(String value) {
        label.setText(value);
    }

    public Object getValue() {
        return inputInterface.fromString(textField.getText());
    }

    public void setValue(Object value) {
        textField.setText(inputInterface.toString(value));
    }

    public InputI getInputInterface() {
        return inputInterface;
    }

    public void setInputInterface(InputI inputInterface) {
        this.inputInterface = inputInterface;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    //endregion

    //region

    InputI inputInterface = DefaultInputI;

    interface InputI {
        Object fromString(String value);

        String toString(Object value);

        boolean onChange(String oldValue, String newValue);
    }

    public static InputI DefaultInputI = new InputI() {
        @Override
        public Object fromString(String value) {
            return value;
        }

        @Override
        public String toString(Object value) {
            return value.toString();
        }

        @Override
        public boolean onChange(String oldValue, String newValue) {
            return true;
        }
    };

    public static InputI NaturalInputI = new InputI() {
        @Override
        public Object fromString(String value) {
            if (value.length() == 0) return 0.0;
            return Integer.parseUnsignedInt(value);
        }

        @Override
        public String toString(Object value) {
            return value.toString();
        }

        @Override
        public boolean onChange(String oldValue, String newValue) {
            if (newValue.length() == 0) return true;
            return newValue.matches("[0-9]+");
        }
    };

    public static InputI DoubleInputI = new InputI() {

        @Override
        public Object fromString(String value) {
            if (value.length() == 0) return 0.0d;
            return Double.parseDouble(value);
        }

        @Override
        public String toString(Object value) {
            return value.toString();
        }

        @Override
        public boolean onChange(String oldValue, String newValue) {
            if (newValue.length() == 0) return true;

            try {
                Double.parseDouble(newValue);
                return true;
            } catch (Exception q) {
                return false;
            }

        }
    };

    //endregion
}
