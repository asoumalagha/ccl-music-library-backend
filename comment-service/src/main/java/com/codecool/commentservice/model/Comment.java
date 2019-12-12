package com.codecool.commentservice.model;


import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Comment {


    @Id
    @GeneratedValue
    private Long id;

    private String comment;

    private Long songId;

}
