package com.fiosequeries;
import com.fiosequeries.Model.Medida;
import com.fiosequeries.Model.Peca;
import com.fiosequeries.service.PecaService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;

@Controller
public class PecaController implements Initializable {
    @FXML
    private TableView<Peca> pecaTableView;
    @FXML
    private TableColumn<Peca, Long> idColumn;
    @FXML
    private TableColumn<Peca, String> nomeColumn;
    @FXML
    private TableColumn<Peca, Double> precoBaseColumn;
    @FXML
    private TableColumn<Peca, List<Medida>> medidasColumn;
    @FXML
    private TableColumn<Medida, Long> idMedidaColumn;
    @FXML
    private TableColumn<Medida, String> nomeMedidaColumn;
    @FXML
    private TableColumn<Medida, Double> tamanhoMedidaColumn;
    @FXML
    private TextField nomeTextField;
    @FXML
    private TextField precoBaseTextField;
    @FXML
    private ComboBox<String> medidasComboBox;
    @FXML
    private Button btn_Editar_Peca;
    @FXML
    private Button btn_Adicionar_Peca;
    @FXML
    private Button btn_Adicionar_Medida;
    @FXML
    private Button btn_Remover_Medida;

    @Autowired
    private PecaService pecaService;

    private ObservableList<Peca> pecasList;
    private ObservableList<Medida> medidasList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        configurarColunas();
        carregarPecas();
        configurarColunas();
        carregarPecas();
        loadNomesPecas(); // Carrega os nomes das peças para o ComboBox
        };

        private void configurarColunas() {
            pecasList = FXCollections.observableArrayList();
            medidasList = FXCollections.observableArrayList();
            idColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));
            nomeColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNome()));
            precoBaseColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrecoBase()));
            medidasColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getMedidas()));
            medidasColumn.setCellFactory(column -> new TableCell<Peca, List<Medida>>() {
                @Override
                protected void updateItem(List<Medida> medidas, boolean empty) {
                    super.updateItem(medidas, empty);

                    if (empty || medidas == null || medidas.isEmpty()) {
                        setText("");
                    } else {
                        StringBuilder medidasString = new StringBuilder();
                        for (Medida medida : medidas) {
                            medidasString.append(medida.getNome()).append(", ");
                        }
                        medidasString.setLength(medidasString.length() - 2); // Remover a vírgula extra no final

                        setText(medidasString.toString());
                    }
                }
            });
        }

    private void carregarPecas() {
        // Obtém a lista de peças do serviço e define como os itens da tabela
        List<Peca> pecas = pecaService.listarPecas();
        pecaTableView.getItems().setAll(pecas);
    }

    @FXML
    private void adicionarPeca() {
        String nome = nomeTextField.getText();
        Double precoBase;
        try {
            precoBase = Double.parseDouble(precoBaseTextField.getText());
        } catch (NumberFormatException ex) {
            exibirErro("Erro ao adicionar peça", "O preço base deve ser um número válido.");
            return;
        }
        Peca peca = pecaService.adicionarPeca(nome, precoBase);
        if (peca != null) {
            pecaTableView.getItems().add(peca);
            clearFields();
        } else {
            exibirErro("Erro ao adicionar peça", "Não foi possível adicionar a peça.");
        }
    }

    @FXML
    private void editarPeca() {
        Peca selectedPeca = pecaTableView.getSelectionModel().getSelectedItem();
        if (selectedPeca != null) {
            Long pecaId = selectedPeca.getId();
            Double novoPrecoBase;
            try {
                novoPrecoBase = Double.parseDouble(precoBaseTextField.getText());
            } catch (NumberFormatException ex) {
                exibirErro("Erro ao editar peça", "O novo preço base deve ser um número válido.");
                return;
            }

            Peca peca = pecaService.editarPeca(pecaId, novoPrecoBase);
            if (peca != null) {
                refreshTable();
                clearFields();
            } else {
                exibirErro("Erro ao editar peça", "Não foi possível editar a peça.");
            }
        } else {
            exibirErro("Nenhuma peça selecionada", "Selecione uma peça para editar.");
        }
    }


    private void exibirErro(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
        };



    private void refreshTable() {
        List<Peca> pecas = pecaService.listarPecas();
        pecaTableView.setItems(FXCollections.observableArrayList(pecas));
    }

    @FXML
    private void loadNomesPecas() {
        Peca selectedPeca = pecaTableView.getSelectionModel().getSelectedItem();
        if (selectedPeca != null) {
            List<Medida> medidasPeca = selectedPeca.getMedidas();
            List<String> nomesMedidas = medidasPeca.stream()
                    .map(Medida::getNome)
                    .collect(Collectors.toList());
            medidasComboBox.setItems(FXCollections.observableArrayList(nomesMedidas));
        } else {
            medidasComboBox.setItems(FXCollections.emptyObservableList());
        }
    }

    private void clearFields() {
        nomeTextField.clear();
        precoBaseTextField.clear();
    }

    private List<Medida> getSelectedMedidas() {
        // Lógica para obter as medidas selecionadas no ComboBox
        return null;
    }

    @FXML
    private void adicionarMedida() {
        Peca selectedPeca = pecaTableView.getSelectionModel().getSelectedItem();
        if (selectedPeca != null) {
            List<Medida> medidasSelecionadas = getSelectedMedidas();
            if (!medidasSelecionadas.isEmpty()) {
                Peca peca = pecaService.adicionarMedida(selectedPeca.getId(), medidasSelecionadas.get(0));
                if (peca != null) {
                    refreshTable();
                    exibirMedidas(); // Exibe as medidas atualizadas
                } else {
                    exibirErro("Erro ao adicionar medida", "Não foi possível adicionar a medida à peça.");
                }
            } else {
                exibirErro("Nenhuma medida selecionada", "Selecione uma medida para adicionar à peça.");
            }
        } else {
            exibirErro("Nenhuma peça selecionada", "Selecione uma peça para adicionar medida.");
        }
    }

    @FXML
   private void removerMedida() {
//
    }

    public void exibirMedidas() {
//
    }


}
