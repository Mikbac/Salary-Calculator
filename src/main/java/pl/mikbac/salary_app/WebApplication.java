package pl.mikbac.salary_app;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static pl.mikbac.salary_app.constants.GlobalConstants.Package;

/**
 * Created by MikBac on 2018
 */

@Log4j2
@SpringBootApplication(scanBasePackages = {Package.SPRING})
@EntityScan(basePackages = {Package.MODEL})
@EnableJpaAuditing
public class WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        log.info("Starting Spring boot application");
        SpringApplication.run(WebApplication.class, args);
    }

}
