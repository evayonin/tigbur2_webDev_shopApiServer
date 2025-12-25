package org.example.shopyearb.Controller;

import org.example.shopyearb.Entity.Product;
import jakarta.annotation.PostConstruct;
import org.example.shopyearb.Entity.User;
import org.example.shopyearb.Response.BasicResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {


    List<Product> productList = new ArrayList<>();



    @PostConstruct
    //הפונקציה תקרא אוטומטית שהתוכנית עולה בלי שנזמן אותה
    public void init(){
        this.productList.add(new Product(111,2.5,"apple", "RED"));
        this.productList.add(new Product(222,15.5,"banana", "YELLOW"));
        this.productList.add(new Product(333,14.5,"Book", "BLUE"));

        System.out.println(this.productList);
    }

    @RequestMapping("/say-hello")
    public String  sayHello(){
       return "Hello";
    }

    @GetMapping("/get-products")
    public List<Product> getProducts(){
        return this.productList;
    }

    @PostMapping ("/register-user")
    public BasicResponse register(User user){
        return new BasicResponse(true,1);
    }

}
