package br.com.vainaweb.escolat3.model;

import org.hibernate.validator.constraints.br.CPF;

import br.com.vainaweb.escolat3.enums.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_colaboradores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorModel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	@Email
	@Column(unique = true)
	private String email;
	
	@CPF
	@Column(unique = true)
	private String cpf;
	private Cargo cargo;
	
	@Embedded //Diz que o atributo será incorporado NESSA tabela
	private Endereco endereco;
	
// |------------------------------------------CONSTRUTOR-----------------------------------------|
	
	public ColaboradorModel(String nome, String cpf, String email, Cargo cargo) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.cargo = cargo;
	}
	
}






