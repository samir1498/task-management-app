package com.samir.taskmanagement.domain.entities;

import lombok.Data;

@Data
public class Task {

    private int id;

    private String title;
    private String description;
}
