$(function() {
	var id = $("input#idPerfil").val();
	$.ajax({
		url : "/usuario/obter-perfil-funcionalidade",
		type : "GET",
		dataType : "JSON",
		data : {
			id : id
		},
		success : function(listaFunc) {
			if (listaFunc != null) {
				$("li.menu-opcao").each(function(index, li) {
					$.each(listaFunc, function(i, item) {
						if (item.id == $(li).val()) {
							$(li).removeClass("hide")
							if($(li).hasClass("hasMenu")){
								$(".menu"+$(li).val()).removeClass("hide");
							}
						}
					});
				});
			}
			$("#menu-toggle").css("visibility", "visible");
		}
	});
	$('.um-click-js').click(function(){ 

        $(this).attr('disabled',true);
    });
});