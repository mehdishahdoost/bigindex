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
@ConfigurationProperties("spring.datasource-oracle")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryOracle",
        transactionManagerRef = "transactionManagerOracle",
        basePackages = {"com.example.demo.card.repo"}
)
public class CardDataSourceConfig extends HikariConfig {

    private final String PERSISTENCE_UNIT_NAME = "oracle";
    private final String MODEL_PACKAGE = "com.example.demo.card.model";

    private final Properties JPA_PROPERTIES = new Properties() {{
        put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
        put("hibernate.hbm2ddl.auto", "none");
        put("hibernate.ddl-auto", "none");
        put("show-sql", "true");
    }};

    @Bean
    public HikariDataSource dataSourceOracle() {
        return new HikariDataSource(this);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryOracle(
            final HikariDataSource dataSourceOracle) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSourceOracle);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(MODEL_PACKAGE);
            setJpaProperties(JPA_PROPERTIES);
        }};
    }

    @Bean
    public PlatformTransactionManager transactionManagerOracle(EntityManagerFactory entityManagerFactoryOracle) {
        return new JpaTransactionManager(entityManagerFactoryOracle);
    }
}
