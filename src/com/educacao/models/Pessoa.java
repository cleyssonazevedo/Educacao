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
public class Pessoa {

    private Long id;
    private String nome;
    private int idade;
    private Sexo sexo;

    public Pessoa() {

    }

    public Pessoa(Long id, String nome, int idade, Sexo sexo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
    /**
     * Para montagem do banco de dados mais simples
     */
    public static class Builder {
        private Long id;
        private String nome;
        private int idade;
        private Sexo sexo;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder setIdade(int idade) {
            this.idade = idade;
            return this;
        }

        public Builder setSexo(Sexo sexo) {
            this.sexo = sexo;
            return this;
        }
        
        public Pessoa build() {
            return new Pessoa(id, nome, idade, sexo);
        }
    }
}
