package com.example.server.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum SectionChargeEnum {

    CHARGE("C", "收费"),
    FREE("F", "免费");

    @Setter
    private String code;
    @Setter
    private String desc;

    SectionChargeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}