import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerTask managerTask = new ManagerTask();

        System.out.println("\n =====Boas-vindas ao TaskNager seu gerenciador de tarefas====");


        boolean execution = true;
        while (execution) {
            int menuChoice = showMenu();
            int option = readOption(menuChoice, managerTask);
            if (option == 5) {
                System.out.println("Sistema encerrado com sucesso");
                scanner.close();
            }

        }
    }


    private static Integer showMenu() {
        System.out.println("O que você quer fazer?");
        System.out.println("1 - Cadastrar nova tarefa");
        System.out.println("2 - Filtrar tarefa por status");
        System.out.println("3 - Ordenar tarefa por data");
        System.out.println("4 - Listar todas as tarefas");
        System.out.println("5 - Sair do sistema");
        Scanner scannerOption = new Scanner(System.in);
        Integer option = scannerOption.nextInt();
        return option;
    }

    private static int readOption(int option, ManagerTask managerTask) {
        try {
            Scanner scanner = new Scanner(System.in);

            switch (option) {
                case 1:
                    System.out.println("\n== Cadastro de Nova Tarefa ==");

                    System.out.print("Título: ");
                    String title = scanner.nextLine();

                    System.out.print("Descrição: ");
                    String description = scanner.nextLine();

                    LocalDate deadline = null;
                            System.out.print("Data Limite (yyyy-MM-dd): ");
                        String dataStr = scanner.nextLine();
                        try {
                             deadline = LocalDate.parse(dataStr);
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato de data inválido. Use yyyy-MM-dd.");
                        }


                    System.out.println("""
                            Status:
                            1. Pendente;
                            2. Em andamento;
                            3. Concluído;
                            """);
                    // System.out.print("Escolha o status: ");


                    Integer statusChoice = scanner.nextInt();

                    StatusTask status = StatusTask.values()[statusChoice - 1];


                    Task newTask = new Task(title, description, status, deadline);
                    managerTask.createTask(newTask);

                    System.out.println("✓ Tarefa cadastrada com sucesso!");
                    return 1;

                case 2:
                    System.out.println("""
                            Filtre pelo status:
                            1. Pendente;
                            2. Em andamento;
                            3. Concluído;
                            """);


                    Integer statusFilter = scanner.nextInt();

                    System.out.println(managerTask.filterStatus(StatusTask.values()[statusFilter - 1]));


                    return 1;
                case 3:
                    managerTask.orderDeadline();
                    System.out.println(managerTask.orderDeadline());;

                    return 1;

                case 4:
                    managerTask.getList()
                            .stream()
                            .forEach(System.out::println);
                    return 1;

                default:
                    System.out.println("Opção inválida. Digite um número de 1 a 4.");
                    return -1;

            }
           // System.out.println("Programa finalizado!");
           // scanner.close();
          //  return 1;

        } catch (NumberFormatException e) {
            return -1;
        }
    }
}


