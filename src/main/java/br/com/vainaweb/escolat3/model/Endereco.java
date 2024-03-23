package br.com.vainaweb.escolat3.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Embeddable //Permite que a classe seja incorporada em outra tabela
public class Endereco {
	
	private String cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String uf;
	private String complemento;
	private Integer numero;
	
}
