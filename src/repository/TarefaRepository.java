package repository;

import model.Tarefa;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Princípios SOLID aplicados:
 * - SRP (Single Responsibility Principle): A classe tem uma única responsabilidade: gerenciar as tarefas(adicionar, listar, filtrar e validar tarefas). 
 *   Ela não se preocupa com a lógica de negócios ou com a interação com o usuário. Tudo relacionado ao armazenamento e manipulação de tarefas é feito aqui, tornando a classe focada em uma única tarefa.
*/
public class TarefaRepository {
    private final List<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    /*Lista de tarefas*/
    public List<Tarefa> listarTarefas() {
        return new ArrayList<>(tarefas);
    }
    
    /*Metodo para buscar tarefas*/
    public String tarefasUsuario(){
    String tarefasUsuario = "";    
    for (int i = 0; i < tarefas.size(); i++) {
        Tarefa t = tarefas.get(i);
        tarefasUsuario += "\nId: " + i + " - Descrição: " + t.getDescricao() + " - Prioridade: " + t.getPrioridade() + " - Concluída: " + t.isConcluida();
    }
    return tarefasUsuario;    
    }

    /*Metodo para retornar informação das tarefas filtradas pela prioridade*/
    public String filtrarPorPrioridade(int prioridade) {
    String tarefasListadas = ""; 
    /*tarefas filtradas pela prioridade*/
    List<Tarefa> tarefasFiltradas = tarefas.stream()
                .filter(t -> t.getPrioridade() == prioridade)
                .collect(Collectors.toList());
        
    /*percorrendo a lista filtrada e armazenando registros na string*/
    for (int i = 0; i < tarefasFiltradas.size(); i++) {
        Tarefa t = tarefasFiltradas.get(i);
        tarefasListadas += "\nId: " + i + " - Descrição: " + t.getDescricao() + " - Prioridade: " + t.getPrioridade() + " - Concluída: " + t.isConcluida();
    }
    return tarefasListadas;  
    }
    
    /*Metodo para verificar se prioridade existe*/
    public boolean verificaPrioridade(int prioridade) {
        if (prioridade != 1 && prioridade != 2 && prioridade != 3) {
            return false;
        } else{
            return true;
        }
    }
    
    /*Metodo para validar se a tarefa existe ous e está concluida*/
    public boolean validaTarefa(int id) {
    List<Tarefa> tarefas = listarTarefas();
    
    // Verificando se o id da tarefa existe na lista
    if (id >= 0 && id < tarefas.size()) {
        Tarefa t = tarefas.get(id);
        /*caso exista, verifica se tarefa está concluida*/
        if(t.isConcluida() == true){
            return false;
        }else{
        return true;
        }
        
        } else {
        return false;
    }
    }
    
}
