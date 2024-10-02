package org.askie01.customers.mapper;

/**
 * A generic interface for mapping objects from a source type to a target type.
 *
 * @param <S> the source type.
 * @param <T> the target type.
 */
public interface Mapper <S, T> {

    /**
     * Maps the fields from the source to the target object.
     *
     * @param source the source object to map from.
     * @param target the target object to map to.
     * @return the target object populated with fields from the source object.
     */
    T map(S source, T target);
}
