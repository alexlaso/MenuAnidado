package com.example.menuanidado;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaPrincipalController implements Initializable {
    @FXML
    private VistaDosController vistaController;
    @FXML
    private StackPane vistaDosAnidada;
    @FXML
    private Button btnAdelante;

    public void Cambiar(ActionEvent e) {
        vistaDosAnidada.setVisible(true);
        btnAdelante.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vistaDosAnidada.setVisible(false);
    }
}