package com.LPenterprises.listatelefonica.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegiaoValidacao {

	//private static final String siglaEstados[]={"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};

	private static final String CEP_PATTERN = "\\d{5}[-]\\d{2}";

	private Pattern pattern;

	private Matcher matcher;

	public boolean validarRegiao(String nacionalidade, String estado, String cidade, String cep) {

		if (validarNacionalidade(nacionalidade) && validarEstado(estado) && validarCidade(cidade) && validarCep(cep)) {
			return true;
		}
		return false;
	}

	public boolean validarNacionalidade(String nacionalidade) {

		if(!nacionalidade.equals("Brasileira")) {
			return false;
		}
		return true;
	}

	public boolean validarEstado(String estado) {

		if(estado.contains("AC") && estado.contains("AL") && estado.contains("AP") && estado.contains("AM") && estado.contains("BA") && estado.contains("CE") && estado.contains("DF") &&
				estado.contains("ES") && estado.contains("GO") && estado.contains("MA") && estado.contains("MT") && estado.contains("MS") && estado.contains("MG") && estado.contains("PA") &&
				estado.contains("PB") && estado.contains("PR") && estado.contains("PE") && estado.contains("PI") && estado.contains("RJ") && estado.contains("RN") && estado.contains("RS") &&
				estado.contains("RO") && estado.contains("RR") && estado.contains("SC") && estado.contains("SP") && estado.contains("SE") && estado.contains("TO")){
			return true;
		}
		return false;
	}   

	public boolean validarCidade(String cidade) {

		if(cidade.length() > 5 || cidade.length() < 32) {
			return true;
		}
		return false;
	}

	public boolean validarCep(String cep) {

		pattern = Pattern.compile(CEP_PATTERN, Pattern.CASE_INSENSITIVE);		
		matcher= pattern.matcher(cep);
		return matcher.matches();
	}

}





