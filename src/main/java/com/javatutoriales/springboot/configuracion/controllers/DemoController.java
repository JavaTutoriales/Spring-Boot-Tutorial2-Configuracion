package com.javatutoriales.springboot.configuracion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatutoriales.springboot.configuracion.config.EjemploConfig;

import lombok.Setter;

@RestController
public class DemoController {
	@Setter (onMethod=@__(@Autowired))
	private EjemploConfig config;
	
	@Setter (onMethod=@__(@Autowired))
	private Environment env;
	
	@GetMapping
	public String saluda() {
		return "Hola " + config.getValor();
	}
	
	@GetMapping("/env")
	public String saludaEnv() {
		return "Hola " + env.getProperty("demo.valorEnv");
	}
	
	
}
