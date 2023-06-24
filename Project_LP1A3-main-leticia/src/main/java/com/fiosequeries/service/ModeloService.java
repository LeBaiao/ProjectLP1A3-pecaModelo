package com.fiosequeries.service;

import com.fiosequeries.Model.Modelo;
import com.fiosequeries.Model.Peca;
import com.fiosequeries.repository.ModeloRepository;
import com.fiosequeries.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {
    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private PecaRepository pecaRepository;


    public Modelo adicionarModelo(String nome, Double multiplicador) {
        Modelo modelo = new Modelo(nome, multiplicador);
        return modeloRepository.save(modelo);
    }

    public List<Modelo> listarModelos() {
        List<Modelo> modelos =  modeloRepository.findAll();
        for (Modelo modelo : modelos) {
            modelo.getPecas().size(); // Buscar as medidas associadas a cada peça
        }
        return modelos;
    }

    public Modelo editarModelo(Long modeloId, Double novoMultiplicador) {
        Optional<Modelo> optionalModelo = modeloRepository.findById(modeloId);
        if (optionalModelo.isPresent()) {
            Modelo modelo = optionalModelo.get();
            modelo.setMultiplicador(novoMultiplicador); //só altera o multiplicador

            // Mantém o nome atual do modelo
            String nomeAtual = modelo.getNome();
            modelo.setNome(nomeAtual);

            return modeloRepository.save(modelo);
        }
        throw new IllegalArgumentException("Modelo com ID " + modeloId + " não encontrado");
    }


    public void removerPecaDoModelo(Long modeloId, Long pecaId) {
        Optional<Modelo> optionalModelo = modeloRepository.findById(modeloId);
        Optional<Peca> optionalPeca = pecaRepository.findById(pecaId);

        if (optionalModelo.isPresent() && optionalPeca.isPresent()) {
            Modelo modelo = optionalModelo.get();
            Peca peca = optionalPeca.get();

            modelo.getPecas().remove(peca);
            modeloRepository.save(modelo);
        } else {
            throw new IllegalArgumentException("Modelo com ID " + modeloId + " ou peça com ID " + pecaId + " não encontrados");
        }
    }

}
