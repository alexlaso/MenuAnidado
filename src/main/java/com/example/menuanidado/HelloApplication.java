package com.example.menuanidado;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Locale spanish = new Locale("es", "ES");
        Locale english = new Locale("en", "UK");
        ResourceBundle rBSpanish = ResourceBundle.getBundle("com/example/menuanidado/i18n.strings",spanish);
        ResourceBundle rBEnglish = ResourceBundle.getBundle("com/example/menuanidado/i18n.strings",english);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VistaPrincipal.fxml"), rBSpanish);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("UwU");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}