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
public class Endereco {

    private Long id;
    private Long id_pessoa;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    private String cep;

    public Endereco() {
        this.estado = "SP";
    }

    public Endereco(Long id, Long id_pessoa, String logradouro, String numero, String bairro, String cidade, String estado, String complemento, String cep) {
        this.id = id;
        this.id_pessoa = id_pessoa;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
        this.cep = cep;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public static class Builder {

        private Long id;
        private Long id_pessoa;
        private String logradouro;
        private String numero;
        private String bairro;
        private String cidade;
        private String estado;
        private String complemento;
        private String cep;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setId_pessoa(Long id_pessoa) {
            this.id_pessoa = id_pessoa;
            return this;
        }

        public Builder setLogradouro(String logradouro) {
            this.logradouro = logradouro;
            return this;
        }

        public Builder setNumero(String numero) {
            this.numero = numero;
            return this;
        }

        public Builder setBairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public Builder setCidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public Builder setEstado(String estado) {
            this.estado = estado;
            return this;
        }

        public Builder setComplemento(String complemento) {
            this.complemento = complemento;
            return this;
        }
        
        public Builder setCep(String cep) {
            this.cep = cep;
            return this;
        }

        public Endereco build() {
            return new Endereco(id, id_pessoa, logradouro, numero, bairro, cidade, estado, complemento, cep);
        }
    }
}
