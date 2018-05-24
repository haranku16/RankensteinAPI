package com.rankenstein.service.models;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder
public class Comment {
    private final String message;
    private final User author;
    private final Date created;
    private final Date edited;
    private final List<Comment> replies;
    private final int thumbsUp;
    private final int thumbsDown;
}
