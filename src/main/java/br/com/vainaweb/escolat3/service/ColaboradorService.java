package br.com.vainaweb.escolat3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat3.dto.DadosAtualizados;
import br.com.vainaweb.escolat3.dto.DadosColaborador;
import br.com.vainaweb.escolat3.model.ColaboradorModel;
import br.com.vainaweb.escolat3.repository.ColaboradorRepository;


@Service //Serviço
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository repository;
	
	public List<ColaboradorModel> encontrarTodosOsColaboradores() {
		return repository.findAll(); // SELECT * FROM tb_colaboradores;
	}

	public String cadastrar(DadosColaborador dados) {
		
		var colaborador = repository.findByCpf(dados.cpf());
	
		if(colaborador.isPresent()) {
			return "CPF Já cadastrado";
		}else {
			repository.save(new ColaboradorModel(dados.nome(), dados.cpf(), dados.email(), dados.cargo())); //INSERT 
			return "Cadastro efetuado com sucesso";
		}
	
		
	}
	
}
