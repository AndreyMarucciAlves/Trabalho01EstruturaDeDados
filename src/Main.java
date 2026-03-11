public class Main{
    static void main() {
        ListaDinamica ld = new ListaDinamica();
        ld.adicionarElemento("maria");
        ld.adicionarElemento("João");
        ld.adicionarElemento("João");
        ld.adicionarElemento("João");


        System.out.println("Quantidade de elementos removidos: " + ld.removerTodas("João"));
        ld.exibirElementos();
        ld.limpar();
        ld.exibirElementos();
    }
}