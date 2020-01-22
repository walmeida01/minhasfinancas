package com.walmeida.minhasfinancas.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmeida.minhasfinancas.exception.RegraNegocioException;

import com.walmeida.minhasfinancas.model.entity.Usuario;
import com.walmeida.minhasfinancas.model.repository.UsuarioRepository;
import com.walmeida.minhasfinancas.service.UsuarioService;

@Service
public class UsuarioServiceImpl  implements UsuarioService{
	
	private UsuarioRepository repository;	
	
	@Autowired
	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		return null;
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		return null;
	}
	
	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com este email.");
		}
	}

	
}
