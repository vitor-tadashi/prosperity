<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>

<layout:extends name="base">
	<layout:put block="title" type="REPLACE">
		<title>Cadastro de Candidato</title>
	</layout:put>
	
	<layout:put block="contents">O
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="/pagina-inicial"> Página inicial</a></li>
				<li>Candidato</li>
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
						<div id="textDiv">
								<c:forEach var="erro" items="${listaErros}">
									<p>${erro}</p>
								</c:forEach>
								</div>
							<c:if test="${not empty sucesso}">
								<div id="msg-sucesso" class="alert alert-success msg-margin">
									<ul style="list-style: none;">
										<li class="li-msg"> ${sucesso}</li>
									</ul>
								</div>
							</c:if>
						
						<div id="textDiv1"></div>
						<div id="textDiv2"></div>
						<div id="textDiv3"></div>

						<form class="form-border" action="salvar" method="post"
							enctype="multipart/form-data" id=formCadastro onblur="validar()">
						
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
											<input type="hidden" value="${candidato.id}" id="id" name="id">
											<div class="form-group col-md-3">
												<label for="cpf" class="control-label">CPF</label> <input
													type="text" class="form-control cpf parsley-validated"
													id="cpf" name="cpf" data-required="true"
													placeholder="Informe seu CPF" value="${candidato.cpf}"
													onblur="pesquisacpf()">
											</div>
											<div class="form-group col-md-4">
												<label class="control-label" for="nome">Nome</label> <input
													value="${candidato.nome}" type="text"
													placeholder="Informe seu nome" maxlength="100"
													class="form-control parsley-validated" data-minlength="8"
													id="nome" name="nome">
											</div>
											<div class="form-group col-md-3">
												<label for="email" class="control-label">E-mail</label> <input
													type="email" class="form-control parsley-validated"
													id="email" name="email" data-required="true" maxlength="100"
													placeholder="Informe seu email" value="${candidato.email}">
											</div>

											<div class="form-group col-md-2">
												<label for="rg" class="control-label">RG</label> <input
													type="text" class="form-control rg parsley-validated" maxlength="50"
													id="rg" name="rg" data-required="true" data-required="true"
													placeholder="Informe seu RG" value="${candidato.rg}">
											</div>
											<div class="form-group col-md-2 col-sm-4">
												<label for="dataNascimento" class="control-label">Data
													nascimento</label>
												<fmt:formatDate value="${candidato.dataNascimento}"
													pattern="dd/MM/yyyy" var="dataNascimento" />
												<input type="text" class="form-control date"
													name="dataNascimento" data-required="false" id="dataNascimento"
													onblur="validarData('dataNascimento')"
													value="${dataNascimento}">

											</div>
											<div class="form-group col-md-2">
												<label for="contato" class="control-label">Telefone</label>
												<input type="text"
													class="form-control telefone parsley-validated" maxlength="30"
													placeholder="Informe seu telefone" data-required="true"
													id="contato" name="contato.telefone" onblur="validarTel()"
													value="${candidato.contato.telefone}">
											</div>
											<div class="form-group col-md-2">
												<label for="cep" class="control-label">CEP</label> <input
													type="text" class="form-control cep parsley-validated"
													id="cep" name="endereco.cep" placeholder="Informe seu CEP"
													value="${candidato.endereco.cep}" data-required="true"
													onblur="pesquisacep(this.value)" />
											</div>
											<div class="form-group col-md-6">
												<label for="rua" class="control-label">Endereço</label> <input
													type="text" class="form-control parsley-validated" id="rua"
													data-required="true" name="endereco.logradouro"
													value="${candidato.endereco.logradouro}" />
											</div>
											<div class="form-group col-md-2">
												<label for="numero" class="control-label">Número</label> <input
													type="number" class="form-control parsley-validated"
													id="numero" data-required="true" name="endereco.numero"
													value="${candidato.endereco.numero}">
											</div>
											<div class="form-group col-md-3">
												<label for="complemento" class="control-label">Complemento</label>
												<input type="text" class="form-control" id="complemento"
													data-required="true" name="endereco.complemento"
													value="${candidato.endereco.complemento}">
											</div>
											<div class="form-group col-md-3">
												<label for="uf" class="control-label">Estado</label> <input
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
													<input type="file" id="upload-curriculo" name="file"
														class="upload-demo" value="${candidato.curriculo}"> <label data-title="Selecione"
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
												class="form-control" id="curso" name="formacao.nomeCurso"
												placeholder="Informe seu curso" maxlength="50"
												value="${candidato.formacao.nomeCurso}">
										</div>
										<div class="form-group col-md-5">
											<label for="instituicao">Instituição</label> <input
												type="text" class="form-control" id="instituicao"
												name="formacao.nomeInstituicao" maxlength="50"
												placeholder=" Informe a instituição"
												value="${candidato.formacao.nomeInstituicao}">
										</div>
										<div class="form-group col-md-3">
											<label for="tipoDeCurso">Grau de instrução</label> <select
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
												name="formacao.situacaoAtual.id">
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
												pattern="dd/MM/yyyy" var="dataConclusao" />
											<input type="text" class="form-control date"
												id="mesAnoConclusao" data-required="false"
												name="formacao.dataConclusao" onblur="validarData('mesAnoConclusao')"
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
													<input type="text" class="form-control dinheiro pretensao"
														id="valorPretensao" placeholder="R$" name="valorPretensao"
														value="${candidato.valorPretensao}" />
												</div>

											</div>
										</div>
										<div class="form-group col-md-3">
											<label for="vaga">Vaga a ser aplicado</label> <select
												class="form-control" id="vaga" name="vagaCandidato.vaga.id">
												<option value="0">Selecione</option>
												<c:forEach var="vaga" items="${listaVaga}">
													<option value="${vaga.id}"
														${vaga.id == candidato.vagaCandidato.vaga.id ? 'selected="selected"' : ''}>${vaga.nomeVaga}</option>
												</c:forEach>
											</select>
										</div>
										<div class="form-group col-md-3">
											<label for="canalInformacao">Como ficou sabendo
												desta vaga?</label> <select class="form-control"
												name="vagaCandidato.CanalInformacao.id"
												id="canalInformacao">
												<option value="0">Selecione</option>
												<c:forEach var="canalInformacao" items="${listaCanal}">
													<option value="${canalInformacao.id}"
														${canalInformacao.id == candidato.vagaCandidato.canalInformacao.id ? 'selected="selected"' : ''}>${canalInformacao.nome}</option>
												</c:forEach>
											</select>
										</div>
										<div class="form-group col-md-2 col-sm-2">
											<label for="dataUltimoContato" class="control-label">Data
												de ultimo contato</label>
											<fmt:formatDate value="${candidato.dataUltimoContato}"
												pattern="dd/MM/yyyy" var="dataUltimoContato" />
											<input type="text" class="form-control date"
												name="dataUltimoContato" onblur="validarData(this.value)"
												data-required="false" id="dataUltimoContato"
												value="${dataUltimoContato}">
										</div>
										<div class="form-group col-md-2 col-sm-4">
											<label for="entrevista" class="control-label">Data
												de Entrevista</label>
											<fmt:formatDate value="${candidato.entrevista}"
												pattern="dd/MM/yyyy" var="entrevista" />
											<input type="text" class="form-control date"
												data-required="false" name="entrevista" id="entrevista"
												onblur="validarData('entrevista')" value="${entrevista}">
										</div>
									</div>
								</div>
							</div>
							<div class="form-group col-sm-4">
								<input type="hidden" value="${candidato.id}" name="id">
								<input type="hidden" value="${erro}" id="contErro">
								<button class="btn btn-success btnAjuste"><i class="fa fa-check"></i> Salvar</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
