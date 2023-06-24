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
public class AtualizarClienteController implements Initializable {
    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField telefoneTextField;

    @FXML
    private ComboBox<String> medida1ComboBox;

    @FXML
    private ComboBox<String> medida2ComboBox;

    @FXML
    private ComboBox<String> medida3ComboBox;

    @FXML
    private Button cancelarButton;

    @FXML
    private Button salvarButton;

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
