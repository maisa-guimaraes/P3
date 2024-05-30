CREATE TABLE categoria (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    ativo TINYINT DEFAULT 1
);

INSERT INTO categoria (nome) values ('Lazer');
INSERT INTO categoria (nome) values ('Alimentação');
INSERT INTO categoria (nome) values ('Supermercado');
INSERT INTO categoria (nome) values ('Farmácia');
INSERT INTO categoria (nome) values ('Outros');