// Generated via dto.ftl
package com.example.server.dto;

import lombok.Data;

@Data
public class CourseCategoryDto {
    /**
     * id
     */
    private String id;
    /**
     * 课程|course.id
     */
    private String courseId;
    /**
     * 分类|course.id
     */
    private String categoryId;
}