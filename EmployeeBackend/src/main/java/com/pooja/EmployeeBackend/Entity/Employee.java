package com.pooja.EmployeeBackend.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "firstname",length = 50)
    private String firstname;
    @Column(name = "lastname",length = 50)
    private String lastname;
    @Column(name = "rating",length = 50)
    private String rating;
    @Column(name = "feedback",length = 100)
    private String feedback;
    @Column(name = "duration",length = 50)
    private String duration;
    @Column(name = "improvements",length = 70)
    private String improvements;
    @Column(name = "completedItems",length = 70)
    private String completedItems;
    @Column(name = "pendingItems",length = 70)
    private String pendingItems;

    public Employee(int id, String firstname, String lastname, String rating, String feedback, String duration, String improvements, String completedItems, String pendingItems) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.rating = rating;
        this.feedback = feedback;
        this.duration = duration;
        this.improvements = improvements;
        this.completedItems = completedItems;
        this.pendingItems = pendingItems;
    }

    public Employee(String firstname, String lastname, String rating, String feedback, String duration, String improvements, String completedItems, String pendingItems) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.rating = rating;
        this.feedback = feedback;
        this.duration = duration;
        this.improvements = improvements;
        this.completedItems = completedItems;
        this.pendingItems = pendingItems;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImprovements() {
        return improvements;
    }

    public void setImprovements(String improvements) {
        this.improvements = improvements;
    }

    public String getCompletedItems() {
        return completedItems;
    }

    public void setCompletedItems(String completedItems) {
        this.completedItems = completedItems;
    }

    public String getPendingItems() {
        return pendingItems;
    }

    public void setPendingItems(String pendingItems) {
        this.pendingItems = pendingItems;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", rating='" + rating + '\'' +
                ", feedback='" + feedback + '\'' +
                ", duration='" + duration + '\'' +
                ", improvements='" + improvements + '\'' +
                ", completedItems='" + completedItems + '\'' +
                ", pendingItems='" + pendingItems + '\'' +
                '}';
    }
}
