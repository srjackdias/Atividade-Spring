package com.SistemaDeCadastro.cadastro.models;

import com.SistemaDeCadastro.cadastro.Interfaces.IConsultas;

public  abstract class Consultas  implements IConsultas{
    protected final double renda = 500;

    private String Data;
    private String descricao;
    public double getRenda() {
        return renda;
    }
    public String getData() {
        return Data;
    }
    public void setData(String data) {
        Data = data;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    

    
}
