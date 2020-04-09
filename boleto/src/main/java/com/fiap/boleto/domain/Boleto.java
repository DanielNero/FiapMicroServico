package com.fiap.boleto.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bolId;
    @NotNull
    private String bolStatus;
    private double bolValor;
    private String bolDigitavel;
    private String bolVencimento;
    private String bolLinkPdf;
    private String bolDetalhes;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cliente cliente;

    public Boleto(){
    }

    public Boleto(final long id, final String status, final double valor, final String digitavel, final String vencimento, final String detalhes,final String link_pdf, final Cliente cliente){
        this.bolId = id;
        this.bolStatus = status;
        this.bolValor = valor;
        this.bolDigitavel = digitavel;
        this.bolVencimento = vencimento;
        this.bolLinkPdf = link_pdf;
        this.bolDetalhes = detalhes;
        this.cliente = cliente;
    }

    public long getId() {
        return bolId;
    }

    public Boleto setId(final long id) {
        this.bolId = id;
        return this;
    }

    public String getStatus() {
        return bolStatus;
    }

    public Boleto setStatus(final String status) {
        this.bolStatus = status;
        return this;
    }

    public double getValor() {
        return bolValor;
    }

    public Boleto setValor(final double valor) {
        this.bolValor = valor;
        return this;
    }

    public String getDigitavel() {
        return bolDigitavel;
    }

    public Boleto setDigitavel(final String digitavel) {
        this.bolDigitavel = digitavel;
        return this;
    }

    public String getVencimento() {
        return bolVencimento;
    }

    public Boleto setVencimento(final String vencimento) {
        this.bolVencimento = vencimento;
        return this;
    }

    public String getLink_pdf() {
        return bolLinkPdf;
    }

    public Boleto setLink_pdf(final String link_pdf) {
        this.bolLinkPdf = link_pdf;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Boleto setCliente(final Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boleto boleto = (Boleto) o;
        return bolId == boleto.bolId &&
                Double.compare(boleto.bolValor, bolValor) == 0 &&
                bolStatus.equals(boleto.bolStatus) &&
                bolDigitavel.equals(boleto.bolDigitavel) &&
                bolVencimento.equals(boleto.bolVencimento) &&
                bolLinkPdf.equals(boleto.bolLinkPdf) &&
                bolDetalhes.equals(boleto.bolDetalhes) &&
                cliente.equals(boleto.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bolId, bolStatus, bolValor, bolDigitavel, bolVencimento, bolLinkPdf, bolDetalhes, cliente);
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "id=" + bolId +
                ", status='" + bolStatus + '\'' +
                ", valor=" + bolValor +
                ", digitavel='" + bolDigitavel + '\'' +
                ", vencimento=" + bolVencimento +
                ", link_pdf='" + bolLinkPdf + '\'' +
                ", detalhes='" + bolDetalhes + '\'' +
                ", cliente=" + cliente +
                '}';
    }

    public String getDetalhes() {
        return bolDetalhes;
    }

    public Boleto setDetalhes(String bolDetalhes) {
        this.bolDetalhes = bolDetalhes;
        return this;
    }
}
