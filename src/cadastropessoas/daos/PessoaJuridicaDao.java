/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastropessoas.daos;

import cadastropessoas.connection.Conexao;
import cadastropessoas.entities.PessoaFisica;
import cadastropessoas.entities.PessoaJuridica;
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
public class PessoaJuridicaDao {

    public void insert(PessoaJuridica pj) throws SQLException {
        String comandoSqlPessoa = "insert into pessoa(nome, endereco, telefone, email) values (?, ?, ?, ?)";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparadoP = con.prepareStatement(comandoSqlPessoa,Statement.RETURN_GENERATED_KEYS);
        estadoPreparadoP.setString(1, pj.getNome());
        estadoPreparadoP.setString(2, pj.getEndereco());
        estadoPreparadoP.setString(3, pj.getTelefone());
        estadoPreparadoP.setString(4, pj.getEmail());
        estadoPreparadoP.executeUpdate();
        ResultSet rs = estadoPreparadoP.getGeneratedKeys();
        rs.next();
        int idGerado = rs.getInt(1);
        estadoPreparadoP.close();
  
       String comandoSqlPessoaFisica = "insert into pessoaJuridica(idpessoa, cnpj) values (?, ?)" ;
       PreparedStatement estadoPreparadoPj = con.prepareStatement(comandoSqlPessoaFisica);
       estadoPreparadoPj.setInt(1, idGerado);
       estadoPreparadoPj.setString(2, pj.getCnpj());
       estadoPreparadoPj.execute();
       estadoPreparadoPj.close();
       con.close();
        
    }

    public ArrayList<PessoaJuridica> selectAll() throws SQLException {
        String comandoSql = "Select pj.cnpj,pj.idPessoa,p.* from pessoaJuridica pj inner join pessoa P on pj.idPessoa = p.id";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparado = con.prepareStatement(comandoSql);
        ResultSet rs = estadoPreparado.executeQuery();
        ArrayList<PessoaJuridica>pessoasJuridicas = new ArrayList();
        
        while (rs.next()) {  
            PessoaJuridica pj = new PessoaJuridica(rs.getString("pj.cnpj"), rs.getInt("p.id"), rs.getString("p.nome"), rs.getString("p.endereco"), rs.getString("p.telefone"),rs.getString("p.email"));
            pessoasJuridicas.add(pj);
        }
        
        return pessoasJuridicas;
        
    }

    public void update(PessoaJuridica pj) throws SQLException {
        String comandoSqlPj = "update pessoaJuridica set cnpj = ? where idPessoa = ? ";
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        PreparedStatement estadoPreparadoPj = con.prepareStatement(comandoSqlPj);
        estadoPreparadoPj.setString(1, pj.getCnpj());
        estadoPreparadoPj.setInt(2, pj.getId());
        estadoPreparadoPj.execute();
        estadoPreparadoPj.close();
        
        String comandoSqlP = "update pessoa set nome = ?, endereco = ?, telefone = ?, email = ? where id";
        PreparedStatement estadoPreparadoP = con.prepareStatement(comandoSqlP);
        estadoPreparadoP.setString(1,pj.getNome());
        estadoPreparadoP.setString(2, pj.getEndereco());
        estadoPreparadoP.setString(3, pj.getTelefone());
        estadoPreparadoP.setString(4, pj.getEmail());
        estadoPreparadoP.executeUpdate();
        estadoPreparadoP.close();
        con.close();
    }
    
}
