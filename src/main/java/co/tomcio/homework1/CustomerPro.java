package co.tomcio.homework1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("pro")
public class CustomerPro {
    @Value("${bonus}")
    double bonus;
    @Value("${vat}")
    double tax;
    double price = 0;

    ShopService shopService;

    @Autowired
    public CustomerPro(ShopService shopService) {
        this.shopService = shopService;
    }

    public double getSuma() {
        double priceAll = shopService.getPrice();
        double bonus = priceAll * this.bonus;
        priceAll += priceAll * tax;
        return priceAll - bonus;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showAll() {

        shopService.getProducts();
        System.out.println("Cena z vat i bonusem = " + String.format("%.2f", getSuma()));
    }
}
