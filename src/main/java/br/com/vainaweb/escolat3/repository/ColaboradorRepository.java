package br.com.vainaweb.escolat3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vainaweb.escolat3.model.ColaboradorModel;

@Repository
public interface ColaboradorRepository extends JpaRepository <ColaboradorModel, Long> {

	// SELECT * FROM tb_colaboradores WHERE cpf = ??
	Optional<ColaboradorModel> findByCpf(String cpf);
	
}
