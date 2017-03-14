USE [Prosperity]
GO
/****** Object:  Table [dbo].[tbCandidato]    Script Date: 14/03/2017 14:24:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbCandidato](
	[idCandidato] [int] NOT NULL,
	[cpf] [varchar](50) NOT NULL,
	[idEndereco] [int] NULL,
	[idFormacao] [int] NULL,
	[idContato] [int] NULL,
	[nmCandidato] [varchar](100) NULL,
	[rg] [varchar](20) NULL,
	[dtNascimento] [date] NULL,
	[vlPretensao] [decimal](18, 0) NULL,
	[dtFechamento] [date] NULL,
	[cmCurriculo] [varchar](200) NULL,
	[nmEmail] [varchar](45) NULL,
	[idUsuario] [int] NULL,
	[dtAlteracao] [date] NULL,
	[dtUltimoContato] [date] NULL,
	[dtEntrevista] [date] NULL,
	[dsProposta] [varchar](8000) NULL,
	[dtAbertura] [date] NULL,
 CONSTRAINT [PK__tbCandid__F84D9A3C83E0F730] PRIMARY KEY CLUSTERED 
(
	[idCandidato] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbCargo]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbCargo](
	[idCargo] [int] IDENTITY(1,1) NOT NULL,
	[nmCargo] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idCargo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbCargoSenioridade]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbCargoSenioridade](
	[idCargoSenioridade] [int] IDENTITY(1,1) NOT NULL,
	[idCargo] [int] NULL,
	[idSenioridade] [int] NULL,
	[vlMinSalario] [decimal](18, 0) NULL,
	[vlMaxSalario] [decimal](18, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[idCargoSenioridade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbCliente]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbCliente](
	[idCliente] [int] IDENTITY(1,1) NOT NULL,
	[nmCliente] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbCompetencias]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbCompetencias](
	[idCompetencias] [int] IDENTITY(1,1) NOT NULL,
	[idCandidato] [int] NULL,
	[compDesenvolvimento] [numeric](18, 0) NULL,
	[compProfundidade] [numeric](18, 0) NULL,
	[compPlanejamento] [numeric](18, 0) NULL,
	[compExecucaoEntrega] [numeric](18, 0) NULL,
	[compRelacionamento] [numeric](18, 0) NULL,
	[compPessoas] [numeric](18, 0) NULL,
	[compComercial] [numeric](18, 0) NULL,
	[compFinanceiro] [numeric](18, 0) NULL,
	[dsParecer] [varchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[idCompetencias] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbContato]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbContato](
	[idContato] [int] IDENTITY(1,1) NOT NULL,
	[telefone] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idContato] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbEndereco]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbEndereco](
	[idEndereco] [int] IDENTITY(1,1) NOT NULL,
	[cep] [varchar](10) NULL,
	[vlNumero] [int] NULL,
	[dsComplemento] [varchar](10) NULL,
	[nmEstado] [varchar](45) NULL,
	[nmLogradouro] [varchar](45) NULL,
	[nmCidade] [varchar](45) NULL,
PRIMARY KEY CLUSTERED 
(
	[idEndereco] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TbExample]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TbExample](
	[idExample] [int] IDENTITY(1,1) NOT NULL,
	[cpf] [varchar](50) NOT NULL,
	[nmExample] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[idExample] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbFormacao]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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

GO
/****** Object:  Table [dbo].[tbFuncionalidade]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbFuncionalidade](
	[idFuncionalidade] [int] IDENTITY(1,1) NOT NULL,
	[nmFuncionalidade] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idFuncionalidade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbFuncionario]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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

GO
/****** Object:  Table [dbo].[tbPerfil]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbPerfil](
	[idPerfil] [int] IDENTITY(1,1) NOT NULL,
	[nmPerfil] [varchar](45) NULL,
PRIMARY KEY CLUSTERED 
(
	[idPerfil] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbPerfilFuncionalidade]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbPerfilFuncionalidade](
	[idPerfilFuncionalidade] [int] IDENTITY(1,1) NOT NULL,
	[idPerfil] [int] NULL,
	[idFuncionalidade] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idPerfilFuncionalidade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbProjeto]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbProjeto](
	[idProjeto] [int] IDENTITY(1,1) NOT NULL,
	[nmProjeto] [varchar](100) NULL,
	[idFuncionario] [int] NULL,
	[idCliente] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idProjeto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbRelatorio]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbRelatorio](
	[idRelatorio] [int] IDENTITY(1,1) NOT NULL,
	[nmRelatorio] [varchar](100) NULL,
	[cmRelatorio] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[idRelatorio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbSenioridade]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbSenioridade](
	[idSenioridade] [int] IDENTITY(1,1) NOT NULL,
	[nmSenioridade] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[idSenioridade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbSituacaoAtual]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbSituacaoAtual](
	[idSituacaoAtual] [int] IDENTITY(1,1) NOT NULL,
	[nmSituacaoAtual] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idSituacaoAtual] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbStatus]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbStatus](
	[idStatus] [int] IDENTITY(1,1) NOT NULL,
	[nmStatus] [varchar](50) NULL,
	[tpCss] [varchar](100) NULL,
	[idTpStatus] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idStatus] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbStatusCandidato]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbStatusCandidato](
	[idStatusCandidato] [int] IDENTITY(1,1) NOT NULL,
	[idStatus] [int] NULL,
	[idCandidato] [int] NULL,
	[dtAlteracao] [date] NULL,
	[dsParecer] [varchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[idStatusCandidato] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbStatusVaga]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbStatusVaga](
	[idStatusVaga] [int] IDENTITY(1,1) NOT NULL,
	[idStatus] [int] NULL,
	[idVaga] [int] NULL,
	[dtAlteracao] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[idStatusVaga] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbTipoCurso]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbTipoCurso](
	[idTipoCurso] [int] IDENTITY(1,1) NOT NULL,
	[nmTipoCurso] [varchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[idTipoCurso] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbTpStatus]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbTpStatus](
	[idTpStatus] [int] IDENTITY(1,1) NOT NULL,
	[nmTpStatus] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idTpStatus] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbUsuario]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbUsuario](
	[idUsuario] [int] IDENTITY(1,1) NOT NULL,
	[idPerfil] [int] NULL,
	[idFuncionario] [int] NULL,
	[nmUsuario] [varchar](200) NULL,
	[senha] [varchar](max) NULL,
	[email] [varchar](50) NULL,
	[flPrimeiroAcesso] [bit] NULL,
	[ativo] [bit] NULL,
 CONSTRAINT [PK__tbUsuari__645723A6C77113D0] PRIMARY KEY CLUSTERED 
(
	[idUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbVaga]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbVaga](
	[idVaga] [int] IDENTITY(1,1) NOT NULL,
	[idProjeto] [int] NULL,
	[idCargo] [int] NULL,
	[idSenioridade] [int] NULL,
	[idUsuario] [int] NULL,
	[nmSolicitante] [varchar](50) NULL,
	[vlPretensao] [decimal](18, 0) NULL,
	[dtInicio] [date] NULL,
	[flLocalTrabalho] [char](1) NULL,
	[idTpVaga] [char](1) NULL,
	[hrEntrada] [date] NULL,
	[hrSaida] [date] NULL,
	[flAumentoQuadra] [char](1) NULL,
	[numCandidatos] [int] NULL,
	[nmSubstituido] [varchar](50) NULL,
	[dsFormacaoAcademica] [varchar](300) NULL,
	[dsPerfilComportamental] [varchar](300) NULL,
	[dsPerfilTecnico] [varchar](300) NULL,
	[dtAbertura] [date] NULL,
	[dtAprovacao] [date] NULL,
	[dtFechamento] [date] NULL,
	[nmVaga] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idVaga] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbVagaCandidato]    Script Date: 14/03/2017 14:24:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbVagaCandidato](
	[idVagaCandidato] [int] IDENTITY(1,1) NOT NULL,
	[idVaga] [int] NULL,
	[idCandidato] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idVagaCandidato] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[tbCandidato] ([idCandidato], [cpf], [idEndereco], [idFormacao], [idContato], [nmCandidato], [rg], [dtNascimento], [vlPretensao], [dtFechamento], [cmCurriculo], [nmEmail], [idUsuario], [dtAlteracao], [dtUltimoContato], [dtEntrevista], [dsProposta], [dtAbertura]) VALUES (2, N'38210505866', 1, 1, 1, N'Vitor Tadashi', N'123456789', CAST(N'1991-08-03' AS Date), CAST(100000 AS Decimal(18, 0)), NULL, NULL, N'vitor.tadashi@verity.com.br', NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[tbCandidato] ([idCandidato], [cpf], [idEndereco], [idFormacao], [idContato], [nmCandidato], [rg], [dtNascimento], [vlPretensao], [dtFechamento], [cmCurriculo], [nmEmail], [idUsuario], [dtAlteracao], [dtUltimoContato], [dtEntrevista], [dsProposta], [dtAbertura]) VALUES (3, N'38748842877', 2, 4, 2, N'André Posman', N'452967314', CAST(N'1994-02-15' AS Date), CAST(1100 AS Decimal(18, 0)), NULL, NULL, N'andre.posman@verity.com.br', NULL, NULL, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[tbCargo] ON 

INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (1, N'Analista de Requisitos ')
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (2, N'Analista de Sistemas e Inovação ')
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (3, N'Analista Teste')
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (4, N'Scrum Master')
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (5, N'Banco de talentos Analista de Sistemas')
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (6, N'Banco de talentos Administrativo e Financeiro')
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (7, N'Banco de talentos Gestão de Configuração')
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (8, N'Banco de talentos de Infraestrutura')
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (9, N'Banco de Talentos Recursos Humanos ')
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (10, N'Desenvolvedor .NET')
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (11, N'Desenvolvedor Java')
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (12, N'Desenvolvedor Java Liferay')
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (13, N'Gerente de Operações ')
SET IDENTITY_INSERT [dbo].[tbCargo] OFF
SET IDENTITY_INSERT [dbo].[tbCliente] ON 

INSERT [dbo].[tbCliente] ([idCliente], [nmCliente]) VALUES (1, N'claudinho')
SET IDENTITY_INSERT [dbo].[tbCliente] OFF
SET IDENTITY_INSERT [dbo].[tbContato] ON 

INSERT [dbo].[tbContato] ([idContato], [telefone]) VALUES (1, N'191')
INSERT [dbo].[tbContato] ([idContato], [telefone]) VALUES (2, N'11971245006')
SET IDENTITY_INSERT [dbo].[tbContato] OFF
SET IDENTITY_INSERT [dbo].[tbEndereco] ON 

INSERT [dbo].[tbEndereco] ([idEndereco], [cep], [vlNumero], [dsComplemento], [nmEstado], [nmLogradouro], [nmCidade]) VALUES (1, N'04024444', 111, N'apt. 1000', N'SP', N'Av. Faria Lima', N'São Paulo')
INSERT [dbo].[tbEndereco] ([idEndereco], [cep], [vlNumero], [dsComplemento], [nmEstado], [nmLogradouro], [nmCidade]) VALUES (2, N'05027000', 1155, N'apt. 42', N'SP', N'Dr. Miranda de Azevedo', N'São Paulo')
SET IDENTITY_INSERT [dbo].[tbEndereco] OFF
SET IDENTITY_INSERT [dbo].[tbFormacao] ON 

INSERT [dbo].[tbFormacao] ([idFormacao], [nmInstituicao], [dtConclusao], [idTipoCurso], [idSituacaoAtual], [nmCurso]) VALUES (1, N'FIAP', CAST(N'2020-12-01' AS Date), 5, 1, N'Massagem')
INSERT [dbo].[tbFormacao] ([idFormacao], [nmInstituicao], [dtConclusao], [idTipoCurso], [idSituacaoAtual], [nmCurso]) VALUES (4, N'FIAP', CAST(N'2017-12-01' AS Date), 5, 2, N'Engenharia da Computação')
SET IDENTITY_INSERT [dbo].[tbFormacao] OFF
SET IDENTITY_INSERT [dbo].[tbFuncionalidade] ON 

INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade]) VALUES (1, N'Aprovar vaga')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade]) VALUES (2, N'Alterar candidato')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade]) VALUES (3, N'Cadastrar usuário')
SET IDENTITY_INSERT [dbo].[tbFuncionalidade] OFF
SET IDENTITY_INSERT [dbo].[tbFuncionario] ON 

INSERT [dbo].[tbFuncionario] ([idFuncionario], [nmFuncionario], [idCargo], [idSenioridade]) VALUES (6, N'João dos Santos', 1, 1)
INSERT [dbo].[tbFuncionario] ([idFuncionario], [nmFuncionario], [idCargo], [idSenioridade]) VALUES (7, N'Felipe Leitão da Silva', NULL, NULL)
INSERT [dbo].[tbFuncionario] ([idFuncionario], [nmFuncionario], [idCargo], [idSenioridade]) VALUES (8, N'Stephen Knupfer', 11, 3)
SET IDENTITY_INSERT [dbo].[tbFuncionario] OFF
SET IDENTITY_INSERT [dbo].[tbPerfil] ON 

INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (1, N'Administrador')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (2, N'RH')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (3, N'Gestor Administrativo')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (4, N'CEO')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (5, N'Gestor de Desenvolvimento')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (6, N'Gestor de Testes')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (7, N'Gestor de Projetos')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (8, N'Arquiteto')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (9, N'Diretor de Operação')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (11, N'test')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (15, N'teste2aaaaaaaaaa')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (24, N'testando')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (25, N'Daniel')
SET IDENTITY_INSERT [dbo].[tbPerfil] OFF
SET IDENTITY_INSERT [dbo].[tbPerfilFuncionalidade] ON 

INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (1, 1, 1)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (2, 2, 3)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (5, 11, 1)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (6, 11, 2)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (7, 11, 3)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (12, 15, 1)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (13, 15, 2)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (14, 15, 3)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (16, 24, 1)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (17, 24, 2)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (18, 25, 1)
SET IDENTITY_INSERT [dbo].[tbPerfilFuncionalidade] OFF
SET IDENTITY_INSERT [dbo].[tbProjeto] ON 

INSERT [dbo].[tbProjeto] ([idProjeto], [nmProjeto], [idFuncionario], [idCliente]) VALUES (2, N'P20160603_001 - Implementação de Conteúdo - Portal de Cartões', NULL, NULL)
INSERT [dbo].[tbProjeto] ([idProjeto], [nmProjeto], [idFuncionario], [idCliente]) VALUES (3, N'P20161114_002 - Homologação do Clock Work - Equipe de Crédito - Fase 2', NULL, NULL)
SET IDENTITY_INSERT [dbo].[tbProjeto] OFF
SET IDENTITY_INSERT [dbo].[tbSenioridade] ON 

INSERT [dbo].[tbSenioridade] ([idSenioridade], [nmSenioridade]) VALUES (1, N'Junior')
INSERT [dbo].[tbSenioridade] ([idSenioridade], [nmSenioridade]) VALUES (2, N'Pleno')
INSERT [dbo].[tbSenioridade] ([idSenioridade], [nmSenioridade]) VALUES (3, N'Senior')
SET IDENTITY_INSERT [dbo].[tbSenioridade] OFF
SET IDENTITY_INSERT [dbo].[tbSituacaoAtual] ON 

INSERT [dbo].[tbSituacaoAtual] ([idSituacaoAtual], [nmSituacaoAtual]) VALUES (1, N'Concluido')
INSERT [dbo].[tbSituacaoAtual] ([idSituacaoAtual], [nmSituacaoAtual]) VALUES (2, N'Cursando')
INSERT [dbo].[tbSituacaoAtual] ([idSituacaoAtual], [nmSituacaoAtual]) VALUES (3, N'Interrompido')
SET IDENTITY_INSERT [dbo].[tbSituacaoAtual] OFF
SET IDENTITY_INSERT [dbo].[tbTipoCurso] ON 

INSERT [dbo].[tbTipoCurso] ([idTipoCurso], [nmTipoCurso]) VALUES (1, N'Ensino Fundamental')
INSERT [dbo].[tbTipoCurso] ([idTipoCurso], [nmTipoCurso]) VALUES (3, N'Ensino Médio Fundamental')
INSERT [dbo].[tbTipoCurso] ([idTipoCurso], [nmTipoCurso]) VALUES (4, N'Técnico ')
INSERT [dbo].[tbTipoCurso] ([idTipoCurso], [nmTipoCurso]) VALUES (5, N'Graduação')
INSERT [dbo].[tbTipoCurso] ([idTipoCurso], [nmTipoCurso]) VALUES (6, N'Técnologo')
INSERT [dbo].[tbTipoCurso] ([idTipoCurso], [nmTipoCurso]) VALUES (7, N'Pós Graduação')
INSERT [dbo].[tbTipoCurso] ([idTipoCurso], [nmTipoCurso]) VALUES (8, N'MBA')
INSERT [dbo].[tbTipoCurso] ([idTipoCurso], [nmTipoCurso]) VALUES (9, N'Mestrado')
INSERT [dbo].[tbTipoCurso] ([idTipoCurso], [nmTipoCurso]) VALUES (10, N'Doutorado')
SET IDENTITY_INSERT [dbo].[tbTipoCurso] OFF
SET IDENTITY_INSERT [dbo].[tbUsuario] ON 

INSERT [dbo].[tbUsuario] ([idUsuario], [idPerfil], [idFuncionario], [nmUsuario], [senha], [email], [flPrimeiroAcesso], [ativo]) VALUES (1, 1, 7, N'admin', N'usa', N'admin@admin.com', 1, 1)
INSERT [dbo].[tbUsuario] ([idUsuario], [idPerfil], [idFuncionario], [nmUsuario], [senha], [email], [flPrimeiroAcesso], [ativo]) VALUES (4, 1, 8, N'hackerzaum_da_zonasul', N'dmVyaXR5QDEyMw==', N'stephen.knupfer@verity.com.br', 1, 1)
INSERT [dbo].[tbUsuario] ([idUsuario], [idPerfil], [idFuncionario], [nmUsuario], [senha], [email], [flPrimeiroAcesso], [ativo]) VALUES (5, 7, 6, N'joao.santos', N'dmVyaXR5QDEyMw==', N'joao.santos@verity.com.br', 1, 1)
INSERT [dbo].[tbUsuario] ([idUsuario], [idPerfil], [idFuncionario], [nmUsuario], [senha], [email], [flPrimeiroAcesso], [ativo]) VALUES (6, 2, 8, N'teste', N'dmVyaXR5QDEyMw==', N'teste@teste.com', 1, NULL)
SET IDENTITY_INSERT [dbo].[tbUsuario] OFF
SET IDENTITY_INSERT [dbo].[tbVaga] ON 

INSERT [dbo].[tbVaga] ([idVaga], [idProjeto], [idCargo], [idSenioridade], [idUsuario], [nmSolicitante], [vlPretensao], [dtInicio], [flLocalTrabalho], [idTpVaga], [hrEntrada], [hrSaida], [flAumentoQuadra], [numCandidatos], [nmSubstituido], [dsFormacaoAcademica], [dsPerfilComportamental], [dsPerfilTecnico], [dtAbertura], [dtAprovacao], [dtFechamento], [nmVaga]) VALUES (8, 2, 2, 2, 1, N'Vitor Tadashi', CAST(1100 AS Decimal(18, 0)), CAST(N'1998-07-29' AS Date), N'B', N'A', CAST(N'2017-03-13' AS Date), CAST(N'2017-03-13' AS Date), N'C', 40, N'Yuri', N'Sistemas de Informação', N'Muito educado e comunicativo', N'Não possui muito conhecimento', CAST(N'2017-01-12' AS Date), CAST(N'2017-03-03' AS Date), CAST(N'2017-03-04' AS Date), N'Analista Pleno')
SET IDENTITY_INSERT [dbo].[tbVaga] OFF
ALTER TABLE [dbo].[tbUsuario] ADD  CONSTRAINT [def_senha]  DEFAULT ('verity@123') FOR [senha]
GO
ALTER TABLE [dbo].[tbUsuario] ADD  CONSTRAINT [def_primeiroAcesso]  DEFAULT ((1)) FOR [flPrimeiroAcesso]
GO
ALTER TABLE [dbo].[tbCandidato]  WITH CHECK ADD  CONSTRAINT [FK__tbCandida__idEnd__4AB81AF0] FOREIGN KEY([idEndereco])
REFERENCES [dbo].[tbEndereco] ([idEndereco])
GO
ALTER TABLE [dbo].[tbCandidato] CHECK CONSTRAINT [FK__tbCandida__idEnd__4AB81AF0]
GO
ALTER TABLE [dbo].[tbCandidato]  WITH CHECK ADD  CONSTRAINT [FK__tbCandida__idFor__4BAC3F29] FOREIGN KEY([idFormacao])
REFERENCES [dbo].[tbFormacao] ([idFormacao])
GO
ALTER TABLE [dbo].[tbCandidato] CHECK CONSTRAINT [FK__tbCandida__idFor__4BAC3F29]
GO
ALTER TABLE [dbo].[tbCandidato]  WITH CHECK ADD  CONSTRAINT [FK__tbCandida__idUsu__4CA06362] FOREIGN KEY([idUsuario])
REFERENCES [dbo].[tbUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[tbCandidato] CHECK CONSTRAINT [FK__tbCandida__idUsu__4CA06362]
GO
ALTER TABLE [dbo].[tbCandidato]  WITH CHECK ADD  CONSTRAINT [FK_tbCandidato_tbContato] FOREIGN KEY([idContato])
REFERENCES [dbo].[tbContato] ([idContato])
GO
ALTER TABLE [dbo].[tbCandidato] CHECK CONSTRAINT [FK_tbCandidato_tbContato]
GO
ALTER TABLE [dbo].[tbCargoSenioridade]  WITH CHECK ADD FOREIGN KEY([idCargo])
REFERENCES [dbo].[tbCargo] ([idCargo])
GO
ALTER TABLE [dbo].[tbCargoSenioridade]  WITH CHECK ADD FOREIGN KEY([idSenioridade])
REFERENCES [dbo].[tbSenioridade] ([idSenioridade])
GO
ALTER TABLE [dbo].[tbCompetencias]  WITH CHECK ADD  CONSTRAINT [FK__tbCompete__idCan__160F4887] FOREIGN KEY([idCandidato])
REFERENCES [dbo].[tbCandidato] ([idCandidato])
GO
ALTER TABLE [dbo].[tbCompetencias] CHECK CONSTRAINT [FK__tbCompete__idCan__160F4887]
GO
ALTER TABLE [dbo].[tbFormacao]  WITH CHECK ADD FOREIGN KEY([idSituacaoAtual])
REFERENCES [dbo].[tbSituacaoAtual] ([idSituacaoAtual])
GO
ALTER TABLE [dbo].[tbFormacao]  WITH CHECK ADD FOREIGN KEY([idTipoCurso])
REFERENCES [dbo].[tbTipoCurso] ([idTipoCurso])
GO
ALTER TABLE [dbo].[tbFuncionario]  WITH CHECK ADD FOREIGN KEY([idCargo])
REFERENCES [dbo].[tbCargo] ([idCargo])
GO
ALTER TABLE [dbo].[tbFuncionario]  WITH CHECK ADD FOREIGN KEY([idSenioridade])
REFERENCES [dbo].[tbSenioridade] ([idSenioridade])
GO
ALTER TABLE [dbo].[tbPerfilFuncionalidade]  WITH CHECK ADD FOREIGN KEY([idFuncionalidade])
REFERENCES [dbo].[tbFuncionalidade] ([idFuncionalidade])
GO
ALTER TABLE [dbo].[tbPerfilFuncionalidade]  WITH CHECK ADD FOREIGN KEY([idPerfil])
REFERENCES [dbo].[tbPerfil] ([idPerfil])
GO
ALTER TABLE [dbo].[tbProjeto]  WITH CHECK ADD FOREIGN KEY([idCliente])
REFERENCES [dbo].[tbCliente] ([idCliente])
GO
ALTER TABLE [dbo].[tbProjeto]  WITH CHECK ADD FOREIGN KEY([idFuncionario])
REFERENCES [dbo].[tbFuncionario] ([idFuncionario])
GO
ALTER TABLE [dbo].[tbStatus]  WITH CHECK ADD FOREIGN KEY([idTpStatus])
REFERENCES [dbo].[tbTpStatus] ([idTpStatus])
GO
ALTER TABLE [dbo].[tbStatusCandidato]  WITH CHECK ADD  CONSTRAINT [FK__tbStatusC__idCan__571DF1D5] FOREIGN KEY([idCandidato])
REFERENCES [dbo].[tbCandidato] ([idCandidato])
GO
ALTER TABLE [dbo].[tbStatusCandidato] CHECK CONSTRAINT [FK__tbStatusC__idCan__571DF1D5]
GO
ALTER TABLE [dbo].[tbStatusCandidato]  WITH CHECK ADD FOREIGN KEY([idStatus])
REFERENCES [dbo].[tbStatus] ([idStatus])
GO
ALTER TABLE [dbo].[tbStatusVaga]  WITH CHECK ADD FOREIGN KEY([idStatus])
REFERENCES [dbo].[tbStatus] ([idStatus])
GO
ALTER TABLE [dbo].[tbStatusVaga]  WITH CHECK ADD FOREIGN KEY([idVaga])
REFERENCES [dbo].[tbVaga] ([idVaga])
GO
ALTER TABLE [dbo].[tbUsuario]  WITH CHECK ADD  CONSTRAINT [FK__tbUsuario__idFun__24927208] FOREIGN KEY([idFuncionario])
REFERENCES [dbo].[tbFuncionario] ([idFuncionario])
GO
ALTER TABLE [dbo].[tbUsuario] CHECK CONSTRAINT [FK__tbUsuario__idFun__24927208]
GO
ALTER TABLE [dbo].[tbUsuario]  WITH CHECK ADD  CONSTRAINT [FK__tbUsuario__idPer__239E4DCF] FOREIGN KEY([idPerfil])
REFERENCES [dbo].[tbPerfil] ([idPerfil])
GO
ALTER TABLE [dbo].[tbUsuario] CHECK CONSTRAINT [FK__tbUsuario__idPer__239E4DCF]
GO
ALTER TABLE [dbo].[tbVaga]  WITH CHECK ADD FOREIGN KEY([idCargo])
REFERENCES [dbo].[tbCargo] ([idCargo])
GO
ALTER TABLE [dbo].[tbVaga]  WITH CHECK ADD FOREIGN KEY([idProjeto])
REFERENCES [dbo].[tbProjeto] ([idProjeto])
GO
ALTER TABLE [dbo].[tbVaga]  WITH CHECK ADD FOREIGN KEY([idSenioridade])
REFERENCES [dbo].[tbSenioridade] ([idSenioridade])
GO
ALTER TABLE [dbo].[tbVaga]  WITH CHECK ADD  CONSTRAINT [FK__tbVaga__idUsuari__2A4B4B5E] FOREIGN KEY([idUsuario])
REFERENCES [dbo].[tbUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[tbVaga] CHECK CONSTRAINT [FK__tbVaga__idUsuari__2A4B4B5E]
GO
ALTER TABLE [dbo].[tbVagaCandidato]  WITH CHECK ADD  CONSTRAINT [FK__tbVagaCan__idCan__534D60F1] FOREIGN KEY([idCandidato])
REFERENCES [dbo].[tbCandidato] ([idCandidato])
GO
ALTER TABLE [dbo].[tbVagaCandidato] CHECK CONSTRAINT [FK__tbVagaCan__idCan__534D60F1]
GO
ALTER TABLE [dbo].[tbVagaCandidato]  WITH CHECK ADD FOREIGN KEY([idVaga])
REFERENCES [dbo].[tbVaga] ([idVaga])
GO
