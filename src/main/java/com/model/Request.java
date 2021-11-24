package com.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "request"
)
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id"
    )
    private int id;

    @Column(
            name = "status",
            nullable = false
    )
    private String status;

    @Column(
            name = "req_date",
            nullable = false
    )
    private LocalDate reqDate;

    @Column(
            name = "return_date",
            nullable = false
    )
    private LocalDate returnDate;


    @Column(
            name = "return_by",
            nullable = false
    )
    private String returnedUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_id_fk"
            )
    )
    private User user;


    @ManyToOne
    @JoinColumn(
            name = "animal_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "animal_request_fk"
            )
    )
    private Animal animal;


}
