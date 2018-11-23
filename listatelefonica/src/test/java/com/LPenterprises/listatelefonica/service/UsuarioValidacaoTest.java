package com.LPenterprises.listatelefonica.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UsuarioValidacaoTest {

	@Test
	public void naoPodeValidarNomeComNumeros() {
		UsuarioValidacao usuarioValidacao = new UsuarioValidacao();

		String nome = "Luiz Fernando 123";
		String email = "luiz18659@gmail.com";
		String senha = "1234567890";

		boolean ehUsuarioValido = usuarioValidacao.validarUsuario(nome, email, senha);

		assertEquals(false, ehUsuarioValido);
	}

	@Test
	public void naoPodeValidarNomeESobrenomeEscritosSemEspaco() {
		UsuarioValidacao usuarioValidacao = new UsuarioValidacao();

		String nome = "LuizFernando";
		String email = "luiz18659@gmail.com";
		String senha = "1234567890";

		boolean ehUsuarioValido = usuarioValidacao.validarUsuario(nome, email, senha);

		assertEquals(false, ehUsuarioValido);
	}

	@Test
	public void naoPodeValidarNomeDeUsuarioQueQueiraColocarSeuNomeCompleto() {
		UsuarioValidacao usuarioValidacao = new UsuarioValidacao();

		String nome = "Luiz Fernando Martins da Silva";
		String email = "luiz18659@gmail.com";
		String senha = "1234567890";

		boolean ehUsuarioValido = usuarioValidacao.validarUsuario(nome, email, senha);

		assertEquals(false, ehUsuarioValido);
	}

	@Test
	public void naoPodeValidarEmailSemOArroba() {
		UsuarioValidacao usuarioValidacao = new UsuarioValidacao();

		String nome = "Luiz Fernando";
		String email = "luiz18659gmail.com";
		String senha = "1234567890";

		boolean ehUsuarioValido = usuarioValidacao.validarUsuario(nome, email, senha);

		assertEquals(false, ehUsuarioValido);

	}

	@Test
	public void naoPodeValidarEmailSemOPonto() {
		UsuarioValidacao usuarioValidacao = new UsuarioValidacao();

		String nome = "Luiz Fernando";
		String email = "luiz18659gmailcom";
		String senha = "1234567890";

		boolean ehUsuarioValido = usuarioValidacao.validarUsuario(nome, email, senha);

		assertEquals(false, ehUsuarioValido);
	}

	@Test
	public void naoPodeValidarEmailComCaracteresEspeciais() {
		UsuarioValidacao usuarioValidacao = new UsuarioValidacao();

		String nome = "Luiz Fernando";
		String email = "luiz$%18#659@gmail.com";
		String senha = "1234567890";

		boolean ehUsuarioValido = usuarioValidacao.validarUsuario(nome, email, senha);

		assertEquals(false, ehUsuarioValido);
	}

	@Test
	public void naoPodeValidarSenhaComMenosDeDezCaracteres() {
		UsuarioValidacao usuarioValidacao = new UsuarioValidacao();

		String nome = "Luiz Fernando Martins da Silva";
		String email = "luiz18659gmailcom";
		String senha = "12345678";

		boolean ehUsuarioValido = usuarioValidacao.validarUsuario(nome, email, senha);

		assertEquals(false, ehUsuarioValido);
	}
	
	@Test
	public void naoPodeValidarSenhaComCaracteresEspeciais() {
		UsuarioValidacao usuarioValidacao = new UsuarioValidacao();

		String nome = "Luiz Fernando Martins da Silva";
		String email = "luiz18659gmailcom";
		String senha = "12345678%$#@+";

		boolean ehUsuarioValido = usuarioValidacao.validarUsuario(nome, email, senha);

		assertEquals(false, ehUsuarioValido);
	}

	@Test
	public void permitirValidarComTudoCorreto() {
		UsuarioValidacao usuarioValidacao = new UsuarioValidacao();

		String nome = "Luiz Fernando";
		String email = "luiz18659@gmail.com";
		String senha = "123456789000";
		
		boolean ehUsuarioValido = usuarioValidacao.validarUsuario(nome, email, senha);
		
		assertEquals(true, ehUsuarioValido);
	}

	
	
}
