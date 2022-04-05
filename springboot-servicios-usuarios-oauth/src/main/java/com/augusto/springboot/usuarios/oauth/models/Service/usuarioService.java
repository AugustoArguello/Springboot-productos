package com.augusto.springboot.usuarios.oauth.models.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.augusto.springboot.commons.usuarios.models.Entity.Usuarios;
import com.augusto.springboot.usuarios.oauth.cliente.clienteFeing;

import feign.FeignException;


@Service
public class usuarioService implements UserDetailsService, IUsuarioService {

	private Logger log = LoggerFactory.getLogger(usuarioService.class);
	
	@Autowired
	private clienteFeing clienteFeing;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Usuarios usuarios = clienteFeing.findByUsername(username);
			
			
			List<GrantedAuthority> authorities = usuarios.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getNombre()))
					.peek(authority -> log.info("Role:"+ authority.getAuthority()))
					.collect(Collectors.toList());
			log.info("usuario autenticado:"+ username);
			return new User(username, usuarios.getPassword(), usuarios.getEnable(), true, true, true, authorities );
		
		} catch (FeignException e) {
			String error = "Error en el login, no existe el usuario '" + username + "' en el sistema";
			log.error(error);

			throw new UsernameNotFoundException(error);
		}
	}

	@Override
	public Usuarios findByUsername(String username) {
		
	 return clienteFeing.findByUsername(username);
	}

	@Override
	public Usuarios update(Usuarios usuario, Long id) {
		return clienteFeing.update(usuario, id);
	}

}
