package com.codecool.apigateway.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser {

    private long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> roles = new ArrayList<>();
}
