/************************************************************************** 
* Verity TI
* --------------------------- 
* Criado por...:           Guilherme de Oliveira
* Em...........:           03/07/2017
* Projeto......:           Prosperity
* Descri��o....:           Script para fallback das tabelas de dominio do banco Prosperity
* Tabelas envoldidas:      tabelas de dominio
**************************************************************************/ 

DECLARE @nomeScript VARCHAR(MAX);
SET @nomeScript = '01. nome do script aqui'
PRINT 'Iniciando execu��o script ['+ @nomeScript +']'
BEGIN TRY
    BEGIN TRANSACTION;
		
		USE Prosperity
	
		delete tbAvaliacao
		delete tbCanalInformacao
		delete tbCancelamento
		delete tbCargo
		delete tbSenioridade
		delete tbCliente
		delete tbCompetencia
		delete tbProva
		delete tbSituacaoAtual
		delete tbTpStatus
		delete tbFuncionario
		delete tbStatus
		delete tbStatusDisponivel
		delete tbStatusFuturo
		delete tbTipoCurso
		delete tbCargoSenioridade
		delete tbFuncionalidade
			        
	COMMIT TRANSACTION;
 
    PRINT 'Sucesso na execu��o do script ['+ @nomeScript +']'
END TRY
BEGIN CATCH
		IF @@TRANCOUNT > 0
			 ROLLBACK TRANSACTION;
             
 		DECLARE @errorNumber INT;
		SET @errorNumber  = ERROR_NUMBER();
		DECLARE @errorLine INT;
		SET @errorLine = ERROR_LINE();
		DECLARE @errorMessage NVARCHAR(4000);
		SET @errorMessage = ERROR_MESSAGE();
		DECLARE @errorSeverity INT;
		SET @errorSeverity = ERROR_SEVERITY();
		DECLARE @errorState INT;
		SET @errorState = ERROR_STATE();
      
		PRINT 'ERRO na execu��o do script. [' + @nomeScript + ']'
		PRINT 'N�mero do erro: [' + CAST(@errorNumber AS VARCHAR(10)) + ']';
		PRINT 'N�mero da linha: [' + CAST(@errorLine AS VARCHAR(10)) + ']';
		PRINT 'Descri��o do erro: [' + @errorMessage + ']';
 
		RAISERROR(@errorMessage, @errorSeverity, @errorState);
END CATCH