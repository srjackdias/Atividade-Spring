package com.SistemaDeCadastro.cadastro.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name ="medico")
public class MedicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "id_Medico")
    private Long id_Medico;


    @Column(name = "nome")
    private String nome;

    @Column(name = "especialidade")
    private String especialidade;

    
    @OneToOne
    @JoinColumn(name = "id_paciente")
    private PacientesEntity paciente;


    public Long getId_Medico() {
        return id_Medico;
    }


    public void setId_Medico(Long id_Medico) {
        this.id_Medico = id_Medico;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEspecialidade() {
        return especialidade;
    }


    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }


    public PacientesEntity getPaciente() {
        return paciente;
    }


    public void setPaciente(PacientesEntity paciente) {
        this.paciente = paciente;
    }


    
    


}
