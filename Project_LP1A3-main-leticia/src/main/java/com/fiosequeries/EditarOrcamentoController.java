package com.fiosequeries;

import javafx.fxml.Initializable;
import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class EditarOrcamentoController implements Initializable {
    @FXML
    private TextField idOrcamento;

    @FXML
    private TextField idEntrega;

    @FXML
    private TextField idPago;

    @FXML
    private TextField idDataPagamento;

    @FXML
    private TextField idTipoPagamento;

    @FXML
    private TextField idSituacao;

    @FXML
    private Button cancelar_btn;

    @FXML
    private Button salvar_btn;

    @FXML
    private void cancelarButtonAction() {
        // Implemente aqui a lógica quando o botão "Cancelar" for clicado.
    }

    @FXML
    private void salvarButtonAction() {
        // Implemente aqui a lógica quando o botão "Salvar" for clicado.
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
