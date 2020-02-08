package com.walmeida.minhasfinancas.service;

import org.junit.Test;
import org.junit.Test.None;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.walmeida.minhasfinancas.exception.RegraNegocioException;
import com.walmeida.minhasfinancas.model.entity.Usuario;
import com.walmeida.minhasfinancas.model.repository.UsuarioRepository;



@SpringBootTest
@ExtendWith( SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	UsuarioRepository repository;
	
	@Test(expected = None.class )
	public void deveValidarEmail() {
		//cenario
		repository.deleteAll();
		
		//acao
		service.validarEmail("email@email.com");
		
	}
	
	@Test(expected = RegraNegocioException.class)
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		//cenario
		Usuario usuario = Usuario.builder().nome("usuario").email("email@email.com").build();
		repository.save(usuario);
		
		//acao
		service.validarEmail("email@email.com");
	}
}
