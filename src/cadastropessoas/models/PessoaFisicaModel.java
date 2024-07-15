/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastropessoas.models;

import cadastropessoas.daos.PessoaFisicaDao;
import cadastropessoas.entities.PessoaFisica;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anapa
 */
public class PessoaFisicaModel {
    
    public void insert(PessoaFisica pf) throws SQLException{
        PessoaFisicaDao dao = new PessoaFisicaDao();
        dao.insert(pf);
    }

    public ArrayList<PessoaFisica> selectAll() throws SQLException {
        PessoaFisicaDao dao = new PessoaFisicaDao();
        ArrayList<PessoaFisica>pessoasFisicas = dao.selectAll();
        return pessoasFisicas;
    }

    public void update(PessoaFisica pf) throws SQLException {
        PessoaFisicaDao dao = new PessoaFisicaDao();
        dao.update(pf);
    }
    
}
