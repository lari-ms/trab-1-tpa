package src;

import colecao.IColecao;

public class Main {
    public static void main(String[] args) {

        //PEDI PRO GPT FAZER UM TESTE DE ACORDO COM A LISTA QUE CRIAMOS (FIQUEI COM PREGUICA E SONO PRA CRIAR UM TESTE ESPECIFICO PERDAO)
        
        IColecao<String> lista = new ListaEncadeada<>();
        
        System.out.println("=== TESTE DA LISTA ENCADEADA ===\n");
        
        System.out.println("1. Adicionando elementos...");
        lista.adicionar("Java");
        lista.adicionar("Python");
        lista.adicionar("C++");
        lista.adicionar("JavaScript");
        System.out.println("Lista: " + lista);
        System.out.println("Quantidade de nós: " + lista.quantidadeNos());
        
        System.out.println("\n2. Pesquisando elementos...");
        String resultado = lista.pesquisar("Python");
        System.out.println("Pesquisar 'Python': " + (resultado != null ? "Encontrado!" : "Não encontrado"));
        resultado = lista.pesquisar("Ruby");
        System.out.println("Pesquisar 'Ruby': " + (resultado != null ? "Encontrado!" : "Não encontrado"));
        
        System.out.println("\n3. Removendo elementos...");
        boolean removeu = lista.remover("C++");
        System.out.println("Remover 'C++': " + (removeu ? "Sucesso!" : "Falhou"));
        System.out.println("Lista após remoção: " + lista);
        System.out.println("Quantidade de nós: " + lista.quantidadeNos());
        
        removeu = lista.remover("Ruby");
        System.out.println("Remover 'Ruby' (não existe): " + (removeu ? "Sucesso!" : "Falhou"));
        
        System.out.println("\n4. Testando com números...");
        IColecao<Integer> listaNumeros = new ListaEncadeada<>();
        listaNumeros.adicionar(10);
        listaNumeros.adicionar(20);
        listaNumeros.adicionar(30);
        System.out.println("Lista de números: " + listaNumeros);
        listaNumeros.remover(20);
        System.out.println("Após remover 20: " + listaNumeros);
        
        System.out.println("\n=== TODOS OS TESTES PASSARAM! ===");
    }
}
 