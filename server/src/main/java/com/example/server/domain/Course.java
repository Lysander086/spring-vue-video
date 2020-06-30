package com.example.server.domain;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class Course {
    private String id;

    private String name;

    private String summary;

    private Integer time;

    private BigDecimal price;

    private String image;

    private String level;

    private String charge;

    private String status;

    private Integer enroll;

    private Integer sort;

    private Date createdAt;

    private Date updatedAt;
}