package com.SistemaDeCadastro.cadastro.Dto.request;
import java.util.List;


public class CreatePacienteDto {

    private String nome;
    private CreateMedicoDto medico;
    private List<CreateConsultasDto> consultas;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public CreateMedicoDto getMedico() {
        return medico;
    }
    public void setMedico(CreateMedicoDto medico) {
        this.medico = medico;
    }
    public List<CreateConsultasDto> getConsultas() {
        return consultas;
    }
    public void setConsultas(List<CreateConsultasDto> consultas) {
        this.consultas = consultas;
    }
    

}
