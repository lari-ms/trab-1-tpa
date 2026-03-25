package domain;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import colecao.IColecao;
import src.ListaEncadeada;

public class LeitorArquivos {
    private static final String NOME_ARQUIVO = "testes/funcionarios400k.txt";
    
    public static void main(String[] args) {
    
        IColecao<Funcionario> funcionarios;
        funcionarios = new ListaEncadeada<Funcionario>();
        Funcionario func;
        String nome;
        float salario;
        long cpf = 0;

        long inicio = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            int numRegistros = Integer.parseInt(reader.readLine().trim());
            System.out.println("Número de registros: " + numRegistros);
            
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                nome = partes[0];
                salario = Float.parseFloat(partes[1]);
                cpf = Long.parseLong(partes[2]);
            
                //inserindo na lista
                func = new Funcionario(nome, cpf, salario);
                funcionarios.adicionar(func);
                //System.out.println(funcionarios);
            }

            //calculando tempo de processamento
            long fim = System.nanoTime();
            double duracaoMillis = (double) (fim - inicio) / 1000000.0;
            System.out.println("tempo de leitura de arquivo e insercao na lista - " + duracaoMillis + "ms");
            

            //pesquisando ultimo funcionario
            inicio = System.nanoTime();
            Funcionario ultimo = funcionarios.pesquisar(new Funcionario("",cpf,0));
            fim = System.nanoTime();
            duracaoMillis = (double) (fim - inicio) / 1000000.0;
            System.out.println("tempo de busca pelo último elemento da lista - " + duracaoMillis + "ms");

            //pesquisando funcionario inexistente
            inicio = System.nanoTime();
            funcionarios.pesquisar(new Funcionario("",0,0));
            fim = System.nanoTime();
            duracaoMillis = (double) (fim - inicio) / 1000000.0;
            System.out.println("tempo de busca por um elemento inexistente na lista - " + duracaoMillis + "ms");

            //excluindo ultimo funcionario da lista
            inicio = System.nanoTime();
            funcionarios.remover(ultimo);
            fim = System.nanoTime();
            duracaoMillis = (double) (fim - inicio) / 1000000.0;
            System.out.println("tempo de remocao do ultimo elemento da lista - " + duracaoMillis + "ms");

            //imprimindo a qtd de funcionarios na lista
            inicio = System.nanoTime();
            funcionarios.quantidadeNos();
            fim = System.nanoTime();
            duracaoMillis = (double) (fim - inicio) / 1000000.0;
            System.out.println("tempo de impressão da quantidade de elementos da lista - " + duracaoMillis + "ms");

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao processar um dos valores numéricos: " + e.getMessage());
        }
    }
}
