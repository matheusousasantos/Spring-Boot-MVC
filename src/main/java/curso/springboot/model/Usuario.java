package curso.springboot.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;
	private String login;
	private String senha;
	
	@OneToMany( fetch =  FetchType.EAGER)
	@JoinTable(name = "usuarios_rule", 
	
		joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario"), 
		inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", table = "role")
		
		)
	private List<Rule> rules;//Vamos dizer que são os cargos em uma empresa
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override//Retorna os acessos
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return rules;
	}

	@Override//retorna a senha
	public String getPassword() {
		return senha;
	}

	@Override//retorna a senha
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
