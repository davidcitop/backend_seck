package com.servipack.servipack.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.servipack.model.Usuario;
import com.servipack.service.IUsuarioService;

@SuppressWarnings("deprecation")
@Component
public class InfoAdicionalToken implements TokenEnhancer {
	
	@Autowired
	private IUsuarioService usuarioService;
	

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = usuarioService.findByUsuCodigo(authentication.getName());
		
		Map<String, Object> info = new HashMap<>();
		info.put("codigo_usuario", usuario.getUsuCodigo());
		info.put("nombre_usuario", usuario.getUsuNombre());
		info.put("movil_usuario", usuario.getUsuMovil());

		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}
	
	

}
