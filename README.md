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

---
