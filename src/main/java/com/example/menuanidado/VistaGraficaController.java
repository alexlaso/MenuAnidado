package com.example.menuanidado;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;

public class VistaGraficaController {
    @FXML
    private StackPane vistaGrafica;
    @FXML
    private PieChart graficaGenero, graficaEspecie;

    public void cargarDatosPieChartGenero(ObservableList<Persona> lista){
        int contadorMacho = 0;
        for (Persona p1 : lista){
            if (p1.getGenero().equals("Male")){
                contadorMacho++;
            }
        }
        int contadorHembra = 0;
        for (Persona p2 : lista){
            if (p2.getGenero().equals("Female")){
                contadorHembra++;
            }
        }
        int contadorHelicopteroApacheDeCombate=lista.size()-contadorMacho-contadorHembra;

        ObservableList<PieChart.Data> datosGraficoCircular = FXCollections.observableArrayList(
                new PieChart.Data("Macho", contadorMacho),
                new PieChart.Data("Hembra", contadorHembra),
                new PieChart.Data("WhoKnows", contadorHelicopteroApacheDeCombate));
        graficaGenero.setData(datosGraficoCircular);
        graficaGenero.setClockwise(false);
    }

    public void cargarDatosPieChartEspecie(ObservableList<Persona> lista) {
        int contadorHumano = 0;
        for (Persona p4 : lista) {
            if (p4.getEspecie().equals("Human")) {
                contadorHumano++;
            }

        }
        int contadorAlien = 0;
        for (Persona p5 : lista) {
            if (p5.getEspecie().equals("Alien")) {
                contadorAlien++;
            }
        }
        int contadorResto = lista.size() - contadorAlien - contadorHumano;

        ObservableList<PieChart.Data> datosGraficoCircular = FXCollections.observableArrayList(
                new PieChart.Data("Hombre", contadorHumano),
                new PieChart.Data("Alien", contadorAlien),
                new PieChart.Data("Otros", contadorResto));
        graficaEspecie.setData(datosGraficoCircular);
        graficaEspecie.setClockwise(false);

    }
    @FXML
    private void volverPrincipalG(){vistaGrafica.setVisible(false);}
}
