package com.augusto.springboot.usuarios.oauth.Security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.augusto.springboot.commons.usuarios.models.Entity.Usuarios;
import com.augusto.springboot.usuarios.oauth.models.Service.IUsuarioService;

@Component
public class infoAditionalToken implements TokenEnhancer  {
	
	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String ,Object> infoMap = new HashMap<String,Object>();
		Usuarios usuarios= usuarioService.findByUsername(authentication.getName());
		infoMap.put("nombre", usuarios.getNombre());
		infoMap.put("apellido", usuarios.getApellido());
		infoMap.put("correo", usuarios.getE_mail());
		((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(infoMap);
		return accessToken;
	}

}
