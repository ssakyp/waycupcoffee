package kz.solva.repository;

import kz.solva.entity.Product;
import kz.solva.enums.IngredientName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByIngredientNameIsIn(List<IngredientName> ingredientName);

}
