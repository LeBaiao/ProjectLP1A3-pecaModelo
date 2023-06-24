package com.fiosequeries;


import com.fiosequeries.Model.Modelo;
import com.fiosequeries.Model.Peca;
import com.fiosequeries.service.ModeloService;
import com.fiosequeries.service.PecaService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component
public class ModeloController {
    @FXML
    private TableView<Modelo> modeloTableView;

    @FXML
    private TableColumn<Modelo, Long> idColumn;

    @FXML
    private TableColumn<Modelo, String> nomeColumn;

    @FXML
    private TableColumn<Modelo, Double> multiplicadorColumn;
    @FXML
    private TableColumn<Modelo, List<Peca>> pecasColumn;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField multiplicadorTextField;

    @FXML
    private Button btn_Adicionar_Modelo;

    @FXML
    private Button btn_Editar_Modelo;

    @FXML
    private ListView<Peca> pecasListView;

    @FXML
    private Button btn_Adicionar_Peca;

    @FXML
    private Button btn_Remover_Peca;

    @Autowired
    private ModeloService modeloService;

    private PecaService pecaService;


    public void initialize() {
        configurarColunas();
        carregarModelos();
    }

    private void configurarColunas() {
        idColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));
        nomeColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNome()));
        multiplicadorColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getMultiplicador()));
        pecasColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(new ArrayList<>(cellData.getValue().getPecas())));

        pecasColumn.setCellFactory(column -> new TableCell<Modelo, List<Peca>>() {
            @Override
            protected void updateItem(List<Peca> pecas, boolean empty) {
                super.updateItem(pecas, empty);

                if (empty || pecas == null || pecas.isEmpty()) {
                    setText("");
                } else {
                    StringBuilder pecasString = new StringBuilder();
                    for (Peca peca : pecas) {
                        pecasString.append(peca.getNome()).append(", ");
                    }
                    pecasString.setLength(pecasString.length() - 2); // Remover a vírgula extra no final

                    setText(pecasString.toString());
                }
            }
        });

        modeloTableView.setItems(FXCollections.observableList(modeloService.listarModelos()));

        refreshTable();
    }


    private void carregarModelos() {
        // Obtém a lista de peças do serviço e define como os itens da tabela
        List<Modelo> modelos = modeloService.listarModelos();
        modeloTableView.getItems().setAll(modelos);
    }

    @FXML
    private void editarModelo() {
        Modelo modeloSelecionado = modeloTableView.getSelectionModel().getSelectedItem();

        if (modeloSelecionado != null) {
            Long modeloId = modeloSelecionado.getId();
            Double novoMultiplicador; //só é possível alterar o multiplicador
            try {
                novoMultiplicador = Double.parseDouble(multiplicadorTextField.getText());
            } catch (NumberFormatException ex) {
                exibirErro("Erro ao editar modelo", "O novo multiplicador deve ser um número válido.");
                return;
            }

            Modelo modelo = modeloService.editarModelo(modeloId, novoMultiplicador);
            if (modelo != null) {
                refreshTable();
                clearFields();
            } else {
                exibirErro("Erro ao editar modelo", "Não foi possível editar o modelo.");
            }
        } else {
            exibirErro("Nenhum modelo selecionado", "Selecione um modelo para editar.");
        }
    }


    private void exibirErro(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void refreshTable() {
        List<Modelo> modelos = modeloService.listarModelos();
        modeloTableView.setItems(FXCollections.observableArrayList(modelos));
    }

    private void clearFields() {
        nomeTextField.clear();
       multiplicadorTextField.clear();
    }


    @FXML
    private void adicionarPeca() {
        Modelo modeloSelecionado = modeloTableView.getSelectionModel().getSelectedItem();

        if (modeloSelecionado != null) {
            // Obter as peças selecionadas na lista
            ObservableList<Peca> pecasSelecionadas = pecasListView.getSelectionModel().getSelectedItems();

            // Adicionar as peças ao modelo
            modeloSelecionado.getPecas().addAll(pecasSelecionadas);

            // Atualizar a exibição na lista
            pecasListView.getItems().removeAll(pecasSelecionadas);
        }
    }

    @FXML
    private void adicionarModelo() {
        String nome = nomeTextField.getText();
        Double multiplicador;
        try {
            multiplicador = Double.parseDouble(multiplicadorTextField.getText());
        } catch (NumberFormatException ex) {
            exibirErro("Erro ao adicionar peça", "O multiplicador deve ser um número válido.");
            return;
        }
        Modelo modelo = modeloService.adicionarModelo(nome, multiplicador);
        if (modelo != null) {
            modeloTableView.getItems().add(modelo);
            clearFields();
        } else {
            exibirErro("Erro ao adicionar modelo", "Não foi possível adicionar o modelo.");
        }
    }


    @FXML
    private void removerPeca() {
        // Obter o modelo selecionado na tabela
        Modelo modeloSelecionado = modeloTableView.getSelectionModel().getSelectedItem();

        if (modeloSelecionado != null) {
            // Obter a peça selecionada na lista
            Peca pecaSelecionada = pecasListView.getSelectionModel().getSelectedItem();

            if (pecaSelecionada != null) {
                // Remover a peça do modelo
                modeloSelecionado.getPecas().remove(pecaSelecionada);

                // Atualizar o modelo no banco de dados
                modeloService.editarModelo(modeloSelecionado.getId(), modeloSelecionado.getMultiplicador());

                // Atualizar a exibição na tabela
                modeloTableView.refresh();
            }
        }
    }



}

