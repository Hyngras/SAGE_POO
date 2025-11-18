# SAGE — Sistema de Acompanhamento e Gerenciamento de Equipamentos Hospitalares

## Sobre o Projeto
O **SAGE** é uma aplicação orientada a objetos em Java, criada como parte da disciplina de **Programação Orientada a Objetos (POO)** no curso de Análise e Desenvolvimento de Sistemas da [CESAR School]

O sistema tem como objetivo gerenciar a manutenção de equipamentos hospitalares, permitindo abertura e fechamento de ordens de serviço, cadastro de equipamentos e visualização de indicadores de manutenção.

---

## Equipe
- Diego Alves Xavier  
- Hyngrid Souza e Silva  
- Pamela Teixeira Rodrigues  

---

## Funcionalidades (MVP)
- Cadastro e consulta de equipamentos  
- Abertura e fechamento de ordens de serviço  
- Dashboard simples com indicadores de manutenção  
- Persistência em arquivo (JSON)  

---

## Entregas do Projeto

<details>
  <summary><strong>📦 Entrega 01</strong></summary>

  <p>
    A primeira entrega visa garantir o alinhamento inicial do projeto, 
    documentando claramente as funcionalidades esperadas e preparando 
    a base visual para seu desenvolvimento.
  </p>

  <h3> Critérios exigidos</h3>

  <ul>
    <li>
      Documento descrevendo regras de negócio e cenários BDD: 
      <a href="Arquivos/Historias.md"><strong>Historias</strong></a>
    </li>
    <li>
      Link para o protótipo: 
      <a href="https://www.figma.com/design/fNpzjR1EqV8dfAkAnqauC4/SAGE?node-id=0-1&p=f"><strong>Figma - Protótipo</strong></a>
    </li>
    <li>
      Screencast apresentando o protótipo: 
      <a href="https://youtu.be/WLbz_-dBa8k"><strong>YouTube - Protótipo</strong></a>
    </li>
  </ul>

</details>


<details>
  <summary><strong>📦 Entrega 02</strong></summary>

  <p>A primeira entrega visa implementar ao menos duas histórias.</p>

  <hr>

  <h3>✅ Primeira história implementada</h3>
  <p><strong>HU-001 — Visualização de Dashboard</strong></p>
  <p><em>História do Usuário:</em><br>
  Como <strong>gestor hospitalar</strong>, quero ver um painel de controle com status dos equipamentos e ordens de serviço, para tomar decisões rápidas.</p>
  <img src="https://github.com/user-attachments/assets/7aeef2bf-0347-4832-8d07-4edb07897ca9" alt="Dashboard" width="800" style="border-radius:10px; box-shadow:0 2px 8px rgba(0,0,0,0.15);" />

  <hr>

  <h3>✅ Segunda história implementada</h3>
  <p><strong>HU-003 — Abertura de Ordem de Serviço (O.S.)</strong></p>
  <p><em>História do Usuário:</em><br>
  Como <strong>técnico de manutenção</strong>, quero abrir uma O.S. rapidamente, para garantir que os equipamentos sejam reparados sem atrasos.</p>
  <img src="https://github.com/user-attachments/assets/5245e5fc-8f02-4261-8d95-63d4d7ef500c" alt="Abertura de O.S." width="800" style="border-radius:10px; box-shadow:0 2px 8px rgba(0,0,0,0.15);" />

  <h3>Issue/bug tracker atualizado:</h3>
  <img width="1894" height="652" alt="image" src="https://github.com/user-attachments/assets/2318ba20-fedc-4b87-963d-1a86d16d340f" />
  <img width="1912" height="709" alt="image" src="https://github.com/user-attachments/assets/ff659310-8701-47ad-b3de-48bfa752dc8c" />

</details>

