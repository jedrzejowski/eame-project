package eame.project.ui.prop;

import eame.project.ElectricSchema;
import eame.project.Main;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class ElectricElement extends VBox {
    private ImageView avatar = new ImageView();

    public ElectricElement() {

        avatar.setOnMouseClicked(mouseEvent -> {
            Main.getInstance().getRoot().setRight(this);

        });


        initProps();
    }

    public ImageView getAvatar() {
        return avatar;
    }

    public void setIcon(String iconPath) {
        iconPath = "assets/pic/" + iconPath;

        try {
            Image image = new Image(new FileInputStream(iconPath));

            avatar.setFitHeight(image.getHeight());
            avatar.setFitWidth(image.getWidth());

            avatar.setImage(image);
        } catch (FileNotFoundException e) {
        System.out.println(iconPath);
        }
    }

    public void appendAvatar(ElectricSchema schema, double x, double y) {
        schema.getChildren().add(avatar);
        setAvatarPos(x, y);
    }

    public void setAvatarPos(double x, double y) {
        AnchorPane.setTopAnchor(avatar, x);
        AnchorPane.setLeftAnchor(avatar, y);
    }

    protected abstract void initProps();

    protected void addProp(Node prop) {
        getChildren().add(prop);
    }
}
