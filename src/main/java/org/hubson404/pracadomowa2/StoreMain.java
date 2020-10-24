package org.hubson404.pracadomowa2;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreMain {

    private final StoreService storeService;

    @EventListener(ApplicationReadyEvent.class)
    public void run() {

        Product product1 = new Product("Trousers", 100);
        Product product2 = new Product("Jacket", 300);
        Product product3 = new Product("Shirt", 80);
        Product product4 = new Product("Belt", 100);
        Product product5 = new Product("Socks", 30);

        storeService.addProductToShoppingCart(product1);
        storeService.addProductToShoppingCart(product2);
        storeService.addProductToShoppingCart(product3);
        storeService.addProductToShoppingCart(product4);
        storeService.addProductToShoppingCart(product5);

        storeService.calculateTotal();

    }
}
