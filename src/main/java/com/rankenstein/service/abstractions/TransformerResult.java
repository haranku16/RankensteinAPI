package com.rankenstein.service.abstractions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TransformerResult<T> {
    private T t;

    public T get() {
        return t;
    }

    public <U> TransformerResult<U> andThen(Transformer<T,U> transformer) {
        return transformer.transform(t);
    }
}
