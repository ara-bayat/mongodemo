package com.learning.mongodemo.product.enums;

import lombok.Getter;

@Getter
public enum Category {

    SMARTPHONE("smartPhone","phone with OS"),
    TV("tv","TV");

    private String name;
    private String description;
    Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
