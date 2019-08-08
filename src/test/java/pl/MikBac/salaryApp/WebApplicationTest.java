/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.MikBac.salaryApp.spring.controller.CountryController;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTest {

    @Autowired
    CountryController countryController;

    @Test
    public void contextLoads() {
        assertThat(countryController).isNotNull();
    }

}
