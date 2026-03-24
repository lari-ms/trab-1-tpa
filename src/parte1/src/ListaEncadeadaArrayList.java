package src;

import java.util.ArrayList;

import colecao.IColecao;

public class ListaEncadeadaArrayList<T> implements IColecao<T>{   
    private final ArrayList<T> lista = new ArrayList<T>();
    
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

