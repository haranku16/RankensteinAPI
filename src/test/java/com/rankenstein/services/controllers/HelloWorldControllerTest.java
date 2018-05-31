package com.rankenstein.services.controllers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldControllerTest {
    @Test
    public void test() {
        assertEquals("Hello, world!", new HelloWorldController().greet("world"));
    }
}
