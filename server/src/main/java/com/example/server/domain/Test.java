package com.example.server.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Test {
    private String id;

    private String name;
}