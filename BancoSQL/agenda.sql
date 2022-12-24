CREATE DATABASE agenda;

CREATE TABLE login (
	loginId serial PRIMARY KEY,
	usuario VARCHAR ( 50 )  NOT NULL,
	senha VARCHAR ( 50 ) NOT NULL
);

CREATE TABLE usuario (
	usuarioId serial PRIMARY KEY,
	nome VARCHAR ( 50 )  NOT NULL,
	cpf VARCHAR ( 11 ) NOT NULL,
	telefone VARCHAR ( 11 ) NOT NULL,
	email VARCHAR ( 50 )  NOT NULL
);

CREATE TABLE auditoria (
	auditoriaId serial PRIMARY KEY,
	evento VARCHAR ( 50 )  NOT NULL,
	body jsonb ( 11 ) NOT NULL,
	dataevento VARCHAR ( 50 ) NOT NULL,
	horarioevento VARCHAR ( 50 )  NOT NULL
	loginId serial NOT NULL,
	FOREIGN KEY (loginId) REFERENCES login (loginId)
);

INSERT INTO login(usuario, senha) VALUES ('testando', '1234');
INSERT INTO login(usuario, senha) VALUES ('usuario', '3456');
INSERT INTO login(usuario, senha) VALUES ('fulano', '5426');

INSERT INTO usuario(nome, cpf, telefone, email) VALUES ('Jose Lino', '11111111111','99999999999','teste@teste.com.br');
INSERT INTO usuario(nome, cpf, telefone, email) VALUES ('Luana Silva', '11111111111','99999999999','teste@teste.com.br');
INSERT INTO usuario(nome, cpf, telefone, email) VALUES ('Silvia Lucia', '11111111111','99999999999','teste@teste.com.br');
INSERT INTO usuario(nome, cpf, telefone, email) VALUES ('Lucas Leandro', '11111111111','99999999999','teste@teste.com.br');

INSERT INTO auditoria(evento, body, dataevento, horarioevento, loginId) VALUES ('CREATE', '{"cpf": "11111111111","nome": "Jose Lino","email": "testando@teste.com","telefone": "99999999999"}','24/12/2022','01:08:50',1);
INSERT INTO auditoria(evento, body, dataevento, horarioevento, loginId) VALUES ('UPDATE', '{"cpf": "11111111111","nome": "Silvia Lucia","email": "testando@teste.com","telefone": "99999999999"}','24/12/2022','10:05:40',2);
INSERT INTO auditoria(evento, body, dataevento, horarioevento, loginId) VALUES ('DELETE', '{"cpf": "11111111111","nome": "Alison Farley","email": "testando@teste.com","telefone": "99999999999"}','24/12/2022','16:26:00',1);
INSERT INTO auditoria(evento, body, dataevento, horarioevento, loginId) VALUES ('CREATE', '{"cpf": "11111111111","nome": "Lucas Leandro","email": "testando@teste.com","telefone": "99999999999"}','24/12/2022','13:35:03',3);