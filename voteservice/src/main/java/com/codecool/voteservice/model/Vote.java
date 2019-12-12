package com.codecool.voteservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Vote {

    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition="int default '0'")
    private int rating;

    private Long songId;
}
