package cz.greenrose.bookshelf.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/status").permitAll();
        http.csrf().disable().authorizeRequests().antMatchers("/api/**").permitAll();
        http
            .cors().and()
            .csrf().disable().authorizeRequests()
            .antMatchers("/users").hasRole("admin")
            .anyRequest().authenticated()
            .and()
            .formLogin();
    }
}
