$(function() {

			$("#novo").click(function(){
				$("div#nome").addClass("hide");	
			});
			$("#sub").click(function(){
				$("div#nome").removeClass("hide");
			});

			$("#cliente").click(function(){
				$("section#dadosInterno").addClass("hide");	
				$("section#dadosAlocacao").removeClass("hide");
			});
			$("#interno").click(function(){
				$("section#dadosInterno").removeClass("hide");
				$("section#dadosAlocacao").addClass("hide");
			});

		});
