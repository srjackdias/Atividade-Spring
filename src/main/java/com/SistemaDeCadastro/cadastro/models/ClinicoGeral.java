package com.SistemaDeCadastro.cadastro.models;


public class ClinicoGeral  extends Consultas{
    @Override
    public double calcularRendaMes(int qtdPontos, double renda) {
        if (qtdPontos >= 3) { 
            return renda;
        }

        return this.renda;
    }
}
