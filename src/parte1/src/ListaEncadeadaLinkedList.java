package src;

import java.util.LinkedList;

import colecao.IColecao;

public class ListaEncadeadaLinkedList<T> implements IColecao<T>{   
    private final LinkedList<T> lista = new LinkedList<T>();
    
    @Override
    public void adicionar(T novoValor) {
        lista.add(novoValor);
    }

    @Override
    public T pesquisar(T valor) {
         return lista.contains(valor) ? valor : null;
    }

    @Override
    public boolean remover(T valor) {
        return lista.remove(valor);

    }

    @Override
    public int quantidadeNos() {
        return lista.size();
    }
}

