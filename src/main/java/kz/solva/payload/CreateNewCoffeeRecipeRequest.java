package kz.solva.payload;

import kz.solva.dto.CoffeeIngredientDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CreateNewCoffeeRecipeRequest {

    public String coffeeName;
    public List<CoffeeIngredientDTO> coffeeIngredients;

}
