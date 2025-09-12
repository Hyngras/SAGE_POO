# Histórias de Usuário — Projeto SAGE (POO em Java)

Disciplina: Programação Orientada a Objetos (POO)  
Instituição: CESAR School  
Equipe: Diego Alves Xavier, Hyngrid Souza e Silva, Pamela Teixeira Rodrigues  

---

## HU-001 — Visualização de Dashboard
**História do Usuário:**  
Como gestor hospitalar, quero ver um painel de controle com status dos equipamentos e ordens de serviço, para tomar decisões rápidas.

**Critérios de Aceitação:**
- Exibir status dos equipamentos e O.S. abertas.  
- Incluir indicadores visuais de criticidade.  
- Permitir filtros por período e tipo de manutenção.  

**Regras de Negócio (RN):**
- RN1 — O dashboard deve agregar dados de todas as O.S. em memória.  
- RN2 — Indicadores de criticidade devem seguir padrão (verde, amarelo, vermelho).  
- RN3 — Filtros devem considerar período (dia, semana, mês) e tipo (preventiva/corretiva).  

**Cenários BDD:**
- **Given** que existem O.S. abertas,  
  **When** acesso o dashboard,  
  **Then** devo ver a contagem de O.S. por status.  
- **Given** que aplico filtro por mês,  
  **When** confirmo a seleção,  
  **Then** só O.S. do período devem aparecer.  

**Implementação do Protótipo:**
<img width="917" height="699" alt="Captura de tela de 2025-09-12 14-36-33" src="https://github.com/user-attachments/assets/256b336d-def5-4c20-bc7f-bc1e9ad1b1af" />


---

## HU-002 — Consulta de Equipamento
**História do Usuário:**  
Como técnico de manutenção, quero consultar um equipamento pelo código ou nome, para ver seu histórico de manutenção.

**Critérios de Aceitação:**
- Permitir busca por nome, código ou categoria.  
- Mostrar status atual do equipamento.  
- Listar histórico completo de manutenções.  

**Regras de Negócio (RN):**
- RN1 — Cada equipamento deve ter um identificador único.  
- RN2 — O status exibido deve refletir a última O.S. relacionada.  
- RN3 — Histórico deve incluir todas as intervenções (preventivas e corretivas).  

**Cenários BDD:**
- **Given** que existe um equipamento cadastrado,  
  **When** busco pelo código,  
  **Then** o sistema deve retornar os dados e status atuais.  
- **Given** que não existe equipamento com o código informado,  
  **When** executo a busca,  
  **Then** o sistema deve exibir mensagem “nenhum resultado encontrado”.  

---

## HU-003 — Abertura de Ordem de Serviço (O.S.)
**História do Usuário:**  
Como técnico de manutenção, quero abrir uma O.S. rapidamente, para garantir que os equipamentos sejam reparados sem atrasos.

**Critérios de Aceitação:**
- Selecionar equipamento e relatar problema.  
- Definir prioridade da O.S. (Baixa, Média, Alta).  
- Atribuir técnico responsável.  

**Regras de Negócio (RN):**
- RN1 — O.S. só pode ser aberta para equipamento existente.  
- RN2 — Status inicial da O.S. deve ser **ABERTA**.  
- RN3 — O equipamento associado deve mudar para status **EM MANUTENÇÃO**.  

**Cenários BDD:**
- **Given** que estou logado como técnico,  
  **When** seleciono um equipamento e crio O.S.,  
  **Then** a O.S. deve ser salva com status “ABERTA”.  
- **Given** que a prioridade não é selecionada,  
  **When** salvo a O.S.,  
  **Then** o sistema deve retornar erro de validação.  

---

## HU-004 — Atribuição de Técnico à O.S.
**História do Usuário:**  
Como gestor, quero atribuir um técnico responsável a uma O.S., para garantir que ela seja atendida.

