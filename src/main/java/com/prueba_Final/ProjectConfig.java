/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.prueba_Final;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
 
@Configuration
public class ProjectConfig implements WebMvcConfigurer {
    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
    }
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registro) {
       registro.addInterceptor(localeChangeInterceptor());
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/index").setViewName("index");
        registro.addViewController("/login").setViewName("login");
        registro.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
    }
    
    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((request) -> request
                .requestMatchers("/","/index","/carrito/**","/js/**","/webjars/**","/registro/**",
                        "/categoria/**","/categoria2/vistaCategoria/**","/producto/**","/sobreNosotros/info","/css/**")
                .permitAll()
                
                 .requestMatchers("/facturar/carrito")
                .hasRole("USER")
                .requestMatchers("/admin/vista")
                .hasRole("EMPLEADO")
                .requestMatchers("/admin/**")
                .hasRole("ADMIN")
        )
                .formLogin((form) -> form.loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
                
        
    return http.build();
    }
    
//      @Autowired
//    private UserDetailsService userDetailsService;
    
    @Bean
    public UserDetailsService users(){
        UserDetails admin = User.builder()
                .username("juan")
                .password("{noop}123")
                .roles("ADMIN","EMPLEADO")
                .build();
         UserDetails empleado = User.builder()
                .username("rebeca")
                .password("{noop}456")
                .roles("EMPLEADO")
                .build();
         
         
        return new InMemoryUserDetailsManager(admin,empleado);
    }
//    @Autowired
//    private UserDetailsService userDetailsService;
//    
//    @Autowired
//    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
//    builder.userDetailsService(userDetailsService)
//            .passwordEncoder(new BCryptPasswordEncoder());
//    
//    }
}