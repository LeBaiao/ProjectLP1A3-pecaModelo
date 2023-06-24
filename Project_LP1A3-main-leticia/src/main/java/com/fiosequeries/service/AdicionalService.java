package com.fiosequeries.service;

import com.fiosequeries.repository.AdicionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionalService {

    @Autowired
    private AdicionalRepository adicionalRepository;


}
