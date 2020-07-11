package com.example.server.domain;

import lombok.Data;

@Data
public class Teacher {
    private String id;

    private String name;

    private String nickname;

    private String image;

    private String position;

    private String motto;

    private String intro;
}