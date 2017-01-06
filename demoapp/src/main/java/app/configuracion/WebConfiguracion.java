package app.configuracion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.lyncode.jtwig.mvc.JtwigViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"app.controlador", "app.repositorio", "app.servicio"})
public class WebConfiguracion extends WebMvcConfigurerAdapter {
	
	@Bean
	public ViewResolver viewResolver() {
		JtwigViewResolver jtwigViewResolver1 = new JtwigViewResolver();
		jtwigViewResolver1.setPrefix("/WEB-INF/views/");
		jtwigViewResolver1.setSuffix(".twig.html");
		return jtwigViewResolver1;
	}

}
