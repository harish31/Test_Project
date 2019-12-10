package com.scoperetail.order.persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(
    exclude = {LiquibaseAutoConfiguration.class, RepositoryRestMvcAutoConfiguration.class})
@EnableJpaRepositories("com.scoperetail.order.persistence.repository")
@EntityScan({"com.scoperetail.order.persistence.entity"})
@EnableTransactionManagement
public class SupplierOrderPersistenceApplication {
  public static void main(String[] args) {
    SpringApplication.run(SupplierOrderPersistenceApplication.class, args);
  }
}
