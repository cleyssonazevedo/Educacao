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
public class Telefone {

    private Long id;
    private Long id_pessoa;
    private String numero;

    public Telefone() {

    }

    public Telefone(Long id, Long id_pessoa, String numero) {
        this.id = id;
        this.id_pessoa = id_pessoa;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(Long id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public static class Builder {

        private Long id;
        private Long id_pessoa;
        private String numero;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setId_pessoa(Long id_pessoa) {
            this.id_pessoa = id_pessoa;
            return this;
        }

        public Builder setNumero(String numero) {
            this.numero = numero;
            return this;
        }
        
        public Telefone build() {
            return new Telefone(id, id_pessoa, numero);
        }
    }

}
