package br.com.vainaweb.escolat3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat3.dto.DadosAluno;
import br.com.vainaweb.escolat3.model.AlunoModel;
import br.com.vainaweb.escolat3.repository.AlunoRepository;

@Service// indica que essa é uma classe para regras de negócio
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	
	public Optional<AlunoModel> cadastrar(DadosAluno dados) {
		
		var cpfExistente = repository.existsByCpf(dados.cpf());
		var emailExistente = repository.existsByEmail(dados.email());

		if (cpfExistente || emailExistente) {
			return Optional.empty();
		}

		return Optional.of(repository.save(new AlunoModel(dados)));
	}
	
}
