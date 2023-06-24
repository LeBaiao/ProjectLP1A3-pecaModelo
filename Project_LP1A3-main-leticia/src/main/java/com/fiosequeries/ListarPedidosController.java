package com.fiosequeries;
import com.fiosequeries.Model.Orcamento;
import com.fiosequeries.Model.Pedido;import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import com.fiosequeries.service.PedidoService;
import javafx.beans.property.SimpleObjectProperty;


@Component
public class ListarPedidosController implements Initializable {

    @Autowired
    private PedidoService pedidoService;

    @FXML
    private TableView<Pedido> tabelaPedidos;

    @FXML
    private TableColumn<Pedido, Integer> colunaId;

    @FXML
    private TableColumn<Pedido, LocalDate> colunaDataEntrega;

    @FXML
    private TableColumn<Pedido, Boolean> colunaPago;

    @FXML
    private TableColumn<Pedido, LocalDate> colunaDataPagamento;

    @FXML
    private TableColumn<Pedido, String> colunaTipoPagamento;

    @FXML
    private TableColumn<Pedido, String> colunaSituacao;

    // ... outras colunas da tabela

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        configurarColunas();
        carregarPedidos();
    }

    private void configurarColunas() {
//        colunaId.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));

        colunaDataEntrega.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDataEntrega()));
        colunaPago.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().isPago()));
        colunaDataPagamento.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDataPagamento()));
        colunaTipoPagamento.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTipoPagamento()).asString());
        colunaSituacao.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getSituacao()).asString());
        // ... configurar outras colunas
    }


    private void carregarPedidos() {
        List<Pedido> pedidos = pedidoService.listarPedidos();
        tabelaPedidos.getItems().addAll(pedidos);
    }

    // ... outros métodos e lógica do controlador
}
