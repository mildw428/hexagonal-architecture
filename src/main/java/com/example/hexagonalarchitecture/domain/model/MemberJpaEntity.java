package com.example.hexagonalarchitecture.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "members")
public class MemberJpaEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;

}