**Critérios de Aceitação:**
- Permitir seleção de técnico válido.  
- Atualizar O.S. com responsável e data de atribuição.  
- Alterar status para **EM ANDAMENTO**.  

**Regras de Negócio (RN):**
- RN1 — Apenas gestor pode atribuir técnico.  
- RN2 — Técnico deve estar cadastrado no sistema.  
- RN3 — Uma O.S. não pode ser atribuída duas vezes sem antes ser fechada.  

**Cenários BDD:**
- **Given** que existe uma O.S. aberta,  
  **When** atribuo um técnico válido,  
  **Then** a O.S. muda para “EM ANDAMENTO”.  

---

## HU-005 — Fechamento de O.S. com Relatório
**História do Usuário:**  
Como técnico de manutenção, quero registrar detalhes da O.S. ao encerrá-la, para manter um histórico completo das intervenções.

**Critérios de Aceitação:**
- O técnico pode adicionar descrição da manutenção realizada.  
- Registrar peças substituídas e tempo gasto.  
- Gerar relatório automático da intervenção.  

**Regras de Negócio (RN):**
- RN1 — O.S. só pode ser fechada por técnico atribuído ou gestor.  
- RN2 — É obrigatório registrar descrição e tempo gasto.  
- RN3 — Após fechamento, status deve ser atualizado para **FECHADA**.  

**Cenários BDD:**
- **Given** que existe uma O.S. em andamento,  
  **When** insiro descrição e tempo gasto,  
  **Then** a O.S. deve mudar para “FECHADA” e integrar ao histórico.  

---

## HU-006 — Controle de Contratos
**História do Usuário:**  
Como gestor hospitalar, quero monitorar contratos com fornecedores, para garantir conformidade e evitar problemas operacionais.

**Critérios de Aceitação:**
- Permitir cadastro e visualização dos contratos.  
- Gerar alertas para contratos próximos ao vencimento.  
- Anexar documentos contratuais.  

**Regras de Negócio (RN):**
- RN1 — Alertas devem ser enviados com 30 dias de antecedência.  
- RN2 — Cada contrato deve ter data de início, término e fornecedor.  
- RN3 — O contrato deve ser associado a pelo menos um equipamento.  

**Cenários BDD:**
- **Given** que existe contrato próximo do vencimento,  
  **When** acesso o painel de contratos,  
  **Then** devo ver alerta destacado.  

---

## HU-007 — Alertas Automáticos de Manutenção
**História do Usuário:**  
Como administrador da clínica, quero receber alertas sobre manutenções programadas, para garantir que os equipamentos estejam sempre operacionais.

**Critérios de Aceitação:**
- Alertas automáticos para manutenções preventivas.  
- Notificações sobre falhas recorrentes.  
- Opção de configurar preferências para receber alertas.  

**Regras de Negócio (RN):**
- RN1 — O sistema deve verificar falhas recorrentes (≥ 3 vezes/mês).  
- RN2 — Notificações podem ser via e-mail ou painel interno.  
- RN3 — Alertas de preventiva devem ser gerados no prazo configurado.  

**Cenários BDD:**
- **Given** que um equipamento tem manutenção preventiva agendada,  
  **When** a data se aproxima,  
  **Then** o sistema deve enviar notificação ao gestor.  

---

## HU-008 — Geração de Relatórios
**História do Usuário:**  
Como gestor hospitalar ou administrador, quero gerar relatórios sobre status dos equipamentos e O.S., para analisar métricas de desempenho.

**Critérios de Aceitação:**
- Permitir filtros personalizados para gerar relatórios.  
- Mostrar tempo médio de resposta e custo de manutenção.  
- Possibilidade de exportação em PDF e Excel.  

**Regras de Negócio (RN):**
- RN1 — Relatórios devem ser gerados em tempo real.  
- RN2 — Indicadores obrigatórios: tempo médio de resposta e custo total.  
- RN3 — Deve existir opção de exportar em PDF e Excel.  

