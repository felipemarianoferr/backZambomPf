package br.insper.af.tarefa;

public class Tarefa {
    private String id;
    private String titulo;
    private String descricao;
    private String prioridade;
    private String emailCriador;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getEmailCriador() {
        return emailCriador;
    }

    public void setEmailCriador(String emailCriador) {
        this.emailCriador = emailCriador;
    }
}
