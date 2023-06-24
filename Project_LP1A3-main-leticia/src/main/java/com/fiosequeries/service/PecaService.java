package com.fiosequeries.service;

import com.fiosequeries.Model.Peca;
import com.fiosequeries.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.fiosequeries.Model.Medida;


@Service
public class PecaService {
    @Autowired
    private PecaRepository pecaRepository;

    // Método usado para mostrar os nomes das peças no combobox

    public List<String> RetornaNomePeca(){
        List<Peca> pecas = pecaRepository.findAll();
        List<String> nomesPecas = new ArrayList<>();

        for(Peca peca : pecas){
            nomesPecas.add(peca.getNome());
        }
        return nomesPecas;
    }

    public Peca adicionarPeca(String nome, Double precoBase) {
        Peca peca = new Peca(nome, precoBase);
        return pecaRepository.save(peca);
    }

    public Peca editarPeca(Long pecaId, Double novoPrecoBase) {
        Optional<Peca> optionalPeca = pecaRepository.findById(pecaId);
        if (optionalPeca.isPresent()) {
            Peca peca = optionalPeca.get();
            peca.setPrecoBase(novoPrecoBase);

            // Mantém o nome atual da peça
            String nomeAtual = peca.getNome();
            peca.setNome(nomeAtual);

            return pecaRepository.save(peca);
        }
        throw new IllegalArgumentException("Peca com ID " + pecaId + " não encontrada");
    }


    public List<Peca> listarPecas() {
        List<Peca> pecas = pecaRepository.findAll();
        for (Peca peca : pecas) {
            peca.getMedidas().size(); // Buscar as medidas associadas a cada peça
        }
        return pecas;}

    public Peca adicionarMedida(Long pecaId, Medida medida) {
        Optional<Peca> optionalPeca = pecaRepository.findById(pecaId);
        if (optionalPeca.isPresent()) {
            Peca peca = optionalPeca.get();
            List<Medida> medidas = peca.getMedidas();
            medidas.add(medida);
            peca.setMedidas(medidas);
            return pecaRepository.save(peca);
        }
        throw new IllegalArgumentException("Peca com ID " + pecaId + " não encontrada");
    }
}

