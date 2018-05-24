package com.rankenstein.service.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class Ranking {
    private User author;
    private List<String> ranking;
    private Date created;
    private Date updated;
    private List<Comment> comments;
    private int views;
    private int thumbsUp;
    private int thumbsDown;
    private Map<Relationship,Privilege> relationshipPrivileges;
    private Map<User,Privilege> userPrivileges;
}
