/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import pl.MikBac.salaryApp.spring.property.NbpProperties;

@Log4j2
@SpringBootApplication(scanBasePackages = {"pl.MikBac.salaryApp.spring"})
@EntityScan(basePackages = {"pl.MikBac.salaryApp.model"})
@EnableConfigurationProperties(value = {NbpProperties.class})
public class WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        log.info("Starting Spring boot application");
        SpringApplication.run(WebApplication.class, args);
    }

}
