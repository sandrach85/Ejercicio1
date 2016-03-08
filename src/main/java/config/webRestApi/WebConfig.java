package config.webRestApi;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import config.PackageNames;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {PackageNames.REST_API})
//@Import(value = {MailConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {


}
