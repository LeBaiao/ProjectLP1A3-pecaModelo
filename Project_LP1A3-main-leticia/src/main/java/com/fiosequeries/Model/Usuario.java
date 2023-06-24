package com.fiosequeries.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nomeUsuario")
    private String nomeUsuario;

    @Column(name = "senhaUsuario")
    private String senhaUsuario;

    @Column(name = "emailUsuario")
    private String emailUsuario;

    @Column(name = "gerente")
    private boolean isGerente;

    public Usuario() {
    }

    public Usuario(String nomeUsuario, String senhaUsuario, String emailUsuario, boolean isGerente) {
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
        this.emailUsuario = emailUsuario;
        this.isGerente = isGerente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public boolean isGerente() {
        return isGerente;
    }

    public void setGerente(boolean gerente) {
        isGerente = gerente;
    }
}