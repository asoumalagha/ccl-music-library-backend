package com.codecool.cclmusiclibrarybackend.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class TodoAppUser {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
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

    // roles of the user (ADMIN, USER,..)
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();
}
