public class Main{
    static void main() {
        ListaDinamica ld = new ListaDinamica();
        ld.adicionarElemento("João");
        ld.adicionarElemento("Maria");
        ld.adicionarElemento("Júlia");
        ld.adicionarElemento("João");
        ld.adicionarElemento("João");
        System.out.println(ld.ultimoIndiceDe("João"));
    }
}