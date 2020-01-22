package com.walmeida.minhasfinancas.model.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.walmeida.minhasfinancas.model.entity.Usuario;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioRepositoryTest {

	@Autowired
	UsuarioRepository repository;
	
	@org.junit.jupiter.api.Test
	public void deveVerificarAExistenciaDeUmEmail() {
		//cenário
		Usuario usuario = ((Object) Usuario.builder()).nome("usuario").email("usuario@email.com").build();
		
		//ação / execução
		
		
		//verificação
		
	}
	
}
