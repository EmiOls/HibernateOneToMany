package se.yrgo.domain;
import jakarta.persistence.*;

@Entity
@Table(name="TBL_STUDENT")
public class Student
{
    private String enrollmentID;
    private String name;

    @ManyToOne
    @JoinColumn(name="TUTOR_FK")
    private Tutor tutor;

    @Column (name="NUM_COURSES")
    private Integer numberOfCourses;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    
    public Student() {
    }

    public Student(String name, Tutor tutor)
    {
    	this.name = name;
    	this.tutor = tutor;
    }


    public Student(String name)
    {
    	this.name = name;
    	this.tutor = null;
        this.numberOfCourses = 10;
    }

    public String getEnrollmentID() {
        return enrollmentID;
    }

    public String getName() {
        return name;
    }

    public Integer getNumberOfCourses() {
        return numberOfCourses;
    }

    public int getId() {
        return id;
    }

    public Tutor getTutor() {
		return tutor;
	}

    public void setEnrollmentID(String enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfCourses(Integer numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student [enrollmentID=" + enrollmentID + ", name=" + name + ", tutor=" + tutor + ", numberOfCourses="
                + numberOfCourses + ", id=" + id + "]";
    }

    public void allocateTutor(Tutor tutor) {
        this.tutor=tutor;	
    }
        
    public String getTutorName() {
        return this.tutor.getName();
    }
}
