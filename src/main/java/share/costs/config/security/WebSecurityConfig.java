package share.costs.config.security;

import share.costs.config.security.jwt.JWTAuthorizationFilter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable();
    http.authorizeRequests()
        .antMatchers(HttpMethod.POST, SecurityConstants.USERS_URL).permitAll()
            .antMatchers(HttpMethod.POST, SecurityConstants.LOGIN_URL).permitAll()
        .anyRequest().authenticated()
        .and()
            .addFilter(new JWTAuthorizationFilter(authenticationManager()))
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Override
  public void configure(final WebSecurity web) {
    web.ignoring().antMatchers(
        "/users/**",
        "/configuration/ui",
        "/configuration/**",
        "/actuator/**",
        "/v2/api-docs",
        "/swagger-resources/**",
        "/swagger-ui.html",
        "/webjars/**");
  }

}
