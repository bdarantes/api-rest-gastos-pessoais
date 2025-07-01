# 💸 Gerenciador de Transações com Spring Boot

Este projeto é uma API REST desenvolvida em Java com Spring Boot para gerenciar  
**usuários** e suas **transações financeiras** (receitas e despesas).  
A aplicação permite realizar operações de cadastro, consulta, atualização e exclusão,  
utilizando DTOs com validação, relacionamento entre entidades e uma arquitetura em camadas.

---

## ⚙️ Funcionalidades

- ✅ CRUD de Usuários
- ✅ CRUD de Transações (Receitas e Despesas)
- ✅ Validações com Bean Validation (`@NotBlank`, `@DecimalMin`, `@Size`, entre outras)
- ✅ Relacionamento entre `Transacao` e `Usuario` (`@ManyToOne`)
- ✅ Enum `TipoTransacao` para diferenciar receitas e despesas
- ✅ Mapeamento manual entre entidades e DTOs
- ✅ Organização do projeto por camadas (Controller, Service, Repository)

---

## 🛠️ Tecnologias utilizadas

- Java 24
- Spring Boot 3
- Spring Data JPA
- Hibernate
- Validações com Bean Validation (atualmente Jakarta Validation)
- Gerenciador de dependências Maven
- H2 Database
- IntelliJ

---

## 📁 Estrutura do projeto

```
src/
├── main/
│ ├── java/
│ │ └── com/
│ │ └── example/
│ │ └── gastos_pessoais/
│ │ ├── controllers/
│ │ ├── dtos/
│ │ ├── mappers/
│ │ ├── models/
│ │ ├── repositories/
│ │ └── services/
│ └── resources/
│ └── application.properties
```

---

## 🔧 Requisitos

- Java 24 ou superior
- Maven 3.8+
- Git
- IDE ou editor de código conforme a preferência

---

## 🚀 Como executar o projeto

```bash
# Clone o repositório
git clone git@github.com:bdarantes/api-rest-gastos-pessoais.git

# Acesse a pasta do projeto
cd api-rest-gastos-pessoais

# Rode o projeto com Maven (Linux/Mac)
./mvnw spring-boot:run

# Ou no Windows
mvnw spring-boot:run
```

A aplicação estará disponível em:  
👉 http://localhost:8080

---

## 🧪 Endpoints principais

### 🧍 Usuários

| Método | Endpoint         | Descrição                 |
|--------|------------------|---------------------------|
| GET    | /usuarios        | Listar todos os usuários  |
| GET    | /usuarios/{id}   | Buscar usuário por ID     |
| POST   | /usuarios        | Criar um novo usuário     |
| PUT    | /usuarios/{id}   | Atualizar usuário         |
| DELETE | /usuarios/{id}   | Remover usuário           |

### 💰 Transações

| Método | Endpoint           | Descrição                    |
|--------|--------------------|------------------------------|
| GET    | /transacoes        | Listar todas as transações   |
| GET    | /transacoes/{id}   | Buscar transação por ID      |
| POST   | /transacoes        | Criar uma transação          |
| PUT    | /transacoes/{id}   | Atualizar uma transação      |
| DELETE | /transacoes/{id}   | Deletar uma transação        |
|

---

## 🧾 Licença

Licença ainda não definida. Este projeto ainda está em desenvolvimento.


---

## 🙋‍♂️ Autor

Feito com 💙 por Braz Daniel 
GitHub: @bdarantes 
