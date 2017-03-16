<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>

<meta charset="UTF-8">
<title>Cadastro de Candidato</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>

<script type="text/javascript">
	function limpa_formulário_cep() {
		//Limpa valores do formulário de cep.
		document.getElementById('rua').value = ("");
		document.getElementById('cidade').value = ("");
		document.getElementById('uf').value = ("");
	}

	function meu_callback(conteudo) {
		if (!("erro" in conteudo)) {
			//Atualiza os campos com os valores.
			document.getElementById('rua').value = (conteudo.rua);
			document.getElementById('cidade').value = (conteudo.localidade);
			document.getElementById('uf').value = (conteudo.uf);
		} //end if.
		else {
			//CEP não Encontrado.
			limpa_formulário_cep();
			alert("CEP não encontrado.");
		}
	}

	function pesquisacep(valor) {

		//Nova variável "cep" somente com dígitos.
		var cep = valor.replace(/\D/g, '');

		//Verifica se campo cep possui valor informado.
		if (cep != "") {

			//Expressão regular para validar o CEP.
			var validacep = /^[0-9]{8}$/;

			//Valida o formato do CEP.
			if (validacep.test(cep)) {
				var script = document.createElement('script');

				//Sincroniza com o callback.
				script.src = '//viacep.com.br/ws/' + cep
						+ '/json/?callback=meu_callback';

				//Insere script no documento e carrega o conteúdo.
				document.body.appendChild(script);

			} //end if.
			else {
				//cep é inválido.
				limpa_formulário_cep();
				alert("Formato de CEP inválido.");
			}
		} //end if.
		else {
			//cep sem valor, limpa formulário.
			limpa_formulário_cep();
		}
	};
