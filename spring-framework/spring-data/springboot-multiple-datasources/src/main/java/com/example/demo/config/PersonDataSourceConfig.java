package com.example.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@Configuration
@ConfigurationProperties("spring.datasource-hprt")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryHprt",
        transactionManagerRef = "transactionManagerHprt",
        basePackages = {"com.example.demo.person.repo"}
)
public class PersonDataSourceConfig extends HikariConfig {

    private final String PERSISTENCE_UNIT_NAME = "hprt";
    private final String MODEL_PACKAGE = "com.example.demo.hprt.model";

    private final Properties JPA_PROPERTIES = new Properties() {{
        put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        put("hibernate.hbm2ddl.auto", "none");
        put("hibernate.ddl-auto", "none");
        put("show-sql", "true");
    }};

    @Bean
    public HikariDataSource dataSourceHprt() {
        return new HikariDataSource(this);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryHprt(
            final HikariDataSource dataSourceHprt) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSourceHprt);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(MODEL_PACKAGE);
            setJpaProperties(JPA_PROPERTIES);
        }};
    }

    @Bean
    public PlatformTransactionManager transactionManagerHprt(EntityManagerFactory entityManagerFactoryHprt) {
        return new JpaTransactionManager(entityManagerFactoryHprt);
    }
}
