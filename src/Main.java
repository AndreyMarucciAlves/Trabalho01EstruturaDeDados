public class Main{
    static void main() {
        ListaSimples ls = new ListaSimples(3);
        ls.inserir(0,"andrey");
        ls.inserir(2,"oi");
        ls.exibirElementos();
        ls.inserir(0,"salve");
        ls.exibirElementos();
    }
}