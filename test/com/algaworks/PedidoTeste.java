package com.algaworks;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PedidoTeste {

	private PedidoBuilder pedido;

	@Before
	public void setUp(){
		pedido = new PedidoBuilder();
	}
	
	private void assertResumoPedido(double valorTotal, double desconto) {
		ResumoPedido resumoPedido = pedido.construir().resumo();
		assertEquals(new ResumoPedido(valorTotal, desconto), resumoPedido);
	}
	
	@Test
	public void deveCalcularValorTotalEDescontoParaPedidoVazio() throws Exception{
		assertResumoPedido(0.0, 0.0);
	}
	
	@Test
	public void deveCalcularResumoParaUmItemSemDesconto()  throws Exception{
		pedido.comItem(5.0, 5);
		assertResumoPedido(25.0, 0.0);
	}
	
	@Test
	public void deveAplicarDescontoAcimaDe300()  throws Exception{
		pedido.comItem(20.0, 20);
		assertResumoPedido(400.0, 16.0);
	}
	
	@Test
	public void deveAplicarDescontoAcimaDe800() throws Exception{
		pedido.comItem(15.0, 30)
			.comItem(15.0, 30);
		assertResumoPedido(900.0, 54.0);
	}
	
	@Test
	public void deveAplicarDescontoAcimaDe1000() {
		pedido.comItem(15.0, 30)
			.comItem(15.0, 30)
			.comItem(10.0, 30);
		assertResumoPedido(1200.0, 96);
	}
	
	@Test(expected=QuantidadeDeItensInvalidaException.class)
	public void naoAceitarPedidosComQuantidadesNegativas() throws Exception{
		pedido.comItem(0.0, -10);
	}

}
