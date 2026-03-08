public class ListaDinamica implements ListaOperacoes{
    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista Dinâmica criada com sucesso!");
    }

    public void adicionarElemento(String conteudo) {
        if(!this.existeInicio()) {
            this.inicio.setConteudo(conteudo);
        } else {
            No novoNo = new No(conteudo);
            No aux = this.inicio;
            while(aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
        }
    }

    private boolean existeInicio() {
        return this.inicio.getConteudo() != null;
    }

    public void exibirElementos(boolean b) {
        int indice = 0;
        if(existeInicio()) {
            No aux = this.inicio;
            while(aux.getProx() != null) {
                System.out.println("ListaDinâmica[" + indice + "] = " + aux.getConteudo());
                aux = aux.getProx();
                indice++;
            }
            System.out.println("ListaDinâmica[" + indice + "] = " + aux.getConteudo());
        } else {
            System.out.println("Não existem elementos na Lista Dinâmica.");
        }
    }

    public void removerElemento(String elemento) {
        if(existeInicio()) {
            if(buscarElemento(elemento)) {
                //removendo primeiro
                if(this.inicio.getConteudo().equals(elemento)) {
                    this.inicio = this.inicio.getProx();
                } else if(this.inicio.getProx() != null) {
                    No aux = this.inicio;
                    do {
                        if(aux.getProx().getConteudo().equals(elemento)) {
                            aux.setProx(aux.getProx().getProx());
                            return;
                        }
                        aux = aux.getProx();
                    } while (aux != null);
                } else {
                    this.inicio.setConteudo(null);
                }

                //removendo intermediário
                //método de busca
            }

        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public boolean buscarElemento(String elemento) {
        No aux = this.inicio;

        do {
            if(aux.getConteudo().equals(elemento)) {
                System.out.println("Elemento " + elemento + " encontrado.");
                return true;
            }
            aux = aux.getProx();
        } while(aux != null);
        System.out.println("Elemento " + elemento + " não encontrado!");
        return false;
    }

    /**
     * Verifica se um número está dentro do intervalo da lista.
     *
     * @param indice número da posição da lista a ser verificado se existe
     * @return true se o indice estiver dentro do intervalo
     */
    private boolean verificarIntervalo(int indice){
        return this.contar()-1 >=  indice && indice >= 0;
    }

    /**
     * Obtém o último índice da lista dinâmica.
     *
     * @return o último índice da lista dinâmica.
     */
    private int ultimoIndice(){
        return this.contar()-1;
    }
    @Override
    public int removerTodas(String elemento) {
        return 0;
    }

    /**
     * Conta quantos elementos existem dentro da lista dinâmica.
     *
     * @return quantidade de elementos na lista dinâmica.
     */
    @Override
    public int contar() {
        int cont = 0;
        if(existeInicio()){
            No aux = this.inicio;
            while(aux != null){
                cont ++;
                aux = aux.getProx();
            }
        }
        return cont;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        return 0;
    }

    @Override
    public String obter(int indice) {
        if(indice < 0){
            throw new IllegalArgumentException(
                    "Não foi possível obter o elemento da lista dinâmica porque o indice é menor que 0"
            );
        }

        if(existeInicio()){
            int indiceLista= 0;
            No aux = this.inicio;
            while(aux.getProx() != null && indiceLista < indice){
                indiceLista++;
                aux = aux.getProx();
            }

            return aux.getConteudo();
        } else {
            System.out.println("Não foi possível obter elemento porque a lista está vazia.");
            return null;
        }
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
    public void limpar() {}

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