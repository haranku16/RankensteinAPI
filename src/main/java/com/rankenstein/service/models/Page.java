package com.rankenstein.service.models;

import com.rankenstein.service.util.PageSize;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Page<T> {
    private final List<T> lines;
    private final PageSize pageSize;
    private final int pageNumber;
    private final int numPages;
}
