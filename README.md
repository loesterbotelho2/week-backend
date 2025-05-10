## 🚀 Como iniciar o projeto - Docker
```
docker-compose build --no-cache --parallel
```
```
docker-compose up -d
```
```
docker-compose up --build -d
```

## 🚀 health
http://localhost:8080/health

## 🚀 swagger
http://localhost:8080/swagger-ui/index.html

## 📁 Estrutura de Pacotes Recomendada


com.nexuscare.recipe

| Pacote         | Descrição                                                  |
|----------------|------------------------------------------------------------|
| `controller`   | Camada de entrada (REST APIs)                              |
| `dto`          | Objetos de transferência de dados (Data Transfer Object)   |
| `model`        | Entidades JPA (ou `entity`)                                |
| `repository`   | Repositórios Spring Data JPA (substitui a camada DAO)      |
| `service`      | Camada de regras de negócio (serviços)                     |
| `mapper`       | Conversores entre `model` e `dto` (usando MapStruct, etc.) |
| `config`       | Configurações da aplicação (Swagger, CORS, Security, etc.) |

## 📁 Configurar variável de ambiente do eclipse

![Descrição da imagem](imgs/env_eclipse.png)

## 🚀 Exemplo

Infecções respiratórias e bronquite bacteriana
doença relampago x10 2040

![Descrição da imagem](imgs/swagger-exemplo.png)
