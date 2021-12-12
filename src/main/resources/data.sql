INSERT INTO USUARIO(nome, email, senha) VALUES('Ricardo', 'ricardo@gmail', '12345');
INSERT INTO USUARIO(nome, email, senha) VALUES('Débora', 'debora@gmail', '123');
INSERT INTO USUARIO(nome, email, senha) VALUES('Ana', 'ana@gmail', '12345678');

INSERT INTO CIRURGIA(matricula, data, usuario_id) VALUES(11111111, '2020-02-20', 1);
INSERT INTO CIRURGIA(matricula, data, usuario_id) VALUES(11111111, '2021-05-26', 1);

INSERT INTO CIRURGIA(matricula, data, usuario_id) VALUES(22222222, '2009-10-10', 2);
INSERT INTO CIRURGIA(matricula, data, usuario_id) VALUES(33333333, '2013-08-15', 2);

INSERT INTO CIRURGIA(matricula, data, usuario_id) VALUES(44444444, '2000-02-07', 3);
INSERT INTO CIRURGIA(matricula, data, usuario_id) VALUES(44444444, '2000-02-07', 3);
INSERT INTO CIRURGIA(matricula, data, usuario_id) VALUES(44444444, '2010-12-24', 3);
INSERT INTO CIRURGIA(matricula, data, usuario_id) VALUES(55555555, '1998-05-13', 3);
INSERT INTO CIRURGIA(matricula, data, usuario_id) VALUES(66666666, '2019-06-27', 3);

INSERT INTO PROCEDIMENTO(tipo, premio, codigo, cirurgia_id) VALUES(1, 1, 31102360, 1);
INSERT INTO PROCEDIMENTO(tipo, premio, codigo, cirurgia_id) VALUES(2, 1, 31102077, 1);
INSERT INTO PROCEDIMENTO(tipo, premio, codigo, cirurgia_id) VALUES(1, 1, 30908027, 2);

INSERT INTO PROCEDIMENTO(tipo, premio, codigo, cirurgia_id) VALUES(1, 2, 30202094, 3);
INSERT INTO PROCEDIMENTO(tipo, premio, codigo, cirurgia_id) VALUES(1, 1, 30715016, 4);

INSERT INTO PROCEDIMENTO(tipo, premio, codigo, cirurgia_id) VALUES(1, 2, 31201113, 5);
INSERT INTO PROCEDIMENTO(tipo, premio, codigo, cirurgia_id) VALUES(2, 2, 30914070, 6);
INSERT INTO PROCEDIMENTO(tipo, premio, codigo, cirurgia_id) VALUES(1, 1, 30908027, 7);
INSERT INTO PROCEDIMENTO(tipo, premio, codigo, cirurgia_id) VALUES(1, 2, 31003567, 8);
INSERT INTO PROCEDIMENTO(tipo, premio, codigo, cirurgia_id) VALUES(1, 2, 30729017, 9);

