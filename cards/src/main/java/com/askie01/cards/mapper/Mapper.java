package com.askie01.cards.mapper;

public interface Mapper<S, T> {
    T map(S source, T target);
}
