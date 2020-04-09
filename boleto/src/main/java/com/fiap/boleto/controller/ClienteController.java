package com.fiap.boleto.controller;

import com.fiap.boleto.domain.Boleto;
import com.fiap.boleto.domain.Cliente;
import com.fiap.boleto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/ListaCliente")
    public List<Cliente> ListarClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }
}
