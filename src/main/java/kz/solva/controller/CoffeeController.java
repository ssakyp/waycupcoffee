package kz.solva.controller;

import kz.solva.dto.CoffeeDTO;
import kz.solva.payload.CreateNewCoffeeRecipeRequest;
import kz.solva.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/list")
    public List<CoffeeDTO> getAllCoffees() {
        return CoffeeDTO.toDTO(coffeeService.getAllCoffees());
    }

    @PostMapping("/new/recipe")
    public CoffeeDTO addNewRecipe(@RequestBody CreateNewCoffeeRecipeRequest request) {
        return CoffeeDTO.toDTO(coffeeService.createNewCoffeeRecipe(request));
    }

}
