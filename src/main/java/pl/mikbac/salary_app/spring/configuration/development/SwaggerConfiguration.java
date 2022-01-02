package pl.mikbac.salary_app.spring.configuration.development;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static pl.mikbac.salary_app.constants.ConfigurationConstants.Profiles;
import static pl.mikbac.salary_app.constants.GlobalConstants.Package;

/**
 * Created by MikBac on 13.08.2019
 */

@Configuration
@Profile(Profiles.DEVELOPMENT)
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(Package.CONTROLLER))
                .build();
    }

}
