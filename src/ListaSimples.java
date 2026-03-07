import java.util.Arrays;

public class ListaSimples implements ListaOperacoes {
    String[] lista;

    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
    }

    public void exibirElementos() {
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }

    public void adicionarElemento(String elemento) {
        if (!estaCheia()) {
            this.lista[encontrarPosicaoVazia()] = elemento;
            System.out.println("Elemento " + elemento + " adicionado com sucesso!");
        }
    }

    private boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("A lista está cheia!");
        return true;
    }

    private boolean estaVazio() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                return false;
            }
        }
        System.out.println("A lista está vazia!");
        return true;
    }

    private int encontrarPosicaoVazia() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return i;
            }
        }
        return i;
    }

    public void removerElemento(String elemento) {
        if (!estaVazio()) {
            if (this.buscarElemento(elemento) >= 0) {
                this.lista[this.buscarElemento(elemento)] = null;
                System.out.println("Elemento " + elemento + " removido com sucesso!");
            }
        }
    }

    public int buscarElemento(String elemento) {
        int i;
        if (!estaVazio()) {
            for (i = 0; i < this.lista.length; i++) {
                if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                    return i;
                }
            }
        }
        System.out.println("Elemento não encontrado na lista.");
        return -1;
    }

    public void alterarElemento(String elementoASerAlterado, String alteracao) {
        if (buscarElemento(elementoASerAlterado) >= 0) {
            this.lista[buscarElemento(elementoASerAlterado)] = alteracao;
            System.out.println("Elemento " + elementoASerAlterado + " alterado com sucesso para " + alteracao);
        }
    }

    public void quantidadeElementos() {
        int cont = 0;
        if (!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] != null) {
                    cont++;
                }
            }
        }
        System.out.println("A lista possui " + cont + " elementos!");
    }

    private void deslocarParaDireita(int indice) {
        for (int i = this.lista.length - 1; i > indice; i--) {
            this.lista[i] = this.lista[i - 1];
        }
    }

    private boolean verificarIntervalo(int indice) {
        if (indice >= 0 && indice <= this.lista.length - 1) {
            return true;
        } else {
            System.out.println("O indice informado está fora do intervalo da lista.");
            return false;
        }
    }

    @Override
    public int removerTodas(String elemento) {
        return 0;
    }

    /**
     * Conta os elementos existentes na lista desconsiderando elementos iguais a null
     *
     * @return número de elementos existentes na lista
     */
    @Override
    public int contar() {
        int cont = 0;
        for (String item : this.lista) {
            if (item != null) {
                cont++;
            }
        }
        return cont;
    }

    /**
     * Adiciona múltiplos elementos na lista
     *
     * @param elementos Vetor de Strings contendo os elementos a serem adicionados.
     * @return quantidade de elementos que foram adicionados na lista
     */
    @Override
    public int adicionarVarios(String[] elementos) {
        int elementosAdicionados = 0;
        for(int i = 0; i < elementos.length; i++){
            if(this.lista[i] == null){
                elementosAdicionados++;
                this.lista[i] = elementos[i];
            }
        }
        return elementosAdicionados;
    }

    /**
     * Obtém o elemento da lista com base no indice inserido.
     *
     * @param indice Posição desejada.
     * @return null se a posição está vazia ou (maior ou menor) que o intervalo da lista. Elemento do indice se não.
     * @throws IllegalArgumentException se o índice for inválido (menor que zero ou fora do intervalo).
     */
    @Override
    public String obter(int indice) {
        if (!verificarIntervalo(indice)) {
            throw new IllegalArgumentException("O indice informado está fora do intervalo da lista.");
        }
        return this.lista[indice];
    }

    /**
     * Insere um elemento na lista com base no indice inserido.
     *
     * @param indice Posição onde o elemento será inserido.
     * @param elemento Elemento a ser inserido.
     * @return true se inserção aconteseu, se não false
     */
    @Override
    public boolean inserir(int indice, String elemento) {
        if (!verificarIntervalo(indice) || estaCheia()) {
            return false;
        }

        if (this.lista[indice] != null) {
            deslocarParaDireita(indice);
        }

        lista[indice] = elemento;
        return true;
    }

    /**
     * Remove um elemento da lista pelo indice.
     *
     * @param indice Posição do elemento a ser removido.
     * @return null se o indice está fora do intervalo da lista, o elemento removido caso não
     */
    @Override
    public String removerPorIndice(int indice) {
        if (!verificarIntervalo(indice)) {
            return null;
        }
        String removido = this.lista[indice];
        this.lista[indice] = null;
        return removido;
    }

    /**
     * Deixa o tamanho da lista em 0, limpando-a
     */
    @Override
    public void limpar() {
        Arrays.fill(this.lista, null);
    }

    /**
     * Procura a última incidência do elemento na lista.
     *
     * @param elemento Elemento a ser buscado.
     * @return Última vez que aparece na lista, ou -1 se não aparece
     */
    @Override
    public int ultimoIndiceDe(String elemento) {
        for (int i = this.lista.length - 1; i >= 0; i--) {
            if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                return i;
            }
        }
        System.out.println("Elemento " + elemento + " não encontrado na lista!");
        return -1;
    }

    /**
     * Conta o número de vezes que um elemento aparece na lista.
     *
     * @param elemento Elemento a ser contado.
     * @return número de vezes que foi encontrado na lista.
     */
    @Override
    public int contarOcorrencias(String elemento) {
        int ocorrencias = 0;
        for (String item : this.lista) {
            if (item != null && item.equals(elemento)) {
                ocorrencias++;
            }
        }
        return ocorrencias;
    }

    /**
     * Substitui todas as ocorrências de um elemento na lista por outro elemento.
     *
     * @param antigo Elemento que será substituído.
     * @param novo Novo valor que substituirá o antigo.
     * @return Quantidade total de substituições realizadas.
     */
    @Override
    public int substituir(String antigo, String novo) {
        int subs = 0;
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null && this.lista[i].equals(antigo)) {
                this.lista[i] = novo;
                subs++;
            }
        }
        return subs;
    }
}