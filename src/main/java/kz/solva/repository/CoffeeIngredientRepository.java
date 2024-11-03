package kz.solva.repository;

import kz.solva.entity.Coffee;
import kz.solva.entity.CoffeeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeIngredientRepository extends JpaRepository<CoffeeIngredient, Long> {

    List<CoffeeIngredient> findByCoffee(Coffee coffee);

}
