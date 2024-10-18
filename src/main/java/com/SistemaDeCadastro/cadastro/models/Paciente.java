package com.SistemaDeCadastro.cadastro.models;


import java.util.ArrayList;
import java.util.List;

import com.SistemaDeCadastro.cadastro.enums.Profissao;

public class Paciente {
    

    private Long id;
    private String nome;
    private Profissao profissao;
    private Medico medico;
    private List<Consultas> consultas;
   
    public Paciente(){
        this.consultas = new ArrayList<>();


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

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Consultas> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consultas> consultas) {
        this.consultas = consultas;
    }

    public void setConsulta(Consulta consulta){

        this.consultas.add(consulta);

    }



   

    
}
