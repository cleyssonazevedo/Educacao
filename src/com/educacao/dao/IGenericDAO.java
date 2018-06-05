/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educacao.dao;

import com.educacao.models.Pessoa;
import java.util.List;

/**
 *
 * @author cleys
 */
public interface IGenericDAO {
    void salvar(Pessoa pessoa) throws Exception;
    void editar(Pessoa pessoa) throws Exception;
    void excluir(Long id) throws Exception;
    
    Pessoa buscarPorNome(String nome) throws Exception;
    List<Pessoa> listar() throws Exception;
}
