package phenrique.com.github.View;

import phenrique.com.github.Model.Entity.Task.TaskEntity;
import phenrique.com.github.View.InterfaceUI.UITaskInterface;

import java.util.Scanner;

public class UI {

    private UITaskInterface taskInterface;

    public static Scanner input = new Scanner(System.in);

    public UI(UITaskInterface taskInterface) {
        this.taskInterface = taskInterface;
    }

    public void printDisplay(){
        Integer response = screen();
        System.out.println();
        while (response != 5){
            try{
                switch (response){
                    case 1 :
                        listAllTaskUI();
                        break;
                    case 2 :
                        createTaskUI();
                        break;
                    case 3 :
                        updateTaskUI();
                        break;
                    case 4 :
                        deleteTaskUI();
                        break;
                }
                response = screen();
                System.out.println();
            }catch (Exception e){
                System.out.println("\n"+e.getMessage());
                System.out.println("Pressione \"Enter\" para continuar!\n");
            }
        }
    }

    private Integer screen(){
        System.out.print("""
                     \nTask Manager
                   Escolha uma opção:
                1  - Listar Minhas Tarefas.
                2  - Criar uma Nova Tarefa.
                3  - Atualizar uma nova Tarefa.
                4  - Apagar uma Tarefa.
                5  - SAIR.
                """);
        return input.nextInt();
    }

    private void createTaskUI() {
        input.nextLine();
        System.out.println("Descreva sua Tarefa :");
        String description = input.nextLine();
        System.out.print("Qual a data limite para o término da tarefa" +
                "\nEscreva neste formato 'dd/MM/yyyy': ");
        String dueDate = input.nextLine();
        taskInterface.createTask(description, dueDate);
        System.out.println("\nTarefa criada!");
    }

    private void listAllTaskUI() {
        System.out.println(taskInterface.findAll());
    }
    private void updateTaskUI() {
        System.out.print("Qual Tarefa deseja alterar: \nTarefas:\n");
        listAllTaskUI();
        System.out.print("Digite o ID da Tarefa que deseja excluir: ");
        Long id = input.nextLong();
        input.nextLine();
        System.out.println("Descreva sua Tarefa Atualizada : ");
        String description = input.nextLine();
        System.out.print("Qual a data limite para o término dessa tarefa" +
                "\nEscreva neste formato 'dd/MM/yyyy': ");
        String dueDate = input.nextLine();
        TaskEntity newTask = new TaskEntity(description, TaskEntity.parseFormat(dueDate));
        taskInterface.updateTask(id, newTask);
        System.out.println("Tarefa Atualizada!!!");
    }
    private void deleteTaskUI() {
        System.out.print("Qual Tarefa deseja excluir: \nTarefas:\n");
        listAllTaskUI();
        System.out.print("Digite o ID da Tarefa que deseja excluir: ");
        Long id = input.nextLong();
        taskInterface.deleteTask(id);
        System.out.println("Tarefa Exluida!!!");
    }

}
