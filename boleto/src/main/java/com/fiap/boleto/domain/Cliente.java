package com.fiap.boleto.domain;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cliId;
    @NotNull
    private String cliNome;
    private String cliEmail;
    private String cliCelular;

    public Cliente(){
    }

    public Cliente(final long id, final String nome, final String email, final String celular){
        this.cliId = id;
        this.cliNome = nome;
        this.cliEmail = email;
        this.cliCelular = celular;
    }

    public long getId() {
        return cliId;
    }

    public Cliente setId(final long id) {
        this.cliId = id;
        return this;
    }

    public String getNome() {
        return cliNome;
    }

    public Cliente setNome(final String nome) {
        this.cliNome = nome;
        return this;
    }

    public String getEmail() {
        return cliEmail;
    }

    public Cliente setEmail(final String email) {
        this.cliEmail = email;
        return this;
    }

    public String getCelular() {
        return cliCelular;
    }

    public Cliente setCelular(final String celular) {
        this.cliCelular = celular;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cliId == cliente.cliId &&
                cliNome.equals(cliente.cliNome) &&
                cliEmail.equals(cliente.cliEmail) &&
                cliCelular.equals(cliente.cliCelular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliId, cliNome, cliEmail, cliCelular);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + cliId +
                ", nome='" + cliNome + '\'' +
                ", email='" + cliEmail + '\'' +
                ", celular='" + cliCelular + '\'' +
                '}';
    }
}
