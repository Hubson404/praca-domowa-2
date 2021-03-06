package org.hubson404.pracadomowa2;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Service
@Profile("Pro")
@ConfigurationProperties("store-properties")
public class StoreProService implements StoreService {

    private final List<Product> shoppingCart = new ArrayList<>();
    private double vat;
    private double discount;

    @Override
    public void addProductToShoppingCart(Product product) {
        shoppingCart.add(product);
    }

    @Override
    public void calculateTotal() {
        float total = 0f;

        for (Product product : shoppingCart) {
            total += product.getPrice();
        }

        System.out.printf("Your proStore total is: %.2f", total*(1+vat)*(1-discount));
    }
}
