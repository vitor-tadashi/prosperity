<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>

<meta charset="UTF-8">
<title>Cadastro de Candidato</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>


</head>
<body>
	<c:import url="/WEB-INF/views/shared/dashboard.jsp"></c:import>

	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href=""> Início</a></li>
				<li><a href=""> Candidato</a></li>
				<li class="active">Cadastrar</li>
				
			</ul>
		</div>
		<!--breadcrumb-->

		<!-- SOMENTE ALTERAR DAQUI PARA BAIXO -->

		<div class="padding-md">
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">Informações do candidato</div>
					<div class="panel-body">
					<div class="alert.alert-success"></div>
						<div id="textDiv">
							<c:forEach var="erro" items="${listaErros}">
								<p>${erro}</p>

							</c:forEach>
						</div>
							<div id="textDiv1"></div>
								<div id="textDiv2"></div>
								<div id="textDiv3"></div>
								
						<form class="form-border" action="salvar" method="post"
							id=formCadastro onsubmit="return Validar()"<%--data-validate="parsley" --%>>
							<div class="panel-tab clearfix">
								<ul class="tab-bar wizard-demo" id="wizardDemo">
									<li class="active tab-verity"><a href="#first"
										data-toggle="tab"><i class="fa fa-user"></i> Inf. pessoais</a></li>
									<li class="tab-verity"><a href="#second" data-toggle="tab"
										class="text-success"><i class="fa fa-pencil"></i> Inf.
											acadêmicas</a></li>
									<li class="tab-verity"><a href="#third" data-toggle="tab"
										class="text-success"><i class="fa fa-briefcase"></i>
											Inf.Vaga</a></li>
								</ul>
							</div>
							<div class="panel-body">
								<div class="tab-content">
									<div class="tab-pane fade in active" id="first">
										<div class="row">
											<div class="form-group col-md-4">
												<label class="control-label" for="nome">Nome</label> <input
													value="${candidato.nome}" type="text" placeholder="Informe seu nome"
													class="form-control parsley-validated" data-minlength="8"
													id="nome" name="nome">
											</div>
											<div class="form-group col-md-3">
												<label for="email" class="control-label">E-mail</label> <input
													type="email" class="form-control parsley-validated"
													id="email" name="email" data-required="true"
													placeholder="email@dominio.com" value="${candidato.email}">
											</div>
											<div class="form-group col-md-3">
												<label for="cpf" class="control-label">CPF</label> <input
													type="text" class="form-control cpf parsley-validated"
													id="cpf" name="cpf" data-required="true"
													placeholder="Informe seu CPF" value="${candidato.cpf}"
													onblur="verificarCPF(this.value)">
											</div>
											<div class="form-group col-md-2">
												<label for="rg" class="control-label">RG</label> <input
													type="text" class="form-control rg parsley-validated"
													id="rg" name="rg" data-required="true" data-required="true" placeholder="Informe seu RG"
													value="${candidato.rg}">
											</div>
											<div class="form-group col-md-2 col-sm-4">
												<label for="dataNascimento" class="control-label">Data
													nascimento</label> <fmt:formatDate value="${candidato.dataNascimento}"
													pattern="dd/MM/yyyy" var="dataNascimento"/>
													<input type="text"
													class="form-control date parsley-validated"
													data-required="true" name="dataNascimento"
													id="dataNascimento" value="${dataNascimento}"
													onblur="validarData(this.value)">
											</div>
											<div class="form-group col-md-2">
												<label for="telefone" class="control-label">Telefone</label>
												<input type="text"
													class="form-control telefone parsley-validated"
													data-required="true" id="contato" name="contato.telefone"
													value="${candidato.contato.telefone}">
											</div>
											<div class="form-group col-md-2">
												<label for="cep" class="control-label">CEP</label> <input
													type="text" class="form-control cep parsley-validated"
													id="cep" name="endereco.cep"
													value="${candidato.endereco.cep}" data-required="true"
													onblur="pesquisacep(this.value);" />
											</div>
											<div class="form-group col-md-6">
												<label for="Endereco" class="control-label">Endereço</label>
												<input type="text" class="form-control parsley-validated"
													id="rua" data-required="true" name="endereco.logradouro"
													value="${candidato.endereco.logradouro}" />
											</div>
											<div class="form-group col-md-2">
												<label for="numero" class="control-label">Número</label> <input
													type="number" class="form-control parsley-validated"
													id="numero" data-required="true" name="endereco.numero"
													value="${candidato.endereco.numero}">
											</div>
											<div class="form-group col-md-3">
												<label for="Endereco.complemento" class="control-label">Complemento</label>
												<input type="text" class="form-control" id="complemento"
													data-required="true" name="endereco.complemento"
													value="${candidato.endereco.complemento}">
											</div>
											<div class="form-group col-md-3">
												<label for="estado" class="control-label">Estado</label> <input
													type="text" class="form-control parsley-validated" id="uf"
													data-required="true" name="endereco.estado"
													value="${candidato.endereco.estado}" />

											</div>
											<div class="form-group col-md-4">
												<label for="cidade" class="control-label">Cidade</label> <input
													type="text" class="form-control parsley-validated"
													id="cidade" data-required="true" name="endereco.cidade"
													value="${candidato.endereco.cidade}" />
											</div>
											<div class="form-group col-xs-12">
												<label class="control-label">Currículo</label>
												<div class="upload-file" style="width: 356px;">
													<input type="file" id="upload-curriculo"
														class="upload-demo"> <label data-title="Selecione"
														for="upload-curriculo"> <span
														data-title="Nenhum arquivo selecionado..."></span>
													</label>
												</div>
											</div>
										</div>
									</div>
									<div class="tab-pane fade" id="second">
										<div class="form-group col-md-4">
											<label for="curso">Curso</label> <input type="text"
												class="form-control" id="curso" name="formacao.curso"
												placeholder="Informe seu curso"
												value="${candidato.formacao.nomeCurso}">
										</div>
										<div class="form-group col-md-5">
											<label for="instituicao">Instituição</label> <input
												type="text" class="form-control" id="instituicao"
												name="formacao.nomeInstituicao" placeholder="Instituição"
												value="${candidato.formacao.nomeInstituicao}">
										</div>
										<div class="form-group col-md-3">
											<label for="tipoDeCurso">Tipo de curso</label> <select
												class="form-control" id="tipoDeCurso"
												name="formacao.tipoCurso.id">
												<option value="0">Selecione</option>
												<c:forEach var="tipoCurso" items="${tiposCurso}">
													<option value="${tipoCurso.id}"
														${tipoCurso.id == candidato.formacao.tipoCurso.id ? 'selected="selected"' : ''}>${tipoCurso.nome}</option>
												</c:forEach>

											</select>
										</div>
										<div class="form-group col-md-2">
											<label for="situacaoAtual">Situação atual</label> <select
												class="form-control" id="situacaoAtual"
												name="formacao.SituacaoAtual.id">
												<option value="0">Selecione</option>
												<c:forEach var="situacaoAtual" items="${listaSituacaoAtual}">
													<option value="${situacaoAtual.id}"
														${situacaoAtual.id == candidato.formacao.situacaoAtual.id ? 'selected="selected"' : ''}>${situacaoAtual.descricao}</option>
												</c:forEach>
											</select>
										</div>
										<div class="form-group col-md-2">
											<label for="mesAnoConclusao">Data de conclusão</label> 
											<fmt:formatDate value="${candidato.formacao.dataConclusao}"
													pattern="dd/MM/yyyy" var="dataConclusao"/>
											<input
												type="text" class="form-control date" id="mesAnoConclusao"
												data-required="false" name="formacao.dataConclusao"
												onblur="validarData(this.value)"
												value="${dataConclusao}">
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
													<input type="number" class="form-control dinheiro"
														id="pretensaoSalarial" placeholder="R$" name="valorMin"
														value="${candidato.valorMin}" />
												</div>
												<div class="col-sm-1">
													<p class="text-center">até</p>
												</div>
												<div class="col-md-2">
													<input type="number" class="form-control dinheiro"
														placeholder="R$" name="valorMax"
														value="${candidato.valorMax}" />
												</div>
											</div>
										</div>
										<div class="form-group col-md-4">
											<label for="vagaASerAplicado">Vaga a ser aplicado</label> <select
												class="form-control" id="vaga" name="vagaCandidato.vaga.id">
												<option value="0">Selecione</option>
												<c:forEach var="vaga" items="${listaVaga}">
													<option value="${vaga.id}"
														${vaga.id == candidato.vagaCandidato.vaga.id ? 'selected="selected"' : ''}>${vaga.nomeVaga}</option>
												</c:forEach>
											</select>
										</div>
										<div class="form-group col-md-3">
											<label for="exampleInputEmail1">Como ficou sabendo
												desta vaga?</label> <select class="form-control"
												name="vagaCandidato.canalInformacao.id">
												<option value="0">Selecione</option>
												<c:forEach var="canalInformacao" items="${listaCanal}">
													<option value="${canalInformacao.id}"
													${canalInformacao.id == candidato.vagaCandidato.canalInformacao.id ? 'selected="selected"' : ''}>${canalInformacao.nome}</option>
												</c:forEach>
											</select>
										</div>
										<div>
											<div class="form-group col-md-2 col-sm-2">
												<label for="dataUltimoContato" class="control-label">Data
													de ultimo contato</label> <fmt:formatDate value="${candidato.dataUltimoContato}"
													pattern="dd/MM/yyyy" var="dataUltimoContato"/>
													<input type="text"
													class="form-control date" name="dataConclusao"
													onblur="validarData(this.value)" data-required="false"
													id="dataUltimoContato"
													value="${dataUltimoContato}">
											</div>
											<div class="form-group col-md-2 col-sm-4">
												<label for="entrevista" class="control-label">Data
													de Entrevista</label> <fmt:formatDate value="${candidato.entrevista}"
													pattern="dd/MM/yyyy" var="entrevista"/>
													<input type="text" class="form-control date"
													data-required="false" name="entrevista" id="entrevista"
													onblur="validarData(this.value)"
													value="${entrevista}">
											</div>
										</div>


									</div>
								</div>
								<div></div>

							</div>
							<div>
							<input type="hidden" value="${candidato.id}" name="id">
								<button class="btn btn-success btnAjuste">Salvar</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- SOMENTE ALTERAR DAQUI PARA CIMA -->
	<input value="${erro}" id="contErro">
	<c:import url="/WEB-INF/views/shared/footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/shared/js.jsp"></c:import>
	<script src='/resources/js/parsley.min.js'></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('.cpf').mask('999.999.999-99', {
				reverse : true
			});
			$('.telefone').mask('(99) 99999-9999');
			$('#rg').mask('99.999.999-9');
			$("#cep").mask("99999-999");
			$('.date').mask('99/99/9999');

		})

		function limpa_formulário_cep() {
			//Limpa valores do formulário de cep.
			document.getElementById('rua').value = ("");
			document.getElementById('cidade').value = ("");
			document.getElementById('uf').value = ("");
		}

		function meu_callback(conteudo) {
			if (!("erro" in conteudo)) {
				//Atualiza os campos com os valores.
				document.getElementById('rua').value = (conteudo.logradouro);
				document.getElementById('cidade').value = (conteudo.localidade);
				document.getElementById('uf').value = (conteudo.uf);
			} //end if.
			else {
				//CEP não Encontrado.
				limpa_formulário_cep();
				var div = document.getElementById("textDiv").className = "alert alert-danger";

				textDiv.textContent = "CEP inválido";

				var text = "[" + div.textContent + "]";
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
					var div = document.getElementById("textDiv").className = "alert alert-danger";

    				textDiv.textContent = "CEP inválido";

    				var text = "[" + div.textContent + "]";
				}


				textDiv.textContent = "";

				var text = "[" + div.textContent + "]";
			} //end if.
			else {
				//cep sem valor, limpa formulário.
				limpa_formulário_cep();
				
			}
		};
	</script>

	<script>
		$(document).ready(function() {
			if ($("input#contErro").val() > 0) {
				$('#textDiv').addClass("alert alert-danger");
			}
		})
	</script>
	<script>
		function verificarCPF(strCPF) {
			var Soma;
			var Resto;
			strCPF = strCPF.substring(0, 3) + strCPF.substring(4, 7)
					+ strCPF.substring(8, 11) + strCPF.substring(12, 14);
			Soma = 0;
			if (strCPF == "00000000000") {
				var div = document.getElementById("textDiv1").className = "alert alert-danger";

				textDiv1.textContent = "CPF inválido.";

				var text = "[" + div.textContent + "]";
				return false;
			}

			for (i = 1; i <= 9; i++)
				Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
			Resto = Soma % 11;

			if ((Resto == 0) || (Resto == 1)) {
				Resto = 0;
			} else {
				Resto = 11 - Resto;
			}

			if (Resto != parseInt(strCPF.substring(9, 10))) {
				var div = document.getElementById("textDiv1").className = "alert alert-danger";

				textDiv1.textContent = "CPF inválido.";

				var text = "[" + div.textContent + "]";
				return false
			}

			Soma = 0;
			for (i = 1; i <= 10; i++)
				Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
			Resto = Soma % 11;

			if ((Resto == 0) || (Resto == 1)) {
				Resto = 0;
			} else {
				Resto = 11 - Resto;
			}

			if (Resto != parseInt(strCPF.substring(10, 11))) {
				var div = document.getElementById("textDiv1").className = "alert alert-danger ";

				textDiv1.textContent = "CPF inválido.";

				var text = "[" + div.textContent + "]";
				return false;
			}
			var div = document.getElementById("textDiv1").className = "";

			textDiv1.textContent = "";

			var text = "[" + div.textContent + "]";
			return true;
		}
	</script>
	<script type="text/javascript">
		function validarData(id) {
			
			var campo = $('#dataNascimento').val();
			   if (campo!="")
			{
			        erro=0;
			        hoje = new Date();
			        anoAtual = hoje.getFullYear();
			        barras = campo.split("/");
			        if (barras.length == 3)
			        {
			                dia = barras[0];
			                mes = barras[1];
			                ano = barras[2];
			                resultado = (!isNaN(dia) && (dia > 0) && (dia < 32)) && (!isNaN(mes) && (mes > 0) && (mes < 13)) && (!isNaN(ano) && (ano.length == 4) && (ano <= anoAtual && ano >= 1900));
			                if (!resultado)
			                {
			                	var div = document.getElementById("textDiv2").className = "alert alert-danger";

			    				textDiv2.textContent = "Data inválida";

			    				var text = "[" + div.textContent + "]";
			                        campo.focus();
			                        return false;
			                }
			         }
			         else
			         {
			        		var div = document.getElementById("textDiv").className = "";

			    			textDiv2.textContent = "Data inválida";

			    			var text = "[" + div.textContent + "]";
			                campo.focus();
			                return false;
			         }
			        var div = document.getElementById("textDiv2").className = "";

	    			textDiv2.textContent = "";

	    			var text = "[" + div.textContent + "]";
	                campo.focus();
			return true;
			
			}
		}
			

	</script>
</body>
</html>