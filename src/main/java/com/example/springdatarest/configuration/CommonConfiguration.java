package com.example.springdatarest.configuration;

import com.example.springdatarest.entity.Company;
import com.example.springdatarest.entity.Department;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class CommonConfiguration {
    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return new RepositoryRestConfigurer() {
            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration restConfig, CorsRegistry cors) {
                //restConfig.setBasePath("/api");
                //restConfig.setRepositoryDetectionStrategy(RepositoryDetectionStrategy.RepositoryDetectionStrategies.ANNOTATED);
                restConfig.setReturnBodyOnCreate(true);
                restConfig.setReturnBodyOnUpdate(true);
                restConfig.exposeIdsFor(Company.class, Department.class);
            }
        };
    }
}
