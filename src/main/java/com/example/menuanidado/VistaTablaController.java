package com.example.menuanidado;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;

public class VistaTablaController {
    @FXML
    private StackPane vistaTablaAnidada;
    @FXML
    private TableView tablaPersonas;
    @FXML
    private TableColumn<?, ?> colId, colNombre, colEst, colEsp, colGen;

    public void cargarTabla(ObservableList<Persona> lista){

    }
}
