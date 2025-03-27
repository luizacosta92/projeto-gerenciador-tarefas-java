# 📌 TaskNager - Gerenciador de Tarefas Inteligente

## 📍 Visão Geral

Este repositório contém a implementação do **TaskNager**, um **Gerenciador de Tarefas Inteligente**, desenvolvido em **Java**, para auxiliar profissionais na organização e gerenciamento de suas atividades diárias. 

A aplicação permite **cadastrar, listar, filtrar e ordenar tarefas**, garantindo que nenhuma tarefa seja registrada com prazos inválidos. Além disso, o sistema foi projetado para futuras implementações de **notificações automáticas**, avisando os usuários sobre prazos próximos.

---

## 🚀 Funcionalidades Implementadas

### ✅ Cadastro de Tarefas  
Cada tarefa possui os seguintes atributos:
- **Título:** Não pode ser vazio e deve ter pelo menos 5 caracteres.
- **Descrição:** Texto livre para detalhar a tarefa.
- **Data limite (Deadline):** Não pode ser uma data passada.
- **Status:** `Pendente`, `Em andamento` ou `Concluído`.

### ✅ Gerenciamento e Filtragem  
- Listagem de todas as tarefas cadastradas.
- Filtragem de tarefas com base no status.
- Ordenação de tarefas pela data limite.

### ✅ Validação de Dados  
- Bloqueio de tarefas com títulos muito curtos.
- Garantia de que toda tarefa cadastrada possua um status válido.
- Impedimento do registro de tarefas com datas inválidas.

---

## 🛠 Tecnologias e Conceitos Utilizados

- **Linguagem:** Java  
- **Manipulação de Datas:** API `java.time`  
- **Programação Funcional:** `Streams`, `Optional` e `Predicate` para validação e processamento de tarefas.  
- **Ordenação e Filtragem:** Uso de `Comparator` e `Collectors` para classificação e busca das tarefas.  
- **Estruturação em Classes:** Implementação de padrões limpos e coesos para gerenciamento de tarefas.  

---

## 📂 Estrutura do Código

### 🔹 `Task.java`
Define a estrutura da tarefa com título, descrição, status e data limite.

### 🔹 `StatusTask.java`
Enum que contém os status possíveis de uma tarefa: `Pendente`, `Em andamento`, `Concluído`.

### 🔹 `ManagerTask.java`
Classe responsável pelo gerenciamento das tarefas, incluindo cadastro, listagem, filtragem e ordenação.

### 🔹 `Filter.java`
Interface que define o método `filterStatus`, permitindo a filtragem de tarefas com base no status.

### 🔹 `Order.java`
Interface que define o método `orderDeadline`, permitindo a ordenação das tarefas por data limite.


---

## 📌 Próximas Melhorias e Versões Futuras
O **TaskNager** está na **primeira versão** e novas funcionalidades serão adicionadas nas próximas versões, como:
- **Notificações Inteligentes:** Alertas automáticos para tarefas com prazos próximos.
- **Persistência de Dados:** Armazenamento das tarefas em banco de dados ou arquivo.
- **Interface Gráfica:** Desenvolvimento de um painel para melhor interação com os usuários.

Fique atento às próximas atualizações! 🚀

---

## 📜 Licença

O **TaskNager** está licenciado sob a **MIT License**, permitindo que qualquer pessoa use, modifique e distribua o código livremente, desde que seja mantida a atribuição original ao autor.

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests para melhorias e novas funcionalidades.
