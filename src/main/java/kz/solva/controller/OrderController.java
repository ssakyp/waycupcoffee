package kz.solva.controller;

import kz.solva.dto.CoffeeDTO;
import kz.solva.dto.OrderDTO;
import kz.solva.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{coffee_id}")
    public OrderDTO createOrder(@PathVariable(name = "coffee_id") Long coffeeId) {
        return OrderDTO.toDTO(orderService.createOrder(coffeeId));
    }

    @GetMapping("/list")
    public List<OrderDTO> getAllOrders() {
        return OrderDTO.toDTO(orderService.findAll());
    }

    @GetMapping("/popular/coffee")
    public CoffeeDTO getPopularCoffee() {
        return CoffeeDTO.toDTO(orderService.getPopularCoffee());
    }

}
