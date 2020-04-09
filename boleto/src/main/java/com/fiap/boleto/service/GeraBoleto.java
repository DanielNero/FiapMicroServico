package com.fiap.boleto.service;

import com.fiap.boleto.domain.Boleto;
import com.fiap.boleto.domain.Cliente;
import com.fiap.boleto.repository.BoletoRepository;
import com.fiap.boleto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GeraBoleto {

    private final BoletoRepository boletoRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public GeraBoleto(BoletoRepository boletoRepository, ClienteRepository clienteRepository) {
        this.boletoRepository = boletoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Boleto add(final String status, final double valor, final String digitavel,
                      final String vencimento, final String link_pdf, final String detalhes,
                      final String nome, final String email, final String sms){
        return boletoRepository.save(new Boleto()
                .setStatus(status)
                .setValor(valor)
                .setDigitavel(digitavel)
                .setVencimento(vencimento)
                .setLink_pdf(link_pdf)
                .setDetalhes(detalhes)
                .setCliente(getCliente(nome,email,sms)));
    }

    private Cliente getCliente(final String nome, final String email, final String sms) {
        final Cliente found = clienteRepository.findByCliNome(nome);

        if (found != null){
            return found;
        }

        return clienteRepository.save( new Cliente()
                .setNome(nome)
                .setCelular(sms)
                .setEmail(email));
    }
}
