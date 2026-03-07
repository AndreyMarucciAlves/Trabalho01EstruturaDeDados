public class ListaSimples implements ListaOperacoes {
    private int tamanho;
    private String lista [];

    public ListaSimples(int tamanhoDaLista) {
        this.tamanho = tamanhoDaLista;
        lista = new String[tamanhoDaLista];
        System.out.println("A lista foi criada com sucesso! Seu tamanho é igual a: " + tamanhoDaLista);
    }

    public void inserirElemento(String elemento) {
        for (int i = 0; i < this.tamanho ; i++) {
            if(posicaoEstaVazia(i)) {
                this.lista[i] = elemento;
                break;
            }
        }
    }

    public boolean estaVazia() {
        return this.lista[0] == null;
    }

    public boolean posicaoEstaVazia(int posicao) {
        return this.lista[posicao] == null;
    }

    /**
     * Verifica se a lista está cheia.
     * @return true se está cheia, false se não está.
     */
    private boolean estaCheio(){
        for (String item : this.lista) {
            if (item == null) {
                return false;
            }
        }
        return true;
    }

    public void percorrerElementos() {
        for (int i = 0; i < this.tamanho; i++) {
            System.out.println(this.lista[i]);
        }
    }

    public boolean verificarIntervalo(int indice) {
        if(indice >= 0 && indice <= this.tamanho-1) {
            return true;
        } else {
            System.out.println("O indice informado está fora do intervalo da lista.");
            return false;
        }
    }

    public boolean buscaElemento(String elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if(this.lista[i] == elemento) {
                System.out.println("O elemento " + elemento + " existe na lista, no índice " + (i+1));
                return true;
            }
        }
        System.out.println("O elemento não foi encontrado!");
        return false;
    }

    public void editarPorIndice(int indice, String elemento) {
        if(verificarIntervalo(indice)) {
            if(posicaoEstaVazia(indice)) {
                System.out.println("A posição informada já está vazia.");
            } else {
                this.lista[indice] = elemento;
            }
        }
    }

    public void contarElementos() {
        int cont = 0;
        if(estaVazia()) {
            System.out.println("Existem " + cont + " elementos na lista.");
        } else {
            for (int i = 0; i < tamanho; i++) {
                if (this.lista[i] != null) {
                    cont = cont + 1;
                } else {
                    break;
                }
            }
            System.out.println("Existem " + cont + " elementos na lista.");
        }
    }

    public void ordenarCrescente() {
        if(estaVazia()) {
            System.out.println("Não existem elementos para serem ordenados.");
        } else {
            String aux;
            for (int h = 0; h < this.tamanho; h++) {// 3
                for (int i = 0; i < (this.tamanho - 1); i++) {// 2
                    if(this.lista[i+1] != null &&this.lista[i].length() > this.lista[i+1].length()) {
                        aux = this.lista[i];
                        this.lista[i] = this.lista[i+1];
                        this.lista[i+1] = aux;
                    }
                }
            }

        }
    }

    public void insereOrdenado(String elemento) {
        ordenarCrescente();
        inserirElemento(elemento);

    }

    @Override
    public void limpar() {

    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        if(buscaElemento(elemento)){

        }
        int ultimoIndice;
        for(int i=0; i<this.lista.length; i++){

        }
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

    /**
     *Obtém o elemento da lista com base no indice inserido.
     * @param indice Posição desejada.
     * @return null se a posição está vazia ou (maior ou menor) que o intervalo da lista. Elemento do indice se não.
     * @throws IllegalArgumentException se o índice for inválido (menor que zero ou fora do intervalo).
     */
    @Override
    public String obter(int indice) {
        if(!verificarIntervalo(indice)){
            throw new IllegalArgumentException("O indice informado está fora do intervalo da lista.");
        }
        if(posicaoEstaVazia(indice)){
            return null;
        }
        return this.lista[indice];
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if(!verificarIntervalo(indice)){
            throw new IllegalArgumentException("O indice informado está fora do intervalo da lista.");
        }

        if(estaCheio()){
            String[] listaAux = new String[this.lista.length+1];
            System.arraycopy(this.lista, 0, listaAux, 0, this.lista.length);
            this.lista = listaAux;
            this.tamanho++;
        }

        if(!posicaoEstaVazia(indice)){
            deslocarParaDireita(indice);
        }

        lista[indice] = elemento;
        return true;
    }

    /**
     * Método que desloca os itens para direita
     *
     * @param indice será o ponto final do for
     */
    private void deslocarParaDireita(int indice){

        for(int i = this.lista.length -1; i > indice;i--){
            this.lista[i] = this.lista[i-1];
        }

    }

    @Override
    public String removerPorIndice(int indice) {
        if(verificarIntervalo(indice)) {
            if(posicaoEstaVazia(indice)) {
                System.out.println("A posição informada já está vazia.");
            } else {
                this.lista[indice] = null;
            }
        }

        return "";
    }

}