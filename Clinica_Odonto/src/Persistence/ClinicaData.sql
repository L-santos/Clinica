/*Cliente Data*/
INSERT INTO cliente(nome,cpf)
VALUES('Lucas','11111111111'),('Marcos','22222222222'),('Samuel','33333333333');

/*Funcionario Data*/
INSERT INTO funcionario(nome,cpf,telefone)
VALUES('Lucas Santos','12345678901',1234543),('Marcos Rocha','22345678901',2234545),('Samuel Souza','32345678901',3234511);

/*Especialidades*/
INSERT INTO especialidade(id, nome)
VALUES(1, "Odontopediatria"), (2, "Dentística"), (3, "Prótese Dentária"), (4, "Ortodontia");

/*Medico Data*/
INSERT INTO medico(nome,cpf,registro,especialidade)
VALUES('Ambrosio Santos','33322121234','897cx',1),('Feliciano Santos','11322121234','822or',2),('Rubenilda Bastos','33322121200','117gn',3);

/*INSERT INTO telefone(numero,cpf)

VALUES('87654326','11111111111')

INSERT INTO telefone(numero,cpf)

VALUES('89765876','22222222222')

INSERT INTO telefone(numero,cpf)

VALUES('87654355','33333333333')

INSERT INTO telefone(numero,cpf)

VALUES('97654300','11111111111') 
*/