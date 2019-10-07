package curso.springboot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;
	
	@NotEmpty( message = "Nome não pode ser Vazio!" )
	@NotNull( message = "Nome não pode ser nulo!" )
	private String nome;
	
	@NotEmpty( message = "Sobrenome não pode ser Vazio!" )
	@NotNull( message = "Sobrenome não pode ser nulo!" )
	private String sobrenome;
	
	@OneToMany( mappedBy = "pessoa", orphanRemoval = true, cascade = CascadeType.ALL )
	List<Telefone> telefones = new ArrayList<Telefone>();
	
	@Min( value = 18, message = "Idade Invalida!" )
	private int idade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
