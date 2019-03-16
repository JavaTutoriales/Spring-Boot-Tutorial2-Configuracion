package com.javatutoriales.springboot.configuracion.config;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Credenciales {
	
	private String user;
	
	@Size(min=8, max=10)
	private String password;
	private String host;
}
