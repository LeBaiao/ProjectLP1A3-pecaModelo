package com.fiosequeries;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class EditarPedidoController implements Initializable {
    @FXML
    private Label labelEditarPedido;
    @FXML
    private TextField tfIdPedido;
    @FXML
    private TextField tfDataEntrega;
    @FXML
    private TextField tfPago;
    @FXML
    private TextField tfDataPgto;
    @FXML
    private TextField tfTipoPgto;
    @FXML
    private TextField tfSituacao;
    @FXML
    private Button cancelar_btn;
    @FXML
    private Button salvar_btn;
    @FXML
    private Button voltar_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

