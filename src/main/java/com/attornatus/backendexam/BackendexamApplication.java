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
public class BackendexamApplication implements CommandLineRunner {

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private EnderecoService enderecoService;

	public static void main(String[] args) {
		SpringApplication.run(BackendexamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createPessoas("pessoas.json");
		createEnderecos("enderecos.json");
	}

	/**
	 * Salva as pessoas do .json no database
	 * @param path Caminho para o arquivo .json
	 * @throws IOException
	 */
	private void createPessoas(String path) throws IOException{
		PessoaFromFile.read(path).forEach(pessoa->
				pessoaService.createPessoa(
					pessoa.getNome(),
					pessoa.getDataNasc()
				));
	}

	/**
	 * Salva os enderecos do .json no database
	 * @param path Caminho para o arquivo .json
	 * @throws IOException
	 */
	private void createEnderecos(String path) throws IOException{
		EnderecoFromFile.read(path).forEach(endereco->
				enderecoService.createEndereco(
						endereco.getLogradouro(),
						endereco.getCep(),
						endereco.getNumero(),
						endereco.getCidade(),
						endereco.getPessoaId()
				));
	}


	/**
	 * Classe que carrega Endereços contidos
	 * em um arquivo .json
	 */
	private static class EnderecoFromFile{
		private String logradouro;
		private String cep;
		private String numero;
		private String cidade;
		private Integer pessoaId;

		protected EnderecoFromFile(){}

		static List<EnderecoFromFile> read(String path) throws IOException{
			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD,
					JsonAutoDetect.Visibility.ANY).
					readValue(new FileInputStream(path),
					new TypeReference<List<EnderecoFromFile>>(){});

		}

		String getLogradouro() {
			return logradouro;
		}

		String getCep() {
			return cep;
		}

		String getNumero() {
			return numero;
		}

		String getCidade() {
			return cidade;
		}

		Integer getPessoaId() {
			return pessoaId;
		}
	}

	/**
	 * Classe que carrega as Pessoas presentes
	 * em um arquivo .json
	 */
	private static class PessoaFromFile {
		private String nome;
		private Date dataNasc;

		protected PessoaFromFile(){}
		static List<PessoaFromFile> read(String path) throws IOException{
			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD,
					JsonAutoDetect.Visibility.ANY).
					readValue(new FileInputStream(path),
					new TypeReference<List<PessoaFromFile>>() {});

		}

		String getNome() {
			return nome;
		}

		 void setNome(String nome) {
			this.nome = nome;
		}

		 Date getDataNasc() {
			return dataNasc;
		}

		void setDataNasc(Date dataNasc) {
			this.dataNasc = dataNasc;
		}


	}
}
