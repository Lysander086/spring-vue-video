package com.example.server.domain;

import lombok.Data;

@Data
public class Category {
    private String id;

    private String parent;

    private String name;

    private Integer sort;
}