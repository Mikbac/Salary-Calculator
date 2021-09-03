package pl.mikbac.salaryapp.spring.configuration.development;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.mikbac.salaryapp.constants.ConfigurationConstants.Profiles;
import pl.mikbac.salaryapp.constants.WebConstants.AntPatterns;

/**
 * Created by MikBac on 06.08.2019
 */

@Configuration
@Profile(Profiles.DEVELOPMENT)
@EnableWebSecurity(debug = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public SecurityConfiguration() {
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .authorizeRequests()
                .antMatchers(AntPatterns.ROOT).permitAll()
                .and().headers().frameOptions().sameOrigin();
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers(AntPatterns.RESOURCES,
                        AntPatterns.ASSETS,
                        AntPatterns.CSS,
                        AntPatterns.LESS,
                        AntPatterns.JS,
                        AntPatterns.IMAGES,
                        AntPatterns.FONTS,
                        AntPatterns.JSON);
    }

}
