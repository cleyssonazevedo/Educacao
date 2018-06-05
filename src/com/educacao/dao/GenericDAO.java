/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educacao.dao;

import com.educacao.exception.NoResultException;
import com.educacao.models.Endereco;
import com.educacao.models.Pessoa;
import com.educacao.models.Sexo;
import com.educacao.models.Telefone;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cleys
 */
public class GenericDAO implements IGenericDAO {

    final String DRIVER = "com.mysql.jdbc.Driver";
    final String URL = "jdbc:mysql://localhost:3306/educacao?autoReconnect=true&useSSL=false";

    public GenericDAO() {
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, "root", "root");
    }

    @Override
    public void salvar(Pessoa pessoa) throws Exception {
        CallableStatement state = this.getConnection()
                .prepareCall("{ call sp_salvar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
        
        state.setString(1, pessoa.getNome());
        state.setInt(2, pessoa.getIdade());
        state.setString(3, pessoa.getSexo().getAbreviacao());
        
        state.setString(4, pessoa.getEndereco().getLogradouro());
        state.setString(5, pessoa.getEndereco().getNumero());
        state.setString(6, pessoa.getEndereco().getBairro());
        
        state.setString(7, pessoa.getEndereco().getCidade());
        state.setString(8, pessoa.getEndereco().getEstado());
        state.setString(9, pessoa.getEndereco().getComplemento());
        
        state.setString(10, pessoa.getEndereco().getCep());
        state.setString(11, pessoa.getTelefone().getNumero());
        
        state.executeUpdate();
    }

    @Override
    public void editar(Pessoa pessoa) throws Exception {
        CallableStatement state = this.getConnection()
                .prepareCall("{ call sp_atualizar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
        
        System.out.println(pessoa);
        
        state.setLong(1, pessoa.getId());
        state.setString(2, pessoa.getNome());
        state.setInt(3, pessoa.getIdade());
        state.setString(4, pessoa.getSexo().getAbreviacao());
        
        state.setString(5, pessoa.getEndereco().getLogradouro());
        state.setString(6, pessoa.getEndereco().getNumero());
        state.setString(7, pessoa.getEndereco().getBairro());
        state.setString(8, pessoa.getEndereco().getCidade());
        state.setString(9, pessoa.getEndereco().getEstado());
        state.setString(10, pessoa.getEndereco().getComplemento());
        state.setString(11, pessoa.getEndereco().getCep());
        
        state.setString(12, pessoa.getTelefone().getNumero());
        
        state.executeUpdate();
    }

    @Override
    public void excluir(Long id) throws Exception {
        PreparedStatement state = this.getConnection()
                    .prepareStatement("DELETE FROM pessoa WHERE id = ?");
        state.setLong(1, id);
        
        state.execute();
    }

    @Override
    public Pessoa buscar(Long id) throws Exception {
       PreparedStatement state = this.getConnection()
              .prepareStatement("SELECT * FROM vw_pessoa WHERE id = ?");
       state.setLong(1, id);
       
       ResultSet result = state.executeQuery();
       
       if (result.next()) {
            return new Pessoa.Builder()
                  .setId(result.getLong("id"))
                  .setNome(result.getString("nome"))
                  .setIdade(result.getInt("idade"))
                  .setSexo(Sexo.getFromAbbr(result.getString("sexo")))
                  .setEndereco(new Endereco.Builder()
                       .setId(result.getLong("id_endereco"))
                       .setId_pessoa(result.getLong("id_pessoa_endereco"))
                       .setLogradouro(result.getString("logradouro"))
                       .setNumero(result.getString("numero"))
                       .setBairro(result.getString("bairro"))
                       .setCidade(result.getString("cidade"))
                       .setCep(result.getString("cep"))
                       .setEstado(result.getString("estado"))
                       .setComplemento(result.getString("complemento"))
                          .build()
                  
                  )
                  .setTelefone(new Telefone.Builder()
                          .setId(result.getLong("id_telefone"))
                          .setId_pessoa(result.getLong("id_pessoa_telefone"))
                          .setNumero(result.getString("telefone"))
                            .build()
                  )
                    .build();
                    
       } else {
           throw new NoResultException();
       }
    }

    
    
    @Override
    public List<Pessoa> buscarPorNome(String nome) throws Exception {
        PreparedStatement state = this.getConnection()
                .prepareStatement("SELECT id, nome, idade, sexo FROM pessoa WHERE nome LIKE ?");
        state.setString(1, "%" + nome + "%");
        
        List<Pessoa> lista = new ArrayList<Pessoa>();
        ResultSet result = state.executeQuery();
        while(result.next()) {
            Pessoa p = new Pessoa.Builder()
                .setId(result.getLong("id"))
                .setNome(result.getString("nome"))
                .setIdade(result.getInt("idade"))
                .setSexo(Sexo.getFromAbbr(result.getString("sexo")))
                   .build();
            
            lista.add(p);
        }
        
        if(lista.size() > 0) 
            return lista;
        else
            throw new NoResultException();
    }

    @Override
    public List<Pessoa> listar() throws Exception {
        PreparedStatement state = this.getConnection()
                .prepareStatement("SELECT id, nome, idade, sexo FROM pessoa");
        
        List<Pessoa> lista = new ArrayList<Pessoa>();
        ResultSet result = state.executeQuery();
        while(result.next()) {
            Pessoa p = new Pessoa.Builder()
                .setId(result.getLong("id"))
                .setNome(result.getString("nome"))
                .setIdade(result.getInt("idade"))
                .setSexo(Sexo.getFromAbbr(result.getString("sexo")))
                   .build();
            
            lista.add(p);
        }
        
        return lista;
    }

}
