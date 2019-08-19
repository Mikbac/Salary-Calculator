/**
 * Created by MikBac on 2018
 */

package pl.MikBac.salaryApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.MikBac.salaryApp.spring.controller.CountryPageController;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTest {

    @Autowired
    CountryPageController countryPageController;

    @Test
    public void contextLoads() {
        assertThat(countryPageController).isNotNull();
    }

}
