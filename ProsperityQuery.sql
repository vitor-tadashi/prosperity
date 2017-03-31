CREATE DATABASE Prosperity;

USE Prosperity;

CREATE TABLE tbRelatorio(
	idRelatorio INT PRIMARY KEY IDENTITY (1,1),
	nmRelatorio VARCHAR(100),
	cmRelatorio VARCHAR(100)
)

CREATE TABLE tbCargo (
	idCargo INT PRIMARY KEY IDENTITY (1,1),
	nmCargo VARCHAR(50)
);

CREATE TABLE tbSenioridade (
	idSenioridade INT NOT NULL PRIMARY KEY IDENTITY (1,1),
	nmSenioridade VARCHAR(20),

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

CREATE TABLE tbProjeto (
	idProjeto INT IDENTITY (1,1) PRIMARY KEY,
	nmProjeto VARCHAR(100),
	idFuncionario INT FOREIGN KEY REFERENCES tbFuncionario(idFuncionario),
	idCliente INT FOREIGN KEY REFERENCES tbCliente(idCliente)
);

CREATE TABLE tbTpStatus(
	idTpStatus INT IDENTITY (1,1) PRIMARY KEY,
	nmTpStatus VARCHAR(50)
);

CREATE TABLE tbPerfil (

	idPerfil INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	nmPerfil VARCHAR(45),
);

CREATE TABLE tbUsuario(
	idUsuario INT IDENTITY(1,1) PRIMARY KEY,
	idPerfil INT FOREIGN KEY REFERENCES tbPerfil(idPerfil),
	idFuncionario INT FOREIGN KEY REFERENCES tbFuncionario(idFuncionario),
	nmUsuario VARCHAR(200),
	senha VARCHAR(20),

);


CREATE TABLE tbAvaliacao(
	idAvaliacao  INT NOT NULL PRIMARY KEY IDENTITY (1,1),
	nmAvaliacao VARCHAR(200)
	)

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
	flAumentoQuadra CHAR
);

Create TABLE tbAvaliador (

	idAvaliador INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	idPerfil INT FOREIGN KEY REFERENCES tbPerfil (idPerfil),
	idVaga INT FOREIGN KEY REFERENCES tbVaga (idVaga)
);

CREATE TABLE tbStatus(
	idStatus INT IDENTITY(1,1) PRIMARY KEY,
	nmStatus VARCHAR(50),
	tpCss VARCHAR(100),
	idTpStatus INT FOREIGN KEY REFERENCES tbTpStatus(idTpStatus)

);

CREATE TABLE tbFuncionalidade (
	idFuncionalidade INT PRIMARY KEY IDENTITY (1,1),
	nmFuncionalidade VARCHAR(50)
);

CREATE TABLE tbTipoCurso (
	idTipoCurso INT PRIMARY KEY IDENTITY (1,1),
	nmTipoCurso VARCHAR(40)
);