<details>
    <summary><strong>📦 Entrega 03</strong></summary>

  <p>A terceira entrega visa implementar mais duas histórias.</p>

  <hr>

  <h3>✅ Primeira história implementada</h3>
  <p><strong>HU-002 — Consulta de Equipamento</strong></p>
  <p><em>História do Usuário:</em><br>
  Como <strong>técnico de manutenção</strong>, quero consultar um equipamento pelo código ou nome, para ver seu histórico de manutenção.</p>

  <h4>Critérios de Aceitação:</h4>
  <ul>
    <li>Permitir busca por nome, código ou categoria.</li>
    <li>Mostrar status atual do equipamento.</li>
    <li>Listar histórico completo de manutenções.</li>
  </ul>

  <h4>Regras de Negócio (RN):</h4>
  <ul>
    <li><strong>RN1:</strong> Cada equipamento deve ter um identificador único.</li>
    <li><strong>RN2:</strong> O status exibido deve refletir a última O.S. relacionada.</li>
    <li><strong>RN3:</strong> Histórico deve incluir todas as intervenções (preventivas e corretivas).</li>
  </ul>

  <h4>Cenários BDD:</h4>
  <ul>
    <li>Dado que eu tenha um equipamento com histórico de manutenção, quando eu buscar por nome, código ou categoria, então o sistema deve mostrar o status atual e o histórico completo de manutenções.</li>
    <li>Dado que o status de um equipamento foi alterado, quando eu visualizar o equipamento, então o status exibido deve refletir a última O.S. relacionada.</li>
  </ul>

  <img width="1280" height="587" src="https://github.com/user-attachments/assets/1c83dbe0-11f8-4a07-9bfb-c1a509311e35" alt="Consulta de Equipamento" width="800" style="border-radius:10px; box-shadow:0 2px 8px rgba(0,0,0,0.15);" />

  <hr>

  <h3>✅ Segunda história implementada</h3>
<p><strong>HU-004 — Dashboard Administrativo</strong></p>
<p><em>História do Usuário:</em><br>
Como <strong>gestor hospitalar</strong>, quero visualizar um dashboard administrativo com dados sobre equipamentos, ordens de serviço e status de manutenção, para acompanhar a performance dos recursos de maneira eficiente.</p>

<h4>Critérios de Aceitação</h4>

- Exibir indicadores principais: total de equipamentos, ordens de serviço abertas e status de manutenção.  
- Permitir filtro por período e tipo de manutenção.  
- Exibir mensagem “Sem registros para o período” quando não houver dados.

<h4>Regras de Negócio (RN)</h4>

- RN1: O status do equipamento deve refletir a última O.S. associada.  
- RN2: O semáforo indica criticidade (verde ≥ 80%, amarelo 60–79%, vermelho < 60%).  
- RN3: Contagem de O.S. abertas considera apenas estados “ABERTA” e “EM_ANDAMENTO”.

<h4>Cenários BDD</h4>

- Dado que existam equipamentos e O.S. registradas, quando o usuário acessar o dashboard, então os indicadores devem ser exibidos corretamente.  
- Dado que o usuário aplique um filtro de data, quando o período for válido, então os dados devem refletir apenas esse intervalo.  
- Dado que não existam registros no período selecionado, quando o dashboard for atualizado, então deve exibir zero e a mensagem “Sem registros para o período”.

<br>

<img width="1280" height="564" src="https://github.com/user-attachments/assets/cc8e6a93-72bd-4ce5-ab5e-fa9de522c1d0" alt="Dashboard Administrativo" width="800" style="border-radius:10px; box-shadow:0 2px 8px rgba(0,0,0,0.15);" />

<h3>Issue/bug tracker atualizado:</h3>
<img width="1886" height="799" alt="image" src="https://github.com/user-attachments/assets/e1a297a8-af75-4239-bed2-62a1eff554b1" />

<hr>  

<h2>Testes Automatizados</h2>

<p>Os testes foram criados com <strong>JUnit 5</strong> e simulam o comportamento das histórias <strong>HU-002</strong> e <strong>HU-004</strong>.</p>

<h3>Casos de Teste</h3>
<ul>
  <li><strong>HU-002:</strong> Valida a busca de um equipamento pelo nome.</li>
  <li><strong>HU-004:</strong> Verifica a consistência dos indicadores do dashboard administrativo.</li>
</ul>

<h3>Execução dos Testes</h3>
<pre><code>mvn test
</code></pre>

<h3>Screencast dos Testes Automatizados</h3>
<p>Screencast apresentando os testes executados no terminal, com os resultados do Maven:</p>
<p><a href="https://youtu.be/YRql8VrhqRg" target="_blank"><strong>Assista no YouTube</strong></a></p>

<h3>Screencast das telas</h3>
<p><a href="https://youtu.be/LjIiI4lecJ4" target="_blank"><strong>Assista no YouTube</strong></a></p>

</details>

