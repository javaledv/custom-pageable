package com.example.demo.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class Search extends PageRequest {

    Long id;

    public Search() {
        super(0, 1);
    }

    public Search(int page, int size) {
        super(page, size);
    }

    public Search(int page, int size, Sort.Direction direction, String... properties) {
        super(page, size, direction, properties);
    }

    public Search(int page, int size, Sort sort) {
        super(page, size, sort);
    }

    public static Search from(Pageable pageRequest) {
        return new Search(pageRequest.getPageNumber(), pageRequest.getPageSize(), pageRequest.getSort());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
