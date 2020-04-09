package com.fiap.boleto.repository;

import com.fiap.boleto.domain.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
