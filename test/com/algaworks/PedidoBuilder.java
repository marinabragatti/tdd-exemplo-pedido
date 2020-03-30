package com.algaworks;

import com.algaworks.desconto.CalculadoraDescontoAcima1000;
import com.algaworks.desconto.CalculadoraDescontoAcima800;
import com.algaworks.desconto.CalculadoraDescontoAcimaDe300;
import com.algaworks.desconto.CalculadoraFaixaDesconto;
import com.algaworks.desconto.SemDesconto;

public class PedidoBuilder {

	private Pedido instancia;

	public PedidoBuilder(){
		CalculadoraFaixaDesconto calculadoraFaixaDesconto = 
			new CalculadoraDescontoAcima1000(
				new CalculadoraDescontoAcima800(
					new CalculadoraDescontoAcimaDe300(
						new SemDesconto(null))));

		instancia = new Pedido(calculadoraFaixaDesconto);
	}

	public PedidoBuilder comItem(double valorUnitario, int quantidade){
		instancia.adicionarItem(new ItemPedido("Item Qualquer", valorUnitario, quantidade));
		return this;
	}

	public Pedido construir(){
		return instancia;
	}

}
