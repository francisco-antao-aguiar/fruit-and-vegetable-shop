package constrou.fruitVegetableShop.ShopController;

import constrou.fruitVegetableShop.entity.Product;
import constrou.fruitVegetableShop.entity.ProductOrder;
import constrou.fruitVegetableShop.model.ProductInput;
import constrou.fruitVegetableShop.model.ProductOrderInput;
import constrou.fruitVegetableShop.service.ProductOrderService;
import constrou.fruitVegetableShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductOrderService productOrderService;

    @GetMapping("products")
    public List<Product> getProducts() {
        return productService.findAllProducts();
    }

    @PostMapping("product")
    public String putProducts(@RequestBody ProductInput productInput) {
        productService.save(productInput);
        return "Added with success";
    }

    @GetMapping("orders")
    public List<ProductOrder> getOrders() {
        return productOrderService.findAllOrders();
    }

    @GetMapping("orders/{user}")
    public List<ProductOrder> getOrders(@PathVariable String user) {
        return productOrderService.findByUser(user);
    }

    @PostMapping("make-order")
    public String makeOrder(@RequestBody ProductOrderInput productOrderInput) {
        return productOrderService.save(productOrderInput);
    }
}
