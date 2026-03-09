public class ListaEncadeada {
    private No primeiro, ultimo; //primeiro e ultimo no da lista
    private int tamanho;

    public ListaEncadeada() { //construtor da ListaEncadeada
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    @Override
    public String toString(){
        String resultado = "";
        No atual = this.primeiro;
        for(int i=0;i<this.tamanho;i++){ //enquanto nao chegar no final da lista 
            resultado += atual.getValor() + ",";    
            atual = atual.getProximo(); //passa para o proximo no
        }
        return resultado;
    }

    public void adicionar(Object elem){
        No novo= new No(elem);//cria um novo no

        //verifica se a lista esta vazia
        if(this.primeiro==null){
            this.primeiro=novo;
            this.ultimo=novo;
        }else{
            this.ultimo.SetProximo(novo);//faz o ultimo no apontar para o novo no
            this.ultimo=novo;//atualiza o ultimo no para o novo no
        }
        this.tamanho++;
    }

    public int quantidade(){
        return this.tamanho;
    }

    
}
