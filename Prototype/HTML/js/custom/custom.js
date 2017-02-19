$(function	()	{
	
	//#tab-cadastraCandidato
	var currentStep = 1; 
	 
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
	
	$('#tab-cadastraCandidato').parsley( { listeners: {
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
					$('#tab-cadastraCandidato li:eq(1) a').tab('show');
					
					$('#prevStep2').attr('disabled',false);
					$('#prevStep2').removeClass('disabled');
				}
				else if(currentStep == 3)	{
					$('#tab-cadastraCandidato li:eq(2) a').tab('show');
				}
				else if(currentStep == 4)	{
					$('#tab-cadastraCandidato li:eq(3) a').tab('show');
					
					$('#nextStep2').attr('disabled',true);
					$('#nextStep2').addClass('disabled');
				}
				
				return false;
			}
        }
    }});
	
	$('#prevStep2').click(function()	{
		
		currentStep--;
		
		if(currentStep == 1)	{
		
			$('#tab-cadastraCandidato li:eq(0) a').tab('show');
				
			$('#prevStep2').attr('disabled',true);
			$('#prevStep2').addClass('disabled');
			
		}
		else if(currentStep == 2)	{
			$('#tab-cadastraCandidato li:eq(1) a').tab('show');
		}
		
		else if(currentStep == 3)	{
		
			$('#tab-cadastraCandidato li:eq(2) a').tab('show');
					
			$('#nextStep2').attr('disabled',false);
			$('#nextStep2').removeClass('disabled');
			
		}
		
		return false;
	});
});