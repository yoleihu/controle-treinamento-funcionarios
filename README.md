# Controle de Treinamento de Funcionários API 🚀

Este é um projeto de uma API REST desenvolvida para gerenciar operações básicas de controle de treinamento de funcionários. 👨‍🏫👩‍💼

## Objetivo 🎯

O objetivo principal deste projeto é criar uma API robusta e eficiente para o gerenciamento de treinamentos de funcionários.

## Tecnologias Utilizadas 🛠️

- Banco de Dados Relacional: H2
- Linguagem de Programação: Java 17 ☕
- Framework: Spring Boot 3.1.3

## Funcionalidades 📋

- Listagem de Dados: Consulta no banco de dados sem filtro, com ordenação contextual.
- Busca de Turmas: Endpoint que recebe o código do curso como parâmetro, filtrando todas as turmas daquele curso e ordenando-as pela data de início e data de fim. Cada turma retornada informa a quantidade de funcionários nela inscritos.
- Busca de Funcionários: Recebe um parâmetro que indica se deve trazer apenas funcionários ativos, apenas inativos ou ambos. O retorno é ordenado por nome da pessoa. O parâmetro de filtro é opcional e, se omitido, traz todos. Se fornecido, deve indicar 0 para inativos ou 1 para ativos.

## Observações Importantes 📝

Este projeto foi desenvolvido com foco na simplicidade e eficiência. As operações básicas de controle de treinamento de funcionários são suportadas, proporcionando uma base sólida para expansões futuras.

Sinta-se à vontade para contribuir e melhorar este projeto! 🙌

--- 

Divirta-se construindo seu controle de treinamento de funcionários com esta API! 😄🚀