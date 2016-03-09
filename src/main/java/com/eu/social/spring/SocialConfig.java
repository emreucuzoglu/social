package com.eu.social.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "file:/socialapp/config/application.properties")
public class SocialConfig {

}