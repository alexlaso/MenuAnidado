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

public class VistaDosController{

    @FXML
    Pane fondo;
    @FXML
    ImageView imagenPersona;
    @FXML
    StackPane vistaDos;
    @FXML
    Label nombrePersona, estadoPersona, especiePersona, generoPersona;


    @FXML
    private void volverPrincipalT(){vistaDos.setVisible(false);}

     public void cargarPersona(Persona persona){
        Image image = new Image(persona.getImagen());
        imagenPersona.setImage(image);
        nombrePersona.setText(persona.getNombre());
        estadoPersona.setText(persona.getEstado());
        especiePersona.setText(persona.getEspecie());
        generoPersona.setText(persona.getGenero());
    }


}
