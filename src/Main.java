public class Main{
    static void main() {
        ListaSimples ls = new ListaSimples(3);
        ls.inserirElemento("oi");
        ls.inserirElemento("tudo");
        ls.inserirElemento("bem?");
        ls.inserir(2,",");
        ls.percorrerElementos();
    }
}