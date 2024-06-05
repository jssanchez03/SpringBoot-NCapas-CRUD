package ec.edu.espe.registropersona.registropersona;

import ec.edu.espe.registropersona.registropersona.services.PersonServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RegistroPersonaApplication extends SpringBootServletInitializer {

    public static final Logger log = LoggerFactory.getLogger(PersonServices.class);

    public static void main(String[] args) {
        SpringApplication.run(RegistroPersonaApplication.class, args);
        log.warn("Demostración de logs warn");
        log.info("Demostración de logs info");
        log.error("Demostración de logs error");
        log.debug("Demostración de logs debug");
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RegistroPersonaApplication.class);

    }
}
