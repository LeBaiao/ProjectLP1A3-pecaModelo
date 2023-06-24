package com.fiosequeries.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Cor")
public class Cor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Cor")
    private String nome;

    @OneToMany(mappedBy = "cor")
    private List<ItemPedido> itensPedido = new ArrayList<>();


    public Cor(String nome, Long id) {
        this.nome = nome;
        this.id = id;
    }

    public Cor()
    {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
