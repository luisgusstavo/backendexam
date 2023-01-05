package com.attornatus.backendexam;

import com.attornatus.backendexam.service.EnderecoService;
import com.attornatus.backendexam.service.PessoaService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BackendexamApplication {



	public static void main(String[] args) {
		SpringApplication.run(BackendexamApplication.class, args);
	}


}
