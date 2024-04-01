package br.com.vainaweb.escolat3.model;

import br.com.vainaweb.escolat3.enums.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorModel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	@Column(unique = true)
	private String email;
	
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






