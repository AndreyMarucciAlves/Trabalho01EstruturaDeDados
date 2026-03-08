public class Main{
    static void main() {
        ListaDinamica ld = new ListaDinamica();
        ld.adicionarElemento("Oi");
        ld.adicionarElemento("tudo");
        ld.adicionarElemento("bem");
        ld.adicionarElemento("com");
        ld.adicionarElemento("você ?");
        ld.exibirElementos();
        System.out.println(ld.contar());
    }
}