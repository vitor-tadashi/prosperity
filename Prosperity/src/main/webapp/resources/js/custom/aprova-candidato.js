var nomeCandidato;
	
	function maxCaracterParecer(){
		var maxParecer = $("#parecer").val();
		var restante = 500 - maxParecer.length;
		var maxCaracteres = document.querySelector("#maxParecer");
		maxCaracteres.innerHTML = "Caracteres restantes : " + restante;
		}
	function maxCaracterParecerCancelamento(){
		var maxParecer = $("#parecerCancelamento").val();
		var restante = 300 - maxParecer.length;
		var maxCaracteres = document.querySelector("#maxParecerCanc");
		maxCaracteres.innerHTML = "Caracteres restantes : " + restante;
	}
	
		$("body").on("click", "#aprovar-candidato", function(){
			var inputs  = $(this).closest("tr").find("input[type=hidden]");
			var tituloModal = $(this).text();

			inputs.each(function(index, value){
				if(!isNaN($(value).attr("id"))){
					var id = $(value).attr("id");

					$.ajax({
						url:"buscar/"+id,
						dataType:"json",
						method:"GET",
						success:function(data){
							
							nomeCandidato = data.candidato.nome;
							
							var perfil = $('#user').val();
							$("#modalTitulo").text(tituloModal);
							if(data.ultimoStatus.status.id == "9"){
				                 if(perfil == "Analista de RH" || perfil == "Gestor RH"){
									$("#proposta-tab").show();
				                 }
							}else if(data.ultimoStatus.status.id == "10"){
				                 if(perfil == "Administrador" || perfil == "CEO" || perfil == "Diretor de operação"){
					                	$("#proposta-tab").show();
					                 }
							}else if(data.ultimoStatus.status.id == "11"){
				                 if(perfil == "Analista de RH" || perfil == "Gestor RH"){
					                	$("#proposta-tab").show();
					                 }
							}else if(data.ultimoStatus.status.id == "13"){
				                 if(perfil == "Analista de RH" || perfil == "Gestor RH"){
					                	$("#proposta-tab").show();
					                 }
							}else if(data.ultimoStatus.status.id == "14"){
				                 if(perfil == "Analista de RH" || perfil == "Gestor RH"){
					                	$("#proposta-tab").show();
					                 }
							}else{
			                	$("#proposta-tab").hide();
							}
							if(data.ultimoStatus.status.id == "6"){
								$("#avaliacao-tab").show();
								$("#processo-tab").show();
							}else{
								$("#avaliacao-tab").hide();
								$("#processo-tab").hide();
							}
							$('.tab-bar a[href="#infoEntrevista"]').tab('show');
							$('#modalProposta').modal('show');
						}
					})
				}
				});

			function alterarStatus(id,status){
				$('input.cancelar-id').val(id);
				$('input.cancelar-status').val(status);
			}


			})
                  $('#alterarStatus').click(function() {
	                   	var avaliacoes = [];

	                   	$(".avaliacaoCompetencia").each(function(){
                            if($(this).prop("checked")){
                                var idAvaliacao = $(this).attr("alt");
                                var idCompetencia = $(this).val();
								avaliacoes.push(idAvaliacao);
								avaliacoes.push(idCompetencia);
                            }
                        });

	                   	var provasDescricoes  = [];
	                	var x = 0;
	                   	$(".processoSeletivo").each(function(){
		                   	var provaDescricao = {
		                   			"prova" : "",
		                   			"descricao" : ""
		                   	};
		                   	
	                   	    var select = $(this).find("#prova-js").val();
	                   	    var input = $(this).find("#descricao-js").val();

	                   		provasDescricoes.push(select);
	                   		provasDescricoes.push(input);
	                   		x++;
	                   	});
	                   	file();
	                   	
                        $.ajax({
                              url : "alterar-status-candidato",
                              method : "POST",
                              dataType : "JSON",
                              data : {
                                   'idCandidato' : $('#hdn-id-candidato').val(),
                                   'parecer' : $('#parecer').val(),
                                   'idStatus' : $('#hdn-status').val(),
                                   'parecerTecnico' : $('#parecerTecnico').val(),
                                   'processoSelectivo' : JSON.stringify(provasDescricoes),
                                   'ac' : JSON.stringify(avaliacoes)
                              },
                              success : function(data) {
                            	  location.reload();
                              },
                              error : function(e) {
                                   location.reload();
                              }
                        });
                  });
			
                  function file(){
                   	  var paperElement = document.getElementById("modalPapers");

                   	  if ($(paperElement).val()) {
	                   	  var form = document.getElementById("formValidar");
	                   	  var formData = new FormData(form);
	                   	  var xhr = new XMLHttpRequest();
	                   	  xhr.open('POST', "submitFiles");
	                   	  xhr.onreadystatechange = function() {
	                   	    if (xhr.readyState == 4 && xhr.status == 200) {
	                   	      console.log("Files Uploaded")
	                   	    }
	                   	  };
	                   	  xhr.send(formData);
	                  }
					}      
                  
            function alterarStatus(idCandidato, idStatus, proposta) {
                  $('#hdn-id-candidato').val(idCandidato);
                  $('#hdn-proposta').val(proposta);
                  $('#hdn-status').val(idStatus);
                  
                  $('#idCandidatoFile').val(idCandidato);
            }

            function cancelarCandidato() {
            	var id = $("#idCancelamento").val();

            	$.ajax({
        			url : "cancelar-candidato/"+id,
        			type : "POST"
        		}).done(function() {
        			$('#delete-modal').modal('hide');
        			msg = 'O candidato <strong>' + nomeCandidato + '</strong> foi cancelado com sucesso!'
        			$('#msg-sucesso').html(msg).addClass('alert alert-success').show();
        			$('#js-trCandidato_' + id).remove();
        			escondeMensagem();
        		}).fail(function(jqXHR, textStatus) {
        			 location.reload();
        		});
            }

           function cancelarClick (id){
        	   $("#idCancelamento").val(id);

        	   $('#frmCancelar')[0].reset();
        	   maxCaracterParecerCancelamento();
           } 



        /*gerador de campo*/
            var cont = 0;
            $("#gerarCampo").click(function(){
            	
            	var campos = 
            	
            	"<div class='div"+cont+" processoSeletivo'>" +
            	"<div class='row'>"+
            	
            	"<div class='col-md-6 form-inline'>"+
            	"<a id='btnRemover' onclick='remover("+ cont +")'class='text-danger fa fa-times fa-lg'></a>"+
            	"&nbsp;<select class='form-control' id='prova-js'>" +
            	"<option value='0'>Selecione</option>"+
            	"<c:forEach var='selecao' items='${provas}'>" +
            	"<option value='${selecao.id}'>${selecao.nome}</option>"+
            	"</c:forEach>" +
            	"</select>"+
            	"<input class='form-control descricaoProva' type='text' id='descricao-js' name='descricao"+ cont +"' placeholder='Descrição' maxlength='50'  onkeyup='maxDescricaoProva()' />"+
            	"</div>"+

            	"<div class='col-md-5 form-inline'>"+
            	"<input name='papers' id='modalPapers' type='file' class='input-sm' multiple data-input='false'>"+
            	"</div>"+
            	//"&nbsp; &nbsp;<label id='maxDescricao'>Caracteres restantes : <span class='numeroCaracteres" + cont +"'>50</span></label>"+
            		
            	"</div>"+
            	"</div>";
            	cont++;
        /*adiciona na div*/
            	$("#processoSeletivo").append(campos);


            	/*contador de caracter - descrição prova*/
            });
       /*remove os campos*/

                function maxDescricaoProva(){
    	   			var cont = 0;
    	   			$(".descricaoProva").each(function(){

                		var descricao = $(this).val().length;
                		var restante = 50 - descricao;
                		$(".numeroCaracteres"+cont).text(restante);
    	   				cont++;
    	   			})

            	}
            function remover(id){
            	$(".div"+id).remove();
            	cont--;
            }

         // Submit do formulário
        	$("button#btnEnviar").click(function() {
        		$("form#formValidar").submit();
        		if($('form#formValidar').parsley('isValid')){
					$('#confirm-modal').modal('show');
			   }
        	});

        	$(document).ready(function () {
                $('form#formValidar').parsley();

                $('form#formValidar').on('submit', function (e) {
                    e.preventDefault();
                    $(this).parsley().validate();
                });
            });

            function gerarProposta(){
                $.ajax({
                    url: 'gerar-proposta',
                    enctype: 'multipart/form-data',
                    type: 'POST',
                    data: MultipartFile,
                    processData: false,
                    contentType: false,
                    cache: false,
                    success: function (data) {
                        alert(data)
                    },
                });
            };
            
        	function escondeMensagem() {
        		window.setTimeout(function () {
        			$("#msg-sucesso").hide();
        			$(".mensagem").hide();
        		}, 5000);
        	}