package com.LPenterprises.listatelefonica.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PessoaValidacaoTest {

	@Test
	public void naoPodeValidarContatoQueExcedaOPadraoDeTelefonesDoBrasil() {
		PessoaValidacao  pessoaValidacao = new PessoaValidacao();

		String contato = "(82)98846-56600";

		boolean ehContatoValido = pessoaValidacao.validarPessoa(contato);

		assertEquals(false, ehContatoValido);
	}

}
