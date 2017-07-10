package br.com.prosperity.integration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.util.FileCopyUtils;

import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.bean.ClienteBean;
import br.com.prosperity.bean.FuncionarioBean;
import br.com.prosperity.bean.ProjetoBean;

public class veritySysIntegration {
	
	public Properties getProp(){
		try {
			Properties props = new Properties();
			FileInputStream file = new FileInputStream("./properties/dados.properties");
			props.load(file);
			return props;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public List<CargoBean> getListCargos() {
		List<CargoBean> cargos = new ArrayList<CargoBean>();
		
		Properties props = getProp();
		String endereco = props.getProperty("prop.integration.listcargo");
		try {
			URL url = new URL(endereco);
			String response = genericGet(url);
			
			JSONObject json = new JSONObject(response);
			JSONArray objetos = json.getJSONArray("ListCargosResult");
			
			for (int i = 0; i < objetos.length(); i++) {
				CargoBean cargo = new CargoBean();
				JSONObject objeto = objetos.getJSONObject(i);
				cargo.setId(objeto.getInt("Id"));
				cargo.setNome(objeto.getString("Nome"));
				cargos.add(cargo);
			}
		} catch (MalformedURLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cargos;
	}

	public CargoBean getCargo(Integer id) {
		CargoBean cargo = new CargoBean();

		Properties props = getProp();
		String endereco = props.getProperty("prop.integration.cargo");
		try {
			URL url = new URL(endereco + id);
			String response = genericGet(url);

			JSONObject json = new JSONObject(response);
			JSONObject objeto = json.getJSONObject("GetCargoResult");
			cargo.setId(objeto.getInt("Id"));
			cargo.setNome(objeto.getString("Nome"));
		} catch (MalformedURLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cargo;
	}

	public List<ClienteBean> getListClientes() {
		List<ClienteBean> clientes = new ArrayList<ClienteBean>();
		
		Properties props = getProp();
		String endereco = props.getProperty("prop.integration.listcliente");
		try {
			URL url = new URL(endereco);
			String response = genericGet(url);
			
			JSONObject json = new JSONObject(response);
			JSONArray objetos = json.getJSONArray("ListClientesResult");
			
			for (int i = 0; i < objetos.length(); i++) {
				ClienteBean cliente = new ClienteBean();
				JSONObject objeto = objetos.getJSONObject(i);
				cliente.setId(objeto.getInt("Id"));
				cliente.setNome(objeto.getString("Nome"));
				clientes.add(cliente);
			}
		} catch (MalformedURLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clientes;
	}

	public ClienteBean getCliente(Integer id) {
		ClienteBean cliente = new ClienteBean();
		
		Properties props = getProp();
		String endereco = props.getProperty("prop.integration.cliente");
		try {
			URL url = new URL(endereco + id);
			String response = genericGet(url);

			JSONObject json = new JSONObject(response);
			JSONObject objeto = json.getJSONObject("GetClienteResult");
			cliente.setId(objeto.getInt("Id"));
			cliente.setNome(objeto.getString("Nome"));
		} catch (MalformedURLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cliente;
	}

	public List<FuncionarioBean> getListFuncionarios() {
		List<FuncionarioBean> funcionarios = new ArrayList<FuncionarioBean>();
		
		Properties props = getProp();
		String endereco = props.getProperty("prop.integration.listfuncionario");
		try {
			URL url = new URL(endereco);
			String response = genericGet(url);
			
			JSONObject json = new JSONObject(response);
			JSONArray objetos = json.getJSONArray("ListFuncionariosResult");
			
			for (int i = 0; i < objetos.length(); i++) {
				FuncionarioBean funcionario = new FuncionarioBean();
				JSONObject objeto = objetos.getJSONObject(i);
				funcionario.setId(objeto.getInt("Id"));
				funcionario.setNome(objeto.getString("Nome"));
				funcionarios.add(funcionario);
			}
		} catch (MalformedURLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return funcionarios;
	}

	public FuncionarioBean getFuncionario(Integer id) {
		FuncionarioBean funcionario = new FuncionarioBean();
		
		Properties props = getProp();
		String endereco = props.getProperty("prop.integration.funcionario");
		try {
			URL url = new URL(endereco + id);
			String response = genericGet(url);

			JSONObject json = new JSONObject(response);
			JSONObject objeto = json.getJSONObject("GetFuncionarioResult");
			funcionario.setId(objeto.getInt("Id"));
			funcionario.setNome(objeto.getString("Nome"));
		} catch (MalformedURLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return funcionario;
	}

	public List<ProjetoBean> getListProjetos() {
		List<ProjetoBean> projetos = new ArrayList<ProjetoBean>();
		
		Properties props = getProp();
		String endereco = props.getProperty("prop.integration.listprojeto");
		try {
			URL url = new URL(endereco);
			String response = genericGet(url);
			
			JSONObject json = new JSONObject(response);
			JSONArray objetos = json.getJSONArray("ListProjetosResult");
			
			for (int i = 0; i < objetos.length(); i++) {
				ProjetoBean projeto = new ProjetoBean();
				JSONObject objeto = objetos.getJSONObject(i);
				projeto.setId(objeto.getInt("Id"));
				projeto.setNome(objeto.getString("Nome"));
				projetos.add(projeto);
			}
		} catch (MalformedURLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return projetos;
	}

	public ProjetoBean getProjeto(Integer id) {
		ProjetoBean projeto = new ProjetoBean();
		
		Properties props = getProp();
		String endereco = props.getProperty("prop.integration.projeto");
		try {
			URL url = new URL(endereco + id);
			String response = genericGet(url);

			JSONObject json = new JSONObject(response);
			JSONObject objeto = json.getJSONObject("GetProjetoResult");
			projeto.setId(objeto.getInt("Id"));
			projeto.setNome(objeto.getString("Nome"));
		} catch (MalformedURLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return projeto;
	}

	public static String genericGet(URL url) {
		InputStream inputstream = null;
		String response = null;
		try {
			// Criando objeto para efetuar conexão com o serviço
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// Atribuindo método GET para conexão
			conn.setRequestMethod("GET");

			// Atribuindo JSON como parâmetro de retorno
			conn.setRequestProperty("Accept", "application/json");

			// Verificando se a conexão com o serviço foi bem sucedida
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			// pegando resultado do serviço
			inputstream = conn.getInputStream();

			// Transformando em Stting
			response = new String(FileCopyUtils.copyToByteArray(inputstream), StandardCharsets.UTF_8);

			conn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}