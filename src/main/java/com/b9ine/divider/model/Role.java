package com.b9ine.divider.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ROLE_ID", nullable = false)
    private Integer id;

    @Column(name="ROLE_NAME", nullable = false)
    private String name;

}