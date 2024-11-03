package kz.solva.service;

import kz.solva.dto.CoffeeIngredientDTO;
import kz.solva.entity.Coffee;
import kz.solva.entity.CoffeeIngredient;
import kz.solva.payload.CreateNewCoffeeRecipeRequest;
import kz.solva.repository.CoffeeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeIngredientService {

    @Autowired
    private CoffeeIngredientRepository coffeeIngredientRepository;

    public List<CoffeeIngredient> getByCoffee(Coffee coffee) {
        return coffeeIngredientRepository.findByCoffee(coffee);
    }

    public List<CoffeeIngredient> addNewIngredients(Coffee coffee, CreateNewCoffeeRecipeRequest request) {
        List<CoffeeIngredient> ingredients = new ArrayList<>();
        for (CoffeeIngredientDTO dto : request.getCoffeeIngredients()) {
            CoffeeIngredient ingredient = new CoffeeIngredient();
            ingredient.setCoffee(coffee);
            ingredient.setIngredientName(dto.getIngredientName());
            ingredient.setUnit(dto.getUnit());
            ingredients.add(ingredient);
        }
        return coffeeIngredientRepository.saveAll(ingredients);
    }

}
