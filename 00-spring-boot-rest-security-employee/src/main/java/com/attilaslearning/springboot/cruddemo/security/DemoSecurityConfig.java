package com.attilaslearning.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    //add support for JDBC authentication
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define query to retrieve user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id = ?");
        //define query to retrieve authorities/roles  by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id = ?");

        return jdbcUserDetailsManager;
    }

    //restrict access based on role
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(configurer ->
                        configurer
                                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
                );
        //use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable CSRF
        //in general, it is not required for REST APIs that use POST, PUT, DELETE, etc.
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }


/*    Method for in-memory authentication
      @Bean
      public InMemoryUserDetailsManager userDetailsManager() {
          UserDetails john = User.builder()
                  .username("john")
                  .password("{noop}test123")
                  .roles("EMPLOYEE")
                  .build();
         UserDetails mary = User.builder()
                  .username("mary")
                  .password("{noop}test123")
                  .roles("EMPLOYEE", "MANAGER")
                  .build();
          UserDetails susan = User.builder()
                  .username("susan")
                  .password("{noop}test123")
                  .roles("EMPLOYEE", "MANAGER", "ADMIN")
                  .build();
        return new InMemoryUserDetailsManager(john, mary, susan);
    }*/


}
