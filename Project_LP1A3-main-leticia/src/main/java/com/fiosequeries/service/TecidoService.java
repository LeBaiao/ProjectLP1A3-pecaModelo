package com.fiosequeries.service;

import com.fiosequeries.repository.TecidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecidoService {
    @Autowired
    private TecidoRepository tecidoRepository;
}
