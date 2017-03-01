CREATE DATABASE Prosperity

CREATE TABLE tbVaga (
	idVaga INT IDENTITY(1,1) PRIMARY KEY,
	idProjeto INT FOREIGN KEY REFERENCES tbProjeto(idProjeto),
	idCargo INT FOREIGN KEY REFERENCES tbCargo(idCargo),
	idSenioridade INT FOREIGN KEY REFERENCES tbSenioridade(idSenioridade),
	idUsuario INT FOREIGN KEY REFERENCES tbUsuario(idUsuario),
	nmSolicitante VARCHAR(50),
	vlPretensao DECIMAL,
	dtInicio DATE,
	flLocalTrabalho CHAR,
	idTpVaga CHAR,
	hrEntrada DATE,
	hrSaida DATE,
	flAumentoQuadra CHAR,
	idAvaliador INT FOREIGN KEY REFERENCES(tbAvaliador)
);

CREATE TABLE tbUsuario(
	idUsuario INT IDENTITY(1,1) PRIMARY KEY,
	idPerfil INT FOREIGN KEY REFERENCES tbPerfil(idPerfil),
	idFuncionario INT FOREIGN KEY REFERENCES tbFuncionario(idFuncionario),
	nmUsuario VARCHAR(200),
	senha VARCHAR(20),

);

CREATE TABLE tbStatus(
	idStatus INT IDENTITY(1,1) PRIMARY KEY,
	nmStatus VARCHAR(50),
	tpCss VARCHAR(100),
	idTpStatus INT FOREIGN KEY REFERENCES tbTpStatus(idTpStatus)

);

CREATE TABLE tbProjeto (
	idProjeto INT IDENTITY (1,1) PRIMARY KEY,
	nmProjeto VARCHAR(100),
	idFuncionario INT FOREIGN KEY REFERENCES tbFuncionario(idFuncionario),
	idCliente INT FOREIGN KEY REFERENCES tbCliente(idCliente)
)

CREATE TABLE tbSenioridade (
	idSenioridade INT NOT NULL PRIMARY KEY IDENTITY (1,1),
	nmSenioridade VARCHAR(20),

);

CREATE TABLE tbCargo (
	idCargo INT PRIMARY KEY IDENTITY (1,1),
	nmCargo VARCHAR(50)
);

CREATE TABLE tbFuncionalidade (
	idFuncionalidade INT PRIMARY KEY IDENTITY (1,1),
	nmFuncionalidade VARCHAR(50)
);

CREATE TABLE tbTipoCurso (
	idTipoCurso INT PRIMARY KEY IDENTITY (1,1),
	nmTipoCurso VARCHAR(40)
);

CREATE TABLE CargoSenioridade (
	idCargoSenioridade INT PRIMARY KEY IDENTITY(1,1),
	idCargo INT FOREIGN KEY REFERENCES tbCargo(idCargo), 
	idSenioridade INT FOREIGN KEY REFERENCES tbSenioridade(idSenioridade),
	vlMinSalario DECIMAL,
	vlMaxSalario DECIMAL
);

CREATE TABLE tbPerfilFuncionalidade (
	idPerfilFuncionalidade INT PRIMARY KEY IDENTITY (1,1),
	idPerfil INT FOREIGN KEY REFERENCES tbPerfil(idPerfil),
	idFuncionalidade INT FOREIGN KEY REFERENCES tbFuncionalidade(idFuncionalidade)
);

CREATE TABLE tbVagaCandidato (
	idVagaCandidato INT PRIMARY KEY IDENTITY (1,1),
	idVaga INT FOREIGN KEY REFERENCES tbVaga(idVaga),
	cpf VARCHAR(30) FOREIGN KEY REFERENCES tbCandidato(cpf)
);

CREATE TABLE tbStatusCandidato (
	idStatusCandidato INT PRIMARY KEY IDENTITY (1,1),
	idStatus INT FOREIGN KEY REFERENCES tbStatus(idStatus),
	cpf VARCHAR(30) FOREIGN KEY REFERENCES tbCandidato(cpf),
	dtAlteracao DATE,
	dsParecer VARCHAR(500) 
);

CREATE TABLE tbStatusVaga (
	idStatusVaga INT PRIMARY KEY IDENTITY (1,1),
	idStatus INT FOREIGN KEY REFERENCES tbStatus(idStatus),
	idVaga INT FOREIGN KEY REFERENCES tbVaga(idVaga),
	dtAlteracao DATE
);

CREATE TABLE tbCliente (
	idCliente INT PRIMARY KEY IDENTITY (1,1),
	nmCliente VARCHAR(50)
);

CREATE TABLE tbFuncionario(
	 idFuncionario INT IDENTITY (1,1) PRIMARY KEY,
	 nmFuncionario  VARCHAR(50),
	 idCargo INT FOREIGN KEY REFERENCES tbCargo(idCargo),
	 idSenioridade INT FOREIGN KEY REFERENCES tbSenioridade(idSenioridade),

);

CREATE TABLE tbFormacao(
	idCurso INT IDENTITY(1,1) PRIMARY KEY,
	nmInstituicao VARCHAR (100),
	dtConclusao DATE,
	idTipoCurso INT FOREIGN KEY REFERENCES tbTipoCurso(idTipoCurso),
	idSituacaoAtual INT FOREIGN KEY REFERENCES tbSituacaoAtual(idSituacaoAtual),

);

CREATE TABLE tbContato(
	idContato INT IDENTITY (1,1) PRIMARY KEY,
	telefone VARCHAR(50),
);

CREATE TABLE tbPerfil (

	idPerfil INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	nmPerfil VARCHAR(45),
	idAvaliador INT FOREIGN KEY
);

CREATE TABLE tbCandidato (

	cpf VARCHAR (50) NOT NULL IDENTITY PRIMARY KEY(1,1),
	idContato INT FOREIGN KEY REFERENCES tbContato (idContato),
	idEndereço INT FOREIGN KEY REFERENCES tbEndereço (idEndereço),
	idCurso INT FOREIGN KEY REFERENCES tbCurso (idCurso),
	nmCandidato VARCHAR (100),
	rg VARCHAR (20),
	dtNascimento DATE,
	vlPretensao DOUBLE,
	dtAbertura DATE,
	dtFechamento DATE,
	cmCurriculo VARCHAR (200),
	nmEmail VARCHAR (45),
	idUsuario INT FOREIGN KEY REFERENCES tbUsuario (idUsuario),
	dtAlteracao DATE
);

Create TABLE tbAvaliador (

	idAvaliador INT NOT NULL PRIMARY KEY IDENTITY(1,1)
);

Create TABLE tbEndereco (

	idEndereco INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	cep VARCHAR (10),
	vlNumero INT,
	dsComplemento VARCHAR (10),
	nmEstado VARCHAR (45),
	nmLogradouro VARCHAR (45),
	nmCidade VARCHAR (45)

);




