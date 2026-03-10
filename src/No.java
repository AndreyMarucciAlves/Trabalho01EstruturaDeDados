public class No {
    private String conteudo;
    private No prox;

    public No(String conteudo) {
        this.conteudo = conteudo;
        this.prox = null;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "No{" +
                "conteudo='" + conteudo + '\'' +
                ", prox=" + prox +
                '}';
    }
}