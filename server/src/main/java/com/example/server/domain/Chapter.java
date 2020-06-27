package com.example.server.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Chapter {
    private String id;

    private String courseId;

    private String name;

}