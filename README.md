# Bem vindo à DEVinHouse <img width="180px" alt="Philips" src="ExerciciosM02S10/images/logo-phil.png"/>
## Módulo 02 - Semana 10

Repositório criado para a elaboração dos 10 exercícios referentes a essa semana. <br>

Para visualizar os exercícios, <a href="https://github.com/GeorgeEnriqueBravo/DEVinHouse-Modulo02-Semana10/archive/refs/heads/main.zip" target="_blank">
    clique aqui
</a>
para baixa-los. <br>

Após o download, abra a pasta "ExerciciosM02S10" utilizando o software `IntelliJ`. Para baixar a última versão grátis do IntelliJ 
<a href="https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC" target="_blank">
    clique aqui
</a>.
  
---

# Lista de exercícios <img width="75px" alt="Philips" src="ExerciciosM02S10/images/lista.png"/>
### [M2S10] Ex 1 - Criação do endpoint Exibe Produto

Criar um endpoint para exibir um Produto.

Esse endpoint deve levar uma página criada pelo Spring com informações pré criadas no HTML.

Na página deve conter:

- O nome do produto,
- Uma descrição dele,
- A data de lançamento e
- Um valor para o mesmo.

### [M2S10] Ex 2 - Criação do Model do Produto

- Criar um Model do Produto. Utilizando a biblioteca do "Spring Data".
- Criar um Model do Produdo adicionando um ID como chave primária.
- Conectar esse programa ao banco de dados criando um repository CRUD, e por fim criar um objeto local de Produto e exibir as suas informações na página criada anteriormente.

O Banco de dados pode ser um H2

### [M2S10] Ex 3 - Criação dos endpoint Exibe Todos os Produtos e Criar novos produtos

- Criar um Service para para realizar a comunicação do "endpoint" do Produto com o Repositório do banco de dados.
- Implementar um método para encontrar todos os produtos armazenados e um método para criar novos produtos.
- Criar um formulário para a inclusão de novos produtos por meio de um método POST.

### [M2S10] Ex 4 - Criação dos endpoint Deletar Produtos por ID e Atualiza produtos por ID

- Criar um método dentro do Service para realizar a atualização de um Produto, e um método para realizar a deleção de um produto.
- Ambos os processo devem ser feitos por meio do ID do produto.

Devemos ter controller e telas para acessar esses services.

### [M2S10] Ex 5 - Adcionando segurança

- Adicionar o componente Spring de Segurança e realizar a configuração de forma que não seja possível acessar o programa sem a autenticação.
- Adicionar a lógica de autenticação de forma que apenas os usuários que possuírem as informações: usuário e senha, determinado pelo sistema, possam visualizar os pedidos.

### [M2S10] Ex 6 - Criando páginas de login e de logout

- Criar uma página de login e uma de logout para o sistema.
- Configurar de forma que, atuem juntamente com a configuração de segurança para permitir, ao usuário determinado, entrar no sistema.

### [M2S10] Ex 7 - Criando a classe Usuário

- Criar Model para Usuário que deverá ser usado para o armazenar e verificar os logins no sistemas.
- O usuário deve estar associado ao Produto ao qual tem o acesso, sendo assim, cada usuário que logar poderá apenas ver os próprios produtos.

### [M2S10] Ex 8 - Defina JWT

- Definir o que é JWT, suas utilizações e o seu modo de funcionamento.
- Criar um passo a passo de uma requisição que utiliza o JWT.
- Gerar um JWT de exemplo que possa ser lido e utilizado por um programa.

### [M2S10] Ex 9 - Criação de uma api com autenticação por JWT

- Criar uma API que permite o acesso a um endpoint /hello, que retorna uma string "hello world" ao ser acessado por um usuários, autenticados e autorizados, através de uma requisição que carrega um token JWT válida.
- Essa requisição deve ser negada para um usuário sem autenticação/autorização.

### [M2S10] Ex 10 - Adicionando funcionalidade a API com JWT

- Adicionar à API, criada no exercício anterior, o mesmo model Produto criado anteriormente.
- Criar uma lógica CRUD para: criar, ler, atualizar e deletar, Produtos utilizando requisições autenticadas por JWT.
- Essa requisição deve ser negada para um usuário sem autenticação/autorização.

---

# O que é DEVinHouse?
DEVinhouse é uma jornada de aceleração da carreira com: grade curricular direcionada, professores do mercado, prática constante, interação frequente com as houses parceiras de cada turma, simulação do dia-a-dia DEV e vagas exclusivas que são abertas pelas Houses durante a jornada.

No DEVinHouse você vira um desenvolvedor Fullstack em 9 meses, ao longo de 900 horas de conteúdo, divididas em três módulos de 3 meses cada, com intervalo de uma semana entre cada um. Aproximadamente 25 horas de dedicação por semana entre aulas, atividades e vivências.

__1º módulo:__ Front-End – JavaScript e Angular <br/>
__2º módulo:__ Back-End – Java, Spring e SQL <br/>
__3º módulo:__ Full-Stack – Scrum, DevOps, Clean Code e Design Patterns <br/>
__Ferramentas__ – GitHub, Trello e Slack

---

# Tecnologias Utilizadas <img width="35px" alt="🌐" src="ExerciciosM02S10/images/tag.gif"/>
Nos exercícios dessa semana foram utilizadas as seguintes tecnologias:
<div style="display: inline_block">
    <img align="center" alt="Java" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
    <img align="center" alt="Spring" src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
    <img align="center" alt="Intellij" src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white"/>
    <img align="center" alt="Oracle" src="https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=black"/>
    <img align="center" alt="Trello" src="https://img.shields.io/badge/Trello-0052CC?style=for-the-badge&logo=trello&logoColor=white"/>
    <img align="center" alt="GitHub" src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"/>
</div>
