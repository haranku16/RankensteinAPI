package com.rankenstein.service.abstractions;

import com.rankenstein.service.exceptions.ServiceException;

@FunctionalInterface
public interface Transformer<S,T> {

    T transformInput(S s) throws ServiceException;

    default TransformerResult<T> transform(S s) {
        return new TransformerResult<>(transformInput(s));
    }
}
