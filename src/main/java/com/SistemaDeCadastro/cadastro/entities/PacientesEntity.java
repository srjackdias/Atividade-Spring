package com.SistemaDeCadastro.cadastro.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "pacientes")

public class PacientesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_paciente")
    private Long id_paciente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "profissao")
    private String profissao;



    @OneToOne(mappedBy = "paciente", cascade = CascadeType.REMOVE)
    private MedicoEntity medico;


    @OneToMany(mappedBy = "paciente")
    private List<ConsultasEntity> consultas;


    public Long getId_paciente() {
        return id_paciente;
    }


    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getProfissao() {
        return profissao;
    }


    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }


    public MedicoEntity getMedico() {
        return medico;
    }


    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }


    public List<ConsultasEntity> getConsultas() {
        return consultas;
    }


    public void setConsultas(List<ConsultasEntity> consultas) {
        this.consultas = consultas;
    }

 

    

}