**Cenários BDD:**
- **Given** que existem O.S. registradas,  
  **When** seleciono período e filtro,  
  **Then** devo obter relatório com métricas calculadas.  

---

## HU-009 — Gerenciamento de Estoque de Peças
**História do Usuário:**  
Como técnico de manutenção, quero ter controle sobre as peças disponíveis no estoque, para evitar atrasos na manutenção por falta de insumos.

**Critérios de Aceitação:**
- Permitir cadastro e controle de estoque de peças.  
- Notificar sobre itens com estoque baixo.  
- Registrar histórico de uso de peças em manutenções.  

**Regras de Negócio (RN):**
- RN1 — Cada peça deve ter código único.  
- RN2 — Alerta de estoque deve disparar quando quantidade ≤ mínimo definido.  
- RN3 — Histórico deve vincular peça usada à O.S. correspondente.  

**Cenários BDD:**
- **Given** que uma peça tem estoque < mínimo,  
  **When** consulto o estoque,  
  **Then** o sistema deve exibir alerta de “estoque baixo”.  

---

## HU-010 — Cadastro e Classificação de Equipamentos
**História do Usuário:**  
Como administrador da clínica, quero cadastrar novos equipamentos no sistema, para controlar seu ciclo de vida e manutenções.

**Critérios de Aceitação:**
- Permitir cadastro de novos equipamentos com detalhes técnicos.  
- Classificar equipamentos por tipo, localização e criticidade.  
- Vincular equipamentos a contratos de manutenção.  

**Regras de Negócio (RN):**
- RN1 — Campos obrigatórios: patrimônio, tipo, fabricante, localização, criticidade.  
- RN2 — Criticidade deve ser uma entre {BAIXA, MÉDIA, ALTA}.  
- RN3 — Equipamento deve ser vinculado a pelo menos uma categoria.  

**Cenários BDD:**
- **Given** que insiro patrimônio, tipo e fabricante,  
  **When** salvo cadastro,  
  **Then** o sistema deve armazenar equipamento com status inicial “OPERACIONAL”.  

---

## HU-011 — Painel de Prioridades e Urgências
**História do Usuário:**  
Como gestor hospitalar, quero visualizar um painel que prioriza as O.S. mais urgentes, para direcionar esforços rapidamente para as demandas críticas.

**Critérios de Aceitação:**
- Criar um painel destacando O.S. urgentes.  
- Permitir reordenação de prioridades em tempo real.  
- Integrar com alertas automáticos para notificação de emergências.  

**Regras de Negócio (RN):**
- RN1 — O.S. críticas (Alta prioridade) devem ser destacadas em vermelho.  
- RN2 — Mudança de prioridade deve refletir imediatamente no painel.  
- RN3 — O painel deve sempre ordenar O.S. urgentes no topo.  

**Cenários BDD:**
- **Given** que existe uma O.S. Média,  
  **When** altero prioridade para Alta,  
  **Then** ela deve subir para o topo do painel de prioridades.  

---

## HU-012 — Histórico de Intervenções Técnicas
**História do Usuário:**  
Como técnico de manutenção, quero acessar um histórico detalhado de todas as intervenções já realizadas em um equipamento, para analisar padrões e prever falhas futuras.

**Critérios de Aceitação:**
- Exibir histórico cronológico das intervenções técnicas.  
- Permitir filtros por tipo de falha ou componente trocado.  
- Gerar insights sobre padrões de falha recorrentes.  

**Regras de Negócio (RN):**
- RN1 — O histórico deve registrar data, técnico, O.S. associada e ação realizada.  
- RN2 — Intervenções devem ser ordenadas do mais recente para o mais antigo.  
- RN3 — Deve ser possível filtrar por tipo de falha ou peça substituída.  

**Cenários BDD:**
- **Given** que acesso o histórico de um equipamento,  
  **When** aplico filtro por componente trocado,  
  **Then** só intervenções relacionadas devem aparecer.  

---
