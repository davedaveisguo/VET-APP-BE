package com.model;


import com.enums.MedType;
import com.enums.Sex;
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
        name = "prescribe"
)
public class Prescribe {
    @Id
    @SequenceGenerator(
            name = "prescribe_sequence",
            sequenceName = "prescribe_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "prescribe_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "diagnosis",
            nullable = false
    )
    private String diagnosis;

    @Column(
            name = "complete_by",
            nullable = false
    )
    private String completeBy;


    @Column(
            name = "created_at",
            nullable = false
    )
    private LocalDate created;

    @Column(name="type",nullable = false)
    @Enumerated(EnumType.STRING)
    private MedType type;

    @ManyToOne
    @JoinColumn(
            name = "animal_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "animal_prescribe_fk"
            )
    )
    private Animal animal;





}
