USE [Prosperity]
GO

INSERT INTO [dbo].[tbAvaliacao]
           ([nmAvaliacao]
           ,[tpCss])
     VALUES
           ('Insatisfatório' ,'#F51D17'),
		   ('Em desenvolvimento' ,'#FF8E00'),
		   ('Atende as expectativas' ,'#FEBF10'),
		   ('Supera as expectativas' ,'#78DE19'),
		   ('Não informar' ,'#B5B5B5')
GO

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
GO

INSERT INTO [dbo].[tbCancelamento]
           (dsCancelamento)
     VALUES
           ('Fora do perfil'),
		   ('Declinou'),
		   ('Sem interesse'),
		   ('Stand by')
GO

INSERT INTO [dbo].[tbCargo]
           (nmCargo)
     VALUES
           ('Analista de Requisitos '),
		   ('Analista de Sistemas e Inovação '),
		   ('Analista Teste'),
		   ('Scrum Master'),
		   ('Banco de talentos Analista de Sistemas'),
		   ('Banco de talentos Administrativo e Financeiro'),
		   ('Banco de talentos Gestão de Configuração'),
		   ('Banco de talentos de Infraestrutura'),
		   ('Banco de Talentos Recursos Humanos '),
		   ('Desenvolvedor .NET'),
		   ('Desenvolvedor Java'),
		   ('Desenvolvedor Java Liferay'),
		   ('Gerente de Operações '),
		   ('Analista de RH'),
		   ('Gestor de projetos'),
		   ('Diretor de operação'),
		   ('Banco Talentos'),
		   ('CEO'),
		   ('Gestor de teste')
GO

INSERT INTO [dbo].[tbSenioridade]
           (nmSenioridade)
     VALUES
           ('Junior'),
		   ('Pleno'),
		   ('Senior'),
		   ('A definir')
GO

INSERT INTO [dbo].[tbCliente]
           (nmCliente)
     VALUES
           ('Carrefour'),
		   ('Alelo'),
		   ('Dell'),
		   ('Verity')
GO

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
GO

INSERT INTO [dbo].[tbProva]
           (nmProva)
     VALUES
           ('Prova prática'),
		   ('Prova teórica'),
		   ('Dinamica de grupo')
GO

INSERT INTO [dbo].[tbSituacaoAtual]
           (nmSituacaoAtual)
     VALUES
           ('Cursando'),
		   ('Concluido'),
		   ('Interrompido')
GO

INSERT INTO [dbo].[tbTpStatus]
           ([nmTpStatus])
     VALUES
           ('Candidato'),
		   ('Vaga')
GO

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
GO

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
GO

INSERT INTO [dbo].[tbStatusFuturo]
           ([idStatus]
           ,[idStatusFuturo])
     VALUES
           (7,6),
		   (7,9)
GO

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
GO

INSERT INTO [dbo].[tbCargoSenioridade]
           (idCargo, idSenioridade, vlMinSalario, vlMaxSalario,dsPreFormacaoAcademica,
		   dsPrePerfilComportamental, dsPrePerfilTecnico)
     VALUES
		(1,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(1,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(1,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(2,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(2,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(2,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(3,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(3,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(3,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(4,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(4,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(4,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(5,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(5,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(5,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(6,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(6,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(6,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(7,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(7,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(7,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(8,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(8,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(8,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(9,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(9,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(9,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(10,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(10,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(10,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(11,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(11,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(11,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(12,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(12,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(12,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(13,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(13,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(13,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(14,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(14,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(14,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(15,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(15,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(15,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(16,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(16,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(16,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(17,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(17,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(17,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(18,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(18,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(18,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(19,1,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(19,2,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)'),
		(19,3,1000.00,2000.00,'Ter cursado Ciência da Computação, Sistemas de Informação, Engenharia de Software ou cursos relacionados.','Boa oratória que transmita tranquilidade e confiança.','Base sólida em computação (Algoritmos e Estruturas de Dados e Orientação a Objetos)')
GO


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