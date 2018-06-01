package com.rankenstein.services.controllers;

import com.rankenstein.services.response.Response;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldControllerTest extends HelloWorldController {

    private Response<String> response;

    @Before
    public void initialize() {
        response = greet("world");
    }

    @Test
    public void testData() {
        assertEquals("Hello, world!", response.getData());
    }

    @Test
    public void testMetadata() {
        Response.Metadata metadata = response.getMetadata();
        assertEquals(1, metadata.getPage());
        assertEquals(1, metadata.getSeed());
        assertEquals(1, metadata.getSize());
        assertEquals(200, metadata.getStatus());
    }
}
