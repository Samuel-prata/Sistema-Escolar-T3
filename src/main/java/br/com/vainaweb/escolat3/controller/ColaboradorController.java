package br.com.vainaweb.escolat3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolat3.dto.DadosColaborador;
import br.com.vainaweb.escolat3.service.Colaborador;

@RestController
@RequestMapping("/colaborador-teste")
public class ColaboradorController {
	
	@Autowired //retorna o controle para o spring container
	private Colaborador colaborador;
	
	@GetMapping
	public List<Colaborador> encontrarColaboradores() {
		return colaborador.encontrarColaboradores();
	}
	
	@GetMapping("/{id}")
	public Colaborador encontrarUmColaboradorPorId(@PathVariable Long id) {
		var c = colaborador.encontrarUmColaborador(id);
		return c;
	}
	
	@PostMapping
	public String cadastrarColaborador(@RequestBody DadosColaborador dados) {
		colaborador.cadastrar(dados);
		return "Ok";
	}
}
