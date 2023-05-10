package se.yrgo.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tutor {
    private String tutorId;
    private String name;
    private int salary;

    //@JoinColumn(name="TUTOR_FK")
    //Add the above if you want to have a FK in Student instead of a bridge table
    @OneToMany
    private List<Student> teachingGroup;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Tutor() {
    }

    public Tutor(String tutorId, String name, int salary) {
        this.teachingGroup = new ArrayList<>();
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

    public List<Student> getTeachingGroup() {
        return Collections.unmodifiableList(this.teachingGroup);
    }

    @Override
    public String toString() {
        return "Tutor [tutorId=" + tutorId + ", name=" + name + ", salary=" + salary + "]";
    }

    public void addStudentToTeachingGroup(Student newStudent) {
        this.teachingGroup.add(newStudent);
    }

}
