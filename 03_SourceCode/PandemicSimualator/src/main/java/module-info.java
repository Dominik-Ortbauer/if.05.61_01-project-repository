module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens at.htlleonding to javafx.fxml;
    exports at.htlleonding;
    exports at.htlleonding.pansimApp;
    opens at.htlleonding.pansimApp to javafx.fxml;
}