</script>
</head>
<body>
	<c:import url="/WEB-INF/views/shared/dashboard.jsp"></c:import>

	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href=""> Início</a></li>
				<li class="active">Cadastrar candidato</li>
			</ul>
		</div>
		<!--breadcrumb-->

		<!-- SOMENTE ALTERAR DAQUI PARA BAIXO -->

		<div class="padding-md">
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">Informações do candidato</div>
					<div class="panel-body">
						<form class="form-border" action="salvar" method="post">
							<div class="panel-tab clearfix">
								<ul class="tab-bar wizard-demo" id="wizardDemo">
									<li class="active tab-verity"><a href="#first"
										data-toggle="tab"><i class="fa fa-user"></i> Inf. pessoais</a></li>
									<li class="tab-verity"><a href="#second" data-toggle="tab"
										class="text-success"><i class="fa fa-pencil"></i> Inf.
											acadêmicas</a></li>
									<li class="tab-verity"><a href="#third" data-toggle="tab"
										class="text-success"><i class="fa fa-briefcase"></i>
											Currículo</a></li>
								</ul>
							</div>
							<div class="panel-body">
								<div class="tab-content">
									<div class="tab-pane fade in active" id="first">
										<div class="row">
											<div class="form-group col-md-4">
												<label class="control-label" for="nome">Nome</label> <input
													type="text" class="form-control" id="nome" name="nome"
													data-required="true" placeholder="Informe seu nome"
													value="">
											</div>
											<div class="form-group col-md-3">
												<label for="email" class="control-label">E-mail</label> <input
													type="text" class="form-control" id="email" name="email"
													data-required="true" placeholder="email@dominio.com"
													value="">
											</div>
											<div class="form-group col-md-3">
												<label for="cpf" class="control-label">CPF</label> <input
													type="text" class="form-control" id="cpf" name="cpf"
													data-required="true" placeholder="Informe seu CPF" value="">
											</div>
											<div class="form-group col-md-2">
												<label for="rg" class="control-label">RG</label> <input
													type="text" class="form-control" id="rg" name="rg"
													data-required="true" value="">
											</div>
											<div class="form-group col-md-2 col-sm-4">
												<label for="dataNascimento" class="control-label">Data
													nascimento</label> <input type="text" class="form-control" name="dataNascimento"
													id="dataNascimento" value="">
											</div>
											<div class="form-group col-md-2">
												<label for="telefone" class="control-label">Telefone</label>
												<input type="text" class="form-control" id="contato" name="contato.telefone"
													 value="">
											</div>
											<div class="form-group col-md-2">
												<label for="cep" class="control-label">CEP</label> <input
													 type="text" class="form-control" id="cep" name="endereco.cep"
													value="" onblur="pesquisacep(this.value);" />
											</div>
											<div class="form-group col-md-6">
												<label for="Endereco" class="control-label">Endereço</label>

												<input  type="text" class="form-control" id="rua" name="endereco.logradouro"
													value="" />

											</div>
											<div class="form-group col-md-2">
												<label for="numero" class="control-label">Número</label> <input
													type="text" class="form-control" id="numero" name="endereco.numero"
													 value="">
											</div>
											<div class="form-group col-md-3">
												<label for="Endereco.complemento" class="control-label">Complemento</label>
												<input type="text" class="form-control" id="complemento" name="endereco.complemento" >
											</div>
											<div class="form-group col-md-3">
												<label for="estado" class="control-label">Estado</label> <input
													 type="text" class="form-control" id="uf" name="endereco.estado"
													value="" />

											</div>
											<div class="form-group col-md-4">
												<label for="cidade" class="control-label">Cidade</label> <input
													 type="text" class="form-control" id="cidade" name="endereco.cidade"
													value="" />
											</div>
										</div>
									</div>
									<div class="tab-pane fade" id="second">
										<div class="form-group col-md-4">
											<label for="curso">Curso</label> <input type="text"
												class="form-control" id="curso" name="formacao.nomeCurso"
												placeholder="Informe seu curso">
										</div>
										<div class="form-group col-md-5">
											<label for="instituicao">Instituição</label> <input
												type="text" class="form-control" id="instituicao" name="formacao.nomeInstituicao" 
												placeholder="Instituição">
										</div>

										<div class="form-group col-md-3">
											<label for="tipoDeCurso">Tipo de curso</label> <select
												class="form-control" id="tipoDeCurso" name="formacao.tipoCurso.id" >
												<!-- FAZER FOREACH  -->
												<c:forEach var="tipoCurso" items="${tiposCurso}">
													<option value="${tipoCurso.id}">${tipoCurso.nome}</option>
												</c:forEach>

											</select>
										</div>
										<div class="form-group col-md-2">
											<label for="situacaoAtual">Situação atual</label> <select
												class="form-control" id="situacaoAtual" name="formacao.situacaoAtual.id" >
												<c:forEach var="situacaoAtual" items="${listaSituacaoAtual}">
													<option value="${situacaoAtual.id}">${situacaoAtual.descricao}</option>
												</c:forEach>
											</select>
										</div>
										<div class="form-group col-md-2">
											<label for="mesAnoConclusao">Mês/Ano de conclusão</label> <input
												type="text" class="form-control" id="mesAnoConclusao"  name="formacao.dataConclusao"
												>
										</div>
									</div>
									<div class="tab-pane fade" id="third">
										<div class="form-group col-xs-12">
											<div class="row">
												<div class="col-xs-12">
													<label class="control-label" for="pretensaoSalarial">Pretensão
														salarial</label>
												</div>
												<div class="col-md-2">
													<input type="text" class="form-control"
														id="pretensaoSalarial" placeholder="R$"  name="valorMin"/>
												</div>
												<div class="col-sm-1">
													<p class="text-center">até</p>
												</div>
												<div class="col-md-2">
													<input  type="text" class="form-control" placeholder="R$" name="valorMax" />
												</div>
											</div>
										</div>
										<div class="form-group col-md-4">
											<label for="vagaASerAplicado">Vaga a ser aplicado</label> <select
												class="form-control" id="vaga" name="vaga.nomeVaga.id"	>
												<c:forEach var="vaga" items="${listaVaga}">
													<option value="${vaga.id}">${vaga.nomeVaga}</option>
												</c:forEach>
											</select> 
										</div>
										<div class="form-group col-md-4">
											<label for="exampleInputEmail1">Como ficou sabendo
												desta vaga?</label> <select class="form-control" name="vaga.vagaCandidato.canalInformacao.id"
												>
												<c:forEach var="canalInformacao" items="${listaCanal}">
													<option value="${canalInformacao.id}">${canalInformacao.nome}</option>
													</c:forEach>
													
											</select>
										</div>
										<div class="form-group col-xs-12">
											<label class="control-label">Currículo</label>
											<div class="upload-file" style="width: 356px;">
												<input type="file" id="upload-curriculo"  class="upload-demo">
												<label data-title="Selecione" for="upload-curriculo">
													<span data-title="Nenhum arquivo selecionado..."></span>
												</label>
											</div>
										</div>
									</div>
								</div>
							</div>
							<button class="btn btn-success btn-sm">Salvar</button>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- SOMENTE ALTERAR DAQUI PARA CIMA -->

	<c:import url="/WEB-INF/views/shared/footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/shared/js.jsp"></c:import>
</body>
</html>