package kz.solva.dto;

import kz.solva.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderDTO {

    private Long id;
    private CoffeeDTO coffee;
    private Date createdAt;

    public static OrderDTO toDTO(Order order) {
        if (order == null) return null;
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setCreatedAt(order.getCreatedAt());
        dto.setCoffee(CoffeeDTO.toDTO(order.getCoffee()));
        return dto;
    }

    public static List<OrderDTO> toDTO(List<Order> orders) {
        List<OrderDTO> dtos = new ArrayList<>();
        for (Order order : orders) {
            dtos.add(OrderDTO.toDTO(order));
        }
        return dtos;
    }

}
