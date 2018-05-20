package com.rankenstein.service.abstractions;

import com.rankenstein.service.exceptions.ServiceException;

@FunctionalInterface
public interface Transformer<S,T> {

    T transform(S s) throws ServiceException;

    default <A> A transform(S s, Transformer<T,A> t1) throws ServiceException {
        return t1.transform(transform(s));
    }

    default <A,B> B transform(S s, Transformer<T,A> t1, Transformer<A,B> t2) throws ServiceException {
        return t2.transform(transform(s, t1));
    }

    default <A,B,C> C transform(S s, Transformer<T,A> t1,
                                Transformer<A,B> t2,
                                Transformer<B,C> t3) throws ServiceException {
        return t3.transform(transform(s, t1, t2));
    }

    default <A,B,C,D> D transform(S s, Transformer<T,A> t1,
                                Transformer<A,B> t2,
                                Transformer<B,C> t3,
                                Transformer<C,D> t4) throws ServiceException {
        return t4.transform(transform(s, t1, t2, t3));
    }

    default <A,B,C,D,E> E transform(S s, Transformer<T,A> t1,
                                 Transformer<A,B> t2,
                                 Transformer<B,C> t3,
                                 Transformer<C,D> t4,
                                 Transformer<D,E> t5) throws ServiceException {
        return t5.transform(transform(s, t1, t2, t3, t4));
    }
}
