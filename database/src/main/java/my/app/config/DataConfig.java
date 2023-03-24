package my.app.config;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource(value = {"classpath:/user.jdbc.properties", "classpath:/user.hibernate.properties"})
@EnableTransactionManagement
@EnableJpaRepositories("my.app.repository")
@ComponentScan("my.app")
public class DataConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource, Properties properties) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("my.app.model");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(properties);
        return em;
    }

    @Bean
    public DataSource dataSource(
            @Value("${url}") String url,
            @Value("${driver}") String driver,
            @Value("${username}") String username,
            @Value("${password}") String password
    ) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url,username,password);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

    @Bean
    public Properties properties(
            @Value("${hibernate.dialect}") String dialect,
            @Value("${hibernate.current_session_context_class}") String sessionContext,
            @Value("${hibernate.show_sql}") String showSql
    ) {
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, dialect);
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, sessionContext);
        properties.put(Environment.SHOW_SQL, showSql);
        return properties;
    }

}
