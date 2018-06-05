/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educacao.models;

/**
 *
 * @author cleys
 */
public enum Sexo {
    MASCULINO("Masculino", "M"), FEMININO("Feminino", "F");

    private final String literal;
    private final String abbr;
    Sexo(String literal, String abbr) {
        this.literal = literal;
        this.abbr = abbr;
    }
    
    public String getLiteral() {
        return this.literal;
    }
    
    public String getAbreviacao() {
        return this.abbr;
    }
}
