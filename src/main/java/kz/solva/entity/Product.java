package kz.solva.entity;

import jakarta.persistence.*;
import kz.solva.enums.IngredientName;
import kz.solva.enums.VolumeType;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ingredient_name")
    @Enumerated(EnumType.STRING)
    private IngredientName ingredientName;

    @Column(name = "volume_type")
    @Enumerated(EnumType.STRING)
    private VolumeType volumeType;

    @Column(name = "unit")
    private Integer unit;

}
