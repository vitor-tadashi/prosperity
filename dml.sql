/************************************************************************** 
* Verity TI
* --------------------------- 
* Criado por...:           Guilherme de Oliveira e Igor Cunha
* Em...........:           03/07/2017
* Projeto......:           Prosperity
* Descrição....:           Script para preenchimento das tabelas do banco Prosperity
* Tabelas envoldidas:      Tabela de dominio
**************************************************************************/ 

DECLARE @nomeScript VARCHAR(MAX);
SET @nomeScript = '01. nome do script aqui'
PRINT 'Iniciando execução script ['+ @nomeScript +']'
BEGIN TRY
    BEGIN TRANSACTION;

		USE [Prosperity]

		INSERT INTO [dbo].[tbAvaliacao]
				   ([nmAvaliacao]
				   ,[tpCss])
			 VALUES
				   ('Insatisfatório' ,'#F51D17'),
				   ('Em desenvolvimento' ,'#FF8E00'),
				   ('Atende as expectativas' ,'#FEBF10'),
				   ('Supera as expectativas' ,'#78DE19'),
				   ('Não informar' ,'#B5B5B5')

		INSERT INTO [dbo].[tbCanalInformacao]
				   (nmCanalInformacao)
			 VALUES
				   ('Site Verity'),
				   ('Facebook'),
				   ('Linkedin'),
				   ('Apinfo'),
				   ('Catho'),
				   ('Outros sites de oportunidades'),
				   ('Indicação de colegas'),
				   ('Outros')

		INSERT INTO [dbo].[tbCancelamento]
				   (dsCancelamento)
			 VALUES
				   ('Fora do perfil'),
				   ('Declinou'),
				   ('Sem interesse'),
				   ('Stand by')
				   

		INSERT INTO [dbo].[tbSenioridade]
				   (nmSenioridade)
			 VALUES
				   ('Junior'),
				   ('Pleno'),
				   ('Senior'),
				   ('A definir')

		INSERT INTO [dbo].[tbCompetencia]
				   (nmCompetencia)
			 VALUES
				   ('Desenvolvimento'),
				   ('Profundidade'),
				   ('Planejamento'),
				   ('Execução e entrega'),
				   ('Pessoas'),
				   ('Comercial'),
				   ('Financeiro')

		INSERT INTO [dbo].[tbProva]
				   (nmProva)
			 VALUES
				   ('Prova prática'),
				   ('Prova teórica'),
				   ('Dinamica de grupo')

		INSERT INTO [dbo].[tbSituacaoAtual]
				   (nmSituacaoAtual)
			 VALUES
				   ('Cursando'),
				   ('Concluido'),
				   ('Interrompido')

		INSERT INTO [dbo].[tbTpStatus]
				   ([nmTpStatus])
			 VALUES
				   ('Candidato'),
				   ('Vaga')

		INSERT INTO [dbo].[tbStatus]
				   (idStatus, nmStatus, tpCss, idTpStatus)
			 VALUES
				   (1,'Ativo', '#2ECC71', 2),
				   (2,'Fechado', '#ed6f02', 2),
				   (3,'Cancelado', '#CF000F', 2),
				   (4,'Pendente', '#02b4ea', 2),
				   (5,'Candidatura', '#03C9A9', 1),
				   (6,'Candidato em análise', '#e67e22', 1),
				   (7,'Candidato aprovado', '#2ECC71', 1),
				   (8,'Candidato reprovado', '#CF000F', 1),
				   (9,'Gerar proposta', '#03C9A9', 1),
				   (10,'Proposta gerada', '#03C9A9', 1),
				   (11,'Proposta aprovada', '#2ECC71', 1),
				   (13,'Proposta recusada', '#CF000F', 1),
				   (14,'Candidato recusou proposta', '#F9690E', 1),
				   (15,'Contratado', '#2ECC71', 1),
				   (17,'Cancelado', '#CF000F', 1),
				   (18,'Reprovado', '#CF000F', 2),
				   (27,'Vaga nova', '#F9690E', 2),
				   (29,'Sem vaga', '#808080', 1)

		INSERT INTO [dbo].[tbStatusDisponivel]
				   (idStatus, idStatusDisponivel, nmOpcao, nmClasse)
			 VALUES
				   (5,6,'Enviar para análise','class="glyphicon fa fa-check fa-lg"'),
				   (6,7,'Aprovar candidato','class="fa fa-check fa-lg"'),
				   (6,8,'Reprovar candidato','class="fa fa-times fa-lg"'),
				   (9,10,'Gerar proposta','class="fa fa-pencil fa-lg"'),
				   (10,11,'Aprovar proposta','class="fa fa-check fa-lg"'),
				   (10,13,'Reprovar proposta','class="fa fa-times fa-lg"'),
				   (11,14,'Candidato recusou proposta','class="fa fa-times fa-lg"'),
				   (11,15,'Contratar candidato','class="fa fa-check fa-lg"'),
				   (13,10,'Refazer proposta','class="fa fa-refresh fa-lg"'),
				   (14,10,'Refazer proposta','class="fa fa-refresh fa-lg"'),
				   (1,3,'Cancelar','class="fa fa-ban fa-lg"'),
				   (1,2,'Fechar','class="fa fa-trash-o fa-lg"'),
				   (4,27,'Aprovar','class="fa fa-check fa-lg"'),
				   (4,18,'Reprovar','class="fa  fa-times fa-lg"'),
				   (27,1,'Divulgar','class="fa fa-check fa-lg"'),
				   (27,3,'Cancelar','class="fa fa-ban fa-lg"')

		INSERT INTO [dbo].[tbStatusFuturo]
				   ([idStatus]
				   ,[idStatusFuturo])
			 VALUES
				   (7,6),
				   (7,9)

		INSERT INTO [dbo].[tbTipoCurso]
				   ([nmTipoCurso])
			 VALUES
				   ('Formação Escolar Fundamental (1° grau) e Média (2° grau)'),
				   ('Curso Técnico - Médio (2º Grau)'),
				   ('Graduação'),
				   ('Pós-graduação – Especialização'),
				   ('Pós-graduação – MBA'),
				   ('Pós-graduação – Mestrado'),
				   ('Pós-graduação – Doutorado'),
				   ('Não informado')

		INSERT INTO [dbo].[tbFuncionalidade]
				   (idFuncionalidade,nmFuncionalidade, url)
			 VALUES
					(1,'Aprovar/Reprovar vaga','vaga/aprovar'),
					(2,'Consultar vaga','vaga/consultar'),
					(3,'Solicitar vaga','vaga/solicitar'),
					(16,'Criar perfil','usuario/perfil/gerenciar'),
					(17,'Cadastrar candidato','candidato/cadastrar'),
					(18,'Consultar candidato','candidato/consultar'),
					(22,'Criar usuário','usuario/gerenciar'),
					(23,'Aprovar/Reprovar proposta','colocarUrlAqui'),
					(24,'Informar avaliador','colocarUrlAqui'),
					(25,'Aprovar/Reprovar candidato','candidato/aprovar'),
					(26,'Gerar proposta','colocarUrlAqui'),
					(27,'Analisar candidato','colocarUrlAqui'),
					(28,'Refazer proposta','colocarUrlAqui'),
					(29,'Cancelar vaga','colocarUrlAqui'),
					(30,'Fechar vaga','colocarUrlAqui'),
					(31,'Editar vaga','colocarUrlAqui'),
					(32,'Editar candidato','candidato/editar/*'),
					(34,'Informar data contato','colocarUrlAqui'),
					(35,'Aprovar vaga','colocarUrlAqui')

	INSERT INTO [dbo].[tbPerfil]
				   (nmPerfil)
			 VALUES
					('Administrador')

	INSERT INTO [dbo].[tbPerfilFuncionalidade]
				   (idPerfil, idFuncionalidade)
			 VALUES
					(1, 16),
					(1, 22)

	INSERT INTO [dbo].[tbUsuario]
				   (idPerfil, nmUsuario, senha, email, nmFuncionario, flPrimeiroAcesso, ativo)
			 VALUES
					(1, 'admin', 'dmVyaXR5QDEyMw==' ,'admin@verity.com.br','admin', 1, 1)
	
	COMMIT TRANSACTION;
 
    PRINT 'Sucesso na execução do script ['+ @nomeScript +']'
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
      
		PRINT 'ERRO na execução do script. [' + @nomeScript + ']'
		PRINT 'Número do erro: [' + CAST(@errorNumber AS VARCHAR(10)) + ']';
		PRINT 'Número da linha: [' + CAST(@errorLine AS VARCHAR(10)) + ']';
		PRINT 'Descrição do erro: [' + @errorMessage + ']';
 
		RAISERROR(@errorMessage, @errorSeverity, @errorState);
END CATCH