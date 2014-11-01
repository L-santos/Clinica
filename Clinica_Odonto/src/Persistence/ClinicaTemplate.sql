
CREATE TABLE cliente( cpf VARCHAR (11) PRIMARY KEY, nome VARCHAR (50) NOT NULL)

CREATE TABLE medico( cpf VARCHAR (11) PRIMARY KEY, nome VARCHAR (50) NOT NULL,
registro VARCHAR(20) NOT NULL , especialidade VARCHAR (50) NOT NULL )

CREATE TABLE consulta( cpfCliente VARCHAR(11) references cliente (cpf) PRIMARY KEY , 
registroMedico VARCHAR (20) references medico (registro) ,
id INT NOT NULL, dataConsulta DATE NOT NULL)