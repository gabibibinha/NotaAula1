import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeVendas {
    private ArrayList<Produto> produtos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void cadastrarProduto() {
        System.out.println("Cadastramento de novo produto: ");

        System.out.println("Código: ");
        double codigo = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("Tamanho: ");
        double tamanho = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Cor: ");
        String cor = scanner.nextLine();

        System.out.println("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Quantidade em estoque: ");
        int quantidade = scanner.nextInt();

        Produto produto = new Produto (codigo, nome, tamanho, cor, valor, quantidade);
        produtos.add(produto);

        System.out.println("O produto foi cadastrado com sucesso!\n");

    }

    public void realizarVenda() {
        System.out.println("Digite o código do produto para venda: ");
        double codigo = scanner.nextDouble();
        Produto produto = buscarProdutoPorCodigo(codigo);

        if (produto != null) {
            System.out.println("Produto encontrado: " + produto);
            System.out.println("Digite a quantidade que deseja vender: ");
            int quantidade = scanner.nextInt();

            if (quantidade <= produto.getQuantidade()) {
                double valorTotal = quantidade * produto.getValor();
                System.out.println("Valor total: R$ " + valorTotal);

                realizarPagamento(valorTotal);

                produto.setQuantidade(produto.getQuantidade() - quantidade);
                System.out.println("Venda realizada com sucesso!\n");
            } else {
                System.out.println("Quantidade insuficiente no estoque!\n");
            }
        } else {
            System.out.println("Produto não encontrado!\n");
        }
    }

    private Produto buscarProdutoPorCodigo(double codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    private void realizarPagamento(double valorTotal) {
        System.out.println("Qual a forma de pagamento?: ");
        System.out.println("1. Pix (5% de desconto)");
        System.out.println("2. Espécie (5% de desconto)");
        System.out.println("3. Transferência/Débito (5% de desconto)");
        System.out.println("4. Crédito (parcelar em até 3x sem juros)");

        System.out.println("Escolha a forma de pagamento: ");
        int opcaoPagamento = scanner.nextInt();

        double valorFinal = valorTotal;

        if (opcaoPagamento >= 1 && opcaoPagamento <= 3) {
            valorFinal = valorTotal * 0.95;
        }

        if (opcaoPagamento == 2) {
            System.out.println("Valor em espécie: ");
            double valorPago = scanner.nextDouble();
            if (valorPago > valorFinal) {
                double troco = valorPago - valorFinal;
                System.out.println("Troco: R$ " + troco);
            }
        } else if (opcaoPagamento == 4) {
            System.out.print("Em quantas vezes deseja parcelar (escolha até 3x): ");
            int parcelas = scanner.nextInt();
            if (parcelas > 0 && parcelas <= 3) {
                System.out.println("Seu pagamento foi parcelado em: " + parcelas + "x de R$ " + valorFinal / parcelas);
            }
        }

        System.out.println("Valor final: R$ " + valorFinal);
    }
}
