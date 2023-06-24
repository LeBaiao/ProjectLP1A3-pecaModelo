package com.fiosequeries;

import com.fiosequeries.service.PecaService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class AdicionarItemController implements Initializable {

    @Autowired
    private PecaService pecaService;


    @FXML
    private ComboBox<String> cbox_Cliente;

    @FXML
    private ComboBox<String> cbox_Peca;

    @FXML
    private ComboBox<String> cbox_Tamanho;

    @FXML
    private ComboBox<String> cbox_Modelo;

    @FXML
    private ComboBox<String> cbox_Cor;

    @FXML
    private ComboBox<String> cbox_Tecido;

    @FXML
    private ComboBox<String> cbox_Add1;

    @FXML
    private ComboBox<String> cbox_Add2;

    @FXML
    private TextField lb_idFunc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        List<String> pecas = pecaService.RetornaNomePeca();
//        cbox_Peca.getItems().addAll(pecas);

    }
}
