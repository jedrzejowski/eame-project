package eame.project.ui.prop;

import eame.project.ElectricSchema;
import eame.project.Main;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;

public abstract class ElectricElement extends VBox {

    private Button avatar = new Button();
    private Label titleLabel =  new Label();

    public ElectricElement() {
        getChildren().add(titleLabel);

        avatar.setOnMouseClicked(mouseEvent -> {
            Main.getInstance().getRoot().setRight(this);
        });

        initProps();
    }


    public void appendAvatar(ElectricSchema schema, double x, double y, double w, double h) {
        schema.getChildren().add(avatar);
        setAvatarPos(x, y, w, h);
    }

    public void setAvatarPos(double x, double y, double w, double h) {
        AnchorPane.setTopAnchor(avatar, y);
        AnchorPane.setLeftAnchor(avatar, x);
        avatar.setMinHeight(h);
        avatar.setMinWidth(w);

        avatar.setStyle("-fx-background-color: #FF0000;");
        avatar.setOpacity(0.5);
    }

    protected abstract void initProps();

    protected void addProp(Node prop) {
        getChildren().add(prop);
    }

    public void setTitle(String title){
        titleLabel.setText(title);
    }
}
