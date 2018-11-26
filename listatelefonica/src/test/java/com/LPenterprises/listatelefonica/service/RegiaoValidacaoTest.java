package com.LPenterprises.listatelefonica.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RegiaoValidacaoTest {

   

	@Test
	public void naoValidarNacionalidadeSemSerABrasileira() {
		RegiaoValidacao regiaoValidacao = new RegiaoValidacao();

		String nacionalidade = "Argentina";
		String estado = "AL";
		String cidade = "Rio Largo";
		String cep = "57100-000";

		boolean ehRegiaoValida = regiaoValidacao.validarRegiao(nacionalidade, estado, cidade, cep);

		assertEquals(false,ehRegiaoValida);

	}

	@Test
	public void naoPodeValidarEstadoSemSerDoBrasil() {
		RegiaoValidacao regiaoValidacao = new RegiaoValidacao();

		String nacionalidade = "Brasileira";
		String estado = "Canada";
		String cidade = "Rio Largo";
		String cep = "57100-000";

		boolean ehRegiaoValida = regiaoValidacao.validarRegiao(nacionalidade, estado, cidade, cep);

		assertEquals(false,ehRegiaoValida);

	}

	@Test
	public void naoPodeValidarEstadoQueASiglaSejaMaiorQueDoisCaracteres() {
		RegiaoValidacao regiaoValidacao = new RegiaoValidacao();

		String nacionalidade = "Brasileira";
		String estado = "ALR";
		String cidade = "Rio Largo";
		String cep = "57100-000";

		boolean ehRegiaoValida = regiaoValidacao.validarRegiao(nacionalidade, estado, cidade, cep);

		assertEquals(false,ehRegiaoValida);

	}

	@Test
	public void naoPodeValidarCidadeQueTenhaONomeMaiorQueTrintaEDoisCaracteres() {
		RegiaoValidacao regiaoValidacao = new RegiaoValidacao();

		String nacionalidade = "Brasileira";
		String estado = "AL";
		String cidade = "Vila Bela da Santíssima Trindadehghhg";
		String cep = "57100-000";

		boolean ehRegiaoValida = regiaoValidacao.validarRegiao(nacionalidade, estado, cidade, cep);

		assertEquals(false,ehRegiaoValida);

	}
	
	@Test
	public void naoPodeValidarCepComMaisDeOitoNumeros() {
		RegiaoValidacao regiaoValidacao = new RegiaoValidacao();

		String nacionalidade = "Brasileira";
		String estado = "AL";
		String cidade = "Rio Largo";
		String cep = "57100-000000//";

		boolean ehRegiaoValida = regiaoValidacao.validarRegiao(nacionalidade, estado, cidade, cep);

		assertEquals(false,ehRegiaoValida);

	}

	@Test
	public void permitirValidarComTudoCorreto() {
		RegiaoValidacao regiaoValidacao = new RegiaoValidacao();

		String nacionalidade = "Brasileira";
		String estado = "AL";
		String cidade = "Rio Largo";
		String cep = "57100-000";	
		
		boolean ehRegiaoValida = regiaoValidacao.validarRegiao(nacionalidade, estado, cidade, cep);
		
		assertEquals(true, ehRegiaoValida);
	}

	
	
}

