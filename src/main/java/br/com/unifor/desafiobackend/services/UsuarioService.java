package br.com.unifor.desafiobackend.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.unifor.desafiobackend.generics.GenericService;
import br.com.unifor.desafiobackend.model.Usuario;
import br.com.unifor.desafiobackend.repository.UsuarioRepository;

@Component
@Service
public class UsuarioService extends GenericService<Usuario, Long, UsuarioRepository> {

	@Override
	public Usuario update(Usuario model) {
		model.setSenha(criptografar(model.getSenha()));
		model.setToken(gerarToken(model));
		return super.update(model);
	}
	
	public Usuario getUsuarioByToken(String token) {
		return this.repository.findByToken(token);
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
