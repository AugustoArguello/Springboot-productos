package com.augusto.springboot.usuarios.oauth.Security.Event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import com.augusto.springboot.commons.usuarios.models.Entity.Usuarios;
import com.augusto.springboot.usuarios.oauth.models.Service.IUsuarioService;

import feign.FeignException;

public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {

	private Logger log= LoggerFactory.getLogger(AuthenticationSuccessErrorHandler.class);
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		if(authentication.getDetails() instanceof WebAuthenticationDetails) {
			return;
		}
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String mensajeString = "Succes Login:"+ userDetails.getUsername();
		System.out.println(mensajeString);
		log.info(mensajeString);
		
		Usuarios usuario = usuarioService.findByUsername(authentication.getName());
		
		if(usuario.getIntentos() != null && usuario.getIntentos()>0) {
			usuario.setIntentos(0);
			usuarioService.update(usuario, usuario.getId());
		}
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		String mensaje = "Error en el login: "+ exception.getMessage();
		log.error(mensaje);
		System.out.println(mensaje);
		
		try {
			StringBuilder error = new StringBuilder();
			error.append(mensaje);
			Usuarios usuario = usuarioService.findByUsername(authentication.getName());
			if(usuario.getIntentos()== null) {
				usuario.setIntentos(0);
			}
			log.info("intento actual es de : "+usuario.getIntentos());
			usuario.setIntentos(usuario.getIntentos()+1);
			
			log.info("intento actual es de : "+usuario.getIntentos());
			error.append("- intentos de login: "+ usuario.getIntentos());
			
			if(usuario.getIntentos()>=3) {
				String errormaxintentoString= String.format("el usuario %s des-habilitado por maximos intentos", usuario.getUsername());
				log.error(errormaxintentoString);
				error.append("-"+ errormaxintentoString);
				usuario.setEnable(false);
			}
			
			usuarioService.update(usuario,usuario.getId());
			
		} catch (FeignException e) {
			log.error(String.format("el usuario %s no existe en el sistema", authentication.getName()));
		}
	}

}
