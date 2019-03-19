package br.com.unifor.desafiobackend.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.unifor.desafiobackend.generics.GenericService;
import br.com.unifor.desafiobackend.model.Usuario;
import br.com.unifor.desafiobackend.repository.UsuarioRepository;

@Component
@Service
public class UsuarioService extends GenericService<Usuario, Long, UsuarioRepository> {

	@Override
	public Usuario salvar(Usuario model) {
		model.setSenha(criptografar(model.getSenha()));
		model.setToken(gerarToken(model));
		return super.salvar(model);
	}
	
	public Usuario getUsuarioByToken(String token) {
		return this.repository.findByToken(token);
	}
	
	public Usuario login(Usuario usuario) {
		Usuario logado = this.repository.findByMatriculaAndSenha(usuario.getMatricula(), criptografar(usuario.getSenha()));
		
		if(logado == null)
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "LOGIN OU SENHA INVALIDOS");
		
		logado.setToken(gerarToken(logado));
		this.repository.saveAndFlush(logado);
		
		logado.setTipoUsuario(null);
		logado.setSenha(null);
		
		
		return logado;
	}
	
	public void logout(Usuario usuario) {
		Usuario user = this.repository.findByToken(usuario.getToken());
		if(user == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ERRO AO DESCONECTAR!");
		
		user.setToken(null);
		this.repository.saveAndFlush(user);
	}

	private String gerarToken(Usuario model) {
		return this.criptografar(model.getNome()+new Date());
	}

	private String criptografar(String senha) {
		try {
			MessageDigest m=MessageDigest.getInstance("MD5");
			m.update(senha.getBytes(),0,senha.length());
			return new BigInteger(1,m.digest()).toString(16)+"";
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
