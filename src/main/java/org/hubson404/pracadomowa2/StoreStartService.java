package org.hubson404.pracadomowa2;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("!Plus&&!Pro")
public class StoreStartService implements StoreService {

    private final List<Product> shoppingCart = new ArrayList<>();

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

        System.out.printf("Your startStore total is: %.2f", total);
    }
}
