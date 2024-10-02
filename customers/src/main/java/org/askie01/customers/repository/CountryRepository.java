package org.askie01.customers.repository;

import org.askie01.customers.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * {@link Repository} interface for {@link Country} entity.
 * <p>
 * Extends {@link JpaRepository} to provide basic CRUD operations and additional query methods for {@link Country} objects.
 * </p>
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    /**
     * Retrieves an {@link Optional} containing {@link Country} based on the provided {@code name}.
     *
     * @param name the name of {@link Country} to be retrieved.
     * @return {@link Optional} containing the matching {@link Country}, or empty {@link Optional} if no match is found.
     */
    Optional<Country> findByName(String name);
}
