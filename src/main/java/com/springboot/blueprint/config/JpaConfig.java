package com.springboot.blueprint.config;

import io.hypersistence.utils.spring.repository.BaseJpaRepositoryImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.TimeZone;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
@EnableJpaRepositories(
        repositoryBaseClass = BaseJpaRepositoryImpl.class,
        value = "com.springboot.blueprint.repository"
)
public class JpaConfig {

    @Component
    public static class HibernateListenerConfigurer {


        @PostConstruct
        protected void init() {
            // Makes sure that JPA/Hibernate defaults to UTC when persisting
            // the createdAt and updatedAt fields of entities extending from the Auditable class
            TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
        }
    }
}
