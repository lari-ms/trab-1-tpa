package domain;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import colecao.IColecao;
import src.ListaEncadeada;

public class LeitorArquivos {
    private static final String NOME_ARQUIVO = "testes/funcionarios100k.txt";
    
    public static void main(String[] args) {
    
        IColecao<Funcionario> funcionarios;
        funcionarios = new ListaEncadeada<Funcionario>();
        Funcionario func;
        long inicio = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            int numRegistros = Integer.parseInt(reader.readLine().trim());
            System.out.println("Número de registros: " + numRegistros);
            
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                String nome = partes[0];
                float salario = Float.parseFloat(partes[1]);
                long cpf = Long.parseLong(partes[2]);
            
                //inserindo na lista
                func = new Funcionario(nome, cpf, salario);
                funcionarios.adicionar(func);
                //System.out.println(funcionarios);
            }

            //calculando tempo de processamento
            long fim = System.nanoTime();
            long duracaoNanos = (fim - inicio);
            double duracaoMillis = (double) duracaoNanos / 1000000.0;

            System.out.println("tempo de leitura de arquivo e insercao na lista - " + duracaoMillis + "ms");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao processar um dos valores numéricos: " + e.getMessage());
        }
    }
}

