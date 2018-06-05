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
    MASCULINO("Masculino", "M"),
    FEMININO("Feminino", "F"),
    NAO_DEFINIDO("Não Definido", "ND");

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
    
    public static Sexo getFromIndex(int index) throws Exception {
        switch(index) {
            case 0:
               return Sexo.NAO_DEFINIDO;
            case 1:
               return Sexo.MASCULINO;
            case 2:
               return Sexo.FEMININO;
            default:
                throw  new Exception("Sexo incorreto!");
        }
    }
    
    public static Sexo getFromAbbr(String abbr) throws Exception {
        switch(abbr) {
            case "M":
                return Sexo.MASCULINO;
            
            case "F":
                return Sexo.FEMININO;
                
            default:
                return Sexo.NAO_DEFINIDO;
        }
    }
}
