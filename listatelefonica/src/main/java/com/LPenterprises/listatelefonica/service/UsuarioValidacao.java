package com.LPenterprises.listatelefonica.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsuarioValidacao {

	private static final String NOME_PATTERN = "^[A-Z][a-z]* [[A-Z][a-z]]*";

	private static final String EMAIL_PATTERN =  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static Pattern pattern;

	private static Matcher matcher;


	public boolean validarUsuario(String nome, String email, String senha) {

		if(validarNome(nome) && validarEmail(email) && validarSenha(senha)) {
			return true;
		}
		else {
			return false;
		}		
	}


	public boolean validarNome(String nome) {

		pattern = Pattern.compile(NOME_PATTERN, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(nome);
		return matcher.matches();

	}

	public boolean validarEmail(String email) {

		pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);		
		matcher= pattern.matcher(email);
		return matcher.matches();

	}

	public boolean validarSenha(String senha) {
		if(senha.length() > 9 && senha.matches("[A-Za-z0-9]+")) {
			return true;
		}
		return false;
	}
}