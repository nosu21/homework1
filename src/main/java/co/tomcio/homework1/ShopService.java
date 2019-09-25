package co.tomcio.homework1;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ShopService {
   private List <Product> productList;
    double totalPrice = 0;
    Random rand = new Random();
    public ShopService() {
        productList = new ArrayList<>();
        productList.add( new Product("Jabłka", ThreadLocalRandom.current().nextDouble(50, 300)));
        productList.add( new Product("Gruszki", ThreadLocalRandom.current().nextDouble(50, 300)));
        productList.add( new Product("Banany", ThreadLocalRandom.current().nextDouble(50, 300)));
        productList.add( new Product("Pomarańcze", ThreadLocalRandom.current().nextDouble(50, 300)));
        productList.add( new Product("Piwko", ThreadLocalRandom.current().nextDouble(50, 300)));
    }
  //  @EventListener(ApplicationReadyEvent.class)
    public void  getProducts(){
        productList.forEach(System.out::println);
    }

   // @EventListener(ApplicationReadyEvent.class)
    public double  getPrice(){
        for (Product p : productList)
            totalPrice += p.getPrice();
        return totalPrice;
    }

    public double getTotalPrice() {
        getPrice();
        return totalPrice;
    }
}
