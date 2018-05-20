package com.rankenstein.service.abstractions;

import org.junit.Test;

public class TransformerTest {
    @Test
    public void test() {
        Transformer<Integer,Integer> doubler = (i) -> 2*i;
        Transformer<Integer,Integer> addThree = (i) -> i+3;
        Transformer<Integer,String> toString = (i) -> Integer.toString(i);
        Transformer<String,Void> printer = (s) -> {
            System.out.println(s);
            return null;
        };
        doubler.transform(2).andThen(addThree).andThen(toString).andThen(printer);
    }
}
