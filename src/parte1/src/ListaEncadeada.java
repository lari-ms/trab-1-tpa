package src;

import colecao.IColecao;

public class ListaEncadeada<T> implements IColecao<T> {
    private No<T> primeiro, ultimo; //primeiro e ultimo no da lista
    private int tamanho;

    public ListaEncadeada() { //construtor da ListaEncadeada
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    @Override
    public String toString() {
        if (this.tamanho == 0) { //se a lista estiver vazia retorna string vazia
            return "";
        }
        
        String resultado = "";
        No<T> atual = this.primeiro;
        while (atual != null) { //enquanto nao chegar no final da lista 
            resultado += atual.getValor();
            if (atual.getProximo() != null) { //adiciona virgula entre os elementos
                resultado += ",";
            }
            atual = atual.getProximo();  //passa para o proximo no
        }
        return resultado;
    }

    @Override
    public void adicionar(T novoValor) {
        No<T> novo = new No<T>(novoValor);//cria um novo no
        
        //verifica se a lista esta vazia
        if (this.primeiro == null) {
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            this.ultimo.setProximo(novo); //faz o ultimo no apontar para o novo no
            this.ultimo = novo; //atualiza o ultimo no
        }
        this.tamanho++; //incrementa o tamanho da lista
    }

    //pesquisar elemento da lista
    @Override
    public T pesquisar(T valor) {
        No<T> atual = this.primeiro;
        
        while (atual != null) {//verifica se nao eh nulo
            if (atual.getValor().equals(valor)) { //compara o valor do no com o valor buscado
                return atual.getValor(); //retorna o valor se encontrar
            }
            atual = atual.getProximo(); //passa pro proximo no
        }
        return null; //retorna null se nao encontrar
    }

    //remover elemento da lista
    @Override
    public boolean remover(T valor) {
        if (this.primeiro == null) {//se for nulo retorna logo 
            return false;
        }
        
        //remover o primeiro elemento da lista
        if (this.primeiro.getValor().equals(valor)) {
            this.primeiro = this.primeiro.getProximo(); //atualiza o primeiro no
            this.tamanho--; //diminui o tamanho
            if (this.tamanho == 0) { //se ficou vazia, atualiza o ultimo
                this.ultimo = null;
            }
            return true;
        }
        
        //procurar o elemento na lista
        No<T> anterior = this.primeiro;
        No<T> atual = this.primeiro.getProximo();
        
        while (atual != null) {
            if (atual.getValor().equals(valor)) { //achou o elemento
                anterior.setProximo(atual.getProximo()); //faz a ponte entre os nos
                if (atual == this.ultimo) { //se for o ultimo, atualiza a referencia
                    this.ultimo = anterior;
                }
                this.tamanho--; //diminui o tamanho
                return true;
            }
            anterior = atual; //avanca os ponteiros
            atual = atual.getProximo();
        }
        
        return false; //nao encontrou o elemento
    }

    //quantidadeNos da interface IColecao 
    @Override
    public int quantidadeNos() {
        return this.tamanho;
    }
}
