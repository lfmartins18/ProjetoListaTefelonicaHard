package com.LPenterprises.listatelefonica.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LPenterprises.listatelefonica.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByNomeAndSenha(String email, String senha);
	
}
