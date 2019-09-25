package co.tomcio.homework1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("start")
public class CustomerStart {

    ShopService shopService;

    @Autowired
    public CustomerStart(ShopService shopService) {
        this.shopService = shopService;
    }

    public ShopService getShopService() {
        return shopService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showAll(){
        getShopService().getProducts();
        getShopService().getPrice();
    }

}
