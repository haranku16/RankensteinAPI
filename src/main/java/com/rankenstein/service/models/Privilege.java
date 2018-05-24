package com.rankenstein.service.models;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Builder
@Accessors(fluent=true)
public class Privilege {
    private final boolean canView;
    private final boolean canComment;
    private final boolean canRank;
}
