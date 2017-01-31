package app.configuracion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
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
	
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
	}
	
	//Solucion al problema de Date
	@Bean
	public FormattingConversionService mvcConversionService(){
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(true);		
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("yyy-MM-dd"));
		
		registrar.registerFormatters(conversionService);
		return conversionService;
	}
}

