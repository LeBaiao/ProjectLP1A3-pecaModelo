package com.fiosequeries.service;

import com.fiosequeries.repository.MedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedidaService {
    @Autowired
    private MedidaRepository medidaRepository;
}
