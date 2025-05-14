package br.insper.af.tarefa;

public record RetornarTarefaDTO(
        String id,
        String titulo,
        String descricao,
        String prioridade,
        String emailCriador
) {}
