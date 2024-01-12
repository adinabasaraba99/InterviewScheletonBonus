package com.example.interviewskeleton.config;

import com.example.interviewskeleton.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/greet/**").authenticated()
            .and()
            .addFilterBefore(new TokenFilter(), UsernamePasswordAuthenticationFilter.class);
  }

  @Bean
  public TokenFilter tokenFilter() {
    return new TokenFilter();
  }
}
