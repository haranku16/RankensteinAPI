package com.rankenstein.services.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Response<T> {
    @Getter
    @Builder
    public static class Metadata {
        @Builder.Default
        private final int status = 200;
        @Builder.Default
        private final int page = 1;
        @Builder.Default
        private final int seed = 1;
        @Builder.Default
        private final int size = 1;
    }
    private final T data;
    private final Metadata metadata;

    public Response(T data) {
        this.data = data;
        this.metadata = Metadata.builder().build();
    }
}
