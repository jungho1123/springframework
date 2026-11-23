package myspring.di.xml.config;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:values.properties",encoding = "UTF-8")
public class HelloConfig {
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
    public Hello hello() {
        Hello hello = new Hello();
        return 
    }
    
    
}
