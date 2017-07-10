package br.com.prosperity.integration;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.springframework.util.FileCopyUtils;


public class veritySisIntegration {

//		getInfos("http://localhost:1276/ServiceCargo.svc/ListCargos");
//		getInfos("http://localhost:1276/ServiceCargo.svc/GetCargo/30");
//		getInfos("http://localhost:1276/ServiceCliente.svc/ListClientes");
//		getInfos("http://localhost:1276/ServiceCliente.svc/GetCliente/8");
//		getInfos("http://localhost:1276/ServiceFuncionario.svc/GetFuncionario/347");
//		getInfos("http://localhost:1276/ServiceFuncionario.svc/ListFuncionarios");
//		getInfos("http://localhost:1276/ServiceProjeto.svc/ListProjetos");
//		getInfos("http://localhost:1276/ServiceProjeto.svc/GetProjeto/96");
		
	
	public String getInfos(String str){
		InputStream inputstream = null;
		String response = null;
		
		try {
			//Criando objeto URL 
			URL url = new URL(str);
			
			//Criando objeto para efetuar conexão com o serviço
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			//Atribuindo método GET para conexão
			conn.setRequestMethod("GET");
			
			//Atribuindo JSON como parâmetro de retorno
			conn.setRequestProperty("Accept", "application/json");

			//Verificando se a conexão com o serviço foi bem sucedida
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			
			//pegando resultado do serviço
			inputstream = conn.getInputStream();
			
			//Transformando em Stting
			response = new String(FileCopyUtils.copyToByteArray(inputstream), StandardCharsets.UTF_8);

			conn.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
