package com.fiap.boleto;

import com.fiap.boleto.domain.Boleto;
import com.fiap.boleto.service.GeraBoleto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoletoApplication {


	public static void main(String[] args) {
		SpringApplication.run(BoletoApplication.class, args);
	}

	private void line(){
		System.out.println();
		System.out.println("=========================================");
		System.out.println();
	}
}
