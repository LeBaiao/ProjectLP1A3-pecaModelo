package com.fiosequeries.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Peca")
public class Peca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "precoBase")
    private Double precoBase;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

    //verificar
    @OneToMany(mappedBy = "peca", fetch = FetchType.EAGER)
    private List<Medida> medidas = new ArrayList<>();

    @OneToMany(mappedBy = "peca")
    private List<ItemPedido> itensPedido = new ArrayList<>();


    public Peca(String nome, Double precoBase) {
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public Peca() {
    }

    public Modelo getModelo() {
        return modelo;
    }

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

    public Double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(Double precoBase) {
        this.precoBase = precoBase;
    }

    public List<Medida> getMedidas() {
        return medidas;
    }

    public void setMedidas(List<Medida> medidas) {
        this.medidas = medidas;
    }
}
