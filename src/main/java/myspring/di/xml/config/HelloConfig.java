package myspring.di.xml.config;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:values.properties",encoding = "UTF-8")
public class HelloConfig {

    @Autowired
    Environment env;
    // <bean id ="strPrinter" class ="myspring.di.xml.StringPrinter">
    @Bean
    public Printer stringPrinter() {
        return new StringPrinter();
    }
    //<bean id ="conPrinter" class ="myspring.di.xml.ConsolePrinter">
    @Bean
    public Printer consolPrinter(){
        return new ConsolePrinter();
    }
    @Bean
    @Scope(value = "singleton")
    public Hello hello() {
        Hello hello = new Hello();
        hello.setName(env.getProperty("app.xmlSetter.name"));
        hello.setPrinter(stringPrinter());
        return hello;
    }



}
