package com.fiosequeries;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class OutrosController implements Initializable {

    @FXML
    private Button btn_peca;
    @FXML
    private Button btn_modelo;
    @FXML
    private Button btn_adicional;
    @FXML
    private Button btn_tecido;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    private final StageInitializer stageInitializer;

    @Autowired
    public OutrosController(StageInitializer stageInitializer) {
        this.stageInitializer = stageInitializer;
    }

    @FXML
    private void goToPeca() {
        stageInitializer.changeScene("/PecaScreen.fxml");
    }

    @FXML
    private void goToModelo() {
        stageInitializer.changeScene("/ModeloScreen.fxml");
    }

    /*private void goToModelo() {
        stageInitializer.changeScene("/ModeloScreen.fxml");
    }*/
}
