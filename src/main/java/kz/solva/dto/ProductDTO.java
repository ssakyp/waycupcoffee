package kz.solva.dto;

import kz.solva.entity.Product;
import kz.solva.enums.IngredientName;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductDTO {

    private Long id;
    private IngredientName ingredientName;
    private String volumeType;
    private Integer unit;

    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setIngredientName(product.getIngredientName());
        productDTO.setVolumeType(product.getVolumeType().toString());
        productDTO.setUnit(product.getUnit());
        return productDTO;
    }

    public static List<ProductDTO> toDTO(List<Product> products) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            productDTOS.add(toDTO(product));
        }
        return productDTOS;
    }

}
