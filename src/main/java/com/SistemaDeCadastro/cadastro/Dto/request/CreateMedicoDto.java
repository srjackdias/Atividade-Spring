package com.SistemaDeCadastro.cadastro.Dto.request;

public class CreateMedicoDto {
    

    private String nome;
    private String especialidade;
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



    
}