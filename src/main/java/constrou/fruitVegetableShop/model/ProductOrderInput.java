package constrou.fruitVegetableShop.model;

import lombok.Data;

import java.util.Date;

@Data
public class ProductOrderInput {
    private String username;
    private Integer amount;
    private String product;
}