<details>
    <summary><strong>📦 Entrega 04</strong></summary>

  <p>A quarta entrega foca na implementação do fluxo completo do <strong>Agente Externo</strong>, criando um portal de serviços simplificado e os formulários de solicitação essenciais para esse perfil de usuário.</p>

  <hr>

  <h3>✅ Primeira história implementada</h3>
  <p><strong>HU-014 — Portal do Agente Externo</strong></p>
  <p><em>História do Usuário:</em><br>
  Como <strong>agente externo (ex: enfermeiro, funcionário)</strong>, quero acessar um portal simplificado, para poder rapidamente navegar para as funções de solicitação, avaliação ou instrução.</p>

  <h4>Critérios de Aceitação:</h4>
  <ul>
    <li>O portal deve exibir três opções claras: "Solicitar manutenção corretiva", "Avaliar serviço ou funcionário" e "Solicitar instrução de equipamento".</li>
    <li>O portal deve ter um botão de "Sair" que retorna à tela de Login.</li>
    <li>O design deve ser limpo e centralizado, seguindo a identidade visual do SAGE.</li>
  </ul>

  <h4>Regras de Negócio (RN):</h4>
  <ul>
    <li><strong>RN1:</strong> O agente externo não pode, em nenhuma circunstância, aceder aos dashboards de engenharia ou administração.</li>
    <li><strong>RN2:</strong> O portal serve como um "hub" de navegação, e cada opção deve levar ao seu respectivo fluxo.</li>
  </ul>

  <h4>Cenários BDD:</h4>
  <ul>
    <li>Dado que sou um agente externo logado, quando eu acedo ao meu painel, então eu devo ver o portal simplificado com as três opções de serviço.</li>
    <li>Dado que estou no portal, quando eu clico em "Sair", então eu devo ser deslogado e redirecionado para a tela de Login.</li>
  </ul>

  <img width="1916" height="855" alt="image" src="https://github.com/user-attachments/assets/e1453ca9-c19a-4461-bd01-303133928111" />


  <hr>

  <h3>✅ Segunda história implementada</h3>
<p><strong>HU-015 — Formulários de Solicitação do Agente</strong></p>
<p><em>História do Usuário:</em><br>
Como <strong>agente externo</strong>, quero usar as opções do portal para abrir formulários específicos e registrar as minhas necessidades (manutenção, avaliação ou instrução).</p>

<h4>Critérios de Aceitação</h4>

- Ao clicar em "Solicitar manutenção corretiva", o sistema deve exibir o formulário de manutenção (HU-015.1).
- Ao clicar em "Avaliar serviço ou funcionário", o sistema deve exibir o formulário de avaliação (HU-015.2).
- Ao clicar em "Solicitar instrução de equipamento", o sistema deve exibir o formulário de instrução (HU-015.3).
- Todos os formulários devem seguir o mesmo padrão visual e ter um botão "Voltar" que retorne ao portal.

<h4>Regras de Negócio (RN)</h4>

- RN1: Cada formulário deve capturar as informações mínimas necessárias para a respectiva solicitação (ex: tipo de equipamento, descrição do problema).
- RN2: A submissão de cada formulário deve (futuramente) gerar um novo registo rastreável no sistema para a equipe técnica.

<h4>Cenários BDD</h4>

- Dado que estou no portal, quando clico em "Solicitar manutenção corretiva", então o formulário `solicitar-manutencao` é exibido.
- Dado que estou no portal, quando clico em "Avaliar serviço...", então o formulário `avaliar-servico` é exibido.
- Dado que estou no formulário de instrução, quando clico em "Voltar", então eu devo retornar para o `/portal/agente`.

<br>

<p><strong>Exemplo de Formulário: Solicitação de Manutenção Corretiva (HU-015.1)</strong></p>
<img width="1917" height="869" alt="image" src="https://github.com/user-attachments/assets/d6d09fb8-b1ab-4064-b94f-b76156965cec" alt="Formulário de Solicitação de Manutenção" width="800" style="border-radius:10px; box-shadow:0 2px 8px rgba(0,0,0,0.15);" />

<br>
<p><strong>Exemplo de Formulário: Avaliar Serviço ou Funcionário (HU-015.2)</strong></p>
<img width="1913" height="862" alt="image" src="https://github.com/user-attachments/assets/7298a969-ebc9-423e-93ce-689c0d71aaf5" alt="Formulário de Avaliação" width="800" style="border-radius:10px; box-shadow:0 2px 8px rgba(0,0,0,0.15);" />

