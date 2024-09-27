public class Aluno {
    public String nome;
    double media, n1, n2, n3;

    public void imprimir (){

        System.out.println(this.nome);
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public void mediaCalc() {
        media = (n1 + n2 + n3) / 3;
        System.out.println("Notas: " + n1 + " "+ n2 + " "+ n3);
        System.out.println("Média: " + media);
    }
}
