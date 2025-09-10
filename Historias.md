# Histórias de Usuário — Projeto SAGE (POO em Java)

Este documento reúne as histórias de usuário definidas para o MVP do **SAGE — Sistema de Acompanhamento e Gerenciamento de Equipamentos Hospitalares**

## Índice
1. [HU-001 — Cadastro de Equipamento](#hu-001--cadastro-de-equipamento)  
2. [HU-002 — Consulta de Equipamento](#hu-002--consulta-de-equipamento)  
3. [HU-003 — Abertura de Ordem de Serviço](#hu-003--abertura-de-ordem-de-serviço)  
4. [HU-004 — Atribuição de Técnico à O.S.](#hu-004--atribuição-de-técnico-à-os)  
5. [HU-005 — Fechamento de O.S. com Relatório](#hu-005--fechamento-de-os-com-relatório)  
6. [HU-006 — Alertas de Manutenção Preventiva](#hu-006--alertas-de-manutenção-preventiva)  
7. [HU-007 — Dashboard de Status de O.S.](#hu-007--dashboard-de-status-de-os)

---

## HU-001 — Cadastro de Equipamento
**Ator:** Gestor  
**Resumo:** Como gestor, quero cadastrar equipamentos com dados técnicos e criticidade para que possam ser gerenciados no ciclo de manutenção.  

### Regras de Negócio
- RN1 — Patrimônio único e obrigatório.  
- RN2 — Campos obrigatórios: patrimônio, tipo, fabricante, localização, criticidade, data de aquisição.  
- RN3 — Criticidade ∈ {BAIXA, MÉDIA, ALTA}.  
- RN4 — Datas coerentes (não futuras).  
- RN5 — Status inicial = OPERACIONAL.  
- RN6 — Auditoria mínima (`criadoPor`, `criadoEm`).  

### Critérios de Aceitação
- CA1 — Cadastro válido cria equipamento OPERACIONAL.  
- CA2 — Patrimônio duplicado bloqueia cadastro.  
- CA3 — Campos obrigatórios validados.  
- CA4 — Equipamento aparece na listagem após cadastro.  

### Cenários BDD
- **Cenário 1:** Cadastro bem-sucedido.  
- **Cenário 2:** Patrimônio duplicado.  
- **Cenário 3:** Campo obrigatório ausente.  
- **Cenário 4:** Criticidade inválida.  
- **Cenário 5:** Data de aquisição futura.  
- **Cenário 6:** Próxima manutenção no passado.  
- **Cenário 7:** Registro de auditoria.  

---

## HU-002 — Consulta de Equipamento
**Ator:** Técnico ou Gestor  
**Resumo:** Como técnico, quero consultar equipamentos por patrimônio, nome ou localização para localizar rapidamente o alvo da manutenção.  

### Regras de Negócio
- RN1 — Permitir busca por patrimônio, termo, localização ou criticidade.  
- RN2 — Ordenação padrão: criticidade (desc) + patrimônio (asc).  
- RN3 — Sempre exibir status atual.  
- RN4 — Paginação: máx. 20 itens/página.  

### Critérios de Aceitação
- CA1 — Buscar por patrimônio retorna 1 resultado exato.  
- CA2 — Termos e filtros retornam lista ordenada.  
- CA3 — Sempre exibir patrimônio, tipo, fabricante, localização, criticidade, status.  
- CA4 — Mensagem clara quando sem resultados.  

### Cenários BDD
- **Cenário 1:** Consulta por patrimônio encontrado.  
- **Cenário 2:** Consulta por termo com múltiplos resultados.  
- **Cenário 3:** Filtros por localização e criticidade.  
- **Cenário 4:** Sem resultados.  
- **Cenário 5:** Paginação funcionando.  

---

## HU-003 — Abertura de Ordem de Serviço
**Ator:** Técnico  
**Resumo:** Como técnico, quero abrir uma O.S. vinculada a um equipamento, informando problema e prioridade, para iniciar manutenção.  

### Regras de Negócio
- RN1 — O.S. só pode ser aberta para equipamento existente.  
- RN2 — Campos obrigatórios: equipamentoId, descrição, prioridade ∈ {BAIXA, MÉDIA, ALTA}.  
- RN3 — Status inicial = ABERTA.  
- RN4 — Abrir O.S. altera status do equipamento para MANUTENÇÃO.  
- RN5 — Permitir múltiplas O.S., mas sinalizar duplicidade.  

### Critérios de Aceitação
- CA1 — Persistir O.S. válida com status correto.  
- CA2 — Validar prioridade e equipamento.  
- CA3 — Atualizar status do equipamento.  
- CA4 — Aviso em caso de O.S. já aberta.  

### Cenários BDD
- **Cenário 1:** Abertura bem-sucedida.  
- **Cenário 2:** Equipamento inexistente.  
- **Cenário 3:** Prioridade inválida.  
- **Cenário 4:** O.S. pré-existente.  

---

## HU-004 — Atribuição de Técnico à O.S.
**Ator:** Gestor  
**Resumo:** Como gestor, quero atribuir técnico a uma O.S. para garantir responsabilidade.  

### Regras de Negócio
- RN1 — Apenas Gestor/Admin podem atribuir.  
- RN2 — Técnico deve existir e ter perfil válido.  
- RN3 — Só atribuir se O.S. estiver ABERTA/EM_ANDAMENTO.  
- RN4 — Status vai para EM_ANDAMENTO.  

### Critérios de Aceitação
- CA1 — Validar permissão do usuário.  
- CA2 — Validar técnico existente.  
- CA3 — Atualizar status e auditoria.  

### Cenários BDD
- **Cenário 1:** Atribuição bem-sucedida.  
- **Cenário 2:** Usuário sem permissão.  
- **Cenário 3:** Técnico inválido.  

---

## HU-005 — Fechamento de O.S. com Relatório
**Ator:** Técnico  
**Resumo:** Como técnico, quero fechar uma O.S. com relatório de intervenção para manter histórico.  

### Regras de Negócio
- RN1 — Só fechar se status = EM_ANDAMENTO e atribuída ao técnico.  
- RN2 — Campos obrigatórios: descrição, tempo gasto > 0.  
- RN3 — Registrar peças utilizadas (opcional).  
- RN4 — Status vai para FECHADA.  
- RN5 — Equipamento volta para OPERACIONAL se não houver O.S. abertas.  

### Critérios de Aceitação
- CA1 — Impedir fechamento sem descrição/tempo.  
- CA2 — Validar autoria (técnico ou gestor).  
- CA3 — Atualizar status da O.S. e equipamento.  

### Cenários BDD
- **Cenário 1:** Fechamento por técnico responsável.  
- **Cenário 2:** Fechamento sem descrição.  
- **Cenário 3:** Fechamento por gestor.  

---

## HU-006 — Alertas de Manutenção Preventiva
**Ator:** Gestor  
**Resumo:** Como gestor, quero visualizar alertas de equipamentos com manutenção vencida ou próxima para planejar intervenções.  

### Regras de Negócio
- RN1 — Vencidos: proximaManutencao < hoje.  
- RN2 — Próximos: proximaManutencao ≤ hoje + janelaDias.  
- RN3 — Ordenar por criticidade e data.  
- RN4 — Filtro por localização opcional.  
- RN5 — Equipamentos sem preventiva → seção separada.  

### Critérios de Aceitação
- CA1 — Listar vencidos, próximos e sem data separadamente.  
- CA2 — Exibir campos-chave (patrimônio, criticidade, data).  
- CA3 — Configurar janela de dias.  

### Cenários BDD
- **Cenário 1:** Vencidos aparecem corretamente.  
- **Cenário 2:** Próximos dentro de 30 dias.  
- **Cenário 3:** Sem preventiva definida.  
- **Cenário 4:** Filtro por localização.  

---

## HU-007 — Dashboard de Status de O.S.
**Ator:** Gestor  
**Resumo:** Como gestor, quero um dashboard com contagem de O.S. por status e prioridade para monitorar demandas.  

### Regras de Negócio
- RN1 — Agregar por status e prioridade.  
- RN2 — Permitir filtro por período (últimos 30 dias padrão).  
- RN3 — Destacar O.S. críticas abertas.  

### Critérios de Aceitação
- CA1 — Exibir totais por status e prioridade.  
- CA2 — Período configurável.  
- CA3 — Alerta de O.S. críticas (ALTA + ABERTA).  

### Cenários BDD
- **Cenário 1:** Totais padrão últimos 30 dias.  
- **Cenário 2:** Totais filtrados por período.  
- **Cenário 3:** Alerta de críticas exibido.  

---
