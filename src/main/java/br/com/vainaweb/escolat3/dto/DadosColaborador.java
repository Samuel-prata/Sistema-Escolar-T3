package br.com.vainaweb.escolat3.dto;

import br.com.vainaweb.escolat3.enums.Cargo;
import jakarta.validation.Valid;

public record DadosColaborador(String nome, String cpf, String email, Cargo cargo, @Valid EnderecoDTO endereco) {
}
