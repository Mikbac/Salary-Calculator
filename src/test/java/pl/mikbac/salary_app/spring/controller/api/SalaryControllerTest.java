package pl.mikbac.salary_app.spring.controller.api;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.mikbac.salary_app.WebApplication;
import pl.mikbac.salary_app.constants.WebConstants.Mapping;

import javax.annotation.Resource;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by MikBac on 02.01.2022
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
@AutoConfigureMockMvc
public class SalaryControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    @DisplayName("Get salary.")
    public void getSalaryWhenDataIsCorrect() throws Exception {
        this.mockMvc.perform(get(Mapping.API + Mapping.CALCULATOR + "/?countryCode=UK&salary=123")
                        .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }
}