package kz.solva.dto;

import kz.solva.entity.Coffee;
import kz.solva.entity.CoffeeIngredient;
import kz.solva.enums.IngredientName;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CoffeeIngredientDTO {

    private Long id;
    private IngredientName ingredientName;
    private Integer unit;

    public static CoffeeIngredientDTO toDTO(CoffeeIngredient coffeeIngredient) {
        CoffeeIngredientDTO coffeeIngredientDTO = new CoffeeIngredientDTO();
        coffeeIngredientDTO.setId(coffeeIngredient.getId());
        coffeeIngredientDTO.setIngredientName(coffeeIngredient.getIngredientName());
        coffeeIngredientDTO.setUnit(coffeeIngredient.getUnit());
        return coffeeIngredientDTO;
    }

    public static List<CoffeeIngredientDTO> toDTO(List<CoffeeIngredient> coffeeIngredients) {
        List<CoffeeIngredientDTO> coffeeIngredientDTOS = new ArrayList<>();
        for (CoffeeIngredient coffeeIngredient : coffeeIngredients) {
            coffeeIngredientDTOS.add(toDTO(coffeeIngredient));
        }
        return coffeeIngredientDTOS;
    }

}
