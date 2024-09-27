
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Aluno aluno = new Aluno();
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);


        System.out.println("Insira seu nome:");
        aluno.nome = sc2.next();

        System.out.print("Insira a sua 1ª nota: ");
        aluno.n1 = sc2.nextDouble();
        System.out.print("Insira a sua 2ª nota: ");
        aluno.n2 = sc2.nextDouble();
        System.out.print("Insira a sua 3ª nota: ");
        aluno.n3 = sc2.nextDouble();

        aluno.mediaCalc();
        if (aluno.media >= 7.0) {
            System.out.println("APROVADO");
        } else if (aluno.media <= 4.0){
            System.out.println("PROVA FINAL");
        } else {
            System.out.println("REPROVADO");
        }




    }
}