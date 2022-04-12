package nl.vanhemert.spring.boot.conferencedemo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        builder.url("jdbc:postgresql://localhost:5432/postgres");
        builder.username("postgres");
        builder.password("Welcome");
        System.out.println("PersistenceConfiguration::dataSource");
        return builder.build();
    }
}
