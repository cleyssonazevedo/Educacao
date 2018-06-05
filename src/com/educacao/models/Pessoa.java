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

    // Others
    private Endereco endereco;
    private Telefone telefone;

    public Pessoa() {
        this.endereco = new Endereco();
        this.telefone = new Telefone();
        this.sexo = Sexo.NAO_DEFINIDO;
    }

    public Pessoa(Long id, String nome, int idade, Sexo sexo, Endereco endereco, Telefone telefone) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.endereco = endereco;
        this.telefone = telefone;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    /**
     * Para montagem do banco de dados mais simples
     */
    public static class Builder {

        private Long id;
        private String nome;
        private int idade;
        private Sexo sexo;
        private Endereco endereco;
        private Telefone telefone;

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

        public Builder setEndereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public Builder setTelefone(Telefone telefone) {
            this.telefone = telefone;
            return this;
        }

        public Pessoa build() {
            return new Pessoa(id, nome, idade, sexo, endereco, telefone);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Id: %d\n", id));
        builder.append(String.format("Nome: %s\n", nome));
        builder.append(String.format("Idade: %d\n", idade));
        builder.append(String.format("Sexo: %s\n", sexo.getLiteral()));

        builder.append("Endereço\n");
        builder.append(String.format("Id: %d\n", endereco.getId()));
        builder.append(String.format("Id Pessoa: %d\n", endereco.getId_pessoa()));
        builder.append(String.format("Logradouro: %s\n", endereco.getLogradouro()));
        builder.append(String.format("Número: %s\n", endereco.getNumero()));
        builder.append(String.format("Bairro: %s\n", endereco.getBairro()));
        builder.append(String.format("Cidade: %s\n", endereco.getCidade()));
        builder.append(String.format("CEP: %s\n", endereco.getCep()));
        builder.append(String.format("estado: %s\n", endereco.getEstado()));
        builder.append(String.format("Complemento: %s\n", endereco.getComplemento()));

        builder.append("Número de telefone\n");
        builder.append(String.format("Id: %d\n", telefone.getId()));
        builder.append(String.format("Id Pessoa: %d\n", telefone.getId_pessoa()));
        builder.append(String.format("Telefone: %s\n", telefone.getNumero()));

        return builder.toString();
    }

}
