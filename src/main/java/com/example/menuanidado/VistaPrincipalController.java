package com.example.menuanidado;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.*;
import java.util.ResourceBundle;

public class VistaPrincipalController implements Initializable {
    private boolean isDesplegado, isClaro;
    private TranslateTransition animacionMenu, animacionBtn;
    @FXML
    private VistaDosController vistaDosController;
    @FXML
    private VistaGraficaController vistaGraficaController;
    @FXML
    private VistaTablaController vistaTablaController;
    @FXML
    private VBox desplegable;
    @FXML
    private Button btnMenu, btnSalir;
    @FXML
    private ToggleButton btnCambio;
    @FXML
    private StackPane vistaDos, vistaGrafica, vistaTabla, vistaPrincipal;
    @FXML
    private ListView<Persona> listView;
    private ObservableList<Persona> listaPersonas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vistaDos.setVisible(false);
        vistaGrafica.setVisible(false);
        vistaTabla.setVisible(false);
        listaPersonas= FXCollections.observableArrayList();
        desplegable.setTranslateX(-110);
        isDesplegado=false;
        isClaro=true;
        initLista();
        listView.setItems(listaPersonas);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.getSelectionModel().selectedItemProperty().addListener((observable, ov, nv)->{
            if(nv != null){
            vistaDosController.cargarPersona(nv);
            vistaDos.setVisible(true);
            }
        });
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

    private void vistaDetalle(){
        vistaDos.setVisible(true);
    }

    @FXML
    private void vistaGrafica(){
        vistaGrafica.setVisible(true);
        vistaGraficaController.cargarDatosPieChartGenero(listaPersonas);
        vistaGraficaController.cargarDatosPieChartEspecie(listaPersonas);
        despliegue();
    }

    @FXML
    private void vistaTabla(){
        vistaTabla.setVisible(true);
        vistaTablaController.cargarTabla(listaPersonas);
        despliegue();
    }

    private void initLista(){
        int numRandom = (int) Math.floor(Math.random()*42+1);
        Runnable task =()->{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://rickandmortyapi.com/api/character?page="+numRandom)).build();
            HttpResponse<String> response = null;
        try{response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Platform.runLater(() -> listView.getItems().removeAll(listaPersonas));
            //JSONArray dataArray = new JSONArray(response.body().substring(163, response.body().length() - 1)); ESTO SE DEJA PARA LA POSTERIDAD.
            JSONObject responseObject = new JSONObject(response.body());
            JSONArray dataArray = new JSONArray(responseObject.getJSONArray("results"));
            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject row = dataArray.getJSONObject(i);
                Platform.runLater(() -> listaPersonas.add(new Persona(row.getInt("id"),
                        row.getString("image"),
                        row.getString("name"),
                        row.getString("status"),
                        row.getString("species"),
                        row.getString("gender"))));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        };
        new Thread(task).start();
        }

    @FXML
    private void cambiarTema(){
        if(!isClaro){
            vistaDos.getStylesheets().clear();
            vistaDos.getStylesheets().add(this.getClass().getResource("CSS/temaclaro.css").toExternalForm());
            isClaro=true;
        }else{
            vistaDos.getStylesheets().clear();
            vistaDos.getStylesheets().add(this.getClass().getResource("CSS/temaoscuro.css").toExternalForm());
            isClaro=false;
        }
        despliegue();
    }
    }