package com.SistemaDeCadastro.cadastro.models;


public class Ortopedia extends  Consultas {
    
    @Override
    public double calcularRendaMes(int qtdPontos, double renda) {
        if (qtdPontos >= 15) {
            return renda + (renda * 0.10);
        }

        return this.renda;
    }


}
