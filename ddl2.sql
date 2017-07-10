/************************************************************************** 
* Verity TI
* --------------------------- 
* Criado por...:           Guilherme de Oliveira
* Em...........:           03/07/2017
* Projeto......:           Prosperity
* Descrição....:           Script para criação do banco Prosperity
* Tabelas envoldidas:      todas
**************************************************************************/ 
create database Prosperity
GO

DECLARE @nomeScript VARCHAR(MAX);
SET @nomeScript = '01. nome do script aqui'
PRINT 'Iniciando execução script ['+ @nomeScript +']'
BEGIN TRY
    BEGIN TRANSACTION;			USE [Prosperity]
			CREATE TABLE [dbo].[tbAvaliacao](
				[idAvaliacao] [int] IDENTITY(1,1) NOT NULL,
				[nmAvaliacao] [varchar](200) NULL,
				[tpCss] [varchar](50) NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idAvaliacao] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbAvaliadorCandidato](
				[id] [int] IDENTITY(1,1) NOT NULL,
				[idCandidato] [int] NULL,
				[idVaga] [int] NULL,
				[idUsuario] [int] NULL,
				[idStatus] [int] NULL,
			 CONSTRAINT [PK_tbAvaliadorCandidato] PRIMARY KEY CLUSTERED 
			(
				[id] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbAvaliadorVaga](
				[idAvaliadorVaga] [int] IDENTITY(1,1) NOT NULL,
				[idUsuario] [int] NULL,
				[idVaga] [int] NULL,
			 CONSTRAINT [PK_tbAvaliadorVaga] PRIMARY KEY CLUSTERED 
			(
				[idAvaliadorVaga] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbCanalInformacao](
				[idCanalInformacao] [int] IDENTITY(1,1) NOT NULL,
				[nmCanalInformacao] [varchar](200) NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idCanalInformacao] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbCancelamento](
				[idCancelamento] [int] IDENTITY(1,1) NOT NULL,
				[dsCancelamento] [varchar](150) NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idCancelamento] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbCandidato](
				[idCandidato] [int] IDENTITY(1,1) NOT NULL,
				[cpf] [varchar](15) NULL,
				[idEndereco] [int] NULL,
				[idFormacao] [int] NULL,
				[idContato] [int] NULL,
				[nmCandidato] [varchar](100) NULL,
				[rg] [varchar](15) NULL,
				[dtNascimento] [date] NULL,
				[vlPretensao] [smallmoney] NULL,
				[cmCurriculo] [varchar](200) NULL,
				[curriculoTexto] [varchar](max) NULL,
				[nmEmail] [varchar](45) NULL,
				[idUsuario] [int] NULL,
				[dtAbertura] [date] NULL,
			 CONSTRAINT [PK__tbCandid__F84D9A3C83E0F730] PRIMARY KEY CLUSTERED 
			(
				[idCandidato] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

			CREATE TABLE [dbo].[tbCandidatoCompetencia](
				[idCandidatoCompetencia] [int] IDENTITY(1,1) NOT NULL,
				[idAvaliacao] [int] NULL,
				[idCandidato] [int] NULL,
				[idCompetencia] [int] NULL,
				[idVaga] [int] NULL,
				[nmAvaliador] [varchar](200) NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idCandidatoCompetencia] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbCargo](
				[idCargo] [int] IDENTITY(1,1) NOT NULL,
				[nmCargo] [varchar](50) NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idCargo] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbCargoSenioridade](
				[idCargoSenioridade] [int] IDENTITY(1,1) NOT NULL,
				[idCargo] [int] NULL,
				[idSenioridade] [int] NULL,
				[vlMinSalario] [smallmoney] NULL,
				[vlMaxSalario] [smallmoney] NULL,
				[dsPreFormacaoAcademica] [varchar](2000) NULL,
				[dsPrePerfilComportamental] [varchar](2000) NULL,
				[dsPrePerfilTecnico] [varchar](2000) NULL,
			 CONSTRAINT [PK__tbCargoS__52D447EA8F8D8611] PRIMARY KEY CLUSTERED 
			(
				[idCargoSenioridade] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbCliente](
				[idCliente] [int] IDENTITY(1,1) NOT NULL,
				[nmCliente] [varchar](200) NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idCliente] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbComparativoProposta](
				[idComparativoProposta] [int] IDENTITY(1,1) NOT NULL,
				[idProposta] [int] NULL,
				[nmFuncionario] [varchar](100) NULL,
				[nmCargo] [varchar](50) NULL,
				[nmSenioridade] [varchar](50) NULL,
				[dsConhecimento] [varchar](500) NULL,
				[dtAdmissao] [date] NULL,
				[vlrSalario] [decimal](9, 2) NULL,
				[vlrVr] [decimal](6, 2) NULL,
				[vlrVa] [decimal](6, 2) NULL,
				[vlrEstacionamento] [decimal](6, 2) NULL,
				[vlrCombustivel] [decimal](6, 2) NULL,
				[vlrAssistenciaMedica] [decimal](6, 2) NULL,
				[vlrOutros] [decimal](6, 2) NULL,
				[vlrTaxa] [decimal](6, 2) NULL,
				[flSituacao] [bit] NULL,
			 CONSTRAINT [PK_tbComparativoProposta] PRIMARY KEY CLUSTERED 
			(
				[idComparativoProposta] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbCompetencia](
				[idCompetencia] [int] IDENTITY(1,1) NOT NULL,
				[nmCompetencia] [varchar](200) NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idCompetencia] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbComunicacao](
				[idComunicacao] [int] IDENTITY(1,1) NOT NULL,
				[dtContato] [date] NULL,
				[dsObservacao] [varchar](100) NULL,
				[idUsuario] [int] NULL,
				[idCandidato] [int] NULL,
				[idVaga] [int] NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idComunicacao] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbContato](
				[idContato] [int] IDENTITY(1,1) NOT NULL,
				[telefone] [varchar](50) NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idContato] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbDataEntrevista](
				[idDataEntrevista] [int] IDENTITY(1,1) NOT NULL,
				[idUsuario] [int] NULL,
				[dtEntrevista] [date] NULL,
				[idVaga] [int] NULL,
				[idCandidato] [int] NULL,
				[flSituacao] [bit] NULL,
			 CONSTRAINT [PK_tbDataEntrevista] PRIMARY KEY CLUSTERED 
			(
				[idDataEntrevista] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbEndereco](
				[idEndereco] [int] IDENTITY(1,1) NOT NULL,
				[cep] [varchar](10) NULL,
				[vlNumero] [int] NULL,
				[dsComplemento] [varchar](50) NULL,
				[nmEstado] [varchar](20) NULL,
				[nmLogradouro] [varchar](50) NULL,
				[nmCidade] [varchar](45) NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idEndereco] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbFormacao](
				[idFormacao] [int] IDENTITY(1,1) NOT NULL,
				[nmInstituicao] [varchar](100) NULL,
				[dtConclusao] [date] NULL,
				[idTipoCurso] [int] NULL,
				[idSituacaoAtual] [int] NULL,
				[nmCurso] [varchar](100) NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idFormacao] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbFuncionalidade](
				[idFuncionalidade] [int] NOT NULL,
				[nmFuncionalidade] [varchar](50) NULL,
				[url] [varchar](50) NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idFuncionalidade] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbFuncionario](
				[idFuncionario] [int] IDENTITY(1,1) NOT NULL,
				[nmFuncionario] [varchar](50) NULL,
				[idCargo] [int] NULL,
				[idSenioridade] [int] NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idFuncionario] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbPerfil](
				[idPerfil] [int] IDENTITY(1,1) NOT NULL,
				[nmPerfil] [varchar](45) NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idPerfil] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbPerfilFuncionalidade](
				[idPerfilFuncionalidade] [int] IDENTITY(1,1) NOT NULL,
				[idPerfil] [int] NULL,
				[idFuncionalidade] [int] NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idPerfilFuncionalidade] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbProjeto](
				[idProjeto] [int] IDENTITY(1,1) NOT NULL,
				[nmProjeto] [varchar](100) NULL,
				[idFuncionario] [int] NULL,
				[idCliente] [int] NULL,
				[ativo] [bit] NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idProjeto] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbProposta](
				[idProposta] [int] IDENTITY(1,1) NOT NULL,
				[idCandidato] [int] NULL,
				[dsNvEmpresa] [varchar](100) NULL,
				[dsAntEmpresa] [varchar](100) NULL,
				[dsNvCargo] [varchar](100) NULL,
				[dsAntCargo] [varchar](100) NULL,
				[vlrAntSalarioFixoBruto] [decimal](7, 2) NULL,
				[vlrNvSalarioFixoBruto] [decimal](7, 2) NULL,
				[vlrAntSalarioLiquidoMensal] [decimal](7, 2) NULL,
				[vlrNvSalarioLiquidoMensal] [decimal](7, 2) NULL,
				[vlrAntVrMensal] [decimal](7, 2) NULL,
				[vlrNvVrMensal] [decimal](7, 2) NULL,
				[vlrAntVaMensal] [decimal](7, 2) NULL,
				[vlrNvVaMensal] [decimal](7, 2) NULL,
				[vlrAntSeguroSaudeMensal] [decimal](7, 2) NULL,
				[vlrNvSeguroSaudeMensal] [decimal](7, 2) NULL,
				[vlrAntValeAuto] [decimal](7, 2) NULL,
				[vlrNvValeAuto] [decimal](7, 2) NULL,
				[vlrAntEstacionamento] [decimal](7, 2) NULL,
				[vlrNvEstacionamento] [decimal](7, 2) NULL,
				[vlrAntValeTransporte] [decimal](7, 2) NULL,
				[vlrNvValeTransporte] [decimal](7, 2) NULL,
				[vlrAntLiquidoComBeneficios] [decimal](7, 2) NULL,
				[vlrNvLiquidoComBeneficios] [decimal](7, 2) NULL,
				[vlrAntAnualLiquido] [decimal](7, 2) NULL,
				[vlrNvAnualLiquido] [decimal](7, 2) NULL,
				[vlrAntParticipacaoLucrosOuBonus] [decimal](7, 2) NULL,
				[vlrNvParticipacaoLucrosOuBonus] [decimal](7, 2) NULL,
				[vlrAntTotalAnualLiquidoComBeneficios] [decimal](7, 2) NULL,
				[vlrNvTotalAnualNvLiquidoComBeneficios] [decimal](7, 2) NULL,
				[cmProposta] [varchar](300) NULL,
				[flSituacao] [bit] NULL,
				[antDsOutros1] [nchar](50) NULL,
				[antVlrOutros1] [decimal](7,2) NULL,
				[antDsOutros2] [nchar](50) NULL,
				[antVlrOutros2] [decimal](7,2) NULL,
				[antDsOutros3] [nchar](50) NULL,
				[antVlrOutros3] [decimal](7,2) NULL,
				[nvDsOutros1] [nchar](50) NULL,
				[nvVlrOutros1] [decimal](7,2) NULL,
				[nvDsOutros2] [nchar](50) NULL,
				[nvVlrOutros2] [decimal](7,2) NULL,
				[nvDsOutros3] [nchar](50) NULL,
				[nvVlrOutros3] [decimal](7,2) NULL
			 CONSTRAINT [PK_tbProposta1] PRIMARY KEY CLUSTERED 
			(
				[idProposta] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbProva](
				[idProva] [int] IDENTITY(1,1) NOT NULL,
				[nmProva] [varchar](100) NULL,
			 CONSTRAINT [PK_tbProva] PRIMARY KEY CLUSTERED 
			(
				[idProva] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbProvaCandidato](
				[idProvaCandidato] [int] IDENTITY(1,1) NOT NULL,
				[idCandidato] [int] NULL,
				[idProva] [int] NULL,
				[idVaga] [int] NULL,
				[cmProva] [nvarchar](300) NULL,
			 CONSTRAINT [PK_tbProvaCandidato] PRIMARY KEY CLUSTERED 
			(
				[idProvaCandidato] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbSenioridade](
				[idSenioridade] [int] IDENTITY(1,1) NOT NULL,
				[nmSenioridade] [varchar](20) NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idSenioridade] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbSituacaoAtual](
				[idSituacaoAtual] [int] IDENTITY(1,1) NOT NULL,
				[nmSituacaoAtual] [varchar](50) NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idSituacaoAtual] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbStatus](
				[idStatus] [int] NOT NULL,
				[nmStatus] [varchar](50) NULL,
				[tpCss] [varchar](100) NULL,
				[idTpStatus] [int] NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idStatus] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbStatusCandidato](
				[idStatusCandidato] [int] IDENTITY(1,1) NOT NULL,
				[idStatus] [int] NULL,
				[idCandidato] [int] NULL,
				[dtAlteracao] [datetime] NULL,
				[dsParecer] [varchar](500) NULL,
				[idUsuario] [int] NULL,
				[flSituacao] [bit] NULL,
				[idCancelamento] [int] NULL,
				[dsCancelamento] [varchar](300) NULL,
				[nmVaga] [varchar](100) NULL,
				[idVaga] [int] NULL,
			 CONSTRAINT [PK__tbStatus__9D0E13172F5355D0] PRIMARY KEY CLUSTERED 
			(
				[idStatusCandidato] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbStatusDisponivel](
				[idStatusHabilitado] [int] IDENTITY(1,1) NOT NULL,
				[idStatus] [int] NULL,
				[idStatusDisponivel] [int] NULL,
				[nmOpcao] [varchar](50) NULL,
				[nmClasse] [varchar](50) NULL,
			 CONSTRAINT [PK_tbStatusDisponivel1] PRIMARY KEY CLUSTERED 
			(
				[idStatusHabilitado] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbStatusFuturo](
				[id] [int] IDENTITY(1,1) NOT NULL,
				[idStatus] [int] NULL,
				[idStatusFuturo] [int] NULL,
			 CONSTRAINT [PK_tbStatusFuturo] PRIMARY KEY CLUSTERED 
			(
				[id] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbStatusVaga](
				[idStatusVaga] [int] IDENTITY(1,1) NOT NULL,
				[idStatus] [int] NULL,
				[dtAlteracao] [datetime] NULL,
				[idVaga] [int] NULL,
				[idUsuario] [int] NULL,
				[flSituacao] [bit] NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idStatusVaga] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbTipoCurso](
				[idTipoCurso] [int] IDENTITY(1,1) NOT NULL,
				[nmTipoCurso] [varchar](56) NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idTipoCurso] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbTpStatus](
				[idTpStatus] [int] IDENTITY(1,1) NOT NULL,
				[nmTpStatus] [varchar](50) NULL,
			PRIMARY KEY CLUSTERED 
			(
				[idTpStatus] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbUsuario](
				[idUsuario] [int] IDENTITY(1,1) NOT NULL,
				[idPerfil] [int] NULL,
				[idFuncionario] [int] NULL,
				[nmUsuario] [varchar](200) NULL,
				[senha] [varchar](max) NULL CONSTRAINT [def_senha]  DEFAULT ('verity@123'),
				[email] [varchar](50) NULL,
				[flPrimeiroAcesso] [bit] NULL CONSTRAINT [def_primeiroAcesso]  DEFAULT ((1)),
				[ativo] [bit] NULL,
			 CONSTRAINT [PK__tbUsuari__645723A6C77113D0] PRIMARY KEY CLUSTERED 
			(
				[idUsuario] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

			CREATE TABLE [dbo].[tbVaga](
				[idVaga] [int] IDENTITY(1,1) NOT NULL,
				[idProjeto] [int] NULL,
				[idCargo] [int] NULL,
				[idSenioridade] [int] NULL,
				[idUsuario] [int] NULL,
				[nmSolicitante] [varchar](50) NULL,
				[vlPretensaoMin] [decimal](9, 0) NULL,
				[vlPretensaoMax] [decimal](9, 0) NULL,
				[dtInicio] [date] NULL,
				[flLocalTrabalho] [char](1) NULL,
				[idTpVaga] [char](1) NULL,
				[flAumentoQuadra] [char](1) NULL,
				[nmSubstituido] [varchar](50) NULL,
				[dsFormacaoAcademica] [varchar](2000) NULL,
				[dsPerfilComportamental] [varchar](2000) NULL,
				[dsPerfilTecnico] [varchar](2000) NULL,
				[dtAbertura] [date] NULL CONSTRAINT [DF_tbVaga_dtAbertura]  DEFAULT (getdate()),
				[dtAprovacao] [date] NULL,
				[dtFechamento] [date] NULL,
				[nmVaga] [varchar](50) NULL,
				[hrEntrada] [time](0) NULL,
				[hrSaida] [time](0) NULL,
				[nmResponsavel] [varchar](30) NULL,
				[nmAreaResponsavel] [varchar](30) NULL,
				[emailResponsavel] [varchar](50) NULL,
				[telResponsavel] [varchar](20) NULL,
				[dsMarketingSocial] [varchar](8000) NULL,
			 CONSTRAINT [PK__tbVaga__02E6F4AA7CB2B6C6] PRIMARY KEY CLUSTERED 
			(
				[idVaga] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]

			CREATE TABLE [dbo].[tbVagaCandidato](
				[idVagaCandidato] [int] IDENTITY(1,1) NOT NULL,
				[idVaga] [int] NULL,
				[idCandidato] [int] NULL,
				[idCanalInformacao] [int] NULL,
				[contratado] [bit] NULL,
				[dsOutros] [varchar](100) NULL,
				[idFuncionario] [int] NULL,
				[situacao] [bit] NULL
			PRIMARY KEY CLUSTERED 
			(
				[idVagaCandidato] ASC
			)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
			) ON [PRIMARY]
			ALTER TABLE [dbo].[tbVagaCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK__tbVagaCan__idCan__534D60F1] FOREIGN KEY([idCandidato])
			REFERENCES [dbo].[tbCandidato] ([idCandidato])
			ON DELETE CASCADE
			

			ALTER TABLE [dbo].[tbVagaCandidato] CHECK CONSTRAINT [FK__tbVagaCan__idCan__534D60F1]
			

			ALTER TABLE [dbo].[tbVagaCandidato]  WITH NOCHECK ADD FOREIGN KEY([idCanalInformacao])
			REFERENCES [dbo].[tbCanalInformacao] ([idCanalInformacao])
			

			ALTER TABLE [dbo].[tbVagaCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK__tbVagaCan__idVag__52593CB8] FOREIGN KEY([idVaga])
			REFERENCES [dbo].[tbVaga] ([idVaga])
			

			ALTER TABLE [dbo].[tbVagaCandidato] CHECK CONSTRAINT [FK__tbVagaCan__idVag__52593CB8]
			

			ALTER TABLE [dbo].[tbVagaCandidato]  WITH CHECK ADD  CONSTRAINT [fk_funcionario] FOREIGN KEY([idFuncionario])
			REFERENCES [dbo].[tbFuncionario] ([idFuncionario])
			

			ALTER TABLE [dbo].[tbVagaCandidato] CHECK CONSTRAINT [fk_funcionario]
			

			ALTER TABLE [dbo].[tbAvaliadorCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK_tbAvaliadorCandidato_tbCandidato] FOREIGN KEY([idCandidato])
			REFERENCES [dbo].[tbCandidato] ([idCandidato])
			

			ALTER TABLE [dbo].[tbAvaliadorCandidato] CHECK CONSTRAINT [FK_tbAvaliadorCandidato_tbCandidato]
			

			ALTER TABLE [dbo].[tbAvaliadorCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK_tbAvaliadorCandidato_tbStatus] FOREIGN KEY([idStatus])
			REFERENCES [dbo].[tbStatus] ([idStatus])
			

			ALTER TABLE [dbo].[tbAvaliadorCandidato] CHECK CONSTRAINT [FK_tbAvaliadorCandidato_tbStatus]
			

			ALTER TABLE [dbo].[tbAvaliadorCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK_tbAvaliadorCandidato_tbUsuario] FOREIGN KEY([idUsuario])
			REFERENCES [dbo].[tbUsuario] ([idUsuario])
			

			ALTER TABLE [dbo].[tbAvaliadorCandidato] CHECK CONSTRAINT [FK_tbAvaliadorCandidato_tbUsuario]
			

			ALTER TABLE [dbo].[tbAvaliadorCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK_tbAvaliadorCandidato_tbVaga] FOREIGN KEY([idVaga])
			REFERENCES [dbo].[tbVaga] ([idVaga])
			

			ALTER TABLE [dbo].[tbAvaliadorCandidato] CHECK CONSTRAINT [FK_tbAvaliadorCandidato_tbVaga]
			


			ALTER TABLE [dbo].[tbAvaliadorVaga]  WITH NOCHECK ADD  CONSTRAINT [FK_tbAvaliadorVaga_tbUsuario] FOREIGN KEY([idUsuario])
			REFERENCES [dbo].[tbUsuario] ([idUsuario])
			

			ALTER TABLE [dbo].[tbAvaliadorVaga] CHECK CONSTRAINT [FK_tbAvaliadorVaga_tbUsuario]
			

			ALTER TABLE [dbo].[tbAvaliadorVaga]  WITH NOCHECK ADD  CONSTRAINT [FK_tbAvaliadorVaga_tbVaga] FOREIGN KEY([idVaga])
			REFERENCES [dbo].[tbVaga] ([idVaga])
			

			ALTER TABLE [dbo].[tbAvaliadorVaga] CHECK CONSTRAINT [FK_tbAvaliadorVaga_tbVaga]
			


			ALTER TABLE [dbo].[tbCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK__tbCandida__idEnd__4AB81AF0] FOREIGN KEY([idEndereco])
			REFERENCES [dbo].[tbEndereco] ([idEndereco])
			

			ALTER TABLE [dbo].[tbCandidato] CHECK CONSTRAINT [FK__tbCandida__idEnd__4AB81AF0]
			

			ALTER TABLE [dbo].[tbCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK__tbCandida__idFor__4BAC3F29] FOREIGN KEY([idFormacao])
			REFERENCES [dbo].[tbFormacao] ([idFormacao])
			

			ALTER TABLE [dbo].[tbCandidato] CHECK CONSTRAINT [FK__tbCandida__idFor__4BAC3F29]
			

			ALTER TABLE [dbo].[tbCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK__tbCandida__idUsu__4CA06362] FOREIGN KEY([idUsuario])
			REFERENCES [dbo].[tbUsuario] ([idUsuario])
			

			ALTER TABLE [dbo].[tbCandidato] CHECK CONSTRAINT [FK__tbCandida__idUsu__4CA06362]
			

			ALTER TABLE [dbo].[tbCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK_tbCandidato_tbContato] FOREIGN KEY([idContato])
			REFERENCES [dbo].[tbContato] ([idContato])
			

			ALTER TABLE [dbo].[tbCandidato] CHECK CONSTRAINT [FK_tbCandidato_tbContato]
			

			ALTER TABLE [dbo].[tbCandidatoCompetencia]  WITH CHECK ADD FOREIGN KEY([idAvaliacao])
			REFERENCES [dbo].[tbAvaliacao] ([idAvaliacao])
			

			ALTER TABLE [dbo].[tbCandidatoCompetencia]  WITH CHECK ADD  CONSTRAINT [FK__tbCandida__idCan__0D44F85C] FOREIGN KEY([idCandidato])
			REFERENCES [dbo].[tbCandidato] ([idCandidato])
			ON DELETE CASCADE
			

			ALTER TABLE [dbo].[tbCandidatoCompetencia] CHECK CONSTRAINT [FK__tbCandida__idCan__0D44F85C]
			

			ALTER TABLE [dbo].[tbCandidatoCompetencia]  WITH CHECK ADD FOREIGN KEY([idCompetencia])
			REFERENCES [dbo].[tbCompetencia] ([idCompetencia])
			


			ALTER TABLE [dbo].[tbCargoSenioridade]  WITH CHECK ADD  CONSTRAINT [FK__tbCargoSe__idCar__5CD6CB2B] FOREIGN KEY([idCargo])
			REFERENCES [dbo].[tbCargo] ([idCargo])
			

			ALTER TABLE [dbo].[tbCargoSenioridade] CHECK CONSTRAINT [FK__tbCargoSe__idCar__5CD6CB2B]
			

			ALTER TABLE [dbo].[tbCargoSenioridade]  WITH CHECK ADD  CONSTRAINT [FK__tbCargoSe__idSen__5DCAEF64] FOREIGN KEY([idSenioridade])
			REFERENCES [dbo].[tbSenioridade] ([idSenioridade])
			

			ALTER TABLE [dbo].[tbCargoSenioridade] CHECK CONSTRAINT [FK__tbCargoSe__idSen__5DCAEF64]
			

			ALTER TABLE [dbo].[tbComparativoProposta]  WITH CHECK ADD  CONSTRAINT [FK_tbComparativoProposta_tbProposta] FOREIGN KEY([idProposta])
			REFERENCES [dbo].[tbProposta] ([idProposta])
			

			ALTER TABLE [dbo].[tbComparativoProposta] CHECK CONSTRAINT [FK_tbComparativoProposta_tbProposta]
			

			ALTER TABLE [dbo].[tbComunicacao]  WITH CHECK ADD FOREIGN KEY([idCandidato])
			REFERENCES [dbo].[tbCandidato] ([idCandidato])
			

			ALTER TABLE [dbo].[tbComunicacao]  WITH CHECK ADD FOREIGN KEY([idUsuario])
			REFERENCES [dbo].[tbUsuario] ([idUsuario])
			


			ALTER TABLE [dbo].[tbDataEntrevista]  WITH CHECK ADD  CONSTRAINT [FK_tbDataEntrevista_tbCandidato] FOREIGN KEY([idCandidato])
			REFERENCES [dbo].[tbCandidato] ([idCandidato])
			

			ALTER TABLE [dbo].[tbDataEntrevista] CHECK CONSTRAINT [FK_tbDataEntrevista_tbCandidato]
			

			ALTER TABLE [dbo].[tbDataEntrevista]  WITH CHECK ADD  CONSTRAINT [FK_tbDataEntrevista_tbUsuario] FOREIGN KEY([idUsuario])
			REFERENCES [dbo].[tbUsuario] ([idUsuario])
			

			ALTER TABLE [dbo].[tbDataEntrevista] CHECK CONSTRAINT [FK_tbDataEntrevista_tbUsuario]
			

			ALTER TABLE [dbo].[tbDataEntrevista]  WITH CHECK ADD  CONSTRAINT [FK_tbDataEntrevista_tbVaga] FOREIGN KEY([idVaga])
			REFERENCES [dbo].[tbVaga] ([idVaga])
			

			ALTER TABLE [dbo].[tbDataEntrevista] CHECK CONSTRAINT [FK_tbDataEntrevista_tbVaga]
			

			ALTER TABLE [dbo].[tbFormacao]  WITH CHECK ADD FOREIGN KEY([idSituacaoAtual])
			REFERENCES [dbo].[tbSituacaoAtual] ([idSituacaoAtual])
			

			ALTER TABLE [dbo].[tbFormacao]  WITH CHECK ADD FOREIGN KEY([idTipoCurso])
			REFERENCES [dbo].[tbTipoCurso] ([idTipoCurso])
			

			ALTER TABLE [dbo].[tbFuncionario]  WITH CHECK ADD FOREIGN KEY([idCargo])
			REFERENCES [dbo].[tbCargo] ([idCargo])
			

			ALTER TABLE [dbo].[tbFuncionario]  WITH CHECK ADD FOREIGN KEY([idSenioridade])
			REFERENCES [dbo].[tbSenioridade] ([idSenioridade])
			
			ALTER TABLE [dbo].[tbPerfilFuncionalidade]  WITH CHECK ADD FOREIGN KEY([idFuncionalidade])
			REFERENCES [dbo].[tbFuncionalidade] ([idFuncionalidade])
			

			ALTER TABLE [dbo].[tbPerfilFuncionalidade]  WITH CHECK ADD FOREIGN KEY([idPerfil])
			REFERENCES [dbo].[tbPerfil] ([idPerfil])
			

			ALTER TABLE [dbo].[tbProjeto]  WITH CHECK ADD FOREIGN KEY([idCliente])
			REFERENCES [dbo].[tbCliente] ([idCliente])
			

			ALTER TABLE [dbo].[tbProjeto]  WITH CHECK ADD FOREIGN KEY([idFuncionario])
			REFERENCES [dbo].[tbFuncionario] ([idFuncionario])
			

			ALTER TABLE [dbo].[tbProposta]  WITH CHECK ADD  CONSTRAINT [FK_tbProposta_tbCandidato] FOREIGN KEY([idCandidato])
			REFERENCES [dbo].[tbCandidato] ([idCandidato])
			

			ALTER TABLE [dbo].[tbProposta] CHECK CONSTRAINT [FK_tbProposta_tbCandidato]
			

			ALTER TABLE [dbo].[tbProvaCandidato]  WITH CHECK ADD  CONSTRAINT [FK_tbProvaCandidato_tbCandidato] FOREIGN KEY([idCandidato])
			REFERENCES [dbo].[tbCandidato] ([idCandidato])
			

			ALTER TABLE [dbo].[tbProvaCandidato] CHECK CONSTRAINT [FK_tbProvaCandidato_tbCandidato]
			

			ALTER TABLE [dbo].[tbProvaCandidato]  WITH CHECK ADD  CONSTRAINT [FK_tbProvaCandidato_tbProva] FOREIGN KEY([idProva])
			REFERENCES [dbo].[tbProva] ([idProva])
			

			ALTER TABLE [dbo].[tbProvaCandidato] CHECK CONSTRAINT [FK_tbProvaCandidato_tbProva]
			
			ALTER TABLE [dbo].[tbStatusCandidato]  WITH CHECK ADD  CONSTRAINT [FK__tbStatusC__idCan__571DF1D5] FOREIGN KEY([idCandidato])
			REFERENCES [dbo].[tbCandidato] ([idCandidato])
			ON DELETE CASCADE
			

			ALTER TABLE [dbo].[tbStatusCandidato] CHECK CONSTRAINT [FK__tbStatusC__idCan__571DF1D5]
			

			ALTER TABLE [dbo].[tbStatusCandidato]  WITH CHECK ADD  CONSTRAINT [FK__tbStatusC__idSta__5629CD9C] FOREIGN KEY([idStatus])
			REFERENCES [dbo].[tbStatus] ([idStatus])
			

			ALTER TABLE [dbo].[tbStatusCandidato] CHECK CONSTRAINT [FK__tbStatusC__idSta__5629CD9C]
			

			ALTER TABLE [dbo].[tbStatusCandidato]  WITH CHECK ADD  CONSTRAINT [FK__tbStatusC__idUsu__11158940] FOREIGN KEY([idUsuario])
			REFERENCES [dbo].[tbUsuario] ([idUsuario])
			

			ALTER TABLE [dbo].[tbStatusCandidato] CHECK CONSTRAINT [FK__tbStatusC__idUsu__11158940]
			
			ALTER TABLE [dbo].[tbStatusFuturo]  WITH CHECK ADD  CONSTRAINT [FK_tbStatusFuturo_tbStatus] FOREIGN KEY([idStatus])
			REFERENCES [dbo].[tbStatus] ([idStatus])
			

			ALTER TABLE [dbo].[tbStatusFuturo] CHECK CONSTRAINT [FK_tbStatusFuturo_tbStatus]
			

			ALTER TABLE [dbo].[tbStatusVaga]  WITH NOCHECK ADD FOREIGN KEY([idStatus])
			REFERENCES [dbo].[tbStatus] ([idStatus])
			

			ALTER TABLE [dbo].[tbStatusVaga]  WITH NOCHECK ADD  CONSTRAINT [FK_tbStatusVaga_tbUsuario] FOREIGN KEY([idUsuario])
			REFERENCES [dbo].[tbUsuario] ([idUsuario])
			

			ALTER TABLE [dbo].[tbStatusVaga] CHECK CONSTRAINT [FK_tbStatusVaga_tbUsuario]
			

			ALTER TABLE [dbo].[tbStatusVaga]  WITH NOCHECK ADD  CONSTRAINT [FK_tbStatusVaga_tbVaga] FOREIGN KEY([idVaga])
			REFERENCES [dbo].[tbVaga] ([idVaga])
			

			ALTER TABLE [dbo].[tbStatusVaga] CHECK CONSTRAINT [FK_tbStatusVaga_tbVaga]
			
			ALTER TABLE [dbo].[tbUsuario]  WITH CHECK ADD  CONSTRAINT [FK__tbUsuario__idFun__24927208] FOREIGN KEY([idFuncionario])
			REFERENCES [dbo].[tbFuncionario] ([idFuncionario])
			

			ALTER TABLE [dbo].[tbUsuario] CHECK CONSTRAINT [FK__tbUsuario__idFun__24927208]
			

			ALTER TABLE [dbo].[tbUsuario]  WITH CHECK ADD  CONSTRAINT [FK__tbUsuario__idPer__239E4DCF] FOREIGN KEY([idPerfil])
			REFERENCES [dbo].[tbPerfil] ([idPerfil])
			

			ALTER TABLE [dbo].[tbUsuario] CHECK CONSTRAINT [FK__tbUsuario__idPer__239E4DCF]
			

			ALTER TABLE [dbo].[tbVaga]  WITH NOCHECK ADD  CONSTRAINT [FK__tbVaga__idCargo__286302EC] FOREIGN KEY([idCargo])
			REFERENCES [dbo].[tbCargo] ([idCargo])
			

			ALTER TABLE [dbo].[tbVaga] CHECK CONSTRAINT [FK__tbVaga__idCargo__286302EC]
			

			ALTER TABLE [dbo].[tbVaga]  WITH NOCHECK ADD  CONSTRAINT [FK__tbVaga__idProjet__276EDEB3] FOREIGN KEY([idProjeto])
			REFERENCES [dbo].[tbProjeto] ([idProjeto])
			

			ALTER TABLE [dbo].[tbVaga] CHECK CONSTRAINT [FK__tbVaga__idProjet__276EDEB3]
			

			ALTER TABLE [dbo].[tbVaga]  WITH NOCHECK ADD  CONSTRAINT [FK__tbVaga__idSenior__29572725] FOREIGN KEY([idSenioridade])
			REFERENCES [dbo].[tbSenioridade] ([idSenioridade])
			

			ALTER TABLE [dbo].[tbVaga] CHECK CONSTRAINT [FK__tbVaga__idSenior__29572725]
			

			ALTER TABLE [dbo].[tbVaga]  WITH NOCHECK ADD  CONSTRAINT [FK__tbVaga__idUsuari__2A4B4B5E] FOREIGN KEY([idUsuario])
			REFERENCES [dbo].[tbUsuario] ([idUsuario])
			

			ALTER TABLE [dbo].[tbVaga] CHECK CONSTRAINT [FK__tbVaga__idUsuari__2A4B4B5E]

			ALTER TABLE [dbo].[tbCandidatoCompetencia]  WITH NOCHECK ADD  CONSTRAINT [FK__tbCandidatoCompetencia__idVaga__] FOREIGN KEY([idVaga])
			REFERENCES [dbo].[tbVaga] ([idVaga])

			ALTER TABLE [dbo].[tbComunicacao]  WITH NOCHECK ADD  CONSTRAINT [FK__tbComunicacao__idVaga__] FOREIGN KEY([idVaga])
			REFERENCES [dbo].[tbVaga] ([idVaga])

			ALTER TABLE [dbo].[tbProvaCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK__tbProvaCandidato__idVaga__] FOREIGN KEY([idVaga])
			REFERENCES [dbo].[tbVaga] ([idVaga])
			        
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