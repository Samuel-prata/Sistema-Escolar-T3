package br.com.vainaweb.escolat3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vainaweb.escolat3.model.AlunoModel;

@Repository // essa classe deve ser tratada como repository (para persistencia de dados)
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {

	// SELECT * FROM tb_alunos WHERE cpf =
	Optional<AlunoModel> findByCpf(String cpf);
}
