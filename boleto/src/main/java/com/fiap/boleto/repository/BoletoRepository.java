package com.fiap.boleto.repository;

import com.fiap.boleto.domain.Boleto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoletoRepository extends CrudRepository<Boleto, Integer> {
    List<Boleto> findByClienteCliId(long cliId);
    List<Boleto> findByBolStatus(String status);
    @Query("SELECT SUM(m.bolValor) FROM Boleto m WHERE bolStatus = :filtro")
    Float selectTotals(@Param("filtro") String filtro);

}