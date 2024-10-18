package com.SistemaDeCadastro.cadastro.models;

public class Radiologia extends Consultas {
    @Override
    public double calcularRendaMes(int qtdPontos, double renda) {
        if (qtdPontos >= 42) {
            return renda + (renda * 0.10);
        }

        return this.renda;
    }
}
