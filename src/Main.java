public class Main{
    static void main() {
        ListaSimples ls = new ListaSimples(3);
        ls.adicionarElemento("Ana");
        ls.adicionarElemento("João");
        ls.adicionarElemento("Ana");

        ls.inserir(1,"oi");
        ls.exibirElementos();



    }
}