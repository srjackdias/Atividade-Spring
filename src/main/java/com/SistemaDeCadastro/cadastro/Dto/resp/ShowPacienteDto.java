package com.SistemaDeCadastro.cadastro.Dto.resp;

import java.util.List;

public class ShowPacienteDto {
    

    private Long id_paciente;
    private String nome;
    private ShowMedicoDto medico;
    private List<ShowConsultasDto> consultas;


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
    public ShowMedicoDto getMedico() {
        return medico;
    }
    public void setMedico(ShowMedicoDto medico) {
        this.medico = medico;
    }
    public List<ShowConsultasDto> getConsultas() {
        return consultas;
    }
    public void setConsultas(List<ShowConsultasDto> consultas) {
        this.consultas = consultas;
    }

    
}
