package com.askie01.cards.copier;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ObjectCopier {

    @SneakyThrows
    public static <T> T copy(T source) {
        Class<?> sourceClass = source.getClass();
        final T copy = getNewInstance(sourceClass);

        while (sourceClass != null) {
            mapFields(sourceClass, source, copy);
            sourceClass = sourceClass.getSuperclass();
        }
        return copy;
    }

    @SneakyThrows
    private static <T> T getNewInstance(Class<?> sourceClass) {
        final Constructor<?> constructor = sourceClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        return (T) constructor.newInstance();
    }

    private static <T> void mapFields(Class<?> sourceClass, T source, T copy) {
        for (Field field : sourceClass.getDeclaredFields()) {
            mapField(field, source, copy);
        }
    }

    @SneakyThrows
    private static <T> void mapField(Field field, T source, T copy) {
        field.setAccessible(true);
        final Object value = field.get(source);
        field.set(copy, value);
    }
}