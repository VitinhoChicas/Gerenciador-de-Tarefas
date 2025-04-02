package model;

/**
  * Princípios SOLID aplicados:
 * - SRP (Single Responsibility Principle): O Princípio da Responsabilidade Única afirma que uma classe deve ter apenas uma razão para mudar, ou seja, deve ser responsável por uma única tarefa. 
 *   Nesta classe, a responsabilidade é unicamente armazenar e retornar dados da tarefa. 
 */
public class Tarefa {
    private String descricao;
    private int prioridade;
    private boolean concluida;

    public Tarefa(String descricao, int prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }
}
