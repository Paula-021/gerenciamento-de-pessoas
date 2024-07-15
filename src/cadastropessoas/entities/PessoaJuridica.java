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
public class PessoaJuridica extends Pessoa {

    public PessoaJuridica() {
    }

    public PessoaJuridica(String cnpj, int id, String nome, String endereco, String telefone, String email) {
        super(id, nome, endereco, telefone, email);
        this.cnpj = cnpj;
    }
    
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void visualizar() {
        super.visualizar(); 
        System.out.println("Cnpj: " + cnpj);
    }
    
    
    
}
