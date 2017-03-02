$(function	()	{
	
	//#formCadastro
	var currentStep = 1; 
	 
    // Desativa navegação por tabs
    /*$('.wizard-demo li a').click(function()	{
		return false;
	});*/
    
	//Form Validation
	$('#basic-constraint').parsley( { listeners: {
        onFormSubmit: function ( isFormValid, event ) {
            if(isFormValid)	{
				return false;
			}
        }
    }}); 
	
	$('#type-constraint').parsley( { listeners: {
        onFormSubmit: function ( isFormValid, event ) {
            if(isFormValid)	{
				return false;
			}
        }
    }}); 
	 
	$('#formValidate1').parsley( { listeners: {
        onFormSubmit: function ( isFormValid, event ) {
            if(isFormValid)	{
				alert('Registration Complete');
				return false;
			}
        }
    }}); 
	
	$('#formValidate2').parsley( { listeners: {
        onFormSubmit: function ( isFormValid, event ) {
            if(isFormValid)	{
				alert('Your message has been sent');
				return false;
			}
        }
    }});
	
	$('#formCadastro').parsley( { listeners: {
		onFieldValidate: function ( elem ) {
			// if field is not visible, do not apply Parsley validation!
			if ( !$( elem ).is( ':visible' ) ) {
				return true;
			}

			return false;
		},
        onFormSubmit: function ( isFormValid, event ) {
            if(isFormValid)	{
					
				currentStep++;
				
				if(currentStep == 2)	{
					$('#wizardDemo li:eq(1) a').tab('show');
					
					$('#prevStep').attr('disabled',false);
					$('#prevStep').removeClass('disabled');
                    $('#nextStep').text('Próximo');
				}
				else if(currentStep == 3)	{
					$('#wizardDemo li:eq(2) a').tab('show');
					$('#nextStep').text('Cadastrar');
				}
				
				return false;
			}
        }
    }});
	
	$('#prevStep').click(function()	{
		
		currentStep--;
		
		if(currentStep == 1)	{
		
			$('#wizardDemo li:eq(0) a').tab('show');
				
			$('#prevStep').attr('disabled',true);
			$('#prevStep').addClass('disabled');
			
		}
		else if(currentStep == 2)	{
			$('#wizardDemo li:eq(1) a').tab('show');
			$('#nextStep').text('Próximo');
		}
		
		else if(currentStep == 3)	{
			$('#wizardDemo li:eq(2) a').tab('show');
		}
		
		return false;
	});
});