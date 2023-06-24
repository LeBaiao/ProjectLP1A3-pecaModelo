package com.fiosequeries;

import com.fiosequeries.Model.Cliente;
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
public class GerenciaClienteController implements Initializable {

    @FXML
    private Label titleLabel;

    @FXML
    private TextField pesquisaTextField;

    @FXML
    private Button pesquisarButton;

    @FXML
    private Button alterarButton;

    @FXML
    private Button excluirButton;

    @FXML
    private Button inserirButton;

    @FXML
    private TableView<Cliente> clienteTableView;

    @FXML
    private TableColumn<Cliente, Integer> idColumn;

    @FXML
    private TableColumn<Cliente, String> nomeColumn;

    @FXML
    private TableColumn<Cliente, String> emailColumn;

    @FXML
    private TableColumn<Cliente, String> telefoneColumn;

    @FXML
    private Button voltarButton;

    @FXML
    private void pesquisarButtonAction() {
        // Implemente aqui a lógica quando o botão "Pesquisar" for clicado.
    }

    @FXML
    private void alterarButtonAction() {
        // Implemente aqui a lógica quando o botão "Alterar" for clicado.
    }

    @FXML
    private void excluirButtonAction() {
        // Implemente aqui a lógica quando o botão "Excluir" for clicado.
    }

    @FXML
    private void inserirButtonAction() {
        // Implemente aqui a lógica quando o botão "Inserir" for clicado.
    }

    @FXML
    private void voltarButtonAction() {
        // Implemente aqui a lógica quando o botão "Voltar" for clicado.
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
