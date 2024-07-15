/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastropessoas.entities;

/**
 *
 * @author anapa
 */
public class PessoaFisica extends Pessoa {
    
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public PessoaFisica( ) {
       
    }

    public PessoaFisica(String cpf, int id, String nome, String endereco, String telefone, String email) {
        super(id, nome, endereco, telefone, email);
        this.cpf = cpf;
    }

    @Override
    public void visualizar() {
        super.visualizar(); 
        System.out.println("Cpf: " + cpf);
    }
    
    
    
}
