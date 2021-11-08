package com.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "comment"
)
public class Comment {

    @Id
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "comment_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "from_user",
            nullable = false
    )
    private String fromUser;

    @Column(
            name = "created_at",
            nullable = false
    )
    private LocalDate created;


    @Column(
            name = "content",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String content;

    @ManyToOne
    @JoinColumn(
            name = "animal_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "animal_comment_fk"
            )
    )
    private Animal animal;

    @ManyToOne
    @JoinColumn(
            name = "report_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "report_comment_fk"
            )
    )
    private Report report;
}


