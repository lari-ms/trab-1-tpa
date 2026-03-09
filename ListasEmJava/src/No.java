public class No {
    private Object valor;
    private No proximo;

    public No(Object valor) {
        this.valor = valor;
        this.proximo = null;
    }

    public void SetProximo(No proximo){
        this.proximo=proximo;
    }

    public No getProximo() {
        return proximo;
    }

    public Object getValor() {
        return valor;
    }
}
