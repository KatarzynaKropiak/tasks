package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity(name = "tasks")
public class Task {

    @javax.persistence.Id
    @Id
    @GeneratedValue
    private Long id;

    @Column (name = "name")
    private String title;

    @Column (name = "description")
    private String content;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
