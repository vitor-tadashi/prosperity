USE [Prosperity]
GO
/****** Object:  Table [dbo].[tbAvaliacao]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbAvaliacao](
	[idAvaliacao] [int] IDENTITY(1,1) NOT NULL,
	[nmAvaliacao] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[idAvaliacao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbAvaliadorCandidato]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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

GO
/****** Object:  Table [dbo].[tbAvaliadorVaga]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbAvaliadorVaga](
	[idAvaliadorVaga] [int] IDENTITY(1,1) NOT NULL,
	[idUsuario] [int] NULL,
	[idVaga] [int] NULL,
 CONSTRAINT [PK_tbAvaliadorVaga] PRIMARY KEY CLUSTERED 
(
	[idAvaliadorVaga] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbCanalInformacao]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbCanalInformacao](
	[idCanalInformacao] [int] IDENTITY(1,1) NOT NULL,
	[nmCanalInformacao] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[idCanalInformacao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbCandidato]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
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
	[dtFechamento] [date] NULL,
	[cmCurriculo] [varchar](200) NULL,
	[nmEmail] [varchar](45) NULL,
	[idUsuario] [int] NULL,
	[dtAlteracao] [date] NULL,
	[dtUltimoContato] [date] NULL,
	[dtEntrevista] [date] NULL,
	[dsProposta] [varchar](8000) NULL,
	[dtAbertura] [date] NULL,
	[curriculoTexto] [varchar](max) NULL,
 CONSTRAINT [PK__tbCandid__F84D9A3C83E0F730] PRIMARY KEY CLUSTERED 
(
	[idCandidato] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbCandidatoCompetencia]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbCandidatoCompetencia](
	[idCandidatoCompetencia] [int] IDENTITY(1,1) NOT NULL,
	[idAvaliacao] [int] NULL,
	[idCandidato] [int] NULL,
	[idCompetencia] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idCandidatoCompetencia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbCargo]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbCargoSenioridade]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbCargoSenioridade](
	[idCargoSenioridade] [int] IDENTITY(1,1) NOT NULL,
	[idCargo] [int] NULL,
	[idSenioridade] [int] NULL,
	[vlMinSalario] [smallmoney] NULL,
	[vlMaxSalario] [smallmoney] NULL,
 CONSTRAINT [PK__tbCargoS__52D447EA8F8D8611] PRIMARY KEY CLUSTERED 
(
	[idCargoSenioridade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbCliente]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbCompetencia]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbCompetencia](
	[idCompetencia] [int] IDENTITY(1,1) NOT NULL,
	[nmCompetencia] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[idCompetencia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbContato]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbEndereco]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
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

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TbExample]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbFormacao]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbFuncionalidade]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbFuncionalidade](
	[idFuncionalidade] [int] IDENTITY(1,1) NOT NULL,
	[nmFuncionalidade] [varchar](50) NULL,
	[url] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idFuncionalidade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbFuncionario]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbPerfil]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbPerfilFuncionalidade]    Script Date: 27/04/2017 20:22:49 ******/
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
/****** Object:  Table [dbo].[tbProjeto]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
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

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbProva]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbProva](
	[idProva] [int] IDENTITY(1,1) NOT NULL,
	[nmProva] [varchar](100) NULL,
 CONSTRAINT [PK_tbProva] PRIMARY KEY CLUSTERED 
(
	[idProva] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbProvaCandidato]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbProvaCandidato](
	[idProvaCandidato] [int] IDENTITY(1,1) NOT NULL,
	[idCandidato] [int] NULL,
	[idProva] [int] NULL,
	[dsProva] [nvarchar](50) NULL,
 CONSTRAINT [PK_tbProvaCandidato] PRIMARY KEY CLUSTERED 
(
	[idProvaCandidato] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbRelatorio]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbSenioridade]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbSituacaoAtual]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbStatus]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbStatusCandidato]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbStatusCandidato](
	[idStatusCandidato] [int] IDENTITY(1,1) NOT NULL,
	[idStatus] [int] NULL,
	[idCandidato] [int] NULL,
	[dtAlteracao] [datetime] NULL,
	[dsParecer] [varchar](500) NULL,
	[idUsuario] [int] NULL,
	[proposta] [varchar](8000) NULL,
	[flSituacao] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[idStatusCandidato] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbStatusDisponivel]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
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

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbStatusFuturo]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbStatusFuturo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idStatus] [int] NULL,
	[idStatusFuturo] [int] NULL,
 CONSTRAINT [PK_tbStatusFuturo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbStatusVaga]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
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

GO
/****** Object:  Table [dbo].[tbTipoCurso]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbTipoCurso](
	[idTipoCurso] [int] IDENTITY(1,1) NOT NULL,
	[nmTipoCurso] [varchar](56) NULL,
PRIMARY KEY CLUSTERED 
(
	[idTipoCurso] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbTpStatus]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbUsuario]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
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

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbVaga]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
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
	[flAumentoQuadra] [char](1) NULL,
	[numCandidatos] [int] NULL,
	[nmSubstituido] [varchar](50) NULL,
	[dsFormacaoAcademica] [varchar](600) NULL,
	[dsPerfilComportamental] [varchar](600) NULL,
	[dsPerfilTecnico] [varchar](600) NULL,
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
 CONSTRAINT [PK__tbVaga__02E6F4AA7CB2B6C6] PRIMARY KEY CLUSTERED 
(
	[idVaga] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbVagaCandidato]    Script Date: 27/04/2017 20:22:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbVagaCandidato](
	[idVagaCandidato] [int] IDENTITY(1,1) NOT NULL,
	[idVaga] [int] NULL,
	[idCandidato] [int] NULL,
	[idCanalInformacao] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idVagaCandidato] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[tbAvaliacao] ON 

INSERT [dbo].[tbAvaliacao] ([idAvaliacao], [nmAvaliacao]) VALUES (1, N'Insatisfatório')
INSERT [dbo].[tbAvaliacao] ([idAvaliacao], [nmAvaliacao]) VALUES (2, N'Em desenvolvimento')
INSERT [dbo].[tbAvaliacao] ([idAvaliacao], [nmAvaliacao]) VALUES (3, N'Atende as expectativas')
INSERT [dbo].[tbAvaliacao] ([idAvaliacao], [nmAvaliacao]) VALUES (4, N'Supera as expectativas')
SET IDENTITY_INSERT [dbo].[tbAvaliacao] OFF
SET IDENTITY_INSERT [dbo].[tbAvaliadorCandidato] ON 

INSERT [dbo].[tbAvaliadorCandidato] ([id], [idCandidato], [idVaga], [idUsuario], [idStatus]) VALUES (3316, 56, 3284, 1041, 17)
INSERT [dbo].[tbAvaliadorCandidato] ([id], [idCandidato], [idVaga], [idUsuario], [idStatus]) VALUES (3317, 56, 3284, 1042, 17)
INSERT [dbo].[tbAvaliadorCandidato] ([id], [idCandidato], [idVaga], [idUsuario], [idStatus]) VALUES (3318, 57, 3284, 1041, 9)
INSERT [dbo].[tbAvaliadorCandidato] ([id], [idCandidato], [idVaga], [idUsuario], [idStatus]) VALUES (3319, 57, 3284, 1042, 6)
INSERT [dbo].[tbAvaliadorCandidato] ([id], [idCandidato], [idVaga], [idUsuario], [idStatus]) VALUES (3326, 61, 3284, 1041, 6)
INSERT [dbo].[tbAvaliadorCandidato] ([id], [idCandidato], [idVaga], [idUsuario], [idStatus]) VALUES (3327, 61, 3284, 1042, 9)
INSERT [dbo].[tbAvaliadorCandidato] ([id], [idCandidato], [idVaga], [idUsuario], [idStatus]) VALUES (3328, 63, 3285, 1040, NULL)
INSERT [dbo].[tbAvaliadorCandidato] ([id], [idCandidato], [idVaga], [idUsuario], [idStatus]) VALUES (3329, 63, 3285, 1041, NULL)
INSERT [dbo].[tbAvaliadorCandidato] ([id], [idCandidato], [idVaga], [idUsuario], [idStatus]) VALUES (3330, 64, 3285, 1040, NULL)
INSERT [dbo].[tbAvaliadorCandidato] ([id], [idCandidato], [idVaga], [idUsuario], [idStatus]) VALUES (3331, 64, 3285, 1041, NULL)
SET IDENTITY_INSERT [dbo].[tbAvaliadorCandidato] OFF
SET IDENTITY_INSERT [dbo].[tbAvaliadorVaga] ON 

INSERT [dbo].[tbAvaliadorVaga] ([idAvaliadorVaga], [idUsuario], [idVaga]) VALUES (3227, 1041, 3284)
INSERT [dbo].[tbAvaliadorVaga] ([idAvaliadorVaga], [idUsuario], [idVaga]) VALUES (3228, 1042, 3284)
INSERT [dbo].[tbAvaliadorVaga] ([idAvaliadorVaga], [idUsuario], [idVaga]) VALUES (3230, 1040, 3288)
INSERT [dbo].[tbAvaliadorVaga] ([idAvaliadorVaga], [idUsuario], [idVaga]) VALUES (3231, 1040, 3285)
INSERT [dbo].[tbAvaliadorVaga] ([idAvaliadorVaga], [idUsuario], [idVaga]) VALUES (3232, 1041, 3285)
SET IDENTITY_INSERT [dbo].[tbAvaliadorVaga] OFF
SET IDENTITY_INSERT [dbo].[tbCanalInformacao] ON 

INSERT [dbo].[tbCanalInformacao] ([idCanalInformacao], [nmCanalInformacao]) VALUES (2, N'Site Verity')
INSERT [dbo].[tbCanalInformacao] ([idCanalInformacao], [nmCanalInformacao]) VALUES (3, N'Facebook')
INSERT [dbo].[tbCanalInformacao] ([idCanalInformacao], [nmCanalInformacao]) VALUES (4, N'Linkedin')
INSERT [dbo].[tbCanalInformacao] ([idCanalInformacao], [nmCanalInformacao]) VALUES (5, N'Apinfo')
INSERT [dbo].[tbCanalInformacao] ([idCanalInformacao], [nmCanalInformacao]) VALUES (6, N'Catho')
INSERT [dbo].[tbCanalInformacao] ([idCanalInformacao], [nmCanalInformacao]) VALUES (7, N'Outros sites de oportunidades')
INSERT [dbo].[tbCanalInformacao] ([idCanalInformacao], [nmCanalInformacao]) VALUES (8, N'Indicação de colegas')
INSERT [dbo].[tbCanalInformacao] ([idCanalInformacao], [nmCanalInformacao]) VALUES (9, N'Outros')
SET IDENTITY_INSERT [dbo].[tbCanalInformacao] OFF
SET IDENTITY_INSERT [dbo].[tbCandidato] ON 

INSERT [dbo].[tbCandidato] ([idCandidato], [cpf], [idEndereco], [idFormacao], [idContato], [nmCandidato], [rg], [dtNascimento], [vlPretensao], [dtFechamento], [cmCurriculo], [nmEmail], [idUsuario], [dtAlteracao], [dtUltimoContato], [dtEntrevista], [dsProposta], [dtAbertura], [curriculoTexto]) VALUES (56, N'43060925852', 11872, 11843, 10880, N'Fabio Vilani Peres', N'377961383', CAST(N'1992-12-12' AS Date), 100000.0000, NULL, N'', N'fabio.peres@verity.com.br', NULL, NULL, NULL, NULL, NULL, CAST(N'2017-04-27' AS Date), NULL)
INSERT [dbo].[tbCandidato] ([idCandidato], [cpf], [idEndereco], [idFormacao], [idContato], [nmCandidato], [rg], [dtNascimento], [vlPretensao], [dtFechamento], [cmCurriculo], [nmEmail], [idUsuario], [dtAlteracao], [dtUltimoContato], [dtEntrevista], [dsProposta], [dtAbertura], [curriculoTexto]) VALUES (57, N'67239510859', 11873, 11844, 10881, N'Homão', N'103714433', CAST(N'1956-12-21' AS Date), 3000.0000, NULL, N'', N'homao@homao', NULL, NULL, NULL, NULL, NULL, CAST(N'2017-04-27' AS Date), NULL)
INSERT [dbo].[tbCandidato] ([idCandidato], [cpf], [idEndereco], [idFormacao], [idContato], [nmCandidato], [rg], [dtNascimento], [vlPretensao], [dtFechamento], [cmCurriculo], [nmEmail], [idUsuario], [dtAlteracao], [dtUltimoContato], [dtEntrevista], [dsProposta], [dtAbertura], [curriculoTexto]) VALUES (61, N'47864489079', 11877, 11848, 10885, N'Evelin souza', N'255503945', CAST(N'1997-06-15' AS Date), 1500.0000, NULL, N'', N'evelin.souza@email.com', NULL, NULL, CAST(N'2017-05-10' AS Date), CAST(N'2017-05-11' AS Date), NULL, CAST(N'2017-04-27' AS Date), NULL)
INSERT [dbo].[tbCandidato] ([idCandidato], [cpf], [idEndereco], [idFormacao], [idContato], [nmCandidato], [rg], [dtNascimento], [vlPretensao], [dtFechamento], [cmCurriculo], [nmEmail], [idUsuario], [dtAlteracao], [dtUltimoContato], [dtEntrevista], [dsProposta], [dtAbertura], [curriculoTexto]) VALUES (62, N'73264824892', 11878, 11849, 10886, N'Ademilton pires', N'360515976', CAST(N'1970-06-18' AS Date), 5000.0000, NULL, N'', N'ademilton.pires@email.com', NULL, NULL, CAST(N'2017-04-12' AS Date), CAST(N'2017-04-13' AS Date), NULL, CAST(N'2017-04-27' AS Date), NULL)
INSERT [dbo].[tbCandidato] ([idCandidato], [cpf], [idEndereco], [idFormacao], [idContato], [nmCandidato], [rg], [dtNascimento], [vlPretensao], [dtFechamento], [cmCurriculo], [nmEmail], [idUsuario], [dtAlteracao], [dtUltimoContato], [dtEntrevista], [dsProposta], [dtAbertura], [curriculoTexto]) VALUES (63, N'67239510859', 11879, 11850, 10887, N'João de Barro', N'386092254', CAST(N'2000-12-12' AS Date), 3000.0000, NULL, N'', N'joao@joao.com', NULL, NULL, NULL, NULL, NULL, CAST(N'2017-04-27' AS Date), NULL)
INSERT [dbo].[tbCandidato] ([idCandidato], [cpf], [idEndereco], [idFormacao], [idContato], [nmCandidato], [rg], [dtNascimento], [vlPretensao], [dtFechamento], [cmCurriculo], [nmEmail], [idUsuario], [dtAlteracao], [dtUltimoContato], [dtEntrevista], [dsProposta], [dtAbertura], [curriculoTexto]) VALUES (64, N'45002367836', 11880, 11851, 10888, N'Daniel Ferreira do Valle', N'531277744', CAST(N'1998-01-12' AS Date), 1500.0000, NULL, N'', N'daniel.valle@verity.com.br', NULL, NULL, CAST(N'2017-05-10' AS Date), CAST(N'2017-05-11' AS Date), NULL, CAST(N'2017-04-27' AS Date), NULL)
SET IDENTITY_INSERT [dbo].[tbCandidato] OFF
SET IDENTITY_INSERT [dbo].[tbCandidatoCompetencia] ON 

INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1616, 1, 56, 1)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1617, 1, 56, 2)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1618, 1, 56, 3)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1619, 1, 56, 4)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1620, 1, 56, 5)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1621, 1, 56, 6)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1622, 1, 56, 7)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1623, 2, NULL, 1)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1625, 3, NULL, 2)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1629, 3, NULL, 3)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1633, 3, NULL, 4)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1637, 2, NULL, 5)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1642, 4, NULL, 6)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1647, 4, NULL, 7)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1651, 2, NULL, 1)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1652, 2, NULL, 2)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1653, 2, NULL, 3)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1654, 2, NULL, 4)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1655, 2, NULL, 5)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1656, 2, NULL, 6)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1657, 2, NULL, 7)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1658, 3, 57, 1)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1659, 3, 57, 2)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1660, 4, 57, 3)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1661, 3, 57, 4)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1662, 2, 57, 5)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1663, 2, 57, 6)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1664, 2, 57, 7)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1665, 1, NULL, 1)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1666, 3, NULL, 2)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1667, 3, NULL, 3)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1668, 3, NULL, 4)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1669, 3, NULL, 5)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1670, 4, NULL, 6)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1671, 4, NULL, 7)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1672, 2, 61, 1)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1673, 2, 61, 2)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1674, 2, 61, 3)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1675, 2, 61, 4)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1676, 2, 61, 5)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1677, 2, 61, 6)
INSERT [dbo].[tbCandidatoCompetencia] ([idCandidatoCompetencia], [idAvaliacao], [idCandidato], [idCompetencia]) VALUES (1678, 2, 61, 7)
SET IDENTITY_INSERT [dbo].[tbCandidatoCompetencia] OFF
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
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (14, N'Analista de RH')
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (15, N'Gestor de projetos')
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (16, N'Diretor de operação')
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (17, N'Banco Talentos')
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (18, N'CEO')
INSERT [dbo].[tbCargo] ([idCargo], [nmCargo]) VALUES (19, N'Gestor de teste')
SET IDENTITY_INSERT [dbo].[tbCargo] OFF
SET IDENTITY_INSERT [dbo].[tbCargoSenioridade] ON 

INSERT [dbo].[tbCargoSenioridade] ([idCargoSenioridade], [idCargo], [idSenioridade], [vlMinSalario], [vlMaxSalario]) VALUES (1, 1, 1, 1000.0000, 2000.0000)
INSERT [dbo].[tbCargoSenioridade] ([idCargoSenioridade], [idCargo], [idSenioridade], [vlMinSalario], [vlMaxSalario]) VALUES (2, 1, 2, 2000.0000, 3000.0000)
INSERT [dbo].[tbCargoSenioridade] ([idCargoSenioridade], [idCargo], [idSenioridade], [vlMinSalario], [vlMaxSalario]) VALUES (3, 1, 3, 3000.0000, 4000.0000)
SET IDENTITY_INSERT [dbo].[tbCargoSenioridade] OFF
SET IDENTITY_INSERT [dbo].[tbCliente] ON 

INSERT [dbo].[tbCliente] ([idCliente], [nmCliente]) VALUES (1, N'Carrefour')
INSERT [dbo].[tbCliente] ([idCliente], [nmCliente]) VALUES (2, N'Alelo')
INSERT [dbo].[tbCliente] ([idCliente], [nmCliente]) VALUES (3, N'Dell')
INSERT [dbo].[tbCliente] ([idCliente], [nmCliente]) VALUES (4, N'Teste Batch')
SET IDENTITY_INSERT [dbo].[tbCliente] OFF
SET IDENTITY_INSERT [dbo].[tbCompetencia] ON 

INSERT [dbo].[tbCompetencia] ([idCompetencia], [nmCompetencia]) VALUES (1, N'Desenvolvimento')
INSERT [dbo].[tbCompetencia] ([idCompetencia], [nmCompetencia]) VALUES (2, N'Profundidade')
INSERT [dbo].[tbCompetencia] ([idCompetencia], [nmCompetencia]) VALUES (3, N'Planejamento')
INSERT [dbo].[tbCompetencia] ([idCompetencia], [nmCompetencia]) VALUES (4, N'Execução e entrega')
INSERT [dbo].[tbCompetencia] ([idCompetencia], [nmCompetencia]) VALUES (5, N'Pessoas')
INSERT [dbo].[tbCompetencia] ([idCompetencia], [nmCompetencia]) VALUES (6, N'Comercial')
INSERT [dbo].[tbCompetencia] ([idCompetencia], [nmCompetencia]) VALUES (7, N'Financeiro')
SET IDENTITY_INSERT [dbo].[tbCompetencia] OFF
SET IDENTITY_INSERT [dbo].[tbContato] ON 

INSERT [dbo].[tbContato] ([idContato], [telefone]) VALUES (10880, N'11 997423448')
INSERT [dbo].[tbContato] ([idContato], [telefone]) VALUES (10881, N'11  20380347')
INSERT [dbo].[tbContato] ([idContato], [telefone]) VALUES (10885, N'11   2548996')
INSERT [dbo].[tbContato] ([idContato], [telefone]) VALUES (10886, N'11324487863')
INSERT [dbo].[tbContato] ([idContato], [telefone]) VALUES (10887, N'1120380347')
INSERT [dbo].[tbContato] ([idContato], [telefone]) VALUES (10888, N'11975870053')
SET IDENTITY_INSERT [dbo].[tbContato] OFF
SET IDENTITY_INSERT [dbo].[tbEndereco] ON 

INSERT [dbo].[tbEndereco] ([idEndereco], [cep], [vlNumero], [dsComplemento], [nmEstado], [nmLogradouro], [nmCidade]) VALUES (11872, N'04347-070', 205, N'nenhum parsa', N'SP', N'Rua Itambacuri', N'São Paulo')
INSERT [dbo].[tbEndereco] ([idEndereco], [cep], [vlNumero], [dsComplemento], [nmEstado], [nmLogradouro], [nmCidade]) VALUES (11873, N'03717-001', 3215, N'', N'SP', N'Avenida Doutor Assis Ribeiro', N'São Paulo')
INSERT [dbo].[tbEndereco] ([idEndereco], [cep], [vlNumero], [dsComplemento], [nmEstado], [nmLogradouro], [nmCidade]) VALUES (11877, N'78746-555', 324, N'Casa', N'MT', N'Rua A-17', N'Rondonópolis')
INSERT [dbo].[tbEndereco] ([idEndereco], [cep], [vlNumero], [dsComplemento], [nmEstado], [nmLogradouro], [nmCidade]) VALUES (11878, N'72855-239', 569, N'Casa', N'GO', N'Quadra 239', N'Luziânia')
INSERT [dbo].[tbEndereco] ([idEndereco], [cep], [vlNumero], [dsComplemento], [nmEstado], [nmLogradouro], [nmCidade]) VALUES (11879, N'03717-001', 32, N'q', N'SP', N'Avenida Doutor Assis Ribeiro', N'São Paulo')
INSERT [dbo].[tbEndereco] ([idEndereco], [cep], [vlNumero], [dsComplemento], [nmEstado], [nmLogradouro], [nmCidade]) VALUES (11880, N'08225-220', 159, N'Casa', N'SP', N'Rua Manuel Jorge Correa', N'São Paulo')
SET IDENTITY_INSERT [dbo].[tbEndereco] OFF
SET IDENTITY_INSERT [dbo].[tbFormacao] ON 

INSERT [dbo].[tbFormacao] ([idFormacao], [nmInstituicao], [dtConclusao], [idTipoCurso], [idSituacaoAtual], [nmCurso]) VALUES (11843, N'UNIP', CAST(N'2017-01-01' AS Date), 10, 9, N'Ciências da Computação')
INSERT [dbo].[tbFormacao] ([idFormacao], [nmInstituicao], [dtConclusao], [idTipoCurso], [idSituacaoAtual], [nmCurso]) VALUES (11844, N'uninoia', CAST(N'2019-12-12' AS Date), 7, 9, N'sistemas')
INSERT [dbo].[tbFormacao] ([idFormacao], [nmInstituicao], [dtConclusao], [idTipoCurso], [idSituacaoAtual], [nmCurso]) VALUES (11848, N'EUACH', CAST(N'2018-12-12' AS Date), 7, 9, N'Analise de Sistemas')
INSERT [dbo].[tbFormacao] ([idFormacao], [nmInstituicao], [dtConclusao], [idTipoCurso], [idSituacaoAtual], [nmCurso]) VALUES (11849, N'Impacta treinamentos', CAST(N'2018-06-12' AS Date), 10, 9, N'Gestão de projetos')
INSERT [dbo].[tbFormacao] ([idFormacao], [nmInstituicao], [dtConclusao], [idTipoCurso], [idSituacaoAtual], [nmCurso]) VALUES (11850, N'uninoia', CAST(N'2019-12-12' AS Date), 7, 9, N'CC')
INSERT [dbo].[tbFormacao] ([idFormacao], [nmInstituicao], [dtConclusao], [idTipoCurso], [idSituacaoAtual], [nmCurso]) VALUES (11851, N'Faculdade Impacta Tecnologia', CAST(N'2019-12-12' AS Date), 7, 9, N'Sistemas de informação')
SET IDENTITY_INSERT [dbo].[tbFormacao] OFF
SET IDENTITY_INSERT [dbo].[tbFuncionalidade] ON 

INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade], [url]) VALUES (1, N'Aprovar/Reprovar vaga', N'vaga/aprovar')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade], [url]) VALUES (2, N'Consultar vaga', N'vaga/consultar')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade], [url]) VALUES (3, N'Solicitar vaga', N'vaga/solicitar')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade], [url]) VALUES (16, N'Criar perfil', N'usuario/perfil/gerenciar')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade], [url]) VALUES (17, N'Cadastrar candidato', N'candidato/cadastrar')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade], [url]) VALUES (18, N'Consultar candidato', N'candidato/consultar')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade], [url]) VALUES (21, N'Gerar relatório', N'relatorio')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade], [url]) VALUES (22, N'Criar usuário', N'usuario/gerenciar')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade], [url]) VALUES (23, N'Aprovar/Reprovar proposta', N'colocarUrlAqui')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade], [url]) VALUES (24, N'Informar avaliador', N'colocarUrlAqui')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade], [url]) VALUES (25, N'Aprovar/Reprovar candidato', N'candidato/aprovar')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade], [url]) VALUES (26, N'Gerar proposta', N'colocarUrlAqui')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade], [url]) VALUES (27, N'Analisar candidato', N'colocarUrlAqui')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade], [url]) VALUES (28, N'Refazer proposta', N'colocarUrlAqui')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade], [url]) VALUES (29, N'Cancelar vaga', N'colocarUrlAqui')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade], [url]) VALUES (30, N'Fechar vaga', N'colocarUrlAqui')
INSERT [dbo].[tbFuncionalidade] ([idFuncionalidade], [nmFuncionalidade], [url]) VALUES (31, N'Editar vaga', N'colocarUrlAqui')
SET IDENTITY_INSERT [dbo].[tbFuncionalidade] OFF
SET IDENTITY_INSERT [dbo].[tbFuncionario] ON 

INSERT [dbo].[tbFuncionario] ([idFuncionario], [nmFuncionario], [idCargo], [idSenioridade]) VALUES (17, N'Admin', 1, 1)
INSERT [dbo].[tbFuncionario] ([idFuncionario], [nmFuncionario], [idCargo], [idSenioridade]) VALUES (1017, N'Taiama', 14, 3)
INSERT [dbo].[tbFuncionario] ([idFuncionario], [nmFuncionario], [idCargo], [idSenioridade]) VALUES (1018, N'Vitor Tadashi', 15, 3)
INSERT [dbo].[tbFuncionario] ([idFuncionario], [nmFuncionario], [idCargo], [idSenioridade]) VALUES (1019, N'Vera Tavares', 16, 3)
INSERT [dbo].[tbFuncionario] ([idFuncionario], [nmFuncionario], [idCargo], [idSenioridade]) VALUES (1020, N'Melissa', 14, 1)
INSERT [dbo].[tbFuncionario] ([idFuncionario], [nmFuncionario], [idCargo], [idSenioridade]) VALUES (1021, N'Juliana', 1, 1)
INSERT [dbo].[tbFuncionario] ([idFuncionario], [nmFuncionario], [idCargo], [idSenioridade]) VALUES (1022, N'Alexandro', 18, 1)
INSERT [dbo].[tbFuncionario] ([idFuncionario], [nmFuncionario], [idCargo], [idSenioridade]) VALUES (1023, N'Gabriela', 19, 1)
SET IDENTITY_INSERT [dbo].[tbFuncionario] OFF
SET IDENTITY_INSERT [dbo].[tbPerfil] ON 

INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (1, N'Administrador')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (2, N'Analista de RH')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (3, N'Gestor RH')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (4, N'CEO')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (5, N'Gestor de desenvolvimento')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (6, N'Gestor de testes')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (7, N'Gestor de projetos')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (8, N'Arquiteto')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (9, N'Diretor de operação')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (63, N'Gestor financeiro')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (64, N'Gestor de sustentação')
INSERT [dbo].[tbPerfil] ([idPerfil], [nmPerfil]) VALUES (65, N'Perfil teste')
SET IDENTITY_INSERT [dbo].[tbPerfil] OFF
SET IDENTITY_INSERT [dbo].[tbPerfilFuncionalidade] ON 

INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3821, 5, 2)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3822, 5, 3)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3823, 5, 18)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3824, 5, 25)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3825, 5, 29)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3826, 5, 31)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3827, 7, 2)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3828, 7, 3)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3829, 7, 18)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3830, 7, 25)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3831, 7, 29)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3832, 7, 31)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3833, 8, 25)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3845, 6, 2)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3846, 6, 3)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3847, 6, 18)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3848, 6, 25)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3849, 6, 29)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3850, 6, 31)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3851, 63, 2)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3852, 63, 3)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3853, 63, 18)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3854, 63, 25)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3855, 63, 29)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3856, 63, 31)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3857, 64, 2)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3858, 64, 3)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3859, 64, 18)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3860, 64, 25)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3861, 64, 29)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (3862, 64, 31)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4424, 9, 1)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4425, 9, 2)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4426, 9, 3)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4427, 9, 18)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4428, 9, 21)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4429, 9, 23)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4430, 9, 25)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4431, 9, 31)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4448, 1, 1)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4449, 1, 2)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4450, 1, 3)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4451, 1, 16)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4452, 1, 17)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4453, 1, 18)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4454, 1, 21)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4455, 1, 22)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4456, 1, 23)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4457, 1, 24)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4458, 1, 25)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4459, 1, 26)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4460, 1, 27)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4461, 1, 28)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4462, 1, 29)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4463, 1, 30)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4464, 1, 31)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4551, 4, 1)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4552, 4, 2)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4553, 4, 3)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4554, 4, 18)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4555, 4, 23)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4556, 4, 25)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4557, 4, 27)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4558, 4, 31)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4573, 2, 1)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4574, 2, 2)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4575, 2, 17)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4576, 2, 18)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4577, 2, 21)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4578, 2, 24)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4579, 2, 25)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4580, 2, 26)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4581, 2, 27)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4582, 2, 28)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4583, 2, 29)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4584, 2, 30)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4585, 2, 31)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4586, 65, 1)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4587, 65, 16)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4603, 3, 1)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4604, 3, 2)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4605, 3, 3)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4606, 3, 16)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4607, 3, 17)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4608, 3, 18)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4609, 3, 21)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4610, 3, 22)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4611, 3, 24)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4612, 3, 25)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4613, 3, 26)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4614, 3, 27)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4615, 3, 28)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4616, 3, 29)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4617, 3, 30)
INSERT [dbo].[tbPerfilFuncionalidade] ([idPerfilFuncionalidade], [idPerfil], [idFuncionalidade]) VALUES (4618, 3, 31)
SET IDENTITY_INSERT [dbo].[tbPerfilFuncionalidade] OFF
SET IDENTITY_INSERT [dbo].[tbProjeto] ON 

INSERT [dbo].[tbProjeto] ([idProjeto], [nmProjeto], [idFuncionario], [idCliente], [ativo]) VALUES (1005, N'Projeto Para Teste', 17, 1, 1)
INSERT [dbo].[tbProjeto] ([idProjeto], [nmProjeto], [idFuncionario], [idCliente], [ativo]) VALUES (1006, N'Banco Talentos', 1017, 4, 1)
SET IDENTITY_INSERT [dbo].[tbProjeto] OFF
SET IDENTITY_INSERT [dbo].[tbProva] ON 

INSERT [dbo].[tbProva] ([idProva], [nmProva]) VALUES (1, N'Prova prática')
INSERT [dbo].[tbProva] ([idProva], [nmProva]) VALUES (2, N'Prova teórica')
INSERT [dbo].[tbProva] ([idProva], [nmProva]) VALUES (3, N'Dinâmica de grupo')
SET IDENTITY_INSERT [dbo].[tbProva] OFF
SET IDENTITY_INSERT [dbo].[tbProvaCandidato] ON 

INSERT [dbo].[tbProvaCandidato] ([idProvaCandidato], [idCandidato], [idProva], [dsProva]) VALUES (95, 56, 1, N'Ruim')
INSERT [dbo].[tbProvaCandidato] ([idProvaCandidato], [idCandidato], [idProva], [dsProva]) VALUES (96, 61, 1, N'ok')
INSERT [dbo].[tbProvaCandidato] ([idProvaCandidato], [idCandidato], [idProva], [dsProva]) VALUES (97, 61, 1, N'ok')
INSERT [dbo].[tbProvaCandidato] ([idProvaCandidato], [idCandidato], [idProva], [dsProva]) VALUES (98, 61, 1, N'ok')
INSERT [dbo].[tbProvaCandidato] ([idProvaCandidato], [idCandidato], [idProva], [dsProva]) VALUES (99, 61, 1, N'ok')
INSERT [dbo].[tbProvaCandidato] ([idProvaCandidato], [idCandidato], [idProva], [dsProva]) VALUES (100, 57, 3, N'dinamismo')
INSERT [dbo].[tbProvaCandidato] ([idProvaCandidato], [idCandidato], [idProva], [dsProva]) VALUES (101, 57, 1, N'ok')
INSERT [dbo].[tbProvaCandidato] ([idProvaCandidato], [idCandidato], [idProva], [dsProva]) VALUES (102, 61, 1, N'ok')
INSERT [dbo].[tbProvaCandidato] ([idProvaCandidato], [idCandidato], [idProva], [dsProva]) VALUES (103, 61, 3, N'DINAMISMO')
SET IDENTITY_INSERT [dbo].[tbProvaCandidato] OFF
SET IDENTITY_INSERT [dbo].[tbSenioridade] ON 

INSERT [dbo].[tbSenioridade] ([idSenioridade], [nmSenioridade]) VALUES (1, N'Junior')
INSERT [dbo].[tbSenioridade] ([idSenioridade], [nmSenioridade]) VALUES (2, N'Pleno')
INSERT [dbo].[tbSenioridade] ([idSenioridade], [nmSenioridade]) VALUES (3, N'Senior')
INSERT [dbo].[tbSenioridade] ([idSenioridade], [nmSenioridade]) VALUES (4, N'Desenvolvedor')
INSERT [dbo].[tbSenioridade] ([idSenioridade], [nmSenioridade]) VALUES (5, N'A definir')
SET IDENTITY_INSERT [dbo].[tbSenioridade] OFF
SET IDENTITY_INSERT [dbo].[tbSituacaoAtual] ON 

INSERT [dbo].[tbSituacaoAtual] ([idSituacaoAtual], [nmSituacaoAtual]) VALUES (9, N'Cursando')
INSERT [dbo].[tbSituacaoAtual] ([idSituacaoAtual], [nmSituacaoAtual]) VALUES (1009, N'Concluido')
INSERT [dbo].[tbSituacaoAtual] ([idSituacaoAtual], [nmSituacaoAtual]) VALUES (1010, N'Interrompido ')
SET IDENTITY_INSERT [dbo].[tbSituacaoAtual] OFF
SET IDENTITY_INSERT [dbo].[tbStatus] ON 

INSERT [dbo].[tbStatus] ([idStatus], [nmStatus], [tpCss], [idTpStatus]) VALUES (1, N'Ativo', N'#2ECC71', 2)
INSERT [dbo].[tbStatus] ([idStatus], [nmStatus], [tpCss], [idTpStatus]) VALUES (2, N'Fechado', N'#ed6f02', 2)
INSERT [dbo].[tbStatus] ([idStatus], [nmStatus], [tpCss], [idTpStatus]) VALUES (3, N'Cancelado', N'#CF000F', 2)
INSERT [dbo].[tbStatus] ([idStatus], [nmStatus], [tpCss], [idTpStatus]) VALUES (4, N'Pendente', N'#02b4ea', 2)
INSERT [dbo].[tbStatus] ([idStatus], [nmStatus], [tpCss], [idTpStatus]) VALUES (5, N'Candidatura', N'#03C9A9', 1)
INSERT [dbo].[tbStatus] ([idStatus], [nmStatus], [tpCss], [idTpStatus]) VALUES (6, N'Candidato em análise', N'#e67e22', 1)
INSERT [dbo].[tbStatus] ([idStatus], [nmStatus], [tpCss], [idTpStatus]) VALUES (7, N'Candidato aprovado', N'#2ECC71', 1)
INSERT [dbo].[tbStatus] ([idStatus], [nmStatus], [tpCss], [idTpStatus]) VALUES (8, N'Candidato reprovado', N'#CF000F', 1)
INSERT [dbo].[tbStatus] ([idStatus], [nmStatus], [tpCss], [idTpStatus]) VALUES (9, N'Gerar proposta', N'#03C9A9', 1)
INSERT [dbo].[tbStatus] ([idStatus], [nmStatus], [tpCss], [idTpStatus]) VALUES (10, N'Proposta candidato', N'#03C9A9', 1)
INSERT [dbo].[tbStatus] ([idStatus], [nmStatus], [tpCss], [idTpStatus]) VALUES (11, N'Proposta aceita', N'#2ECC71', 1)
INSERT [dbo].[tbStatus] ([idStatus], [nmStatus], [tpCss], [idTpStatus]) VALUES (13, N'Proposta recusada', N'#CF000F', 1)
INSERT [dbo].[tbStatus] ([idStatus], [nmStatus], [tpCss], [idTpStatus]) VALUES (14, N'Candidato recusou proposta', N'#F9690E', 1)
INSERT [dbo].[tbStatus] ([idStatus], [nmStatus], [tpCss], [idTpStatus]) VALUES (15, N'Contratado', N'#2ECC71', 1)
INSERT [dbo].[tbStatus] ([idStatus], [nmStatus], [tpCss], [idTpStatus]) VALUES (17, N'Cancelado', N'#CF000F', 1)
INSERT [dbo].[tbStatus] ([idStatus], [nmStatus], [tpCss], [idTpStatus]) VALUES (18, N'Reprovado', N'#CF000F', 2)
INSERT [dbo].[tbStatus] ([idStatus], [nmStatus], [tpCss], [idTpStatus]) VALUES (27, N'Pendente de informações', N'#F9690E', 2)
SET IDENTITY_INSERT [dbo].[tbStatus] OFF
SET IDENTITY_INSERT [dbo].[tbStatusCandidato] ON 

INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5088, 5, 56, CAST(N'2017-04-27 18:37:13.450' AS DateTime), NULL, 1043, NULL, 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5089, 5, 57, CAST(N'2017-04-27 19:03:56.383' AS DateTime), NULL, 47, NULL, 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5090, 5, 61, CAST(N'2017-04-27 19:10:11.547' AS DateTime), NULL, 1040, NULL, 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5091, 5, 62, CAST(N'2017-04-27 19:13:47.007' AS DateTime), NULL, 1040, NULL, 1)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5092, 5, 63, CAST(N'2017-04-27 19:54:31.100' AS DateTime), NULL, 1040, NULL, 1)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5093, 5, 64, CAST(N'2017-04-27 19:55:15.717' AS DateTime), NULL, 47, NULL, 1)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5094, 6, 61, CAST(N'2017-04-27 19:59:13.433' AS DateTime), N'dewfwefwefewfwefwefwe', 1040, N'', 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5095, 6, 56, CAST(N'2017-04-27 19:59:37.087' AS DateTime), N'dewwedewdwedewdwed', 1040, N'', 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5096, 6, 57, CAST(N'2017-04-27 20:01:19.577' AS DateTime), N'homao da preula', 1040, N'', 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5097, 8, 56, CAST(N'2017-04-27 20:02:32.820' AS DateTime), N'Candidato reprovado', 1041, N'', 1)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5102, 7, 57, CAST(N'2017-04-27 20:05:51.510' AS DateTime), N'rwasedyfuhojpihygtfrdesydtugyibyticrd6', 1042, N'', 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5103, 6, 57, CAST(N'2017-04-27 20:05:51.550' AS DateTime), NULL, 1042, N'', 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5104, 7, 57, CAST(N'2017-04-27 20:05:55.007' AS DateTime), N'Aprovado', 1041, N'', 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5105, 9, 57, CAST(N'2017-04-27 20:05:55.067' AS DateTime), NULL, 1041, N'', 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5106, 7, 61, CAST(N'2017-04-27 20:09:18.617' AS DateTime), N'Aprovado', 1041, N'', 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5107, 6, 61, CAST(N'2017-04-27 20:09:18.650' AS DateTime), NULL, 1041, N'', 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5108, 7, 61, CAST(N'2017-04-27 20:09:50.897' AS DateTime), N'DVFBGDSCGHGFDSDGNHFDFSGFBNDSZFC', 1042, N'', 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5109, 9, 61, CAST(N'2017-04-27 20:09:50.937' AS DateTime), NULL, 1042, N'', 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5110, 10, 61, CAST(N'2017-04-27 20:10:28.443' AS DateTime), N'deqdqedqedeqdeqd', 1040, N'<p>dqedqedeqdqedqqedq</p>
', 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5111, 10, 57, CAST(N'2017-04-27 20:10:43.537' AS DateTime), N'dqedqedqedqedeqdeq', 1040, N'<p>edddddddddddddddddddddddddddddddq</p>
', 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5112, 11, 57, CAST(N'2017-04-27 20:11:10.303' AS DateTime), N'sfdgfhyjdhgatw\YHZRJSTDKYFLUGFDS', 1042, N'<p>edddddddddddddddddddddddddddddddq</p>
', 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5113, 13, 61, CAST(N'2017-04-27 20:11:20.117' AS DateTime), N'SDZFRSHTYRGSERHRFDJKH,MNGFH', 1042, N'<p>dqedqedeqdqedqqedq</p>
', 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5114, 15, 57, CAST(N'2017-04-27 20:12:00.947' AS DateTime), N'deqqedqedqedq', 1040, N'<p>edddddddddddddddddddddddddddddddq</p>
', 1)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5115, 10, 61, CAST(N'2017-04-27 20:12:15.037' AS DateTime), N'dqwdqwdqwdqwd', 1040, N'<p>dqedqedeqwdqwdqwdqw</p>
', 0)
INSERT [dbo].[tbStatusCandidato] ([idStatusCandidato], [idStatus], [idCandidato], [dtAlteracao], [dsParecer], [idUsuario], [proposta], [flSituacao]) VALUES (5116, 11, 61, CAST(N'2017-04-27 20:12:38.260' AS DateTime), N'895625413259123654512645WF6HNFFWFEA', 1042, N'<p>dqedqedeqwdqwdqwdqw</p>
', 1)
SET IDENTITY_INSERT [dbo].[tbStatusCandidato] OFF
SET IDENTITY_INSERT [dbo].[tbStatusDisponivel] ON 

INSERT [dbo].[tbStatusDisponivel] ([idStatusHabilitado], [idStatus], [idStatusDisponivel], [nmOpcao], [nmClasse]) VALUES (1, 5, 6, N'Enviar para análise', N'class="glyphicon fa fa-check fa-lg"')
INSERT [dbo].[tbStatusDisponivel] ([idStatusHabilitado], [idStatus], [idStatusDisponivel], [nmOpcao], [nmClasse]) VALUES (2, 6, 7, N'Aprovar candidato', N'class="fa fa-check fa-lg"')
INSERT [dbo].[tbStatusDisponivel] ([idStatusHabilitado], [idStatus], [idStatusDisponivel], [nmOpcao], [nmClasse]) VALUES (3, 6, 8, N'Reprovar candidato', N'class="fa fa-times fa-lg"')
INSERT [dbo].[tbStatusDisponivel] ([idStatusHabilitado], [idStatus], [idStatusDisponivel], [nmOpcao], [nmClasse]) VALUES (4, 9, 10, N'Gerar proposta', N'class="fa fa-pencil fa-lg"')
INSERT [dbo].[tbStatusDisponivel] ([idStatusHabilitado], [idStatus], [idStatusDisponivel], [nmOpcao], [nmClasse]) VALUES (5, 10, 11, N'Aprovar proposta', N'class="fa fa-check fa-lg"')
INSERT [dbo].[tbStatusDisponivel] ([idStatusHabilitado], [idStatus], [idStatusDisponivel], [nmOpcao], [nmClasse]) VALUES (6, 10, 13, N'Reprovar proposta', N'class="fa fa-times fa-lg"')
INSERT [dbo].[tbStatusDisponivel] ([idStatusHabilitado], [idStatus], [idStatusDisponivel], [nmOpcao], [nmClasse]) VALUES (7, 11, 14, N'Candidato recusou proposta', N'class="fa fa-times fa-lg"')
INSERT [dbo].[tbStatusDisponivel] ([idStatusHabilitado], [idStatus], [idStatusDisponivel], [nmOpcao], [nmClasse]) VALUES (8, 11, 15, N'Contratar candidato', N'class="fa fa-check fa-lg"')
INSERT [dbo].[tbStatusDisponivel] ([idStatusHabilitado], [idStatus], [idStatusDisponivel], [nmOpcao], [nmClasse]) VALUES (9, 13, 10, N'Refazer proposta', N'class="fa fa-refresh fa-lg"')
INSERT [dbo].[tbStatusDisponivel] ([idStatusHabilitado], [idStatus], [idStatusDisponivel], [nmOpcao], [nmClasse]) VALUES (10, 14, 10, N'Refazer proposta', N'class="fa fa-refresh fa-lg"')
SET IDENTITY_INSERT [dbo].[tbStatusDisponivel] OFF
SET IDENTITY_INSERT [dbo].[tbStatusFuturo] ON 

INSERT [dbo].[tbStatusFuturo] ([id], [idStatus], [idStatusFuturo]) VALUES (30, 7, 6)
INSERT [dbo].[tbStatusFuturo] ([id], [idStatus], [idStatusFuturo]) VALUES (31, 7, 9)
SET IDENTITY_INSERT [dbo].[tbStatusFuturo] OFF
SET IDENTITY_INSERT [dbo].[tbStatusVaga] ON 

INSERT [dbo].[tbStatusVaga] ([idStatusVaga], [idStatus], [dtAlteracao], [idVaga], [idUsuario], [flSituacao]) VALUES (3431, 4, CAST(N'2017-04-27 17:51:51.633' AS DateTime), 3284, 1045, 0)
INSERT [dbo].[tbStatusVaga] ([idStatusVaga], [idStatus], [dtAlteracao], [idVaga], [idUsuario], [flSituacao]) VALUES (3432, 4, CAST(N'2017-04-27 17:52:09.297' AS DateTime), 3285, 1041, 0)
INSERT [dbo].[tbStatusVaga] ([idStatusVaga], [idStatus], [dtAlteracao], [idVaga], [idUsuario], [flSituacao]) VALUES (3433, 27, CAST(N'2017-04-27 18:03:24.867' AS DateTime), 3285, 1042, 0)
INSERT [dbo].[tbStatusVaga] ([idStatusVaga], [idStatus], [dtAlteracao], [idVaga], [idUsuario], [flSituacao]) VALUES (3434, 1, CAST(N'2017-04-27 18:03:26.067' AS DateTime), 3284, 1044, 0)
INSERT [dbo].[tbStatusVaga] ([idStatusVaga], [idStatus], [dtAlteracao], [idVaga], [idUsuario], [flSituacao]) VALUES (3441, 4, CAST(N'2017-04-27 18:03:26.067' AS DateTime), 3286, 47, 0)
INSERT [dbo].[tbStatusVaga] ([idStatusVaga], [idStatus], [dtAlteracao], [idVaga], [idUsuario], [flSituacao]) VALUES (3450, 4, CAST(N'2017-04-27 19:17:53.053' AS DateTime), 3288, 47, 0)
INSERT [dbo].[tbStatusVaga] ([idStatusVaga], [idStatus], [dtAlteracao], [idVaga], [idUsuario], [flSituacao]) VALUES (3452, 4, CAST(N'2017-04-27 19:32:11.383' AS DateTime), 3289, 47, 1)
INSERT [dbo].[tbStatusVaga] ([idStatusVaga], [idStatus], [dtAlteracao], [idVaga], [idUsuario], [flSituacao]) VALUES (3453, 27, CAST(N'2017-04-27 19:33:56.033' AS DateTime), 3286, 47, 1)
INSERT [dbo].[tbStatusVaga] ([idStatusVaga], [idStatus], [dtAlteracao], [idVaga], [idUsuario], [flSituacao]) VALUES (3454, 1, CAST(N'2017-04-27 19:50:41.287' AS DateTime), 3288, 1042, 1)
INSERT [dbo].[tbStatusVaga] ([idStatusVaga], [idStatus], [dtAlteracao], [idVaga], [idUsuario], [flSituacao]) VALUES (3455, 1, CAST(N'2017-04-27 19:51:37.370' AS DateTime), 3285, 1043, 0)
INSERT [dbo].[tbStatusVaga] ([idStatusVaga], [idStatus], [dtAlteracao], [idVaga], [idUsuario], [flSituacao]) VALUES (3458, 3, CAST(N'2017-04-27 20:10:31.940' AS DateTime), 3285, 47, 1)
INSERT [dbo].[tbStatusVaga] ([idStatusVaga], [idStatus], [dtAlteracao], [idVaga], [idUsuario], [flSituacao]) VALUES (3459, 2, CAST(N'2017-04-27 20:13:06.310' AS DateTime), 3284, 1040, 1)
SET IDENTITY_INSERT [dbo].[tbStatusVaga] OFF
SET IDENTITY_INSERT [dbo].[tbTipoCurso] ON 

INSERT [dbo].[tbTipoCurso] ([idTipoCurso], [nmTipoCurso]) VALUES (4, N'Formação Escolar Fundamental (1° grau) e Média (2° grau)')
INSERT [dbo].[tbTipoCurso] ([idTipoCurso], [nmTipoCurso]) VALUES (6, N'Curso Técnico - Médio (2º Grau)')
INSERT [dbo].[tbTipoCurso] ([idTipoCurso], [nmTipoCurso]) VALUES (7, N'Graduação')
INSERT [dbo].[tbTipoCurso] ([idTipoCurso], [nmTipoCurso]) VALUES (9, N'Pós-graduação – Especialização')
INSERT [dbo].[tbTipoCurso] ([idTipoCurso], [nmTipoCurso]) VALUES (10, N'Pós-graduação – MBA')
INSERT [dbo].[tbTipoCurso] ([idTipoCurso], [nmTipoCurso]) VALUES (12, N'Pós-graduação – Mestrado')
INSERT [dbo].[tbTipoCurso] ([idTipoCurso], [nmTipoCurso]) VALUES (15, N'Pós-graduação – Doutorado')
INSERT [dbo].[tbTipoCurso] ([idTipoCurso], [nmTipoCurso]) VALUES (16, N'Não informado')
SET IDENTITY_INSERT [dbo].[tbTipoCurso] OFF
SET IDENTITY_INSERT [dbo].[tbTpStatus] ON 

INSERT [dbo].[tbTpStatus] ([idTpStatus], [nmTpStatus]) VALUES (1, N'Candidato')
INSERT [dbo].[tbTpStatus] ([idTpStatus], [nmTpStatus]) VALUES (2, N'Vaga')
SET IDENTITY_INSERT [dbo].[tbTpStatus] OFF
SET IDENTITY_INSERT [dbo].[tbUsuario] ON 

INSERT [dbo].[tbUsuario] ([idUsuario], [idPerfil], [idFuncionario], [nmUsuario], [senha], [email], [flPrimeiroAcesso], [ativo]) VALUES (47, 1, 17, N'admin', N'YWRtaW4=', N'admin@verity.com.br', 0, 1)
INSERT [dbo].[tbUsuario] ([idUsuario], [idPerfil], [idFuncionario], [nmUsuario], [senha], [email], [flPrimeiroAcesso], [ativo]) VALUES (1040, 2, 1017, N'taiama', N'dGFpYW1h', N'guilherme.oliveira@verity.com.br', 0, 1)
INSERT [dbo].[tbUsuario] ([idUsuario], [idPerfil], [idFuncionario], [nmUsuario], [senha], [email], [flPrimeiroAcesso], [ativo]) VALUES (1041, 5, 1018, N'vitor', N'dml0b3I=', N'thamires.miranda@verity.com.br', 0, 1)
INSERT [dbo].[tbUsuario] ([idUsuario], [idPerfil], [idFuncionario], [nmUsuario], [senha], [email], [flPrimeiroAcesso], [ativo]) VALUES (1042, 9, 1019, N'tavares', N'dGF2YXJlcw==', N'daniel.valle@verity.com.br', 0, 1)
INSERT [dbo].[tbUsuario] ([idUsuario], [idPerfil], [idFuncionario], [nmUsuario], [senha], [email], [flPrimeiroAcesso], [ativo]) VALUES (1043, 3, 1021, N'juliana', N'anVsaWFuYQ==', N'yuri.silva@verity.com.br', 0, 1)
INSERT [dbo].[tbUsuario] ([idUsuario], [idPerfil], [idFuncionario], [nmUsuario], [senha], [email], [flPrimeiroAcesso], [ativo]) VALUES (1044, 4, 1022, N'alexandro', N'YWxleGFuZHJv', N'stephen.knupfer@verity.com.br', 0, 1)
INSERT [dbo].[tbUsuario] ([idUsuario], [idPerfil], [idFuncionario], [nmUsuario], [senha], [email], [flPrimeiroAcesso], [ativo]) VALUES (1045, 6, 1023, N'gabriela', N'Z2FicmllbGE=', N'graziele.barboza@verity.com.br', 0, 1)
SET IDENTITY_INSERT [dbo].[tbUsuario] OFF
SET IDENTITY_INSERT [dbo].[tbVaga] ON 

INSERT [dbo].[tbVaga] ([idVaga], [idProjeto], [idCargo], [idSenioridade], [idUsuario], [nmSolicitante], [vlPretensao], [dtInicio], [flLocalTrabalho], [idTpVaga], [flAumentoQuadra], [numCandidatos], [nmSubstituido], [dsFormacaoAcademica], [dsPerfilComportamental], [dsPerfilTecnico], [dtAbertura], [dtAprovacao], [dtFechamento], [nmVaga], [hrEntrada], [hrSaida], [nmResponsavel], [nmAreaResponsavel], [emailResponsavel], [telResponsavel]) VALUES (3284, 1005, 3, 3, 1044, N'Juliana', NULL, CAST(N'2017-02-02' AS Date), N'I', N'R', N'N', NULL, N'', N'LALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLAL', N'LALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLAL', N'LALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLALLALALALALALLAL', CAST(N'2017-04-27' AS Date), CAST(N'2017-04-27' AS Date), CAST(N'2017-04-27' AS Date), N'Analista Teste', CAST(N'10:10:00' AS Time), CAST(N'19:00:00' AS Time), N'', N'', N'', N'')
INSERT [dbo].[tbVaga] ([idVaga], [idProjeto], [idCargo], [idSenioridade], [idUsuario], [nmSolicitante], [vlPretensao], [dtInicio], [flLocalTrabalho], [idTpVaga], [flAumentoQuadra], [numCandidatos], [nmSubstituido], [dsFormacaoAcademica], [dsPerfilComportamental], [dsPerfilTecnico], [dtAbertura], [dtAprovacao], [dtFechamento], [nmVaga], [hrEntrada], [hrSaida], [nmResponsavel], [nmAreaResponsavel], [emailResponsavel], [telResponsavel]) VALUES (3285, 1005, 10, 3, 1041, N'Juliana', NULL, CAST(N'2017-06-01' AS Date), N'C', N'R', N'N', NULL, N'', N'Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra ench', N'Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra ench', N'Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra encher o campo. Muito texto pra ench', CAST(N'2017-04-27' AS Date), CAST(N'2017-04-27' AS Date), CAST(N'2017-04-27' AS Date), N'Desenvolvedor Ninja FullStack', CAST(N'08:00:00' AS Time), CAST(N'17:00:00' AS Time), N'Kakashi', N'Projetos', N'vitor.tadashi@verity.com.br', N'11912312312')
INSERT [dbo].[tbVaga] ([idVaga], [idProjeto], [idCargo], [idSenioridade], [idUsuario], [nmSolicitante], [vlPretensao], [dtInicio], [flLocalTrabalho], [idTpVaga], [flAumentoQuadra], [numCandidatos], [nmSubstituido], [dsFormacaoAcademica], [dsPerfilComportamental], [dsPerfilTecnico], [dtAbertura], [dtAprovacao], [dtFechamento], [nmVaga], [hrEntrada], [hrSaida], [nmResponsavel], [nmAreaResponsavel], [emailResponsavel], [telResponsavel]) VALUES (3286, 1005, 1, 1, 1045, N'Admin', NULL, CAST(N'2017-05-01' AS Date), N'I', N'R', N'N', NULL, N'', N'teste', N'teste', N'teste', CAST(N'2017-04-27' AS Date), CAST(N'2017-04-27' AS Date), CAST(N'2017-04-27' AS Date), N'Teste do mineiro', CAST(N'00:00:00' AS Time), CAST(N'00:00:00' AS Time), N'', N'', N'', N'')
INSERT [dbo].[tbVaga] ([idVaga], [idProjeto], [idCargo], [idSenioridade], [idUsuario], [nmSolicitante], [vlPretensao], [dtInicio], [flLocalTrabalho], [idTpVaga], [flAumentoQuadra], [numCandidatos], [nmSubstituido], [dsFormacaoAcademica], [dsPerfilComportamental], [dsPerfilTecnico], [dtAbertura], [dtAprovacao], [dtFechamento], [nmVaga], [hrEntrada], [hrSaida], [nmResponsavel], [nmAreaResponsavel], [emailResponsavel], [telResponsavel]) VALUES (3288, 1005, 5, 1, 1043, N'Admin', NULL, CAST(N'2017-05-18' AS Date), N'C', N'P', N'S', NULL, N'Giovanni', N'Em design gráfico e editoração, Lorem ipsum é um texto utilizado para preencher o espaço de ... Em documentos utilizados para testes, este tipo de texto é utilizado para evitar que as pessoas foquem a atenção no texto e se concentrem nos Em design gráfico e editoração, Lorem ipsum é um texto utilizado para preencher o espaço de ... Em documentos utilizados para testes, este tipo de texto é utilizado para evitar que as pessoas foquem a atenção no texto e se concentrem nos Em design gráfico e edit', N'Em design gráfico e editoração, Lorem ipsum é um texto utilizado para preencher o espaço de ... Em documentos utilizados para testes, este tipo de texto é utilizado para evitar que as pessoas foquem a atenção no texto e se concentrem nos ...', N'Em design gráfico e editoração, Lorem ipsum é um texto utilizado para preencher o espaço de ... Em documentos utilizados para testes, este tipo de texto é utilizado para evitar que as pessoas foquem a atenção no texto e se concentrem nos ...Em design gráfico e editoração, Lorem ipsum é um texto utilizado para preencher o espaço de ... Em documentos utilizados para testes, este tipo de texto é utilizado para evitar que as pessoas foquem a atenção no texto e se concentrem nos ...', CAST(N'2017-04-27' AS Date), CAST(N'2017-04-27' AS Date), CAST(N'2017-04-27' AS Date), N'Analise e teste pires', CAST(N'09:00:00' AS Time), CAST(N'17:00:00' AS Time), N'Adalberto Nunes', N'Teste', N'adalberto.nunes@email.com', N'')
INSERT [dbo].[tbVaga] ([idVaga], [idProjeto], [idCargo], [idSenioridade], [idUsuario], [nmSolicitante], [vlPretensao], [dtInicio], [flLocalTrabalho], [idTpVaga], [flAumentoQuadra], [numCandidatos], [nmSubstituido], [dsFormacaoAcademica], [dsPerfilComportamental], [dsPerfilTecnico], [dtAbertura], [dtAprovacao], [dtFechamento], [nmVaga], [hrEntrada], [hrSaida], [nmResponsavel], [nmAreaResponsavel], [emailResponsavel], [telResponsavel]) VALUES (3289, 1005, 1, 1, 1040, N'Admin', NULL, CAST(N'2018-01-01' AS Date), N'I', N'R', N'N', NULL, N'', N'teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
vv', N'teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
', N'teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
teste
', CAST(N'2017-04-27' AS Date), NULL, NULL, N'teste descrição', CAST(N'08:00:00' AS Time), CAST(N'18:00:00' AS Time), N'', N'', N'', N'')
SET IDENTITY_INSERT [dbo].[tbVaga] OFF
SET IDENTITY_INSERT [dbo].[tbVagaCandidato] ON 

INSERT [dbo].[tbVagaCandidato] ([idVagaCandidato], [idVaga], [idCandidato], [idCanalInformacao]) VALUES (2306, 3284, 56, 2)
INSERT [dbo].[tbVagaCandidato] ([idVagaCandidato], [idVaga], [idCandidato], [idCanalInformacao]) VALUES (2307, 3284, 57, 4)
INSERT [dbo].[tbVagaCandidato] ([idVagaCandidato], [idVaga], [idCandidato], [idCanalInformacao]) VALUES (2311, 3284, 61, 2)
INSERT [dbo].[tbVagaCandidato] ([idVagaCandidato], [idVaga], [idCandidato], [idCanalInformacao]) VALUES (2312, 3285, 62, 2)
INSERT [dbo].[tbVagaCandidato] ([idVagaCandidato], [idVaga], [idCandidato], [idCanalInformacao]) VALUES (2313, 3285, 63, 5)
INSERT [dbo].[tbVagaCandidato] ([idVagaCandidato], [idVaga], [idCandidato], [idCanalInformacao]) VALUES (2314, 3285, 64, 2)
SET IDENTITY_INSERT [dbo].[tbVagaCandidato] OFF
ALTER TABLE [dbo].[tbAvaliadorCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK_tbAvaliadorCandidato_tbCandidato] FOREIGN KEY([idCandidato])
REFERENCES [dbo].[tbCandidato] ([idCandidato])
GO
ALTER TABLE [dbo].[tbAvaliadorCandidato] CHECK CONSTRAINT [FK_tbAvaliadorCandidato_tbCandidato]
GO
ALTER TABLE [dbo].[tbAvaliadorCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK_tbAvaliadorCandidato_tbStatus] FOREIGN KEY([idStatus])
REFERENCES [dbo].[tbStatus] ([idStatus])
GO
ALTER TABLE [dbo].[tbAvaliadorCandidato] CHECK CONSTRAINT [FK_tbAvaliadorCandidato_tbStatus]
GO
ALTER TABLE [dbo].[tbAvaliadorCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK_tbAvaliadorCandidato_tbUsuario] FOREIGN KEY([idUsuario])
REFERENCES [dbo].[tbUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[tbAvaliadorCandidato] CHECK CONSTRAINT [FK_tbAvaliadorCandidato_tbUsuario]
GO
ALTER TABLE [dbo].[tbAvaliadorCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK_tbAvaliadorCandidato_tbVaga] FOREIGN KEY([idVaga])
REFERENCES [dbo].[tbVaga] ([idVaga])
GO
ALTER TABLE [dbo].[tbAvaliadorCandidato] CHECK CONSTRAINT [FK_tbAvaliadorCandidato_tbVaga]
GO
ALTER TABLE [dbo].[tbAvaliadorVaga]  WITH NOCHECK ADD  CONSTRAINT [FK_tbAvaliadorVaga_tbUsuario] FOREIGN KEY([idUsuario])
REFERENCES [dbo].[tbUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[tbAvaliadorVaga] CHECK CONSTRAINT [FK_tbAvaliadorVaga_tbUsuario]
GO
ALTER TABLE [dbo].[tbAvaliadorVaga]  WITH NOCHECK ADD  CONSTRAINT [FK_tbAvaliadorVaga_tbVaga] FOREIGN KEY([idVaga])
REFERENCES [dbo].[tbVaga] ([idVaga])
GO
ALTER TABLE [dbo].[tbAvaliadorVaga] CHECK CONSTRAINT [FK_tbAvaliadorVaga_tbVaga]
GO
ALTER TABLE [dbo].[tbCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK__tbCandida__idEnd__4AB81AF0] FOREIGN KEY([idEndereco])
REFERENCES [dbo].[tbEndereco] ([idEndereco])
GO
ALTER TABLE [dbo].[tbCandidato] CHECK CONSTRAINT [FK__tbCandida__idEnd__4AB81AF0]
GO
ALTER TABLE [dbo].[tbCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK__tbCandida__idFor__4BAC3F29] FOREIGN KEY([idFormacao])
REFERENCES [dbo].[tbFormacao] ([idFormacao])
GO
ALTER TABLE [dbo].[tbCandidato] CHECK CONSTRAINT [FK__tbCandida__idFor__4BAC3F29]
GO
ALTER TABLE [dbo].[tbCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK__tbCandida__idUsu__4CA06362] FOREIGN KEY([idUsuario])
REFERENCES [dbo].[tbUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[tbCandidato] CHECK CONSTRAINT [FK__tbCandida__idUsu__4CA06362]
GO
ALTER TABLE [dbo].[tbCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK_tbCandidato_tbContato] FOREIGN KEY([idContato])
REFERENCES [dbo].[tbContato] ([idContato])
GO
ALTER TABLE [dbo].[tbCandidato] CHECK CONSTRAINT [FK_tbCandidato_tbContato]
GO
ALTER TABLE [dbo].[tbCandidatoCompetencia]  WITH CHECK ADD FOREIGN KEY([idAvaliacao])
REFERENCES [dbo].[tbAvaliacao] ([idAvaliacao])
GO
ALTER TABLE [dbo].[tbCandidatoCompetencia]  WITH CHECK ADD  CONSTRAINT [FK__tbCandida__idCan__0D44F85C] FOREIGN KEY([idCandidato])
REFERENCES [dbo].[tbCandidato] ([idCandidato])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tbCandidatoCompetencia] CHECK CONSTRAINT [FK__tbCandida__idCan__0D44F85C]
GO
ALTER TABLE [dbo].[tbCandidatoCompetencia]  WITH CHECK ADD FOREIGN KEY([idCompetencia])
REFERENCES [dbo].[tbCompetencia] ([idCompetencia])
GO
ALTER TABLE [dbo].[tbCargoSenioridade]  WITH CHECK ADD  CONSTRAINT [FK__tbCargoSe__idCar__5CD6CB2B] FOREIGN KEY([idCargo])
REFERENCES [dbo].[tbCargo] ([idCargo])
GO
ALTER TABLE [dbo].[tbCargoSenioridade] CHECK CONSTRAINT [FK__tbCargoSe__idCar__5CD6CB2B]
GO
ALTER TABLE [dbo].[tbCargoSenioridade]  WITH CHECK ADD  CONSTRAINT [FK__tbCargoSe__idSen__5DCAEF64] FOREIGN KEY([idSenioridade])
REFERENCES [dbo].[tbSenioridade] ([idSenioridade])
GO
ALTER TABLE [dbo].[tbCargoSenioridade] CHECK CONSTRAINT [FK__tbCargoSe__idSen__5DCAEF64]
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
ALTER TABLE [dbo].[tbProvaCandidato]  WITH CHECK ADD  CONSTRAINT [FK_tbProvaCandidato_tbCandidato] FOREIGN KEY([idCandidato])
REFERENCES [dbo].[tbCandidato] ([idCandidato])
GO
ALTER TABLE [dbo].[tbProvaCandidato] CHECK CONSTRAINT [FK_tbProvaCandidato_tbCandidato]
GO
ALTER TABLE [dbo].[tbProvaCandidato]  WITH CHECK ADD  CONSTRAINT [FK_tbProvaCandidato_tbProva] FOREIGN KEY([idProva])
REFERENCES [dbo].[tbProva] ([idProva])
GO
ALTER TABLE [dbo].[tbProvaCandidato] CHECK CONSTRAINT [FK_tbProvaCandidato_tbProva]
GO
ALTER TABLE [dbo].[tbStatus]  WITH CHECK ADD FOREIGN KEY([idTpStatus])
REFERENCES [dbo].[tbTpStatus] ([idTpStatus])
GO
ALTER TABLE [dbo].[tbStatus]  WITH CHECK ADD FOREIGN KEY([idTpStatus])
REFERENCES [dbo].[tbTpStatus] ([idTpStatus])
GO
ALTER TABLE [dbo].[tbStatus]  WITH CHECK ADD FOREIGN KEY([idTpStatus])
REFERENCES [dbo].[tbTpStatus] ([idTpStatus])
GO
ALTER TABLE [dbo].[tbStatusCandidato]  WITH CHECK ADD  CONSTRAINT [FK__tbStatusC__idCan__571DF1D5] FOREIGN KEY([idCandidato])
REFERENCES [dbo].[tbCandidato] ([idCandidato])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tbStatusCandidato] CHECK CONSTRAINT [FK__tbStatusC__idCan__571DF1D5]
GO
ALTER TABLE [dbo].[tbStatusCandidato]  WITH CHECK ADD FOREIGN KEY([idStatus])
REFERENCES [dbo].[tbStatus] ([idStatus])
GO
ALTER TABLE [dbo].[tbStatusCandidato]  WITH CHECK ADD  CONSTRAINT [FK__tbStatusC__idUsu__11158940] FOREIGN KEY([idUsuario])
REFERENCES [dbo].[tbUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[tbStatusCandidato] CHECK CONSTRAINT [FK__tbStatusC__idUsu__11158940]
GO
ALTER TABLE [dbo].[tbStatusFuturo]  WITH CHECK ADD  CONSTRAINT [FK_tbStatusFuturo_tbStatus] FOREIGN KEY([idStatus])
REFERENCES [dbo].[tbStatus] ([idStatus])
GO
ALTER TABLE [dbo].[tbStatusFuturo] CHECK CONSTRAINT [FK_tbStatusFuturo_tbStatus]
GO
ALTER TABLE [dbo].[tbStatusVaga]  WITH NOCHECK ADD FOREIGN KEY([idStatus])
REFERENCES [dbo].[tbStatus] ([idStatus])
GO
ALTER TABLE [dbo].[tbStatusVaga]  WITH NOCHECK ADD  CONSTRAINT [FK_tbStatusVaga_tbUsuario] FOREIGN KEY([idUsuario])
REFERENCES [dbo].[tbUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[tbStatusVaga] CHECK CONSTRAINT [FK_tbStatusVaga_tbUsuario]
GO
ALTER TABLE [dbo].[tbStatusVaga]  WITH NOCHECK ADD  CONSTRAINT [FK_tbStatusVaga_tbVaga] FOREIGN KEY([idVaga])
REFERENCES [dbo].[tbVaga] ([idVaga])
GO
ALTER TABLE [dbo].[tbStatusVaga] CHECK CONSTRAINT [FK_tbStatusVaga_tbVaga]
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
ALTER TABLE [dbo].[tbVaga]  WITH NOCHECK ADD  CONSTRAINT [FK__tbVaga__idCargo__286302EC] FOREIGN KEY([idCargo])
REFERENCES [dbo].[tbCargo] ([idCargo])
GO
ALTER TABLE [dbo].[tbVaga] CHECK CONSTRAINT [FK__tbVaga__idCargo__286302EC]
GO
ALTER TABLE [dbo].[tbVaga]  WITH NOCHECK ADD  CONSTRAINT [FK__tbVaga__idProjet__276EDEB3] FOREIGN KEY([idProjeto])
REFERENCES [dbo].[tbProjeto] ([idProjeto])
GO
ALTER TABLE [dbo].[tbVaga] CHECK CONSTRAINT [FK__tbVaga__idProjet__276EDEB3]
GO
ALTER TABLE [dbo].[tbVaga]  WITH NOCHECK ADD  CONSTRAINT [FK__tbVaga__idSenior__29572725] FOREIGN KEY([idSenioridade])
REFERENCES [dbo].[tbSenioridade] ([idSenioridade])
GO
ALTER TABLE [dbo].[tbVaga] CHECK CONSTRAINT [FK__tbVaga__idSenior__29572725]
GO
ALTER TABLE [dbo].[tbVaga]  WITH NOCHECK ADD  CONSTRAINT [FK__tbVaga__idUsuari__2A4B4B5E] FOREIGN KEY([idUsuario])
REFERENCES [dbo].[tbUsuario] ([idUsuario])
GO
ALTER TABLE [dbo].[tbVaga] CHECK CONSTRAINT [FK__tbVaga__idUsuari__2A4B4B5E]
GO
ALTER TABLE [dbo].[tbVagaCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK__tbVagaCan__idCan__534D60F1] FOREIGN KEY([idCandidato])
REFERENCES [dbo].[tbCandidato] ([idCandidato])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tbVagaCandidato] CHECK CONSTRAINT [FK__tbVagaCan__idCan__534D60F1]
GO
ALTER TABLE [dbo].[tbVagaCandidato]  WITH NOCHECK ADD FOREIGN KEY([idCanalInformacao])
REFERENCES [dbo].[tbCanalInformacao] ([idCanalInformacao])
GO
ALTER TABLE [dbo].[tbVagaCandidato]  WITH NOCHECK ADD  CONSTRAINT [FK__tbVagaCan__idVag__52593CB8] FOREIGN KEY([idVaga])
REFERENCES [dbo].[tbVaga] ([idVaga])
GO
ALTER TABLE [dbo].[tbVagaCandidato] CHECK CONSTRAINT [FK__tbVagaCan__idVag__52593CB8]
GO
