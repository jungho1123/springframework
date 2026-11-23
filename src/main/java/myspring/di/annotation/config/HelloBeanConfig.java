package myspring.di.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"myspring.di.annotation"})
@PropertySource(value = "classpath:values.properties", encoding = "UTF-8")
public class HelloBeanConfig {

}
