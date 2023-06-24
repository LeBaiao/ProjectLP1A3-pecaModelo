package com.fiosequeries;

import com.fiosequeries.Model.Orcamento;
import javafx.fxml.Initializable;
import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ListarOrcamentoController implements Initializable {
    @FXML
    private Label titleLabel;

    @FXML
    private TextField idPesquisa;

    @FXML
    private Button idBtnPesquisa;

    @FXML
    private TableView<Orcamento> orcamentoTableView;

    @FXML
    private TableColumn<Orcamento, Integer> idColumn;

    @FXML
    private TableColumn<Orcamento, String> usuarioColumn;

    @FXML
    private TableColumn<Orcamento, String> clienteColumn;

    @FXML
    private TableColumn<Orcamento, String> itensPedidoColumn;

    @FXML
    private TableColumn<Orcamento, String> dataColumn;

    @FXML
    private TableColumn<Orcamento, Double> totalColumn;

    @FXML
    private TableColumn<Orcamento, String> obsColumn;

    @FXML
    private Button idBtnVoltar;

    @FXML
    private void pesquisarButtonAction() {
        // Implemente aqui a lógica quando o botão "Pesquisar" for clicado.
    }

    @FXML
    private void voltarButtonAction() {
        // Implemente aqui a lógica quando o botão "Voltar" for clicado.
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
