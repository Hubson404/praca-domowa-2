package org.hubson404.pracadomowa2;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class StoreMain {

    private final StoreService storeService;

    @EventListener(ApplicationReadyEvent.class)
    public void run() {

        for (int i = 0; i < 5; i++) {
            storeService.addProductToShoppingCart(
                    new Product(
                            "product " + i,
                            (float) (50 + Math.random() * (300 - 50))
                    ));
        }
        storeService.calculateTotal();

    }
}
