module com.example.demo6 {
    requires transitive javafx.controls;
    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;

    opens com.example.demo6 to javafx.fxml;
    exports com.example.demo6;
}