</div>
		
	</layout:put>
	
	<layout:put block="scripts" type="REPLACE">
	
	<script src="/resources/js/parsley.min.js"></script>
	<script src="/resources/js/app/app.js"></script>
	<script>
	  $(document).ready(function () {
	        setTimeout(function () {
	            $('#msg-sucesso').fadeOut(1500);
	        }, 5000);
	    });
	  
		$(document).ready(function() {
		 	 $('.cpf').mask('000.000.000-00', {
				reverse : true 
			}) ; 
			$('.telefone').mask('(00)00000-0000');
			$('#rg').mask('00.000.000-0');
			$("#cep").mask("99999-999");
			$('.date').mask('00/00/0000');
			$('.dinheiro').mask('000.000.000.000.000,00', {reverse: true});

		}) 
		
		
		function validarTel(){
		var tel = $("#contato").val().replace(/[^\d]+/g,'');
		if (tel.length == 10){
			$("#contato").val(tel).mask('(99)9999-9999');
		}else{
			$("#contato").val(tel).mask('(99)99999-9999');
		}
	}

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

				textDiv.textContent = "";

				var textDiv = "[" + div.textContent + "]";
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
				var div = document.getElementById("textDiv1").className = "alert alert-danger x";

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
				var div = document.getElementById("textDiv1").className = "alert alert-danger";

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
		function validarData(idCampo) {

			var campo = $("#"+idCampo).val();
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
			                resultado = (!isNaN(dia) && (dia > 0) && (dia < 32)) && (!isNaN(mes) && (mes > 0) && (mes < 13)) && (!isNaN(ano) && (ano.length == 4) && (ano >= 1900));
			                if (!resultado)
			                {
			                	var div = document.getElementById("textDiv2").className = "alert alert-danger";

			    				textDiv2.textContent = "Data inválida";

			    				var text = "[" + div.textContent + "]";
			                        
			                        return false;
			                }
			         }
			         else
			         {
			        		var div = document.getElementById("textDiv2").className = "";

			    			textDiv2.textContent = "Data inválida";

			    			var text = "[" + div.textContent + "]";
			              
			                return false;
			         }
			        var div = document.getElementById("textDiv2").className = "";

	    			textDiv2.textContent = "";

	    			var text = "[" + div.textContent + "]";
	                
			return true;
			
			}
		}
			

	</script>
	<script type="text/javascript">
	function dataFormatada(dt){
		var data = new Date(dt);
	    var dia = data.getDate();
	    if (dia.toString().length == 1)
	      dia = "0"+dia;
	    var mes = data.getMonth()+1;
	    if (mes.toString().length == 1)
	      mes = "0"+mes;
	    var ano = data.getFullYear();  
	    return dia+"/"+mes+"/"+ano;
	}
	function pesquisacpf(){
		var cpf = $('#cpf').val();
		
		if (verificarCPF(cpf)) {
			obterCandidato(cpf);
		}	
	}
	
	function obterCandidato(cpf) {
		$.ajax({
			url : "http://localhost:8080/candidato/obter",
			dataType : "JSON",
			data : {
				"cpf" : cpf
			},
			type : "GET",
			success: function (data){
				if(data != null){
					$("#id").val(data.id);
					$("#nome").val(data.nome);
					$("#rg").val(data.rg);
					$("#email").val(data.email);
					$("#dataNascimento").val(dataFormatada(data.dataNascimento));
					$("#contato").val(data.contato.telefone);
					$("#cep").val(data.endereco.cep);
					$("#rua").val(data.endereco.logradouro);
					$("#numero").val(data.endereco.numero);
					$("#complemento").val(data.endereco.complemento);
					$("#uf").val(data.endereco.estado);
					$("#cidade").val(data.endereco.cidade);
					$("#curso").val(data.formacao.nomeCurso);
					$("#instituicao").val(data.formacao.nomeInstituicao);
					$("#tipoDeCurso").val(data.formacao.tipoCurso.id);
					$("#mesAnoConclusao").val(dataFormatada(data.formacao.dataConclusao));
					$("#valorPretensao").val(data.valorPretensao);
					$("#valorPretensao").val(data.valorPretensao);
					$("#vaga").val(data.vagaCandidato.vaga.id);
					$("#canalInformacao").val(data.vagaCandidato.canalInformacao.id);
					$("#dataUltimoContato").val(dataFormatada(data.dataUltimoContato));
					$("#entrevista").val(dataFormatada(data.entrevista));
					$("#situacaoAtual").val(data.formacao.situacaoAtual.id);
					
				}
			},
			error: function (data) {
				console.log("Cpf não encontrado");
				
			}
		});
	}
	
	
	</script>
	</layout:put>
</layout:extends>