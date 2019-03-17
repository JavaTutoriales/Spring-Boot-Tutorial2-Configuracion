package com.javatutoriales.springboot.configuracion.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

public class EncriptionEnvironmentPostProcessor implements EnvironmentPostProcessor {

	private static final String PROPERTY_SOURCE_NAME = "secretConfig";

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("mail.credenciales.password", descifra(environment.getProperty("mail.credenciales.password"), 6));
		map.put("mail.hostname", descifra(environment.getProperty("mail.hostname"), 6));
		
		environment.getPropertySources().addFirst(new MapPropertySource(PROPERTY_SOURCE_NAME, map));
	}


	private String descifra(String valor, int shift) {
		String s = "";
		
		int len = valor.length();
		
		for (int x = 0; x < len; x++) {
			
			char ch = (char) (valor.charAt(x));
			
			if(ch >= 'a' && ch <= 'z'){
	            ch = (char)(ch - shift);
	            
	            if(ch < 'a'){
	                ch = (char)(ch + 'z' - 'a' + 1);
	            }
	            
	            s += ch;
	        }
	        else if(ch >= 'A' && ch <= 'Z'){
	            ch = (char)(ch - shift);
	            
	            if(ch < 'A'){
	                ch = (char)(ch + 'Z' - 'A' + 1);
	            }
	            
	            s += ch;
	        }
	        else {
	        	s += ch;
	        }
		}
		return s;
	}
}
