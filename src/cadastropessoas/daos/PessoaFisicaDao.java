/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastropessoas.daos;

import cadastropessoas.connection.Conexao;
import cadastropessoas.entities.PessoaFisica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author anapa
 */
public class PessoaFisicaDao {
    public void insert (PessoaFisica pf) throws SQLException{ 
        String comandoSqlPessoa = "insert into pessoa(nome, endereco, telefone, email) values (?, ?, ?, ?)";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparadoP = con.prepareStatement(comandoSqlPessoa,Statement.RETURN_GENERATED_KEYS);
        estadoPreparadoP.setString(1, pf.getNome());
        estadoPreparadoP.setString(2, pf.getEndereco());
        estadoPreparadoP.setString(3, pf.getTelefone());
        estadoPreparadoP.setString(4, pf.getEmail());
        estadoPreparadoP.executeUpdate();
        ResultSet rs = estadoPreparadoP.getGeneratedKeys();
        rs.next();
        int idGerado = rs.getInt(1);
        estadoPreparadoP.close();
  
       String comandoSqlPessoaFisica = "insert into pessoaFisica(idpessoa, cpf) values (?, ?)" ;
       PreparedStatement estadoPreparadoPf = con.prepareStatement(comandoSqlPessoaFisica);
       estadoPreparadoPf.setInt(1, idGerado);
       estadoPreparadoPf.setString(2, pf.getCpf());
       estadoPreparadoPf.execute();
       estadoPreparadoPf.close();
       con.close();
       
       
    }

    public ArrayList<PessoaFisica> selectAll() throws SQLException {
        String comandoSql = "Select pf.cpf,pf.idPessoa,p.* from pessoaFisica pf inner join pessoa P on pf.idPessoa = p.id";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparado = con.prepareStatement(comandoSql);
        ResultSet rs = estadoPreparado.executeQuery();
        ArrayList<PessoaFisica>pessoasFisicas = new ArrayList();
        
        while (rs.next()) {  
            PessoaFisica pf = new PessoaFisica(rs.getString("pf.cpf"), rs.getInt("p.id"), rs.getString("p.nome"), rs.getString("p.endereco"), rs.getString("p.telefone"),rs.getString("p.email"));
            pessoasFisicas.add(pf);
        }
        
        return pessoasFisicas;
    }

    public void update(PessoaFisica pf) throws SQLException {
        String comandoSqlPf = "update pessoaFisica set cpf = ? where idPessoa = ? ";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparadoPf = con.prepareStatement(comandoSqlPf);
        estadoPreparadoPf.setString(1, pf.getCpf());
        estadoPreparadoPf.setInt(2, pf.getId());
        estadoPreparadoPf.execute();
        estadoPreparadoPf.close();
        
        String comandoSqlP = "update pessoa set nome = ?, endereco = ?, telefone = ?, email = ? where id";
        PreparedStatement estadoPreparadoP = con.prepareStatement(comandoSqlP);
        estadoPreparadoP.setString(1,pf.getNome());
        estadoPreparadoP.setString(2, pf.getEndereco());
        estadoPreparadoP.setString(3, pf.getTelefone());
        estadoPreparadoP.setString(4, pf.getEmail());
        estadoPreparadoP.executeUpdate();
        estadoPreparadoP.close();
        con.close();
    }
    
}
