package ru.sapteh.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "tourOperator")
public class TourOperator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_operator", length = 10, nullable = false)
    private String name;

    @OneToMany(mappedBy = "tourOperator")
    private Set<Putevka> putevka;
}
