package se.yrgo.domain;

import jakarta.persistence.*;

@Entity
public class Tutor {
    private String tutorId;
    private String name;
    private int salary;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    public Tutor() {
    }

    public Tutor(String tutorId, String name, int salary) {
        this.tutorId = tutorId;
        this.name = name;
        this.salary = salary;
    }

    public String getTutorId() {
        return tutorId;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Tutor [tutorId=" + tutorId + ", name=" + name + ", salary=" + salary + "]";
    }

    
}
