package com.javatutoriales.springboot.configuracion.config;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Configuration
@ConfigurationProperties(prefix = "mail")
@Validated
public class MailConfigurationProperties {
	@NotEmpty(message="El correo es un parámetro obligatorio.")
	private String hostname;
	private String adminMail;
	
	@Positive
	private int port;
	
	@Email
	private String from;
	private List<@Email String> defaultRecipients;
	
	private Map<String, String> additionalHeaders;
	
	@Valid
	private Credenciales credenciales;
}
