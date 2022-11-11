package com.tutorial.music.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
@Getter
@EqualsAndHashCode(of = "id")
@ToString
public class Role {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

}
