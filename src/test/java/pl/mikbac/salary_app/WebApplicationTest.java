package pl.mikbac.salary_app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mikbac.salary_app.spring.controller.CountryPageController;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by MikBac on 2018
 */

@RunWith(SpringRunner.class)
@ActiveProfiles("development")
@SpringBootTest
public class WebApplicationTest {

    @Autowired
    CountryPageController countryPageController;

    @Test
    public void contextLoads() {
        assertThat(countryPageController).isNotNull();
    }

}
