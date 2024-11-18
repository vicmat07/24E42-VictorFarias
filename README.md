# Sistema de Gerenciamento de Pacientes

## Resumo do Projeto

O **Sistema de Gerenciamento de Pacientes** foi desenvolvido para uma clínica de fisioterapia, utilizando **Java com Spring Boot**. O sistema permite a administração eficiente de dados e processos relacionados aos pacientes, oferecendo funcionalidades como:

- Criação, exclusão e listagem de registros de pacientes.
- Geração e recuperação de guias de atendimento.
- Agendamento, remoção e modificação de consultas.

Este sistema visa otimizar o fluxo de trabalho da clínica, garantindo agilidade e precisão no atendimento e na organização das sessões de fisioterapia. Além disso, implementa validações importantes, como a restrição de agendamentos de consultas para datas passadas e a necessidade de uma guia válida para adicionar consultas.

## Endpoints

### GuiaController

- **GET /guias/{idPaciente}**  
  Recupera a guia associada a um paciente específico.  
  **Resposta:** 200 OK (Guia encontrada), 404 Not Found (Guia não encontrada).

- **POST /guias/gerar**  
  Cria uma nova guia para um paciente.  
  **Resposta:** 201 Created (Guia criada).

### ConsultaController

- **POST /consultas**  
  Cria uma nova consulta para um paciente.  
  **Resposta:** 201 Created (Consulta criada).

- **PATCH /consultas**  
  Modifica a data de uma consulta existente.  
  **Resposta:** 200 OK (Consulta modificada).

- **DELETE /consultas/{idConsulta}**  
  Remove uma consulta específica.  
  **Resposta:** 200 OK (Consulta removida).

### PacienteController

- **GET /pacientes/lista**  
  Retorna uma lista de todos os pacientes.  
  **Resposta:** 200 OK (Lista de pacientes).

- **POST /pacientes**  
  Cria um novo paciente.  
  **Resposta:** 201 Created (Paciente criado).

- **GET /pacientes/buscar/{nome}**  
  Busca pacientes pelo nome.  
  **Resposta:** 200 OK (Lista de pacientes encontrados), 204 No Content (Nenhum paciente encontrado).

- **DELETE /pacientes/{idPaciente}**  
  Remove um paciente.  
  **Resposta:** 200 OK (Paciente removido).

### FisioterapeutaController

- **GET /fisioterapeutas/lista**  
  Recupera a lista de fisioterapeutas cadastrados.  
  **Resposta:** 200 OK (Lista de fisioterapeutas).

## Como Usar

### 1. Associação entre Paciente e Guia

Cada paciente no sistema possui uma única guia, que serve como documento de referência para as consultas realizadas. A guia está associada ao paciente, e somente um paciente pode ter uma guia ativa a qualquer momento.

### 2. Consultas Associadas a Guias

Uma guia pode conter uma ou mais consultas. Ao agendar uma consulta, o usuário deve selecionar a guia vinculada ao paciente. Se não houver uma guia válida, o sistema impedirá o agendamento da consulta e informará que uma nova guia precisa ser gerada.

### 3. Restrições de Data para Consultas

Consultas não podem ser agendadas para datas passadas. O sistema verifica a data da consulta antes de permitir o agendamento. Caso o usuário tente agendar uma consulta para uma data anterior, o sistema exibirá um erro.

### 4. Consultando Consultas Associadas a Guias

Para consultar a lista de consultas de um paciente, é necessário acessar a guia vinculada ao paciente. O sistema exibirá todas as consultas associadas àquela guia, incluindo informações sobre data, fisioterapeuta e status da consulta.

### 5. Fluxo de Uso no Sistema

- **Gerar Guia:** O primeiro passo é garantir que o paciente tenha uma guia válida.
- **Marcar Consulta:** Após a guia válida, o agendamento da consulta é feito. O sistema verifica a data da consulta para garantir a validade.
- **Verificar Consultas:** Para visualizar todas as consultas de um paciente, basta acessar a guia vinculada a ele.

Esse fluxo garante que o sistema mantenha um controle eficiente sobre as guias e consultas, evitando erros de agendamento e mantendo o atendimento organizado.

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database** (para desenvolvimento)
