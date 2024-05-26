CREATE TABLE lancamento (
id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR(50) NOT NULL,
dataVencimento DATE NOT NULL,
dataPagamento DATE,
valor DECIMAL(10,2) NOT NULL,
corrente BOOLEAN NOT NULL,
observacao VARCHAR(100),
tipo VARCHAR(20) NOT NULL,
idCategoria BIGINT(20) NOT NULL,
idPessoa BIGINT(20) NOT NULL,
FOREIGN KEY (idCategoria) REFERENCES categoria(id),
FOREIGN KEY (idPessoa) REFERENCES pessoa(id)
)