package config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration // @Configuration: Esta anotación indica que la clase es una clase de configuración de Spring. Spring Boot escaneará esta clase durante el inicio de la aplicación para cargar la configuración.
@EntityScan("domain")
@EnableJpaRepositories(basePackages = "repos")
@EnableWebMvc
@ComponentScan(basePackages = {"controller","service"})
public class DoConfig {
    // Puedes agregar configuraciones adicionales si es necesario
}
