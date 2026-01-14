package org.example.shopyearb;

import org.example.shopyearb.Entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopYearBApplication {

    public static void main(String[] args) {
        // סתם בדיקה קשור לטעות לוגית שהייתה לאביה בקוד - להתעלם
        Product product = new Product(1,2.5,"aplle","red","hbdc");
        System.out.println(product.getName().isEmpty());
        SpringApplication.run(ShopYearBApplication.class, args);

    }


}
