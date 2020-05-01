package com.okta.kotlin.resourceserver

import com.okta.spring.boot.oauth.Okta
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class SecurityConfiguration : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http?.csrf()?.disable()?.authorizeRequests()?.anyRequest()?.authenticated()?.and()?.oauth2ResourceServer()?.jwt();
        Okta.configureResourceServer401ResponseBody(http);
    }
}