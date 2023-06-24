package com.fiosequeries;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class GerenciaPedidoOrcamentoController implements Initializable {

//    @Autowired
//    private Stage primaryStage; // Injete o palco principal aqui

    @FXML
    private Button bnt_voltaHome;
    @FXML
    private Button bnt_cadastraPedOrc;
    @FXML
    private Button btn_listaOrc;
    @FXML
    private Button btn_editaOrc;
    @FXML
    private Button btn_excluiOrc;
    @FXML
    private Button btn_listaPed;
    @FXML
    private Button btn_editaPed;

    @FXML
    private Button btn_excluiPed;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private final StageInitializer stageInitializer;

    public GerenciaPedidoOrcamentoController(StageInitializer stageInitializer) {
        this.stageInitializer = stageInitializer;
    }

    @FXML
    private void goToListarPedidos() {
        stageInitializer.changeScene("/ListarPedidosScreen.fxml");
    }

    @FXML
    private void goToEditarPedidos() {
        stageInitializer.changeScene("/EditarPedidoScreen.fxml");
    }

    @FXML
    private void goToExcluirPedidos() {
        stageInitializer.changeScene("/ExcluirPedidoScreen.fxml");
    }

    @FXML
    private void goToOutros() {
        stageInitializer.changeScene("/OutrosScreen.fxml");
    }

//    @FXML
//    private void goToCriarPedidoOrcScreen() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CadastroPedOrc.fxml"));
//        Parent root = fxmlLoader.load();
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }


//    @FXML
//    private void goToListarOrcamentosScreen() {
//        screenManager.loadScreen("ListarOrcamentos.fxml");
//    }

//    @FXML
//    private void goToEditarOrcamentoScreen() {
//        screenManager.loadScreen("EditarOrcamento.fxml");
//    }

//    @FXML
//    private void goToListarPedidosScreen() throws IOException{
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListarPedidosScreen.fxml"));
//        Parent root = fxmlLoader.load();
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    @FXML
//    private void goToEditarPedidoScreen() throws IOException{
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditarPedidoScreen.fxml"));
//        Parent root = fxmlLoader.load();
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    @FXML
//    private void goToExcluirPedidoScreen() throws IOException{
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ExcluirPedidoScreen.fxml"));
//        Parent root = fxmlLoader.load();
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }


}
