package kz.solva.repository;

import kz.solva.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select coffee_id, count(coffee_id) as count from orders " +
            "group by coffee_id " +
            "order by count desc " +
            "limit 1",
            nativeQuery = true
    )
    List<Object[]> findPopularCoffee();
}
