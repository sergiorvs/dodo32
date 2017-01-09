package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

import app.configuracion.WebConfiguracion;

@Controller
@SpringBootApplication
@Import(WebConfiguracion.class)
@EnableAutoConfiguration
public class AndyToy {	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(AndyToy.class, args);
	}

}
