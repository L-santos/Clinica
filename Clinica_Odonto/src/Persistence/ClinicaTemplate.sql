CREATE TABLE IF NOT EXISTS cliente( cpf VARCHAR (11) PRIMARY KEY, nome VARCHAR (50) NOT NULL, telefone varchar (15));

CREATE TABLE IF NOT EXISTS medico( nome VARCHAR (50) NOT NULL, cpf VARCHAR (11) unique,
registro VARCHAR(20) NOT NULL PRIMARY KEY,
especialidade INTEGER NOT NULL, 
FOREIGN KEY(ESPECIALIDADE) REFERENCES especialidade(id))ENGINE=InnoDB;

DROP TABLE IF EXISTS consulta
CREATE TABLE IF NOT EXISTS consulta(id INT PRIMARY KEY, cpfCliente VARCHAR(11) NOT NULL, 
registroMedico VARCHAR(20) NOT NULL , dataConsulta DATE NOT NULL,
FOREIGN KEY(cpfCliente) references cliente(cpf) ON DELETE CASCADE, 
FOREIGN KEY(registroMedico) references medico(registro) ON DELETE CASCADE)ENGINE=InnoDB;;

CREATE TABLE IF NOT EXISTS funcionario( nome VARCHAR (50) NOT NULL, cpf VARCHAR(11) PRIMARY KEY, 
telefone varchar (15));

CREATE TABLE IF NOT EXISTS especialidade ( id int PRIMARY KEY, nome VARCHAR(30) NOT NULL);


/*CREATE TABLE telefone( numero VARCHAR(10) NOT NULL, cpf VARCHAR (11) PRIMARY KEY REFERENCES cliente(cpf))*/
/*CREATE TABLE funcionario( nome VARCHAR (50) NOT NULL, cpf VARCHAR(11) PRIMARY KEY, matricula INT NOT NULL,
sexo CHAR (1) CHECK(sexo='M' OR sexo='F'), dataNacsimento DATE , salario FLOAT);*/



