	var idUsuario;
	var ativo;
	var nomeFuncionario;

	// Carregar informações do usuário se for alteração e abrir modal
	function abrirModal(action, id) {

		$("#frmUsuario")[0].reset();
		$('#frmUsuario').parsley().reset();
		
		if (id != undefined) {
			$('#usuarioLabel').text('Alterar usuário');
			$('#btnRedefinirSenha').show();
			$('#btnMudarStatus').show();
			idUsuario = id;
			$.ajax({
				url : "carregar-usuario-api/"+idUsuario,
				type : "GET",
				dataType : "JSON"
			}).done(function(data) {
				$('input#id').val(data.id);
				$('input#usuario').val(data.nome);
				$('input#email').val(data.email);
				nomeFuncionario = data.funcionario.nome;
				if(data.ativo) {
					$('button#btnMudarStatus').html("<span class='fa fa-power-off'></span> Desativar");
					$('button#btnMudarStatus').removeClass("btn-primary").addClass("btn-danger");
					ativo = true;
				} else {
					$('button#btnMudarStatus').html("<span class='fa fa-power-off'></span> Ativar");
					$('button#btnMudarStatus').removeClass("btn-danger").addClass("btn-primary");
					ativo = false;
				}
				$('select#cmbFuncionario').val(data.funcionario.id);
				$('select#cmbPerfil').val(data.perfil.id);
				$('#usuario-modal').modal('show');
			}).fail(function(jqXHR, textStatus) {
				console.log('Falha ao carregar as informações do usuário');
				console.log(jqXHR);
				console.log(textStatus);
			});
		} else {
			$('#usuarioLabel').text('Incluir usuário');
			$('button#btnRedefinirSenha').hide();
			$('button#btnMudarStatus').hide();
			$('#usuario-modal').modal('show');
		}
	}

	// Submit do formulário
	$("button#btnSalvar").click(function() {
		$("form#frmUsuario").submit();
	});

	// Mudar status
	$("button#btnMudarStatus").click(function() {
		var msg;
		$.ajax({
			url : "mudar-status-api/"+idUsuario,
			type : "POST"
		}).done(function() {
			if(!ativo) {
            	$('#status_'+idUsuario).find('span').text('Ativo').removeClass('label-danger').addClass('label-success');
            	msg = "Usuário <strong>" + nomeFuncionario + "</strong> ATIVADO com sucesso!";
            } else {
            	$('#status_'+idUsuario).find('span').text('Inativo').removeClass('label-success').addClass('label-danger');
            	msg = "Usuário <strong>" + nomeFuncionario + "</strong> DESATIVADO com sucesso!";
            }
            $('#divAlert').html(msg).addClass('alert alert-success').show();
            
            $('#usuario-modal').modal('hide');
            escondeMensagem();
		}).fail(function(jqXHR, textStatus) {
			console.log('Falha ao mudar status do usuário');
			console.log(jqXHR);
			console.log(textStatus);
		});
	});
	
	// Redefinir Senha
	$("button#btnRedefinirSenha").click(function() {
		var msg;
		$.ajax({
			url : "redefinir-senha-api/"+idUsuario,
			type : "POST"
		}).done(function() {
			$('#usuario-modal').modal('hide');
			msg = 'A senha do usuário <strong>' + nomeFuncionario + '</strong> foi redefinida com sucesso!'
			$('#divAlert').html(msg).addClass('alert alert-success').show();
			escondeMensagem();
		}).fail(function(jqXHR, textStatus) {
			console.log('Falha ao redefinir senha do usuário');
			console.log(jqXHR);
			console.log(textStatus);
		});
	});

	$(document).ready(function () {
		escondeMensagem();
    });
	
	function escondeMensagem() {
		window.setTimeout(function () {
			$("#divAlert").hide();
			$(".mensagem").hide();
		}, 5000);
	}
