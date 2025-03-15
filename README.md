## Music Show - Projeto Web

## Descrição
O **Music Show** é um sistema web para gerenciamento de bandas, músicos, repertórios e músicas. Ele permite que bandas sejam criadas, membros sejam adicionados, músicas sejam gerenciadas e repertórios sejam montados. O sistema também fornece autenticação para usuários através de login.

## Tecnologias Utilizadas
- **Java** com **Spring Boot** para o backend
- **Spring Security** para autenticação
- **Swagger (OpenAPI)** para documentação da API
- **Banco de Dados Relacional** (Ex: MySQL, PostgreSQL)

## Estrutura do Projeto
```
MusicShow.ProjetoWeb
│── Controller          # Controladores da API
│── Dto                # Objetos de Transferência de Dados
│── Model              # Modelos de Entidades
│── Service            # Camada de Serviço
│── Security           # Configuração de Segurança
│── Repository         # Camada de Acesso ao Banco de Dados
```

## Endpoints da API

### 1. Autenticação
| Método  | Endpoint         | Descrição |
|---------|----------------|-------------|
| POST    | /api/public/login   | Autentica um usuário (músico) |
| POST    | /api/public/cadastro | Cadastra um novo músico |

### 2. Gerenciamento de Bandas
| Método  | Endpoint            | Descrição |
|---------|-------------------|-------------|
| POST    | /api/bandas/criar | Cria uma nova banda |
| POST    | /api/bandas/adicionarMembro | Adiciona um músico a uma banda |
| GET     | /api/bandas/listarMembros/{bandaId} | Lista os membros de uma banda |

### 3. Gerenciamento de Músicas
| Método  | Endpoint            | Descrição |
|---------|-------------------|-------------|
| POST    | /api/musicas/adicionar | Adiciona uma nova música |
| GET     | /api/musicas       | Lista todas as músicas cadastradas |

### 4. Gerenciamento de Repertórios
| Método  | Endpoint            | Descrição |
|---------|-------------------|-------------|
| POST    | /api/repertorio/adicionar | Adiciona um novo repertório a uma banda |
| DELETE  | /api/repertorio/remover/{idRepertorio} | Remove um repertório de uma banda |
| POST    | /api/repertorio/musica | Adiciona uma música a um repertório |

## Como Rodar o Projeto
1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/music-show.git
   ```
2. Acesse o diretório do projeto:
   ```sh
   cd music-show
   ```
3. Configure o banco de dados no arquivo `application.properties`.
4. Execute o projeto com:
   ```sh
   mvn spring-boot:run
   ```

## Documentação da API
A documentação da API está disponível no Swagger:
```
http://localhost:8080/swagger-ui.html
```

## Contribuição
1. Fork o repositório.
2. Crie uma branch com sua feature:
   ```sh
   git checkout -b minha-feature
   ```
3. Commit suas mudanças:
   ```sh
   git commit -m "Adiciona nova funcionalidade"
   ```
4. Envie para o repositório remoto:
   ```sh
   git push origin minha-feature
   ```
5. Crie um Pull Request.

## Licença
Este projeto está sob a licença MIT.

