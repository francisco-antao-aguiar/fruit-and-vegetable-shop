package constrou.fruitVegetableShop.service;

import constrou.fruitVegetableShop.entity.Product;
import constrou.fruitVegetableShop.entity.ProductOrder;
import constrou.fruitVegetableShop.model.ProductOrderInput;
import constrou.fruitVegetableShop.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductOrderService {
    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private ProductService productService;

    public List<ProductOrder> findAllOrders() {
        return productOrderRepository.findAll();
    }

    public List<ProductOrder> findByUser(String user) {
        return productOrderRepository.findByUsername(user);
    }

    public String save(ProductOrderInput productOrderInput) {
        Product product = productService.findByName(productOrderInput.getProduct());
        if(product == null){
            return "The product " + productOrderInput.getProduct() + " does not exist";
        }
        ProductOrder productOrder = new ProductOrder();
        productOrder.setDate(new Date());;
        productOrder.setUsername(productOrderInput.getUsername());
        productOrder.setProduct(productOrderInput.getProduct());
        productOrder.setAmount(productOrderInput.getAmount());

        productOrderRepository.save(productOrder);
        return "Order added with success";
    }
}
