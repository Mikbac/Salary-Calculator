package pl.mikbac.salary_app.spring.configuration.production;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.mikbac.salary_app.constants.ConfigurationConstants;
import pl.mikbac.salary_app.constants.ConfigurationConstants.Profiles;

/**
 * Created by MikBac on 06.08.2019
 */

@Configuration
@Profile(Profiles.PRODUCTION)
@EnableWebSecurity(debug = false)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public SecurityConfiguration() {
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .authorizeRequests()
                .antMatchers(ConfigurationConstants.AntPatterns.ROOT).permitAll()
                .and().headers().frameOptions().sameOrigin();
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers(ConfigurationConstants.AntPatterns.RESOURCES, ConfigurationConstants.AntPatterns.ASSETS, ConfigurationConstants.AntPatterns.CSS, ConfigurationConstants.AntPatterns.LESS,
                        ConfigurationConstants.AntPatterns.JS, ConfigurationConstants.AntPatterns.IMAGES, ConfigurationConstants.AntPatterns.FONTS, ConfigurationConstants.AntPatterns.JSON);
    }

}
