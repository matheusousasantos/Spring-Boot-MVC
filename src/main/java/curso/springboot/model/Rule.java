package curso.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Rule implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;
	
	private String nomeRule;

	@Override
	public String getAuthority() {// RULE_ADMIN, RULE_GERENTE, RULE_SECRETARIO
		
		//Retorna o nome do acesso.
		return nomeRule;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeRule() {
		return nomeRule;
	}

	public void setNomeRule(String nomeRule) {
		this.nomeRule = nomeRule;
	}

}


