function info(listaId){
    	//
    	$.ajax({
    		url: "visualizar",
    		type: "GET",
    		dataType: "JSON",
    		data: { 'id' : listaId},
    		success: function(lista){
    			console.log(lista);
    			$('#titulo').html(lista.nomeVaga);
    			$('input#vagaGestor').val(lista.nomeSolicitante);
    			if(lista.localTrabalho == 'C') {
    				//$("#cliente").attr('checked', 'checked');
    				$("#lblLocal").text('Cliente')
    			} else {
    				//$("#interno").attr('checked', 'checked');
    				$("#lblLocal").text('Interno')
    			}
    			if(lista.idTipoVaga == 'H') { 
    				$("#tpVaga").text('Hunting')
    			} else if(lista.idTipoVaga == 'P') {
    				$("#tpVaga").text('Prospecção')
    			} else {
    				$("#tpVaga").text('Real')
    			}
    			if(lista.aumentaQuadro == 'N') {
    				$("#lblQuadro").text('Novo')
    				$("#substituidoId").hide();
    				$("#vagaSubstituto").hide();
       			} else {
       				$("#lblQuadro").text('Substituição')
       				$("#substituidoId").show();
    				$("#vagaSubstituto").show();
    			}
    			$('input#vagaSalario').val(lista.valorPretensao);
    			$('input#cargo').val(lista.cargoBean.nome);
    			$('input#vagaSenioridade').val(lista.senioridadeBean.nome);
    			$('label#horaEntrada').text(lista.horarioEntrada);
    			$('label#horaSaida').text(lista.horarioSaida);
    			$('input#solicitante').val(lista.nomeSolicitante);
    			$('input#vagaQuadro').val(lista.aumentaQuadro);
    			$('label#vagaSubstituto').text(lista.nomeSubstituido);
    			$('#dataInicio').val(dataAtualFormatada);
    			$('input#vagaCiente').val(lista.projeto.cliente.nome);
    			$('input#vagaProjeto').val(lista.projeto.nome);
    			$('#vagaPerfil').val(lista.descricaoPerfilComportamental);
    			$('#vagaFormacao').val(lista.descricaoFormacaoAcademica);
    			$('#vagaPerfilTecnico').val(lista.descricaoPerfilTecnico);
    			$('#vaga-modal').modal('show');
    		}
    	})
    } 
	
	document.getElementById("Print").onclick = function () {
	    printElement(document.getElementById("printThis"));
	};

	function printElement(elem) {
	    var domClone = elem.cloneNode(true);

	    var $printSection = document.getElementById("printSection");

	    if (!$printSection) {
	        var $printSection = document.createElement("div");
	        $printSection.id = "printSection";
	        document.body.appendChild($printSection);
	    }

	    $printSection.innerHTML = "";
	    $printSection.appendChild(domClone);
	    window.print();
	}
	
	function status(){
    	$.ajax({
    		url: "status",
    		type: "POST",
    		dataType: "JSON",
    		data: { 'idVaga' : $('.aprovar-id').val(), 'status' : $('.aprovar-status').val()},
    		success: function(){
    				location.reload();	
    			}
    	});
    	}
	function alterarStatus(id,status){
		$('input.aprovar-id').val(id);
		$('input.aprovar-status').val(status);

		$('input.reprovar-id').val(id);
		$('input.reprovar-status').val(status);
		
		$('input.cancelar-id').val(id);
		$('input.cancelar-status').val(status);
		
	}
	function dataAtualFormatada(){
	    var data = new Date();
	    var dia = data.getDate();
	    if (dia.toString().length == 1)
	      dia = "0"+dia;
	    var mes = data.getMonth()+1;
	    if (mes.toString().length == 1)
	      mes = "0"+mes;
	    var ano = data.getFullYear();  
	    return dia+"/"+mes+"/"+ano;
	}
	$(document).ready(function() {
		var url = window.location.href;
		if(url.match(/editar/)){
			$(".download-download").show();
		} else {
			$(".download-download").hide();
		}
	});	