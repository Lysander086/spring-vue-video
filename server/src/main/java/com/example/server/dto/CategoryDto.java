// Generated via dto.ftl
package com.example.server.dto;

import lombok.Data;

@Data
public class CategoryDto {
    /**
     * id
     */
    private String id;
    /**
     * 父id
     */
    private String parent;
    /**
     * 名称
     */
    private String name;
    /**
     * 顺序
     */
    private Integer sort;
}