/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastropessoas.views;

import cadastropessoas.entities.PessoaFisica;
import cadastropessoas.entities.PessoaJuridica;
import cadastropessoas.models.PessoaFisicaModel;
import cadastropessoas.models.PessoaJuridicaModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author anapa
 */
public class CadastroPessoas {
    
    
    
    public static void cadastrarPessoaFisica() throws SQLException{
        String resposta = "sim";
        while (resposta.equalsIgnoreCase("sim")){
            System.out.println("Digite o nome da pessoa: ");
            Scanner scan = new Scanner(System.in);
            String nome = scan.nextLine();
            System.out.println("Digite o endereço da pessoa: ");
            String endereco = scan.nextLine();
            System.out.println("Digite o telefone da pessoa: ");
            String telefone = scan.nextLine();
            System.out.println("Digite o e-mail da pessoa: ");
            String email = scan.nextLine();
            System.out.println("Digite o cpf: ");
            String cpf = scan.nextLine();
            
            PessoaFisica pf = new PessoaFisica(cpf, 0, nome, endereco, telefone, email);
            PessoaFisicaModel model = new PessoaFisicaModel();
            model.insert(pf);
            System.out.println("Pessoa adicionada na lista.");
            System.out.println("Deseja cadastrar mais uma pessoa? ");
            resposta = scan.next();
            
        }
        menu();
    }
    
     public static void cadastrarPessoaJuridica() throws SQLException{
        String resposta = "sim";
        while (resposta.equalsIgnoreCase("sim")){
            System.out.println("Digite o nome da pessoa: ");
            Scanner scan = new Scanner(System.in);
            String nome = scan.nextLine();
            System.out.println("Digite o endereço da pessoa: ");
            String endereco = scan.nextLine();
            System.out.println("Digite o telefone da pessoa: ");
            String telefone = scan.nextLine();
            System.out.println("Digite o e-mail da pessoa: ");
            String email = scan.nextLine();
            System.out.println("Digite o cnpj: ");
            String cnpj = scan.nextLine();
            
            PessoaJuridica pj = new PessoaJuridica(cnpj, 0, nome, endereco, telefone, email);
            PessoaJuridicaModel model = new PessoaJuridicaModel();
            model.insert(pj);
            System.out.println("Pessoa adicionada na lista.");
            System.out.println("Deseja cadastrar mais uma pessoa? ");
            resposta = scan.next();
            
        }
        menu();
     }
    
    public static void visualizarPessoaFisica() throws SQLException{
        PessoaFisicaModel model = new PessoaFisicaModel();
        ArrayList<PessoaFisica> pessoasFisicas = model.selectAll();
        if(pessoasFisicas.size()== 0){
            System.out.println("Nenhuma pessoa listada. ");           
        }else{
            for(int i = 0; i < pessoasFisicas.size(); i++) {
                PessoaFisica pf = pessoasFisicas.get(i);
                pf.visualizar();
            }    
        }
    }
    
     public static void visualizarPessoaJuridica() throws SQLException{
        PessoaJuridicaModel model = new PessoaJuridicaModel();
        ArrayList<PessoaJuridica> pessoasJuridicas = model.selectAll();
        if(pessoasJuridicas.size()== 0){
            System.out.println("Nenhuma pessoa listada. ");           
        }else{
            for(int i = 0; i < pessoasJuridicas.size(); i++) {
                PessoaJuridica pj = pessoasJuridicas.get(i);
                pj.visualizar();
            }    
        }
    }
    
    public static void editarPessoaFisica() throws SQLException{
         Scanner scan = new Scanner(System.in);
            visualizarPessoaFisica();
            System.out.println("Qual é o id da pessoa que deseja editar? ");
            int idPessoa = Integer.parseInt(scan.nextLine());
            System.out.println("Digite o nome da pessoa: ");
            String nome = scan.nextLine();
            System.out.println("Digite o endereço da pessoa: ");
            String endereco = scan.nextLine();
            System.out.println("Digite o telefone da pessoa: ");
            String telefone = scan.nextLine();
            System.out.println("Digite o e-mail da pessoa: ");
            String email = scan.nextLine();
            System.out.println("Digite o cpf: ");
            String cpf = scan.nextLine();
            
            PessoaFisica pf = new PessoaFisica(cpf, idPessoa, nome, endereco, telefone, email);
            PessoaFisicaModel model = new PessoaFisicaModel();
            model.update(pf);
            System.out.println("Pessoa editada com sucesso! ");
            menu();
            
    }
    
     public static void editarPessoaJuridica() throws SQLException{
         Scanner scan = new Scanner(System.in);
            visualizarPessoaJuridica();
            System.out.println("Qual é o id da pessoa que deseja editar? ");
            int idPessoa = Integer.parseInt(scan.nextLine());
            System.out.println("Digite o nome da pessoa: ");
            String nome = scan.nextLine();
            System.out.println("Digite o endereço da pessoa: ");
            String endereco = scan.nextLine();
            System.out.println("Digite o telefone da pessoa: ");
            String telefone = scan.nextLine();
            System.out.println("Digite o e-mail da pessoa: ");
            String email = scan.nextLine();
            System.out.println("Digite o cnpj: ");
            String cnpj = scan.nextLine();
            
            PessoaJuridica pj = new PessoaJuridica(cnpj, idPessoa, nome, endereco, telefone, email);
            PessoaJuridicaModel model = new PessoaJuridicaModel();
            model.update(pj);
            System.out.println("Pessoa editada com sucesso! ");
            menu();
            
    }
    
    public static void deletarPessoaFisica() throws SQLException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual é o id da pessoa que deseja deletar? ");
        int id = scan.nextInt();
        PessoaFisicaModel model = new PessoaFisicaModel();
        model.delete(id);
        System.out.println("Pessoa deletada com sucesso! ");
        menu();
    }
    
     public static void deletarPessoaJuridica() throws SQLException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual é o id da pessoa que deseja deletar? ");
        int id = scan.nextInt();
        PessoaJuridicaModel model = new PessoaJuridicaModel();
        model.delete(id);
        System.out.println("Pessoa deletada com sucesso! ");
        menu();
    }
    
    public static void menu() throws SQLException{
        System.out.println("Digite a opção desejada?\n1-cadastrar\n2-visualizar\n3-editar\n4-deletar");
        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();
        System.out.println("F pessoa fisica, J pessoa juridica: ");
        String tipoPessoa = scan.next();
        
        if(opcao == 1 && tipoPessoa.equalsIgnoreCase("F")){
            cadastrarPessoaFisica();    
        }else if(opcao == 1 && tipoPessoa.equalsIgnoreCase("J")){
            cadastrarPessoaJuridica();
        }else if(opcao == 2 && tipoPessoa.equalsIgnoreCase("F")){
            visualizarPessoaFisica(); 
            menu();
        }else if (opcao == 2 && tipoPessoa.equalsIgnoreCase("J")){
            visualizarPessoaJuridica();
            menu();
        }else if (opcao == 3 && tipoPessoa.equalsIgnoreCase("F")){
            editarPessoaFisica();
        }else if (opcao == 3 && tipoPessoa.equalsIgnoreCase("J")){
            editarPessoaJuridica();
        }else if (opcao == 4 && tipoPessoa.equalsIgnoreCase("F")){ 
             deletarPessoaFisica();
        }else if (opcao == 4 && tipoPessoa.equalsIgnoreCase("J")){
             deletarPessoaJuridica();
        }else{
            System.out.println("Opção inválida!");
        }
    }


    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
