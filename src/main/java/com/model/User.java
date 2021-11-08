package com.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "user"
)
public class User implements Serializable {


    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;


    @Column(
            name = "phone",
            nullable = true

    )
    private String phone;


    @Column(
            name = "status",
            nullable = false
    )
    private String status;

    @Column(
            name = "dob",
            nullable = false
    )
    private LocalDate dob;


    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @ManyToOne
    @JoinColumn(
            name = "role_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_role_fk"
            )
    )
    private Role role;


    @OneToOne(
            mappedBy = "user",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private Request request;

    public void setRequest(Request request) {
        this.request = request;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(String lastName, String firstName, String phone, String status, LocalDate dob, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.status = status;
        this.dob = dob;
        this.email = email;
    }


}
