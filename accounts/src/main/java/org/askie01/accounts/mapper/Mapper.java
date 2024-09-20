package org.askie01.accounts.mapper;

public interface Mapper<S, T> {
    T map(S source, T target);
}
