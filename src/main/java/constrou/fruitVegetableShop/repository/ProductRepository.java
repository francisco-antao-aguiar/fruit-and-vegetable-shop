package constrou.fruitVegetableShop.repository;

import constrou.fruitVegetableShop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String>{
}
