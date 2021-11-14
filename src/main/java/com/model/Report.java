package com.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "report"
)
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "completed_by",
            nullable = false
    )
    private String completedBy;

    @Column(
            name = "diease",
            nullable = false
    )
    private String diease;

    @Column(
            name = "created_at",
            nullable = false
    )
    private LocalDate created;

    @Column(
            name = "location",
            nullable = false
    )
    private String location;

    @ManyToOne
    @JoinColumn(
            name = "animal_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "animal_report_fk"
            )
    )
    private Animal animal;

    @OneToMany(
            mappedBy = "report",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment){
        if (!this.comments.contains(comment)) {
            this.comments.add(comment);
            comment.setReport(this);
        }
    }

    public void removeComment(Comment comment) {
        if (this.comments.contains(comment)) {
            this.comments.remove(comment);
            comment.setReport(null);
        }
    }



}
