package br.com.vainaweb.escolat3.model;

import org.hibernate.validator.constraints.br.CPF;

import br.com.vainaweb.escolat3.dto.DadosAluno;
import br.com.vainaweb.escolat3.dto.DadosAtualizados;
import br.com.vainaweb.escolat3.enums.Curso;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // Ensina ao Spring que a classe deve ser tratada como uma entidade
@Table(name = "tb_alunos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlunoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incrementado
	public Long id;

	@Column(nullable = false)
	private String nome;

	@Email
	@Column(unique = true)
	private String email;

	@CPF
	@Column(unique = true)
	private String cpf;

	@Column(nullable = false)
	private String telefone;

	@Column(nullable = false)
	private Curso curso;

	@Embedded
	@Column(nullable = false)
	private Endereco endereco;

	public AlunoModel(DadosAluno dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.cpf = dados.cpf();
		this.telefone = dados.telefone();
		this.curso = dados.curso();
		this.endereco= new Endereco(dados.endereco().cep()
				, dados.endereco().logradouro(),
				dados.endereco().bairro(), 
				dados.endereco().cidade(), 
				dados.endereco().uf(),
				dados.endereco().complemento(),
				dados.endereco().numero());

	}

	public void atualizarInfo(@Valid DadosAtualizados dados) {
		this.nome = dados.nome() != null ? dados.nome(): nome;
		this.email = dados.email() != null ? dados.email(): email;
	}
}
