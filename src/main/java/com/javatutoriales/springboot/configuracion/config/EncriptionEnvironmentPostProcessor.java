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

@Component
public class EncriptionEnvironmentPostProcessor implements EnvironmentPostProcessor {

	private static final String PROPERTY_SOURCE_NAME = "secretConfig";

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("demo.valor", environment.getProperty("demo.valor") + " modificado desde el post procesador");
		map.put("demo.valorEnv", environment.getProperty("demo.valorEnv") + " modificado desde el post procesador");
		addOrReplace(environment.getPropertySources(), map);
	}

	private void addOrReplace(MutablePropertySources propertySources, Map<String, Object> map) {
		MapPropertySource target = null;
		target = new MapPropertySource(PROPERTY_SOURCE_NAME, map);
		propertySources.addFirst(target);
	}
}
