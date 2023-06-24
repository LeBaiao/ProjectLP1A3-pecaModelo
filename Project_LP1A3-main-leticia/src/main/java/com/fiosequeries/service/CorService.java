package com.fiosequeries.service;

import com.fiosequeries.repository.CorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorService {
    @Autowired
    private CorRepository corRepository;
}
