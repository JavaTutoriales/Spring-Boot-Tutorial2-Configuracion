package com.javatutoriales.springboot.configuracion.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Configuration
@PropertySource("classpath:config/tutorial.properties")
@Getter
public class EjemploConfig {
	@Value("${demo.valor:default}")
	private String valor;
}
