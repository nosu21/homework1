package co.tomcio.homework1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("plus")
public class CustomerPlus {
    @Value("${vat}")
    double tax;
    double price = 0;

    ShopService shopService;

    @Autowired
    public CustomerPlus(ShopService shopService) {
        this.shopService = shopService;
    }

    public double getSuma(){
        double temp = shopService.getPrice();
        temp += temp*tax;
        return temp;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showAll(){

        shopService.getProducts();
        System.out.println("Cena z vat = " + getSuma());
    }


}
