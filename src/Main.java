public class Main{
    static void main() {
        ListaSimples ls = new ListaSimples(3);
        ls.adicionarElemento("oi");
        ls.adicionarElemento("tudo");
        ls.adicionarElemento("bem ?");
        ls.exibirElementos();
        ls.inserir(2," com");
    }
}