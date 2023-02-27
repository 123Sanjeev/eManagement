package com.emms.wipro.iaf.configuration;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	basePackages={"com.emms.wipro.iaf.maximo.dao"},
	entityManagerFactoryRef = "maximoEntityManager",
    transactionManagerRef = "maximoTransactionManager")
public class MaximoDBConfiguration {

	@Bean(name="maximodatasource")
	@ConfigurationProperties(prefix="spring.maximodatasource")
	public DataSource maximoDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="maximoEntityManager")
	public LocalContainerEntityManagerFactoryBean maximoEntityManager(EntityManagerFactoryBuilder builder, @Qualifier("maximodatasource")DataSource dataSource) {
		HashMap<String, Object> properties = new HashMap<String,Object>();
		properties.put("hibernate.hbm2ddl","update");
        return builder.dataSource(dataSource).packages("com.emms.wipro.iaf.eAssessment.entities").persistenceUnit("maximoPersistenceUnit").properties(properties).build();
	}
	
	@Bean(name="maximoTransactionManager")
    public PlatformTransactionManager maximoTransactionManager(@Qualifier("maximoEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
    }
}
