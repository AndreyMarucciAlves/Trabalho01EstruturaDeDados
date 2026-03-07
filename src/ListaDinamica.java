import java.util.List;

public class ListaDinamica implements ListaOperacoes {
    private No primeiroElemento;

    public ListaDinamica(String conteudo) {
        this.primeiroElemento = new No(conteudo);
    }

    public void insereElemento(String conteudo) {
        No novoNo = new No(conteudo);
        if(estaVazia()) {
            this.primeiroElemento = novoNo;
        } else {
            No aux = this.primeiroElemento;
            while(aux.getProx() != null) { //Garanto que existem elementos a serem percorridos
                aux = aux.getProx();
            }
            //Apto para inserir o novo NO
            aux.setProx(novoNo);
        }
    }

    public void percorrerElementos() {
        if(estaVazia()) {
            System.out.println("A lista se encontra vazia.");
        } else {
            No aux = this.primeiroElemento;
            while(aux.getProx() != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
            System.out.println(aux.getConteudo());
        }
    }

    public boolean estaVazia() {
        if(this.primeiroElemento == null) { //não existem elementos na lista
            return true;
        }
        return false;
    }

    //to do
    //método de remoção por elemento (verificar casos)
    //método de busca por elemento

    public void removerElemento(String conteudo) {
        if(estaVazia()) {
            System.out.println("Não há elementos na lista.");
        } else if(verificaExistencia(conteudo)){
            if(this.primeiroElemento.getConteudo().equals(conteudo)) {// removendo primeiro elemento
                this.primeiroElemento = this.primeiroElemento.getProx();
            } else {
                No aux = this.primeiroElemento;
                while(aux.getProx().getConteudo() != conteudo) {
                    aux = aux.getProx();
                }
                aux.setProx(aux.getProx().getProx());
            }
        } else {
            System.out.println("O elemento buscado não existe.");
        }
    }

    public boolean verificaExistencia(String conteudo) {
        No aux = this.primeiroElemento;
        while(aux != null) {
            if(aux.getConteudo() == conteudo) {
                return true;
            }
            aux = aux.getProx();
        }
        return false;
    }

    public void contarElementos() {
        int cont = 0;
        if(estaVazia()) {
            System.out.println("Existem " + cont + " elementos na lista.");
        } else {
            No aux = this.primeiroElemento;
            while(aux != null) {
                cont = cont + 1;
                aux = aux.getProx();
            }
            System.out.println("Existem " + cont + " elementos na lista.");
        }
    }

    public void ordenarCrescente() {
        if(estaVazia()) {
            System.out.println("Não existem elementos para serem ordenados.");
        } else {
            No atual = this.primeiroElemento;
            while (atual != null){
                No atual2 = this.primeiroElemento;
                while(atual2 != null) {
                    No proximo = atual2.getProx();
                    String aux;
                    if(atual2.getProx() != null && Integer.parseInt(atual2.getConteudo()) > Integer.parseInt(proximo.getConteudo())) {
                        aux = atual2.getConteudo();
                        atual2.setConteudo(proximo.getConteudo());
                        proximo.setConteudo(aux);
                    }
                    atual2 = atual2.getProx();
                }
                atual = atual.getProx();
            }
        }
    }

    public void inserirOrdenado(String conteudo) {
        ordenarCrescente();
        insereElemento(conteudo);
    }

    @Override
    public int removerTodas(String elemento) {
        return 0;
    }

    @Override
    public int contar() {
        return 0;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        return 0;
    }

    @Override
    public String obter(int indice) {
        return "";
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        return false;
    }

    @Override
    public String removerPorIndice(int indice) {
        return "";
    }

    @Override
    public void limpar() {

    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        return 0;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        return 0;
    }

    @Override
    public int substituir(String antigo, String novo) {
        return 0;
    }
}