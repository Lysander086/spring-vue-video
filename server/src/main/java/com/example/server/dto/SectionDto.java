package com.example.server.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SectionDto {
    private String id;

    private String title;

    private String courseId;

    private String chapterId;

    private String video;

    private Integer time;

    private String charge;

    private Integer sort;

    private Date createdAt;

    private Date updatedAt;
}