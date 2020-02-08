package com.walmeida.minhasfinancas.model.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.walmeida.minhasfinancas.model.entity.Usuario;

@SpringBootTest
@ExtendWith( SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioRepositoryTest {

	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void deveVerificarAExistenciaDeUmEmail() {
		//cenário
		Usuario usuario = Usuario.builder().nome("usuario").email("usuario@email.com").build();
		repository.save(usuario);
		
		//acao / execucao
		boolean result = repository.existsByEmail("usuario@email.com");		
		
		//verificacao
		Assertions.assertThat(result).isTrue();
		
	}
	
	@Test 
	public void deveRetornarFalsoQuandoNaoHouberUsuarioCadastradoComOEmail() {
		//cenario
		repository.deleteAll();
		
		//acao
		boolean result = repository.existsByEmail("usuario@gmail.com");
		
		//verificacao
		Assertions.assertThat(result).isFalse();				
	}
}
