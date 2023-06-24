package com.fiosequeries;

import javafx.fxml.Initializable;
import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class FinzalizarPedidoController implements Initializable {
    @FXML
    private Label titleLabel;

    @FXML
    private TextField dataEntregaTextField;

    @FXML
    private TextField dataPagamentoTextField;

    @FXML
    private ComboBox<String> tipoPagamentoComboBox;

    @FXML
    private ComboBox<String> situacaoPagamentoComboBox;

    @FXML
    private ComboBox<String> situacaoPedidoComboBox;

    @FXML
    private Button concluirPedidoButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private void concluirPedidoButtonAction() {
        // Implemente aqui a lógica quando o botão "Concluir pedido" for clicado.
    }

    @FXML
    private void cancelarButtonAction() {
        // Implemente aqui a lógica quando o botão "Cancelar" for clicado.
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
