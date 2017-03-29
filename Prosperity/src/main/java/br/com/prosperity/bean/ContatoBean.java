package br.com.prosperity.bean;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import br.com.prosperity.util.FormatUtil;

@Component
public class ContatoBean extends FormatUtil {

	private Integer id;

	@NotEmpty(message = "O campo telefone deve ser prenchido")
	private String telefone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
