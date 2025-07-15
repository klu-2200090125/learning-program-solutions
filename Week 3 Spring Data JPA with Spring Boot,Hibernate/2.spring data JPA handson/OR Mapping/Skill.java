package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sk_name")
    private String name;

    @ManyToMany(mappedBy = "skillList")
    private Set<Employee> employeeList;

    public Skill() {}
    public Skill(String name) { this.name = name; }

    // Getters and setters

    @Override
    public String toString() {
        return "Skill{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
