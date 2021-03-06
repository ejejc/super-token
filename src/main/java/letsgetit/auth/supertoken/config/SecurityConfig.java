package letsgetit.auth.supertoken.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override  
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .anyRequest()
            .permitAll()
        .and()
        .logout()
        .permitAll();

        http
            .csrf().disable()
            .cors().disable();

        http
            .headers().frameOptions().disable();
    }
}
