package com.post;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class PostInitialProjApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(PostInitialProjApplication.class, args);
	}

	
	 @Bean
    public LocaleResolver localeResolver(){
         SessionLocaleResolver localeResolver = new SessionLocaleResolver();
         localeResolver.setDefaultLocale(Locale.FRANCE);
         return  localeResolver;
     }

     @Bean
     public LocaleChangeInterceptor localeChangeInterceptor() {
         LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
         localeChangeInterceptor.setParamName("lang");
         return localeChangeInterceptor;
     }

     @Override
     public void addInterceptors(InterceptorRegistry registry){
         registry.addInterceptor(localeChangeInterceptor());
     }


     @Override
     public void addViewControllers(ViewControllerRegistry registry) {
         registry.addViewController("/").setViewName("login");
     }

}