<br>
<p><strong>Exemplo de Formulário: Solicitar Instrução de Equipamento (HU-015.3)</strong></p>
<img width="1912" height="886" alt="image" src="https://github.com/user-attachments/assets/9a9eb7d4-1b3d-4e02-a029-9db816dcc6ee" alt="Formulário de Instrução" width="800" style="border-radius:10px; box-shadow:0 2px 8px rgba(0,0,0,0.15);" />


<h3>Issue/bug tracker atualizado:</h3>
<img width="1912" height="854" alt="image" src="https://github.com/user-attachments/assets/d90df111-ef42-402c-a1a9-3947d44d279f" />


<hr>  

<h2>Testes Automatizados</h2>

<p>Os testes foram criados com <strong>JUnit 5</strong> e <strong>Spring Boot Test</strong> para simular o comportamento dos controllers (<code>@GetMapping</code>) que servem as novas telas.</p>

<h3>Casos de Teste</h3>
<ul>
  <li><strong>HU-014:</strong> Valida se o acesso ao <code>/dashboard/agente</code> retorna o status HTTP 200 (OK) e renderiza a view "agente-externo".</li>
  <li><strong>HU-015.1:</strong> Valida se o acesso ao <code>/dashboard/solicitar-manutencao</code> retorna o status HTTP 200 (OK) e renderiza a view "solicitar-manutencao".</li>
  <li><strong>HU-015.2:</strong> Valida se o acesso ao <code>/dashboard/avaliar-servico</code> retorna o status HTTP 200 (OK) e renderiza a view "avaliar-servico".</li>
   <li><strong>HU-015.3:</strong> Valida se o acesso ao <code>/dashboard/solicitar-instrucao</code> retorna o status HTTP 200 (OK) e renderiza a view "solicitar-instrucao".</li>
</ul>

<h3>Execução dos Testes</h3>
<pre><code>mvn test
</code></pre>

<h3>Screencast dos Testes Automatizados</h3>
<p>Screencast apresentando os testes executados no terminal, com os resultados do Maven:</p>
<p><a href="https://youtu.be/J2CbcwRmgi8" target="_blank"><strong>Assista no YouTube</strong></a></p>

<h3>Screencast das telas</h3>
<p>Screencast apresentando a navegação entre o Portal do Agente Externo e os seus três formulários de solicitação:</p>
<p><a href="https://youtu.be/52okUwooVog" target="_blank"><strong>Assista no YouTube</strong></a></p>

</details>

<hr>

## 🚀 Como Executar o Projeto (Ambiente de Desenvolvimento)

Siga estes passos para configurar e executar a aplicação localmente na sua máquina.

### Requisitos Mínimos

* **Java (JDK):** Versão 17 ou superior.
* **IntelliJ IDEA** (ou outra IDE de sua preferência, como VS Code com a extensão Java).
* **Maven:** Versão 3.8 ou superior (geralmente já vem integrado no IntelliJ).

---

### Passos para Executar

1.  **Clone o Repositório:**
    ```bash
    git clone [https://github.com/Hyngras/SAGE_POO.git](https://github.com/Hyngras/SAGE_POO.git)
    cd SAGE_POO
    ```

2.  **Abra o Projeto na sua IDE:**
    * **IntelliJ IDEA:** Selecione `File` > `Open...` e escolha a pasta `SAGE_POO` que você acabou de clonar. O IntelliJ irá detetar o ficheiro `pom.xml` e carregar todas as dependências do Maven automaticamente.
    * **VS Code:** Abra a pasta do projeto. Certifique-se de que tem o "Extension Pack for Java" instalado.

3.  **Execute a Aplicação:**
    * Encontre o ficheiro `SageApplication.java` (em `src/main/java/br/com/cesarschool/sage`).
    * **No IntelliJ:** Clique com o botão direito no ficheiro e selecione **Run 'SageApplication'**.
    * **No VS Code:** Abra o ficheiro e clique em **Run** acima do método `main`.

4.  **Acesse a Aplicação:**
    * O servidor Spring Boot iniciará. Você verá no seu terminal uma mensagem a indicar `Tomcat started on port 8080 (http)`.
    * Abra o seu navegador e acesse: `http://localhost:8080`
    * Para diretamente aos dashboards, utilize os URLs:
        * `http://localhost:8080/dashboard/engenheiro`
        * `http://localhost:8080/dashboard/admin`
