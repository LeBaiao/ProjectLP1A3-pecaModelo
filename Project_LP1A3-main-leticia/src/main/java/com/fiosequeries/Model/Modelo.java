package com.fiosequeries.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Modelo")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    // verificar
    @OneToMany(mappedBy = "modelo", fetch = FetchType.EAGER)
    private Set<Peca> pecas = new HashSet<>();



    @Column(name = "multiplicador")
    private Double multiplicador;

    @OneToMany(mappedBy = "modelo")
    private List<ItemPedido> itensPedido = new ArrayList<>();


    public Modelo(String nome,Double multiplicador) {
        this.nome = nome;
        this.multiplicador = multiplicador;
    }

    public Modelo(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(Set<Peca> pecas) {
        this.pecas = pecas;
    }

    public Double getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(Double multiplicador) {
        this.multiplicador = multiplicador;
    }
}
