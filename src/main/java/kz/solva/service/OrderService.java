package kz.solva.service;

import kz.solva.entity.Coffee;
import kz.solva.entity.CoffeeIngredient;
import kz.solva.entity.Order;
import kz.solva.entity.Product;
import kz.solva.enums.IngredientName;
import kz.solva.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CoffeeIngredientService coffeeIngredientService;
    @Autowired
    private CacheService cacheService;

    public Order createOrder(Long coffeeId) {
        if (!checkWorkingTime()) return null;
        Coffee coffee = coffeeService.getCoffeeById(coffeeId);
        if (Objects.isNull(coffee)) return null;
        List<CoffeeIngredient> coffeeIngredients = coffeeIngredientService.getByCoffee(coffee);
        List<Product> products = productService.findByIngredient(
                coffeeIngredients.stream().map(CoffeeIngredient::getIngredientName).toList()
        );
        if (!checkTheBalanceAndUpdate(products, coffeeIngredients)) return null;
        Order order = new Order();
        order.setCoffee(coffee);
        return orderRepository.save(order);
    }

    public Boolean checkTheBalanceAndUpdate(List<Product> products, List<CoffeeIngredient> coffeeIngredients) {
        Map<IngredientName, Product> productMap = new HashMap<>();
        for (Product product : products) {
            productMap.put(product.getIngredientName(), product);
        }
        for (CoffeeIngredient coffeeIngredient : coffeeIngredients) {
            if (!productMap.containsKey(coffeeIngredient.getIngredientName())) {
                return false;
            }
            Product product = productMap.get(coffeeIngredient.getIngredientName());
            if (coffeeIngredient.getUnit().compareTo(product.getUnit()) > 0) {
                return false;
            }
            product.setUnit(product.getUnit() - coffeeIngredient.getUnit());
        }
        productService.saveAll(productMap.values().stream().toList());
        return true;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Coffee getPopularCoffee() {
        List<Object[]> objects = orderRepository.findPopularCoffee();
        if (objects.isEmpty()) return null;
        Long coffeeId = (Long) objects.getFirst()[0];
        return coffeeService.getCoffeeById(coffeeId);
    }

    public Boolean checkWorkingTime() {
        LocalTime morningTime = LocalTime.of(8, 0);
        LocalTime eveningTime = LocalTime.of(17, 0);
        LocalTime now = LocalTime.now();
        if (now.isBefore(morningTime) || now.isAfter(eveningTime)) {
            return false;
        }
        Calendar today = Calendar.getInstance();
        if (today.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                || today.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return false;
        }
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(date);
        return !cacheService.parseHolidays().contains(formattedDate);
    }

}

