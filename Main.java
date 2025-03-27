import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerTask managerTask = new ManagerTask();

        System.out.println("\n =====Boas-vindas ao TaskNager seu gerenciador de tarefas====");
        System.out.println();

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
        System.out.println("-------------------------------");
        System.out.println("| O que você quer fazer?       |");
        System.out.println("| 1 - Cadastrar nova tarefa    |");
        System.out.println("| 2 - Filtrar tarefa por status|");
        System.out.println("| 3 - Ordenar tarefa por data  |");
        System.out.println("| 4 - Listar todas as tarefas  |");
        System.out.println("| 5 - Sair do sistema          |");
        System.out.println("-------------------------------");
        Scanner scannerOption = new Scanner(System.in);
        Integer option = scannerOption.nextInt();
        return option;
    }

    private static int readOption(int option, ManagerTask managerTask) {
        try {
            Scanner scanner = new Scanner(System.in);

            switch (option) {
                case 1:
                    System.out.println("\n== Cadastrar Nova Tarefa ==");

                    String title;
                    while (true) {
                        System.out.print("Título: ");
                        title = scanner.nextLine().trim();
                        if (title.length() < 5) {
                            System.out.println("\nErro: O título deve ter no mínimo 5 caracteres.");
                            continue;
                        }
                        break;
                    }

                    System.out.print("Descrição: ");
                    String description = scanner.nextLine();

                    LocalDate deadline = null;
                    while (deadline == null) {
                        try {
                            System.out.print("Data Limite (yyyy-mm-dd): ");
                            String dataStr = scanner.nextLine();
                            deadline = LocalDate.parse(dataStr);
                            if (deadline.isBefore(LocalDate.now())) {
                                System.out.println("\nErro: A data limite deve ser posterior à data atual.");
                                deadline = null;
                                continue;
                            }
                        } catch (DateTimeException e) {
                            System.out.println("\nErro: Formato de data inválido. Use yyyy-mm-dd. ");
                        }
                    }


                    StatusTask status = null;
                    while (status == null) {
                        System.out.println("""
                        📝 Qual o status da tarefa?
                        1. Pendente;
                        2. Em andamento;
                        3. Concluído;
                        """);

                        try {
                            int statusChoice = scanner.nextInt();
                            status = StatusTask.values()[statusChoice - 1];
                        } catch (Exception e) {
                            System.out.println("\nErro: Selecione uma opção válida (1, 2 ou 3).");
                            scanner.nextLine(); //
                        }
                    }


                    Task newTask = new Task(title, description, status, deadline);
                    managerTask.createTask(newTask);


                    System.out.println("✅ Tarefa cadastrada com sucesso!");
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
                    System.out.println("Próximas tarefas a vencer:");
                    managerTask.orderDeadline();
                    System.out.println(managerTask.orderDeadline());
                    return 1;

                case 4:
                    System.out.println("Todas as tarefas cadastradas:");
                    managerTask.getList()
                            .stream()
                            .forEach(System.out::println);
                    return 1;

                case 5:
                    System.out.println("Encerrando o sistema. Até a próxima!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Digite um número de 1 a 5.");
                    System.out.println("******************************************");
                    return -1;

            }

        } catch (NumberFormatException e) {
            System.out.println("Erro inesperado: " + e.getMessage());
            return option;
        }
    }
}


