package br.insper.af.tarefa;

public record CadastrarTarefaDTO(
        String titulo,
        String descricao,
        String prioridade,
        String emailCriador
) {}
