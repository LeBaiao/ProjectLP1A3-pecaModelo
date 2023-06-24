package com.fiosequeries.service;

import com.fiosequeries.repository.TamanhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TamanhoService {
    @Autowired
    private TamanhoRepository tamanhoRepository;
}
