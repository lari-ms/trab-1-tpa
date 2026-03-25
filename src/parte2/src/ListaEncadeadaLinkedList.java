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
        int index = lista.indexOf(valor);
        return index >= 0 ? lista.get(index) : null;
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

