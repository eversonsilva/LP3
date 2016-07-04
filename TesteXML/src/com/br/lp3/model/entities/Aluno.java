/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;

/**
 *
 * @author Everson
 */
public class Aluno implements Serializable{
    
    private String tia;
    private String nome;
    private String faculdade;
    private String curso;
    private int etapa;
    private Endereco endereco;

    public Aluno(String tia, String nome, String faculdade, String curso, int etapa, Endereco endereco) {
        this.tia = tia;
        this.nome = nome;
        this.faculdade = faculdade;
        this.curso = curso;
        this.etapa = etapa;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Aluno{" + "tia=" + tia + ", nome=" + nome + ", faculdade=" + faculdade + ", curso=" + curso + ", etapa=" + etapa + ", endereco=" + endereco + '}';
    }
 
}
