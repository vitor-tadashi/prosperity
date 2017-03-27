	var idUsuario;
	var ativo;
	var nomeFuncionario;

	function abrirModal(action, id) {

		$("#frmUsuario")[0].reset();
		$('#frmUsuario').parsley().reset();

		if (id != undefined) {
			$('#myModalLabel').text('Alterar usuário');
			$('#btnRedefinirSenha').show();
			$('#btnMudarStatus').show();
			idUsuario = id;
			$.ajax({
				url : "carregar-usuario-api",
				type : "GET",
				dataType : "JSON",
				data : {
					'id' : id
				},
				success : function(data) {
					$('input#id').val(data.id);
					$('input#usuario').val(data.nome);
					$('input#email').val(data.email);
					nomeFuncionario = data.funcionario.nome;
					if(data.ativo) {
						$('#btnMudarStatus').html("<span class='fa fa-power-off'></span> Desativar");
						$('#btnMudarStatus').removeClass("btn-primary").addClass("btn-danger");
						ativo = true;
					} else {
						$('#btnMudarStatus').html("<span class='fa fa-power-off'></span> Ativar");
						$('#btnMudarStatus').removeClass("btn-danger").addClass("btn-primary");
						ativo = false;
					}
					//$('select#cmbFuncionario').val(data.funcionario.id);
					//$('select#cmbFuncionario').attr("disabled", "disabled").attr("selected", "selected").html("<option value="+data.funcionario.id+">"+data.funcionario.nome+"</option>");
					$('select#cmbPerfil').val(data.perfil.id);
					$('#usuario-modal').modal('show');
				}
			});
		} else {
			$('#myModalLabel').text('Incluir usuário');
			$('#btnRedefinirSenha').hide();
			$('#btnMudarStatus').hide();
			$('#usuario-modal').modal('show');
		}
	}

	$("#btnSalvar").click(function() {
		$("#frmUsuario").submit();
	});

	$("#btnMudarStatus").click(function() {
		var mensagem;
		$.ajax({
			url : "mudar-status-api",
			type : "POST",
			dataType : "JSON",
			data : {'id' : idUsuario},
	        error : function() {
	            if(!ativo) {
	            	$('#status_'+idUsuario).find('span').text('Ativo').removeClass('label-danger').addClass('label-success');
	            	mensagem = "Usuário <strong>" + nomeFuncionario + "</strong> ATIVADO com sucesso!";
	            } else {
	            	$('#status_'+idUsuario).find('span').text('Inativo').removeClass('label-success').addClass('label-danger');
	            	mensagem = "Usuário <strong>" + nomeFuncionario + "</strong> DESATIVADO com sucesso!";
	            }
	            $('#divAlert').html(mensagem).addClass('alert alert-success').show();
	            
	            $('#usuario-modal').modal('hide');
	            escondeMensagem();
	        }
		})
	});
	
	$("#btnRedefinirSenha").click(function() {
		var mensagem;
		$.ajax({
			url : "redefinir-senha-api",
			type : "POST",
			dataType : "JSON",
			data : {'id' : idUsuario},
			error : function() {
	            $('#usuario-modal').modal('hide');
	            mensagem = 'A senha do usuário <strong>' + nomeFuncionario + '</strong> foi redefinida com sucesso!'
	            $('#divAlert').html(mensagem).addClass('alert alert-success').show();
	            escondeMensagem();
	        }
		})
	});

	function escondeMensagem() {
		window.setTimeout(
		        function () {
		            $("#divAlert").hide();
		        }, 5000);
	}
