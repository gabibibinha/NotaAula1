//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaDeVendas sistema = new SistemaDeVendas();

        while (true) {
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Realizar venda");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                sistema.cadastrarProduto();
            } else if (opcao == 2) {
                sistema.realizarVenda();
            } else if (opcao == 3) {
                System.out.println("Sistema encerrado.");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();

    }
}