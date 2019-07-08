package com;

import static org.assertj.core.api.Assertions.assertThat;

import com.controller.CountryRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTest {

    @Autowired
    CountryRestController countryRestController;


    @Test
    public void contextLoads() {
        assertThat(countryRestController).isNotNull();
    }

}
