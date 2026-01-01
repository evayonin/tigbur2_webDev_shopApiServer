package org.example.shopyearb.Controller;

import org.example.shopyearb.DataBase.DBManager;
import org.example.shopyearb.Entity.Product;
import jakarta.annotation.PostConstruct;
import org.example.shopyearb.Entity.User;
import org.example.shopyearb.Response.BasicResponse;
import org.example.shopyearb.Utils.Construct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {


    private List<Product> productList = new ArrayList<>();

    @Autowired
    private DBManager dbManager;


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
    public BasicResponse register(@RequestBody User user){
        boolean successes =  false;
        Integer errorCode = Construct.ERROR_REGISTER;
     if (user!=null){
         User dbUser = this.dbManager.getUserByUsername(user.getName());
         if (dbUser == null){
             this.dbManager.insertUser(user);
             successes = true;
             errorCode = null;
         }
     }
      return new BasicResponse(successes,errorCode);
    }

}
