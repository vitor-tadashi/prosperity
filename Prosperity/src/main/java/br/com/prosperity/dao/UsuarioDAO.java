package br.com.prosperity.dao;

import org.springframework.stereotype.Repository;

import br.com.prosperity.entity.UsuarioEntity;

@Repository
public class UsuarioDAO extends GenericDAOImpl<UsuarioEntity, Integer> {

	public Boolean existeUsuario(String usuario) {
		return !this.findByNamedQuery("existeUsuario", usuario).isEmpty();
	}
	
}
