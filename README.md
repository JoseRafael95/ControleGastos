# Controle de Gastos - API em Spring Boot

## 1. Visão Geral do Projeto  
O Controle de Gastos API é um projeto desenvolvido como parte dos meus estudos em Java e Spring Framework. A aplicação permite que usuários gerenciem suas despesas e receitas de forma categorizada,
oferecendo uma visão clara de sua saúde financeira. O principal objetivo foi aplicar e solidificar conhecimentos em tecnologias modernas do ecossistema Java, construindo uma aplicação robusta, 
segura e escalável, desde a configuração inicial até a implementação de testes e segurança.

## 2. Tecnologias e Ferramentas Utilizadas 
- Linguagem: Java 17
- Framework Principal: Spring Boot 3
- Persistência de Dados:
    - Spring Data JPA: Mapeamento Objeto-Relacional (ORM).
    - Banco de Dados em Memória: H2 Database (para ambiente de desenvolvimento e testes). 
- Segurança:
  - Spring Security: Estrutura de segurança.
  - JWT (JSON Web Tokens): Para autenticação e autorização stateless.
- Arquitetura e Padrões de Projeto:
  - Estrutura em Camadas (Controller, Service, Repository): Separação clara de responsabilidades.
  - DTO (Data Transfer Object): Para transferência de dados entre as camadas, evitando a exposição de entidades do domínio.
- Testes 
  - JUnit 5: Para testes unitários.
  - Mockito: Para criação de mocks em testes.
- Validação:
  - Bean Validation (Jakarta Validation): Para validação declarativa dos dados de entrada. 

## 3. Funcionalidades  
- Cadastro, atualização, remoção e listagem de despesas(CRUD)  
- Paginação de resultados   
- Validação de dados na entrada  
- Segurança via JWT (autenticação e autorização)  
- Tratamento de exceções personalizado  
- Testes automatizados cobrindo funcionalidades 

## 4. Estrutura do Projeto  
 ```
src
└── main
  └── java
    └── com.jRafael
      ├── controller 
      ├── dto 
      ├── entity 
      ├── repository 
      ├── security 
      ├── service 
      └── ControleGastosApplication.java 
└── test
  └── java
    └── com.jRafael
        └── service
```
### Descrição das pastas e arquivos principais:

- **controller**: Camada responsável por receber e responder às requisições HTTP.
- **dto**: Objetos usados para transferir dados entre as camadas da aplicação (Data Transfer Objects).
- **entity**: Classes mapeadas com o banco de dados utilizando JPA (entidades do domínio).
- **repository**: Interfaces que fazem a comunicação com o banco de dados utilizando Spring Data JPA.
- **security**: Configurações relacionadas à segurança da aplicação, como autenticação e autorização via JWT.
- **service**: Camada que contém a lógica de negócio da aplicação.
- **ControleGastosApplication.java**: Classe principal que inicializa e configura a aplicação Spring Boot.
- **test/java/com.jRafael.service**: Contém os testes automatizados da camada de serviço.

## 5. Como Rodar o Projeto  
### ✅ Pré-requisitos
- Java 21+
- Maven
- IDE como IntelliJ ou VS Code (opcional, mas recomendado)
- Git instalado

````
# Clone este repositório
git clone https://github.com/seu-usuario/seu-repositorio.git

# Acesse a pasta do projeto no terminal/cmd
cd seu-repositorio

# Execute o projeto com o Maven
./mvnw spring-boot:run

# A aplicação estará disponível em http://localhost:8080
````
## 6. Exemplos de Uso da API (Postman)  

Rotas marcadas com 🔒 podem exigir um token de autenticação JWT no cabeçalho `Authorization`.

### Usuários (Users)

| Método HTTP | Caminho (Endpoint) | Descrição |
| :--- | :--- | :--- |
| `POST` | `/user/login` | Realiza o login de um usuário e retorna um token. |
| `GET` | `/user` | **(FindAll)** Retorna a lista de todos os usuários. 🔒 |
| `POST` | `/user` | **(Save)** Cria um novo usuário. |
| `GET` | `/user/{email}` | **(FindByEmail)** Busca um usuário pelo e-mail. 🔒 |
| `PUT` | `/user/{email}` | **(Update)** Atualiza os dados de um usuário. 🔒 |
| `DELETE` | `/user/{email}` | **(Delete)** Exclui um usuário pelo e-mail. 🔒 |

***

### Categorias (Categories) 

| Método HTTP | Caminho (Endpoint) | Descrição |
| :--- | :--- | :--- |
| `GET` | `/category` | **(FindAll)** Retorna a lista de todas as categorias. 🔒|
| `POST` | `/category` | **(Save)** Cria uma nova categoria. 🔒|
| `GET` | `/category/{name}` | **(FindByName)** Busca uma categoria pelo nome. 🔒 |
| `PUT` | `/category/{name}` | **(Update)** Atualiza uma categoria existente. 🔒 |
| `DELETE` | `/category/{name}` | **(DeleteByName)** Exclui uma categoria pelo nome. 🔒 |


***

### Transações (Transactions) 

| Método HTTP | Caminho (Endpoint) | Descrição |
| :--- | :--- | :--- |
| `GET` | `/transaction` | **(FindAll)** Retorna a lista de todas as transações. 🔒 |
| `POST` | `/transaction` | **(Save)** Cria uma nova transação. 🔒 |
| `PUT` | `/transaction/{id}` | **(Update)** Atualiza uma transação existente pelo seu ID. 🔒 |
