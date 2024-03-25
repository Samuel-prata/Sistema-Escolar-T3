package br.com.vainaweb.escolat3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.vainaweb.escolat3.model.ColaboradorModel;
import br.com.vainaweb.escolat3.repository.ColaboradorRepository;

@Service // Anotação que diz pro Spring tratar essa classe como classe de Serviço
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repository;

	public List<ColaboradorModel> encontrarColaboradores() {
		return repository.findAll();
	}

	public Optional<ColaboradorModel> encontrarUmColaborador(Long id) {
		return repository.findById(id);
	}

	

}