CREATE TABLE tbCargoSenioridade (
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

CREATE TABLE tbCandidatoCompetencia (
	idCandidatoCompetencia INT PRIMARY KEY IDENTITY (1,1),
	idCandidato INT FOREIGN KEY REFERENCES tbCandidato(idCandidato),
	idAvaliacao INT FOREIGN KEY REFERENCES tbAvaliacao(idAvaliacao)
);

CREATE TABLE tbCanalInformacao (
	idCanalInformacao INT PRIMARY KEY IDENTITY (1,1),
	nmCanal VARCHAR(200),
);



CREATE TABLE tbStatusVaga (
	idStatusVaga INT PRIMARY KEY IDENTITY (1,1),
	idStatus INT FOREIGN KEY REFERENCES tbStatus(idStatus),
	idVaga INT FOREIGN KEY REFERENCES tbVaga(idVaga),
	dtAlteracao DATE
);

CREATE TABLE tbSituacaoAtual (
	idSituacaoAtual INT IDENTITY(1,1) PRIMARY KEY,
	nmSituacaoAtual VARCHAR (50)
);

CREATE TABLE tbFormacao(
	idFormacao INT IDENTITY(1,1) PRIMARY KEY,
	nmInstituicao VARCHAR (100),
	dtConclusao DATE,
	idTipoCurso INT FOREIGN KEY REFERENCES tbTipoCurso(idTipoCurso),
	idSituacaoAtual INT FOREIGN KEY REFERENCES tbSituacaoAtual(idSituacaoAtual),

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

CREATE TABLE tbCandidato (

	idCandidato INT NOT NULL PRIMARY KEY IDENTITY(1,1),
	cpf VARCHAR (50) NOT NULL,
	idEndereço INT FOREIGN KEY REFERENCES tbEndereco (idEndereco),
	idFormacao INT FOREIGN KEY REFERENCES tbFormacao (idFormacao),
	nmCandidato VARCHAR (100),
	rg VARCHAR (20),
	dtNascimento DATE,
	vlPretensao DECIMAL,
	dtAbertura DECIMAL,
	dtFechamento DATE,
	cmCurriculo VARCHAR (200),
	nmEmail VARCHAR (45),
	idUsuario INT FOREIGN KEY REFERENCES tbUsuario (idUsuario),
	dtAlteracao DATE
);

CREATE TABLE tbContato(
	idContato INT IDENTITY (1,1) PRIMARY KEY,
	idCandidato INT FOREIGN KEY REFERENCES tbCandidato(idCandidato),
	telefone VARCHAR(50),
);

CREATE TABLE tbVagaCandidato (
	idVagaCandidato INT PRIMARY KEY IDENTITY (1,1),
	idVaga INT FOREIGN KEY REFERENCES tbVaga(idVaga),
	idCandidato INT FOREIGN KEY REFERENCES tbCandidato(idCandidato)
);

CREATE TABLE tbStatusCandidato (
	idStatusCandidato INT PRIMARY KEY IDENTITY (1,1),
	idStatus INT FOREIGN KEY REFERENCES tbStatus(idStatus),
	idCandidato INT FOREIGN KEY REFERENCES tbCandidato(idCandidato),
	dtAlteracao DATE,
	dsParecer VARCHAR(500) 
);

select * from tbCompetencia

insert into tbCompetencia values ('Desenvolvimento')
insert into tbCompetencia values ('Profundidade')
insert into tbCompetencia values ('Planejamento')
insert into tbCompetencia values ('Execução e entrega')
insert into tbCompetencia values ('Pessoas')
insert into tbCompetencia values ('Comercial e financeiro')
select * from tbCandidatoCompetencia
insert into tbCandidatoCompetencia values (1, 2, 1)
insert into tbCandidatoCompetencia values (4, 2, 2)
insert into tbCandidatoCompetencia values (2, 2, 3)
insert into tbCandidatoCompetencia values (3, 2, 4)
insert into tbCandidatoCompetencia values (4, 2, 5)
insert into tbCandidatoCompetencia values (3, 2, 6)
CREATE TABLE tbCompetencia(
	idCompetencia INT PRIMARY KEY IDENTITY (1,1),
	nmCompetencia VARCHAR(200)
)
select * from tbCandidatoCompetencia
CREATE TABLE tbCandidatoCompetencia (
	idCandidatoCompetencia INT PRIMARY KEY IDENTITY (1,1),
	idAvaliacao INT FOREIGN KEY REFERENCES tbAvaliacao(idAvaliacao),
	idCandidato INT FOREIGN KEY REFERENCES tbCandidato(idCandidato),
	idCompetencia INT FOREIGN KEY REFERENCES tbCompetencia(idCompetencia)
);




alter table tbVaga add nmVaga varchar(50)
select * from tbVaga

-- Adicionado coluna situação na tabela de usuarios
ALTER TABLE dbo.tbUsuario ADD
	ativo bit NULL
GO
ALTER TABLE dbo.tbUsuario SET (LOCK_ESCALATION = TABLE)
GO


select * from tbTpStatus

alter table tbVaga add idStatusVaga int 

alter table tbVaga add foreign key(idStatusVaga) references tbStatusVaga(idStatusVaga)

select * from tbFuncionario
select * from tbStatusvaga

insert into tbStatus(nmStatus, tpCss, idTpStatus) values ('Fechado', 'css', 2)

UPDATE tbCandidato set dtAprovacao = '01-01-2017' where idCandidato = 

select * from tbStatusVaga
select * from tbVaga
select * from tbStatus
select * from tbProjeto



select * from tbCandidato

alter table tbVaga add idStatus int
alter table tbVaga add foreign key (idStatus) references tbStatus(idStatus)

--- Removendo idStatus e adicionando idStatusVaga, pois ela que é a tabela associativa.

DELETE tbStatusVaga;

ALTER TABLE tbVaga
DROP COLUMN idStatus;

ALTER TABLE tbVaga ADD idStatusVaga INT FOREIGN KEY REFERENCES tbStatusVaga(idStatusVaga);


<<<<<<< HEAD 

select * from tbVaga

UPDATE tbStatusVaga set idStatus = 17 where idStatusVaga = 8 
tbVaga.idVaga

SELECT * FROM tbVaga left join tbStatusVaga on tbVaga.idVaga = tbStatusvaga.idVaga

where tbStatusVaga.idStatus = 2  AND tbVaga.idVaga = (SELECT tbVaga.idVaga FROM tbVaga WHERE nmVaga like '%Anal%' AND dtAbertura between '2010-01-01' AND '2017-03-03')

SELECT * FROM tbVaga left join tbStatus

where tbStatus.idTpStatus = 2  AND tbVaga.idVaga = (SELECT tbVaga.idVaga FROM tbVaga WHERE nmVaga like '%Anal%' AND dtAbertura between '2010-01-01' AND '2017-03-03')

select * from tbstatusvaga
--- Alterando colunas da tabela vaga para tipo TIME 

ALTER TABLE tbVaga
DROP COLUMN hrEntrada;

ALTER TABLE tbVaga
DROP COLUMN hrsaida;

ALTER TABLE tbVaga
ADD hrEntrada time(0);

ALTER TABLE tbVaga
ADD hrSaida time(0);
>>>>>>> 8089cece931b468ac2be1a247800cc7750c57c2f


select v.idVaga,v.nmVaga,sv.idStatus,s.nmStatus from tbVaga v inner join tbStatusVaga sv on v.idVaga = sv.idVaga
 inner join tbStatus s on sv.idStatus = s.idStatus

 select * from tbStatus

 select  * from tbStatusVaga

 select * from tbVaga

 update tbStatus set tpCss = '#f2f2f2'