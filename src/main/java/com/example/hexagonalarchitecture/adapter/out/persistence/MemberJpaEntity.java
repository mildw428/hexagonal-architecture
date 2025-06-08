package com.example.hexagonalarchitecture.adapter.out.persistence;

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
