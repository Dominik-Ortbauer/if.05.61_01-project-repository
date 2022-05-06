module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens at.htlleonding to javafx.fxml;
    exports at.htlleonding;
    opens at.htlleonding.controller to javafx.fxml;
    exports at.htlleonding.controller;
}