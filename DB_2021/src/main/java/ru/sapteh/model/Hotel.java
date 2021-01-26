package ru.sapteh.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@Data
@Table(name = "hotel")
@Entity
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_hotel", length = 10, nullable = false)
    private String name;

    @Column(name = "maintenance",length = 10, nullable = false)
    private String maintenance;

    @OneToMany(mappedBy = "hotel")
    private Set<Putevka> putevka;
}
