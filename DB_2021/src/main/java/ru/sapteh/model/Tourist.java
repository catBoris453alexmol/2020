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
@Table(name = "tourist")
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstname", length =  50 ,nullable = false)
    private String firstName;

    @Column(name = "name",length = 50, nullable = false)
    private String name;

    @Column (name = "patronomic", length = 50, nullable = false)
    private String patronomic;

    @Column(name = "passeries", length = 10, nullable = false)
    private int passeries;

    @Column(name = "numbseries",length = 10, nullable = false)
    private int numbseries;

    @OneToMany(mappedBy = "tourist")
    private Set<Putevka> putevka;



}
