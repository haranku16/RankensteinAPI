package com.rankenstein.service.models;

import lombok.Data;

import java.util.List;

@Data
public class Rankenstein extends Ranking {
    private List<Ranking> rankings;
    private String title;
    private String description;
    private boolean canAddOptions;
    private List<User> invitees;
}
