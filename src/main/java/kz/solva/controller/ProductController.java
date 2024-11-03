package kz.solva.controller;

import kz.solva.dto.ProductDTO;
import kz.solva.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/remaining")
    public List<ProductDTO> getRemainingProducts() {
        return ProductDTO.toDTO(productService.getRemainingProducts());
    }

    @PostMapping("/add/ingredients")
    public List<ProductDTO> addIngredients(@RequestBody List<ProductDTO> request) {
        return ProductDTO.toDTO(productService.addIngredients(request));
    }

}
