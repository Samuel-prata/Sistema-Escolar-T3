package br.com.vainaweb.escolat3.dto;

public record EnderecoDTO(String cep, String logradouro, String bairro
		,String cidade, String uf, String complemento, Integer numero) {

}
