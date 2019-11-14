package com.codecool.cclmusiclibrarybackend.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Song {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String album;
    private String performer;
    private double length;

    @ManyToMany(mappedBy = "songs", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ElementCollection
    @Singular
    private List<User> owners;

}
