package kz.solva.service;

import kz.solva.dto.ProductDTO;
import kz.solva.entity.Product;
import kz.solva.enums.IngredientName;
import kz.solva.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getRemainingProducts() {
        return productRepository.findAll();
    }

    public List<Product> addIngredients(List<ProductDTO> requests) {
        List<IngredientName> ingredientNames = new ArrayList<>();

        for (ProductDTO request : requests) {
            ingredientNames.add(request.getIngredientName());
        }

        List<Product> products = productRepository.findByIngredientNameIsIn(ingredientNames);
        Map<IngredientName, Product> productMap = new HashMap<>();

        for (Product product : products) {
            productMap.put(product.getIngredientName(), product);
        }
        for (ProductDTO request : requests) {
            if (productMap.containsKey(request.getIngredientName())) {
                Product product = productMap.get(request.getIngredientName());
                product.setUnit(product.getUnit() + request.getUnit());
                productMap.put(request.getIngredientName(), product);
            }
        }
        return productRepository.saveAll(productMap.values());
    }

    public List<Product> findByIngredient(List<IngredientName> ingredientNames) {
        return productRepository.findByIngredientNameIsIn(ingredientNames);
    }

    public List<Product> saveAll(List<Product> products) {
        return productRepository.saveAll(products);
    }

}
