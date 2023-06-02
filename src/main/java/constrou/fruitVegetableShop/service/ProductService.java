package constrou.fruitVegetableShop.service;

import constrou.fruitVegetableShop.entity.Product;
import constrou.fruitVegetableShop.model.ProductInput;
import constrou.fruitVegetableShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public void save(ProductInput productInput) {
        Product product = new Product();
        product.setName(productInput.getName());
        product.setPrice(productInput.getPrice());

        productRepository.save(product);
    }

    public Product findByName(String name){
        return productRepository.findById(name).orElse(null);
    }
}
