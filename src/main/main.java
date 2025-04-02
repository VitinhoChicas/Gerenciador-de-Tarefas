package main;

import java.util.List;
import service.TarefaService;
import java.util.Scanner;
import model.Tarefa;

/**
 * Sistemas para Informação - 5 Semestre- Feito por Mateus Tomaz Siqueira, Victor Junio Grigoleto Chicas e Igor Gabriel
 * Gerenciador de Tarefas Completo
 * 
  * Princípios SOLID aplicados:
 * - SRP (Single Responsibility Principle): O Princípio da Responsabilidade Única afirma que uma classe deve ter apenas uma razão para mudar, ou seja, deve ser responsável por uma única tarefa. 
 *   Nesta classe, a responsabilidade é unicamente de interagir com o usuário: exibir o menu, ler a entrada do usuário e chamar os métodos apropriados da camada service (TarefaService). 
 *   O gerenciamento das tarefas, como criação, listagem, filtragem e conclusão, é delegado para a service, garantindo que essa classe não faça mais do que necessário e se concentre apenas na interação com o usuário.
 */
public class main {
    public static void main(String[] args) {
        TarefaService tarefaService = new TarefaService();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1:
                    criarTarefa(scanner, tarefaService);
                    break;
                case 2:
                    listarTarefas(tarefaService);
                    break;
                case 3:
                    concluirTarefa(scanner, tarefaService);
                    break;
                case 4:
                    filtrarTarefasPorPrioridade(scanner, tarefaService);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n-------------------------");
        System.out.println("Gerenciador de Tarefas");
        System.out.println("1. Criar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Concluir Tarefa");
        System.out.println("4. Filtrar por Prioridade");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
        System.out.println("\n---------------------------");

    }

    private static void criarTarefa(Scanner scanner, TarefaService tarefaService) {
        System.out.print("\nDescrição da tarefa: ");
        String descricao = scanner.nextLine();
        System.out.print("\nEscolha o nivel de Prioridade (Alta(Digite 1), Média(Digite 2), Baixa(Digite 3): ");
        int prioridade = scanner.nextInt();        
        /*Verificando se a prioridade é uma das indicadas*/
        boolean validaPrioridade = tarefaService.verificaPrioridade(prioridade);
        
        if (validaPrioridade == false) {
            System.out.print("\nPrioridade Invalida!");
        } else{
        tarefaService.criarTarefa(descricao, prioridade);
        System.out.println("Tarefa criada!");       
        }   
    }

    private static void listarTarefas(TarefaService tarefaService) {       
       System.out.print("\nTarefas Encontradas:");
       System.out.println("\n" +tarefaService.tarefasUsuario());
    }

    private static void concluirTarefa(Scanner scanner, TarefaService tarefaService) {
        listarTarefas(tarefaService);
        System.out.print("Digite o Id da tarefa para concluir: ");
        int idTarefa = scanner.nextInt();
        boolean validaTarefa = tarefaService.validaTarefa(idTarefa);
        if (validaTarefa == false) {
            System.out.print("Tarefa não existe ou ja está concluida!");
        } else{
        tarefaService.concluirTarefa(idTarefa);
        System.out.println("Tarefa concluída!");
        }      
        
    }

    private static void filtrarTarefasPorPrioridade(Scanner scanner, TarefaService tarefaService) {
        System.out.print("Digite a prioridade para filtrar ( Alta(Digite 1), Média(Digite 2), Baixa(Digite 3) ): ");
        int prioridade = scanner.nextInt();
        /*Verificando se a prioridade é uma das indicadas*/
        boolean validaPrioridade = tarefaService.verificaPrioridade(prioridade);
        
        if (validaPrioridade == false) {
            System.out.print("\nPrioridade Invalida!");
        } else{
       System.out.print("\nTarefas Filtradas:");
       System.out.println("\n" + tarefaService.filtrarTarefasPorPrioridade(prioridade));      
        }      
    }
}
