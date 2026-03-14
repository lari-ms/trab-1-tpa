package domain;

import colecao.IColecao;
import src.*;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        IColecao<Funcionario> funcionarios;
        funcionarios = new ListaEncadeada<Funcionario>();
        Funcionario func;
        String nome;
        int cpf, opcao;
        float salario;

        Scanner s = new Scanner(System.in);

        //menu
        do{
            System.out.println("Escolha uma opcao");
            System.out.println("1 - Cadastrar um funcionario");
            System.out.println("2 - Pesquisar um funcionario");
            System.out.println("3 - Visualizar lista de funcionarios");
            System.out.println("4 - Excluir um funcionario");
            System.out.println("5 - Encerrar o programa");
            System.out.print(">>> ");
            opcao = s.nextInt();
            s.nextLine();//pra pegar o enter
            System.out.println();

            switch (opcao) {
                case 1: //CADASTRAR
                    System.out.print("Digite o nome: ");
                    nome = s.nextLine();
                    //System.out.println();

                    System.out.print("Digite o o cpf (apenas os digitos): ");
                    cpf = s.nextInt();
                    //System.out.println();

                    System.out.print("Digite o salario (xxxx.xx): ");
                    salario = s.nextFloat();
                    s.nextLine();//pra pegar o enter
                    //System.out.println();

                    //criando o funcionario e add na lista
                    func = new Funcionario(nome, cpf, salario);
                    funcionarios.adicionar(func);
                    System.out.println();
                    System.out.println("Funcionario cadastrado com sucesso.");
                    System.out.println();
                    System.out.println();                    
                break;
                
                case 2: //PESQUISAR
                    System.out.print("Digite o cpf (apenas os digitos): ");
                    cpf = s.nextInt();
                    s.nextLine();//pra pegar o enter
                    System.out.println();

                    func = funcionarios.pesquisar(new Funcionario("", cpf, 0));
                    if (func != null){
                        System.out.println("Funcionario encontrado.");
                        System.out.println(func);
                    } else {
                        System.out.println("Funcionario nao cadastrado.");
                    }
                    System.out.println();
                    System.out.println();
                break;

                case 3: //LISTAR
                    System.out.println("Funcionarios cadastrados:");
                    System.out.println(funcionarios);
                    System.out.println();
                    System.out.println();
                break;

                case 4: //EXCLUIR
                    System.out.println("Digite o cpf do funcionario a ser excluido: ");
                    System.out.println(funcionarios);
                    System.out.print(">>> ");
                    cpf = s.nextInt();
                    s.nextLine();//pra pegar o enter
                    System.out.println();

                    func = funcionarios.pesquisar(new Funcionario("", cpf, 0));
                    if (func == null){
                        System.out.println("Funcionario nao cadastrado.");
                        break;
                    }

                    //remover da lista
                    if (funcionarios.remover(func)){
                        System.out.println(String.format("O funcionario %s foi exluido com sucesso.", func.getNome()));
                    } else {
                        System.out.println("nao foi possivel excluir o funcionario.");
                    }
                    System.out.println();
                    System.out.println();
                break;


                default:
                    break;
            }
        } while (opcao != 5);

        s.close();
    }
}