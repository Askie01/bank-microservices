package org.askie01.customers;

import org.askie01.customers.dto.CustomerContactInformationDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Main entry point for the {@code Customers Spring Boot application}.
 * <p>
 * This class configures and starts the Spring Boot application, enabling
 * JPA auditing and binding configuration properties to the specified DTO.
 * </p>
 * <h2>Key Annotations:</h2>
 * <ul>
 *     <li>{@link SpringBootApplication}: This annotation indicates that the class is a Spring Boot application,
 *     enabling component scanning, auto-configuration, and other Spring Boot features.</li>
 *     <li>{@link EnableJpaAuditing}: Enables JPA Auditing, which allows for the automatic handling of entity
 *     auditing fields like {@code createdAt}, {@code createdBy}, {@code updatedAt}, {@code updatedBy}. It
 *     references an auditor provider bean through the {@code auditorAwareRef} attribute.</li>
 *     <li>{@link EnableConfigurationProperties}: Enables binding of configuration properties to the specified
 *     class (in this case, {@link CustomerContactInformationDTO}). This ensures that externalized configuration
 *     properties (e.g. from {@code application.properties}) are mapped to the DTO.</li>
 * </ul>
 *
 * @see SpringBootApplication
 * @see EnableJpaAuditing
 * @see EnableConfigurationProperties
 * @see CustomerContactInformationDTO
 */
@EnableJpaAuditing(auditorAwareRef = "auditor")
@EnableConfigurationProperties(value = {CustomerContactInformationDTO.class})
@SpringBootApplication
public class CustomersApplication {

    /**
     * Main method that starts the {@code Spring Boot application}.
     *
     * @param args command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(CustomersApplication.class, args);
    }

}
