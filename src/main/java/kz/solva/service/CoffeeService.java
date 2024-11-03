package kz.solva.service;

import kz.solva.entity.Coffee;
import kz.solva.payload.CreateNewCoffeeRecipeRequest;
import kz.solva.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private CoffeeIngredientService coffeeIngredientService;

    public List<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }

    public Coffee getCoffeeById(Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    public Coffee createNewCoffeeRecipe(CreateNewCoffeeRecipeRequest request) {
        Coffee coffee = new Coffee();
        coffee.setName(request.getCoffeeName());
        coffee = coffeeRepository.save(coffee);
        coffeeIngredientService.addNewIngredients(coffee, request);
        return coffee;
    }

}
