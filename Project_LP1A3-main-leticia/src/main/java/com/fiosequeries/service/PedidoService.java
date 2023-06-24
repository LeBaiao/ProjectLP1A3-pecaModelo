package com.fiosequeries.service;

import com.fiosequeries.Model.Orcamento;
import com.fiosequeries.Model.Pedido;
import com.fiosequeries.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarPedidos(){
        List<Pedido> pedidosCadastrados = new ArrayList<>();
        pedidosCadastrados = pedidoRepository.findAll();
        return pedidosCadastrados;
    }
}
