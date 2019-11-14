package com.codecool.cclmusiclibrarybackend.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany(mappedBy = "users")
    @EqualsAndHashCode.Exclude
    @ElementCollection
    @Singular
    private List<Song> songs;

}
