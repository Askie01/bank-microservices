package org.askie01.customers.copier;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Utility class for copying fields of an object to a new instance of the same type.
 * <p>
 * This class provides methods to {@code create} a deep {@code copy} of an object by using {@code reflection}.
 * It copies all fields from the {@code source} object, including those from {@code superclass(es)}.
 * </p>
 * <p>
 * Note: This class {@code CANNOT BE} instantiated, as it has private constructor.
 * </p>
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ObjectCopier {

    /**
     * Creates a deep copy of the provided {@code source} object.
     *
     * @param source the object to be copied.
     * @param <T>    the type of the object to be copied.
     * @return a new instance of the same type as the {@code source} object with copied fields.
     * @throws IllegalAccessException if the {@link Field} is not accessible.
     * @throws InstantiationException if the class that declares the underlying {@link Field} is an abstract class.
     * @throws NoSuchMethodException  if the class does not have a no-argument {@link Constructor}.
     */
    @SneakyThrows
    public static <T> T copy(T source) {
        log.atDebug().log("Attempting to copy object of type: '{}'", source.getClass().getSimpleName());
        Class<?> sourceClass = source.getClass();
        final T copy = getNewInstance(sourceClass);
        log.atDebug().log("Created a new instance of type: '{}'", sourceClass.getSimpleName());

        while (sourceClass != null) {
            log.atDebug().log("Attempting to copy fields from class: '{}'", sourceClass.getSimpleName());
            mapFields(sourceClass, source, copy);
            sourceClass = sourceClass.getSuperclass();
        }
        log.atInfo().log("Copying completed successfully for object of type: '{}'", source.getClass().getSimpleName());
        return copy;
    }

    /**
     * Creates a new instance of the specified class using its no-argument constructor.
     *
     * @param sourceClass the class of the object to be instantiated.
     * @param <T>         the type of the object.
     * @return a new instance of the specified class.
     * @throws IllegalAccessException if the constructor is not accessible.
     * @throws InstantiationException if the class that declares the underlying constructor is abstract.
     * @throws NoSuchMethodException  if the class does not have a no-argument constructor.
     */
    @SneakyThrows
    private static <T> T getNewInstance(Class<?> sourceClass) {
        log.atDebug().log("Attempting to obtain no-argument constructor for class: '{}'", sourceClass.getSimpleName());
        final Constructor<?> constructor = sourceClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        return (T) constructor.newInstance();
    }

    /**
     * Map fields from the {@code source} to {@code copy} for the specified class.
     *
     * @param sourceClass the class of the {@code source} object.
     * @param source      the source object from which to copy fields.
     * @param copy        the object to which fields will be copied.
     * @param <T>         the type of the objects.
     */
    private static <T> void mapFields(Class<?> sourceClass, T source, T copy) {
        for (Field field : sourceClass.getDeclaredFields()) {
            log.atDebug().log("Attempting to copy field: '{}'", field.getName());
            mapField(field, source, copy);
        }
    }

    /**
     * Copies a field's value from the source object to the copy object.
     *
     * @param field  the field to be copied.
     * @param source the source object from which to copy the field value.
     * @param copy   the object to which the field value will be copied.
     * @param <T>    the type of the objects.
     * @throws IllegalAccessException if the field is not accessible.
     */
    @SneakyThrows
    private static <T> void mapField(Field field, T source, T copy) {
        field.setAccessible(true);
        final Object value = field.get(source);
        log.atDebug().log("Field: '{}', value: '{}'", field.getName(), value);
        field.set(copy, value);
    }
}