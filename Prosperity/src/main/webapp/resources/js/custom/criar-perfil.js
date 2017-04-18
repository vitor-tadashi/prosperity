    function check (){
    	$(".listFun").each(function(index){
    		if($( "#"+index).prop( "checked" ) == true){
    			$("#"+index).prop("checked",false);
    		}
    	});
    }
    
    $(document).ready(function () {
        setTimeout(function () {
            $('#msg-sucesso').fadeOut(1500);
        }, 5000);
    });
    
    $("input#edita-perfil").click(function(){
        $("#nome-perfil").addClass("hide");
        $("#select-perfil").removeClass("hide");
        $("input#nm-perfil").attr('required',false);
        $("#selected-perfil").attr("name","id");
        $("tr").removeClass("selected");
        check();
    });

    $("input#novo-perfil").click(function(){
        $("#select-perfil").addClass("hide");
        $("#nome-perfil").removeClass("hide");
        $("input#nm-perfil").attr('required',true);
        $("#selected-perfil").attr("name","");
        $("tr").removeClass("selected");
        check();
    });
    
    $("#selected-perfil").change(function(){
    	check();
    	var id = $("#selected-perfil option:selected").val();
    	$.ajax({
    		url: "http://localhost:8080/usuario/carrega-funcionalidade-ajax",
    		type: "GET",
    		dataType: "JSON",
    		data: {id : id},
    		success: function(lista){
    			if(lista != null){
    				$(".listFun").each(function(index){
	    				$.each(lista,function(i,item){
	    					if(item.id == $("#"+index).val()){
	    						$("#"+index).prop("checked",true)
	    					}
	    				});
    				});	
    			}
    		}
    	});
    });