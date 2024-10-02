package org.askie01.customers.auditor;


import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Implementation of {@link AuditorAware} for providing the current {@code auditor}.
 * <p>
 * This implementation returns a fixed value {@code CUSTOMERS_MS}, which represents
 * the microservice responsible for the audit.
 * </p>
 */
@Component("auditor")
public class Auditor implements AuditorAware<String> {

    /**
     * Provides the current {@code auditor}.
     *
     * @return an {@link Optional} containing {@link String} with value {@code CUSTOMERS_MS} as the current auditor.
     */
    @NotNull
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("CUSTOMERS_MS");
    }
}
