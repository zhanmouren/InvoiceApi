package com.korosoft.invoice.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korosoft.invoice.filter.RequestWrapperFilter;
import com.korosoft.invoice.interceptor.LogInterceptor;
import com.korosoft.invoice.resolver.PersonResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Bean
    public FilterRegistrationBean<RequestWrapperFilter> repeatedlyReadFilter() {
		FilterRegistrationBean<RequestWrapperFilter> registration = new FilterRegistrationBean<RequestWrapperFilter>();
		RequestWrapperFilter requestWrapperFilter = new RequestWrapperFilter();
        registration.setFilter(requestWrapperFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }
	
	@Bean
	@ConditionalOnMissingBean(ObjectMapper.class)
	public ObjectMapper jsonMapper() {
		return new JsonMapper();
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		WebMvcConfigurer.super.configureMessageConverters(converters);
		converters.add(new MappingJackson2HttpMessageConverter(jsonMapper()));
	}

	@Bean
	public LogInterceptor logInterceptor() {
		return new LogInterceptor();
	}

	@Bean
	public PersonResolver personResolver() {
		return new PersonResolver();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(logInterceptor()).addPathPatterns("/**");
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		WebMvcConfigurer.super.addArgumentResolvers(resolvers);
		resolvers.add(personResolver());
	}

}
