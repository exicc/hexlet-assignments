package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import exercise.model.Product;

import org.springframework.data.domain.Sort;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // BEGIN
    public List<Product> findByPriceBetweenOrderByPrice(int price, int price2);
    public List<Product> findByPriceGreaterThanOrderByPrice(int price);
    public List<Product> findByPriceLessThanOrderByPrice(int price);
    // END
}
