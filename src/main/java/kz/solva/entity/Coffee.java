package kz.solva.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "coffee")
@Data
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

}
