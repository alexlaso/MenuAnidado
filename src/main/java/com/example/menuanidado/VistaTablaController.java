package com.example.menuanidado;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

public class VistaTablaController {
    @FXML
    private StackPane vistaTabla;
    @FXML
    private TableView tablaPersonas;
    @FXML
    private TableColumn<?, ?> colId, colNombre, colEstado, colEspecie, colGenero;

    public void cargarTabla(ObservableList<Persona> lista){
        tablaPersonas.setEditable(true);
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        tablaPersonas.setItems(lista);
    }

    @FXML
    private void volverPrincipalT(){vistaTabla.setVisible(false);}
}
