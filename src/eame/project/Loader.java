package eame.project;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;

public class Loader {
    public static void loadFX(Parent t) {
        Class c = t.getClass();
        String simple = c.getSimpleName();

        FXMLLoader fxmlLoader = new FXMLLoader(c.getResource(simple+".fxml"));
        fxmlLoader.setRoot(t);
        fxmlLoader.setController(t);

        loadCSS(t);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    public static void loadCSS(Parent t) {
        Class c = t.getClass();
        String simple = c.getSimpleName();
        URL url = c.getResource(simple + ".css");
        loadCSS(t, url);
    }

    public static void loadCSS(Parent t, URL url) {
        if (url != null) t.getStylesheets().add(url.toExternalForm());
    }

}
