package com.example.menuanidado;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class VistaDosController implements Initializable {
    private boolean isDesplegado, isClaro;
    private TranslateTransition animacionMenu, animacionBtn;
    @FXML
    Pane fondo;
    @FXML
    ImageView iconoJonDoe;
    @FXML
    VBox desplegable;
    @FXML
    Button btnMenu, btnSalir;
    @FXML
    ToggleButton btnCambio;
    @FXML
    StackPane ventana;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/resources/jondoe.jpg");
        Image image = new Image(file.toURI().toString());
        iconoJonDoe.setImage(image);
        desplegable.setTranslateX(-110);
        isDesplegado=false;
        isClaro=true;
    }

    @FXML
    private void cambiarTema(){
        if(!isClaro){
            ventana.getStylesheets().clear();
            ventana.getStylesheets().add(this.getClass().getResource("CSS/temaclaro.css").toExternalForm());
            isClaro=true;
        }else{
            ventana.getStylesheets().clear();
            ventana.getStylesheets().add(this.getClass().getResource("CSS/temaoscuro.css").toExternalForm());
            isClaro=false;
        }
        despliegue();
    }

    @FXML
    private void cerrar(){
        System.exit(0);
    }

    @FXML
    private void despliegue(){
        animacionMenu=new TranslateTransition(Duration.millis(300),desplegable);
        animacionBtn= new TranslateTransition(Duration.millis(300),btnMenu);

        if(!isDesplegado){
            animacionMenu.setFromX(-desplegable.getWidth());
            animacionMenu.setToX(0);
            animacionBtn.setFromX(0);
            animacionBtn.setToX(desplegable.getWidth());
            isDesplegado=true;

        }else{
            animacionMenu.setFromX(0);
            animacionMenu.setToX(-desplegable.getWidth());
            animacionBtn.setFromX(desplegable.getWidth());
            animacionBtn.setToX(0);
            isDesplegado=false;
        }
        animacionMenu.play();
        animacionBtn.play();
    }
}
