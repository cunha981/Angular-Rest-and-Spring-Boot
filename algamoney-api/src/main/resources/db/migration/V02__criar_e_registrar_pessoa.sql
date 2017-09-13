CREATE TABLE pessoa(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(150) NOT NULL,
	ativo BIT NOT NULL,
	logradouro VARCHAR(150) NULL,
	numero VARCHAR(10) NULL,
	complemento VARCHAR(100) NULL,
	bairro VARCHAR(100) NULL,
	cep VARCHAR(10) NULL,
	cidade VARCHAR(100) NULL,
	estado VARCHAR(3) NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa 
	(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	VALUES ('Igor Cunha de Almeida', 1, 'Rua Catu', '257', 'Supermercado Veran', 'Guaianazes', '08440-330', 'São Paulo', 'SP');
INSERT INTO pessoa 
	(nome, ativo, logradouro, numero, bairro, cep, cidade, estado) 
	VALUES ('Jean Carlos de Almeida', 1, 'Rua Cunha Xavier', '5459', 'Guaianazes', '08420-330', 'São Paulo', 'SP');
INSERT INTO pessoa 
	(nome, ativo, logradouro, numero, cep, estado) 
	VALUES ('Joaquim Wanderley de Almeida', 1, 'Rua Faria Xavier', '55', '05820-330', 'SP');
INSERT INTO pessoa 
	(nome, ativo, logradouro, numero, bairro, cep, cidade, estado) 
	VALUES ('Maria Aparecida da Cunha', 1, 'Rua Joselino', '548', 'Lima Duarte', '07420-330', 'Lima Duarte', 'MG');
INSERT INTO pessoa (nome, ativo) VALUES ('Daniel Carvalho', 1);	
	