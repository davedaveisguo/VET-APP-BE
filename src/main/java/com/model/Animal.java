package com.model;


import com.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "animal"
)
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "dob",
            nullable = false
    )
    private LocalDate dob;

    @Column(
            name = "status",
            nullable = false
    )
    private String status;

    @Column(
            name = "injury",
            nullable = false
    )
    private String injury;

    @Column(
            name = "on_treat",
            nullable = false
    )
    private String onTreat;


    @Column(
            name = "weight",
            nullable = false
    )
    private int weight;

    @Column(
            name = "age",
            nullable = false
    )
    private int age;


    @Column(name="gender",nullable = false)
    @Enumerated(EnumType.STRING)
    private Sex sex;


    @Column(name="injury_part",nullable = false)
    private String part;


    @Column(name="image_url",nullable = true)
    private String url;

    @Column(name="breed",nullable = false)
    private String breed;

    @Column(name="coat_color",nullable = false)
    private String color;

    @OneToMany(
            mappedBy = "animal",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Request> requests = new ArrayList<>();


    @OneToMany(
            mappedBy = "animal",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Prescribe> prescribes = new ArrayList<>();

    @OneToMany(
            mappedBy = "animal",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Report> reports = new ArrayList<>();


    @OneToMany(
            mappedBy = "animal",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Comment> comments = new ArrayList<>();


    public void addPrescribe(Prescribe prescribe){
        if (!this.prescribes.contains(prescribe)) {
            this.prescribes.add(prescribe);
            prescribe.setAnimal(this);
        }
    }


    public void removePrescribe(Prescribe prescribe){
        if (this.prescribes.contains(prescribe)) {
            this.prescribes.remove(prescribe);
            prescribe.setAnimal(null);
        }
    }

    public void addRequest(Request request){
        if (!this.requests.contains(request)) {
            this.requests.add(request);
            request.setAnimal(this);
        }
    }


    public void removeRequest(Request request){
        if (this.requests.contains(request)) {
            this.requests.remove(request);
            request.setAnimal(null);
        }
    }

    public void addReport(Report report){
        if (!this.reports.contains(report)) {
            this.reports.add(report);
            report.setAnimal(this);
        }
    }


    public void removeReport(Report report){
        if (this.reports.contains(report)) {
            this.reports.remove(report);
            report.setAnimal(null);
        }
    }

    public void addComment(Comment comment){
        if (!this.comments.contains(comment)) {
            this.comments.add(comment);
            comment.setAnimal(this);
        }
    }


    public void removeComment(Comment comment){
        if (this.comments.contains(comment)) {
            this.comments.remove(comment);
            comment.setAnimal(null);
        }
    }



}
