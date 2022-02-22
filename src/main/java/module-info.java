module com.example.menuanidado {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.fontawesome5;
    requires org.json;
    requires java.net.http;


    opens com.example.menuanidado to javafx.fxml;
    exports com.example.menuanidado;
}