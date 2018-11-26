package com.LPenterprises.listatelefonica.service;

public class PessoaValidacao {

	public boolean validarPessoa(String contato) {
		if(validarContato(contato)) {
			return true;
		}
		return false;
	}

	public boolean validarContato(String contato) {
		if(contato.matches(".((10)|([1-9][1-9]).)\\s9?[6-9][0-9]{3}-[0-9]{4}") || contato.matches(".((10)|([1-9][1-9]).)\\s[2-5][0-9]{3}-[0-9]{4}")){
			return true;
		}
		return false;
	}  

}
