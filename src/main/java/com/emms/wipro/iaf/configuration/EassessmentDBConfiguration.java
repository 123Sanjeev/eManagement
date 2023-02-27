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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	basePackages={"com.emms.wipro.iaf.eAssessment.dao", "com.emms.wipro.iaf.eAssessment.Repository"},
	entityManagerFactoryRef = "eAssessmentEntityManager",
    transactionManagerRef = "eAssessmentTransactionManager")
public class EassessmentDBConfiguration {
	
	@Primary
	@Bean(name="dataSource")
	@ConfigurationProperties(prefix="spring.eassessmentdatasource")
	public DataSource eAssessmentDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean(name="eAssessmentEntityManager")
	public LocalContainerEntityManagerFactoryBean eAssessmentEntityManager(EntityManagerFactoryBuilder builder, @Qualifier("dataSource")DataSource dataSource) {
		HashMap<String, Object> properties = new HashMap<String,Object>();
		properties.put("hibernate.hbm2ddl","update");
        return builder.dataSource(dataSource).properties(properties).packages("com.emms.wipro.iaf.eAssessment.entity").build();
	} 
	
	@Primary
	@Bean(name="eAssessmentTransactionManager")
    public PlatformTransactionManager eAssessmentTransactionManager(@Qualifier("eAssessmentEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
    }
}
