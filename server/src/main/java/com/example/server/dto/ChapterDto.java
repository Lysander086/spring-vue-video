package com.example.server.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChapterDto {
    private String id;

    private String courseId;

    private String name;

}