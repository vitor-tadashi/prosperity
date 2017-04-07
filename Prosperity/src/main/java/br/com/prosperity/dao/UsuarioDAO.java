package br.com.prosperity.dao;

import org.springframework.stereotype.Repository;

import br.com.prosperity.entity.UsuarioEntity;

@Repository
public class UsuarioDAO extends GenericDAOImpl<UsuarioEntity, Integer> {

	public Boolean existeUsuario(String nome) {
		return !this.findByNamedQuery("existeUsuario", nome).isEmpty();
	}

	public boolean existeUsuario(Integer id, String nome) {
		return !this.findByNamedQuery("existeUsuarioAlterar", id, nome).isEmpty();
	}
	
}
