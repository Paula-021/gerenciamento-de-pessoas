/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastropessoas.models;

import cadastropessoas.daos.PessoaFisicaDao;
import cadastropessoas.daos.PessoaJuridicaDao;
import cadastropessoas.entities.PessoaFisica;
import cadastropessoas.entities.PessoaJuridica;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anapa
 */
public class PessoaJuridicaModel {
    
    public void insert(PessoaJuridica pj) throws SQLException{
        PessoaJuridicaDao dao = new PessoaJuridicaDao();
        dao.insert(pj);
    }

    public ArrayList<PessoaJuridica> selectAll() throws SQLException {
        PessoaJuridicaDao dao = new PessoaJuridicaDao();
        ArrayList<PessoaJuridica>pessoasJuridicas = dao.selectAll();
        return pessoasJuridicas;
    }

    public void update(PessoaJuridica pj) {
        PessoaJuridicaDao dao = new PessoaJuridicaDao();
        dao.update(pj);
    }
    
}
