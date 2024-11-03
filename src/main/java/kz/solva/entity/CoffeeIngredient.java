package kz.solva.entity;

import jakarta.persistence.*;
import kz.solva.enums.IngredientName;
import lombok.Data;

@Entity
@Table(name = "coffee_ingredients")
@Data
public class CoffeeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ingredient_name")
    @Enumerated(EnumType.STRING)
    private IngredientName ingredientName;

    @Column(name = "unit")
    private Integer unit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coffee_id")
    private Coffee coffee;

}
