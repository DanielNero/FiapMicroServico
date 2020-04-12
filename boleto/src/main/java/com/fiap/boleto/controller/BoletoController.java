package com.fiap.boleto.controller;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import com.fiap.boleto.domain.Boleto;
import com.fiap.boleto.repository.BoletoRepository;
import com.fiap.boleto.service.GeraBoleto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoletoController {
    @Autowired
    private BoletoRepository boletoRepository;
    @Autowired
    private GeraBoleto geraBoleto;

    @CrossOrigin
    @GetMapping("/ListaBoleto")
    public List<Boleto> ListarBoletos() {
        return (List<Boleto>) boletoRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(
            value = "/GeraBoleto",
            method = RequestMethod.POST)
    public Boleto process(@RequestBody Map<String, Object> payload) throws Exception {
        Random rand = new Random();
        String rand_int = String.valueOf(rand.nextInt(1000000000));
        final Boleto add = geraBoleto.add(
                        "NP",
                        (Double) payload.get("valor"),
                        rand_int,
                        payload.get("vencimento").toString(),
                        "https://boleto.com.br?"+rand_int,
                        payload.get("detalhes").toString(),
                        payload.get("nome").toString(),
                        payload.get("email").toString(),
                        payload.get("celular").toString()
                );
                return add;
    }

    @CrossOrigin
    @GetMapping("/ListaBoleto/{id}")
    public List<Boleto> BoletosCliente(@PathVariable int id) throws Exception {
        return boletoRepository.findByClienteCliId(id);
    }

    @CrossOrigin
    @GetMapping("/ListaBoletoSt/{status}")
    public List<Boleto> BoletosStatus(@PathVariable String status) throws Exception {
        return boletoRepository.findByBolStatus(status);
    }

    @CrossOrigin
    @GetMapping("/totalNP/{filtro}")
    public Float selectTotal(@PathVariable String filtro) {
        return boletoRepository.selectTotals(filtro);
    }


}
