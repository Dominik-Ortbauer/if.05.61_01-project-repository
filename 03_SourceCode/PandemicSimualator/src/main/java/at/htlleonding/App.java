package at.htlleonding;

import at.htlleonding.controller.PrimaryViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import at.htlleonding.pansim.City;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static PrimaryViewController primaryViewController;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("PrimaryView"));
        stage.setScene(scene);
        stage.show();

        City.getInstance().startSimulation();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}