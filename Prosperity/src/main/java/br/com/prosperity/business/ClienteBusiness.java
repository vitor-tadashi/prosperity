package br.com.prosperity.business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.dao.ClienteDAO;
import br.com.prosperity.entity.ClienteEntity;

@Component
public class ClienteBusiness {
	@Autowired
	private ClienteDAO clienteDao;
	
	@Transactional
	public List<ClienteEntity> listar(){
		try {
			List<ClienteEntity> listaCliente = clienteDao.listar();
			if (listaCliente.isEmpty()) {
				System.out.println("Não há clientes cadastrados");
			} else {
				return listaCliente;
			}
		} catch (Exception e) {
			throw (e);
		}
		return null;
	}

	/**
	 * -JPQL- Retorna um objeto Cliente ATIVO (buscado através do ID passado
	 * como parâmetro)
	 * 
	 * @param idCliente
	 * @return ClienteBean
	 * @throws BusinessException
	 */
	@Transactional
	public ClienteEntity obterPorId(int idCliente){
		try {
			return clienteDao.obterPorId(idCliente);
		} catch (Exception e) {
			throw (e);
		}
	}
}
