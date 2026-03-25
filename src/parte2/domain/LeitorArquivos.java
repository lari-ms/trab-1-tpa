package domain;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import colecao.IColecao;
import src.ListaEncadeada;

public class LeitorArquivos {
    private static final String NOME_ARQUIVO = "src/parte2/testes/funcionarios100k.txt";
    
    public static void main(String[] args) {
    
        IColecao<Funcionario> funcionarios;
        funcionarios = new ListaEncadeada<Funcionario>();
        Funcionario func;
        Funcionario ultimoFuncionario = null;
        long inicio, fim;
        double duracaoMillis;
        
        // 1. LEITURA E INSERÇÃO
        inicio = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            int numRegistros = Integer.parseInt(reader.readLine().trim());
            System.out.println("Número de registros: " + numRegistros);
            
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                String nome = partes[0];
                float salario = Float.parseFloat(partes[1]);
                long cpf = Long.parseLong(partes[2]);
            
                func = new Funcionario(nome, cpf, salario);
                funcionarios.adicionar(func);
                ultimoFuncionario = func; // Guarda o último para testes posteriores
            }

            fim = System.nanoTime();
            duracaoMillis = (double) (fim - inicio) / 1000000.0;
            System.out.println("1. Tempo de leitura e insercao: " + String.format("%.2f", duracaoMillis) + " ms");
            System.out.println();
            
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.err.println("Erro ao processar um dos valores numéricos: " + e.getMessage());
            return;
        }
        
        // 2. BUSCA PELO ÚLTIMO ELEMENTO
        inicio = System.nanoTime();
        Funcionario encontrado = funcionarios.pesquisar(ultimoFuncionario);
        fim = System.nanoTime();
        duracaoMillis = (double) (fim - inicio) / 1000000.0;
        System.out.println("2. Busca pelo ultimo elemento:");
        System.out.println("   Encontrado: " + (encontrado != null ? "Sim" : "Nao"));
        System.out.println("   Tempo: " + String.format("%.4f", duracaoMillis) + " ms");
        System.out.println();
        
        // 3. BUSCA POR ELEMENTO INEXISTENTE
        Funcionario inexistente = new Funcionario("Inexistente", 99999999999L, 0.0f);
        inicio = System.nanoTime();
        encontrado = funcionarios.pesquisar(inexistente);
        fim = System.nanoTime();
        duracaoMillis = (double) (fim - inicio) / 1000000.0;
        System.out.println("3. Busca por elemento inexistente:");
        System.out.println("   Encontrado: " + (encontrado != null ? "Sim" : "Nao"));
        System.out.println("   Tempo: " + String.format("%.4f", duracaoMillis) + " ms");
        System.out.println();
        
        // 4. REMOÇÃO DO ÚLTIMO ELEMENTO
        inicio = System.nanoTime();
        boolean removido = funcionarios.remover(ultimoFuncionario);
        fim = System.nanoTime();
        duracaoMillis = (double) (fim - inicio) / 1000000.0;
        System.out.println("4. Remocao do ultimo elemento:");
        System.out.println("   Removido: " + (removido ? "Sim" : "Nao"));
        System.out.println("   Tempo: " + String.format("%.4f", duracaoMillis) + " ms");
        System.out.println();
        
        // 5. QUANTIDADE DE NÓS
        inicio = System.nanoTime();
        int quantidade = funcionarios.quantidadeNos();
        fim = System.nanoTime();
        duracaoMillis = (double) (fim - inicio) / 1000000.0;
        System.out.println("5. Quantidade de nos:");
        System.out.println("   Quantidade: " + quantidade);
        System.out.println("   Tempo: " + String.format("%.4f", duracaoMillis) + " ms");
    }
}

