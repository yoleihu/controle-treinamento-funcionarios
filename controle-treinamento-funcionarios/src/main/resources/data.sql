-- Criação da tabela Curso
CREATE TABLE IF NOT EXISTS curso (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(4000) NOT NULL,
    duracao INT NOT NULL
);

-- Criação da tabela Funcionario
CREATE TABLE IF NOT EXISTS funcionario (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    cpf CHAR(11) NOT NULL,
    nascimento DATE NOT NULL,
    cargo VARCHAR(200) NOT NULL,
    admissao DATE NOT NULL,
    status BIT NOT NULL
);

-- Criação da tabela Turma
CREATE TABLE IF NOT EXISTS turma (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    inicio DATE NOT NULL,
    fim DATE NOT NULL,
    local VARCHAR(200),
    curso INT NOT NULL,
    FOREIGN KEY (curso) REFERENCES curso (codigo)
);

-- Criação da tabela Participante
CREATE TABLE IF NOT EXISTS participante (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    turma INT NOT NULL,
    funcionario INT NOT NULL,
    FOREIGN KEY (turma) REFERENCES turma (codigo),
    FOREIGN KEY (funcionario) REFERENCES funcionario (codigo)
);

-- Inserção de dados iniciais
INSERT INTO curso (nome, descricao, duracao) VALUES ('Curso 1', 'Descrição do Curso 1', 90);
INSERT INTO curso (nome, descricao, duracao) VALUES ('Curso 2', 'Descrição do Curso 2', 120);

INSERT INTO funcionario (nome, cpf, nascimento, cargo, admissao, status)
VALUES ('Funcionario 1', '12345678901', '1990-01-01', 'Cargo 1', '2021-01-01', 1);
INSERT INTO funcionario (nome, cpf, nascimento, cargo, admissao, status)
VALUES ('Funcionario 2', '23456789012', '1985-05-15', 'Cargo 2', '2020-03-15', 1);

INSERT INTO turma (inicio, fim, local, curso) VALUES ('2023-09-01', '2023-09-15', 'Local A', 1);
INSERT INTO turma (inicio, fim, local, curso) VALUES ('2023-10-01', '2023-10-15', 'Local B', 2);

INSERT INTO participante (turma, funcionario) VALUES (1, 1);
INSERT INTO participante (turma, funcionario) VALUES (1, 2);
INSERT INTO participante (turma, funcionario) VALUES (2, 2);
