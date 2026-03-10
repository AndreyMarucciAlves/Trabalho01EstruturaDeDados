public class Main{
    static void main() {
        ListaDinamica ld = new ListaDinamica();
        ld.adicionarElemento("João");
        ld.adicionarElemento("Maria");
        ld.adicionarElemento("Júlia");
        ld.adicionarElemento("João");
        ld.adicionarElemento("João");
        ld.adicionarElemento("Jose");

        System.out.println("Elemento removido por indice: " + ld.removerPorIndice(0) );
        ld.exibirElementos();

    }
}