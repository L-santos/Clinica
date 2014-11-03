
CREATE TABLE IF NOT EXISTS cliente( cpf VARCHAR (11) PRIMARY KEY, nome VARCHAR (50) NOT NULL, telefone varchar (15));

CREATE TABLE IF NOT EXISTS medico( cpf VARCHAR (11) PRIMARY KEY, nome VARCHAR (50) NOT NULL,
registro VARCHAR(20) NOT NULL , especialidade int NOT NULL references especialides(id));

CREATE TABLE IF NOT EXISTS consulta(id INT PRIMARY KEY, cpfCliente VARCHAR(11) references cliente (cpf), 
registroMedico VARCHAR (20) references medico (registro) , dataConsulta DATE NOT NULL);

CREATE TABLE IF NOT EXISTS funcionario( nome VARCHAR (50) NOT NULL, cpf VARCHAR(11) PRIMARY KEY, 
telefone varchar (15));

CREATE TABLE IF NOT EXISTS medico( nome VARCHAR (50) NOT NULL, cpf VARCHAR (11) PRIMARY KEY, registro VARCHAR(20) NOT NULL ,
especialidade VARCHAR (50) NOT NULL);

CREATE TABLE IF NOT EXISTS especialidades ( id int PRIMARY KEY, nome VARCHAR(30) NOT NULL);

/*CREATE TABLE telefone( numero VARCHAR(10) NOT NULL, cpf VARCHAR (11) PRIMARY KEY REFERENCES cliente(cpf))*/
/*CREATE TABLE funcionario( nome VARCHAR (50) NOT NULL, cpf VARCHAR(11) PRIMARY KEY, matricula INT NOT NULL,
sexo CHAR (1) CHECK(sexo='M' OR sexo='F'), dataNacsimento DATE , salario FLOAT);*/



