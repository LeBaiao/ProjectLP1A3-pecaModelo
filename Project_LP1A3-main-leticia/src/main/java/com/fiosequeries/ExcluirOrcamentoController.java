package com.fiosequeries;

import javafx.fxml.Initializable;
import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ExcluirOrcamentoController implements Initializable {
    @FXML
    private SplitPane splitPane;

    @FXML
    private Label titleLabel;

    @FXML
    private TextField idPesquisa;

    @FXML
    private Button idBtnPesquisa;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> usuarioColumn;

    @FXML
    private TableColumn<?, ?> clienteColumn;

    @FXML
    private TableColumn<?, ?> itensPedidoColumn;

    @FXML
    private TableColumn<?, ?> dataColumn;

    @FXML
    private TableColumn<?, ?> totalColumn;

    @FXML
    private TableColumn<?, ?> obsColumn;

    @FXML
    private Button idBtnVoltar;

    @FXML
    private Button idBtnExcluir;


    @FXML
    private void pesquisarButtonAction() {
        // Implemente aqui a lógica quando o botão "Pesquisar" for clicado.
    }

    @FXML
    private void voltarButtonAction() {
        // Implemente aqui a lógica quando o botão "Voltar" for clicado.
    }

    @FXML
    private void excluirButtonAction() {
        // Implemente aqui a lógica quando o botão "Excluir" for clicado.
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
