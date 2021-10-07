package pl.mikbac.salary_app.spring.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

/**
 * Created by MikBac on 22.08.2021
 */

@Setter
@Getter
@ConfigurationProperties(prefix = "nbp.api")
@Component
public class NbpProperties {

    @NotBlank
    private String address;

}
