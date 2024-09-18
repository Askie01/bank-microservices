package com.askie01.loans.mapper;

public interface Mapper <S, T> {
    T map(S source, T target);
}
