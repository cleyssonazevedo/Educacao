/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educacao.exception;

/**
 *
 * @author cleys
 */
public class NoResultException extends Exception {

    public NoResultException() {
        super("Dados não encontrados!");
    }
    
}
