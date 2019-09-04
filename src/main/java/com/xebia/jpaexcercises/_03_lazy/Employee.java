package com.xebia.jpaexcercises._03_lazy;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private Long id;

    @Column(name = "full_name")
    private String name;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "long_bio")
    private String bio;

    @Override
    public String toString() {
        return super.toString() + "\nid: " + id + "\nname: " + name + "\nbio: " + bio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
