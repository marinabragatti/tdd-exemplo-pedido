package com.algaworks.desconto;

public class CalculadoraDescontoAcima1000 extends CalculadoraFaixaDesconto{

	public CalculadoraDescontoAcima1000(CalculadoraFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if(valorTotal > 1000.0) {
			return valorTotal * 0.08;
		}
		return -1;
	}
	
}
