package com.fiosequeries.service;

import com.fiosequeries.repository.itemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class itemPedidoService {
    @Autowired
    private itemPedidoRepository itemPedidoRepository;
}
