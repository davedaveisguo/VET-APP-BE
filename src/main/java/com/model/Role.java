package com.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Role")
@Table(
        name = "role"
)
public class Role {
    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "role_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "role_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String roleName;


    @Column(
            name = "role_num",
            nullable = false
    )
    private int roleNum;

    @OneToMany(
            mappedBy = "role",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<User> users = new ArrayList<>();

    public void addUser(User user){
        if (!this.users.contains(user)) {
            this.users.add(user);
            user.setRole(this);
        }
    }


    public void removeUser(User user){
        if (this.users.contains(user)) {
            this.users.remove(user);
            user.setRole(null);
        }
    }

}
