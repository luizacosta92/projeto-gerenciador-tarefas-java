import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


            System.out.println("\n =====Boas-vindas ao TaskNager seu gerenciador de tarefas====");


            boolean execution = true;
            while (execution) {
                    showMenu();
                    int option = readOption();

                    case 1:
                            createTask();
                            break;
            }



            Scanner scannertitle = new Scanner(System.in);
            System.out.println("Título: ");
            String title = scannertitle.nextLine();
            if (title.length() < 10) {
                System.out.println("Erro: Título muito curto, escreva, pelo menos 10 caracteres.");
            } else;

            Scanner scannerdescription = new Scanner(System.in);
            System.out.println("Descrição: ");
            String description = scannerdescription.nextLine();

            Scanner scannerdeadline = new Scanner(System.in);
            System.out.println("Data de vencimento (formato dd/mm/aaaa): ");
            DateTimeFormatter deadline = DateTimeFormatter.ofPattern(scannerdeadline.nextLine());

            Scanner scannerstatus = new Scanner(System.in);
            System.out.println("Status:");
            System.out.println("Digite 1 - para Pendente");
            System.out.println("Digite 2 - para Em Andamento");
            System.out.println("Digite 3 - para Concluída");
            String status = scannerstatus.nextLine();


        }
        private static void showMenu() {
                System.out.println("O que você quer fazer?");
                System.out.println("\n 1 - Cadastrar nova tarefa");
                System.out.println("\n 2 - Filtrar tarefa por status");
                System.out.println("\n 3 - Ordenar tarefa por data");
                Scanner scannerOption = new Scanner(System.in);
                Integer option = scannerOption.nextInt();
        }
        private static int readOption() {
            try {
                    return Integer.parseInt(option);
            }  catch (NumberFormatException e) {
                        return -1;
                }




}