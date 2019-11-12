package com.codecool.cclmusiclibrarybackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    private String title;
    private String album;
    private String performer;
    private double length;

}
