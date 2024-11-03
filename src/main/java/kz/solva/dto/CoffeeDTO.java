package kz.solva.dto;

import kz.solva.entity.Coffee;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CoffeeDTO {

    private Long id;
    private String name;

    public static CoffeeDTO toDTO(Coffee coffee) {
        CoffeeDTO coffeeDTO = new CoffeeDTO();
        coffeeDTO.setId(coffee.getId());
        coffeeDTO.setName(coffee.getName());
        return coffeeDTO;
    }

    public static List<CoffeeDTO> toDTO(List<Coffee> coffees) {
        List<CoffeeDTO> coffeeDTOS = new ArrayList<>();
        for (Coffee coffee : coffees) {
            coffeeDTOS.add(CoffeeDTO.toDTO(coffee));
        }
        return coffeeDTOS;
    }

}
