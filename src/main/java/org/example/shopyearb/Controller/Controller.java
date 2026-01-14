package org.example.shopyearb.Controller;

import org.example.shopyearb.DataBase.DBManager;
import org.example.shopyearb.Entity.Category;
import org.example.shopyearb.Entity.Product;
import jakarta.annotation.PostConstruct;
import org.example.shopyearb.Entity.User;
import org.example.shopyearb.Response.BasicResponse;
import org.example.shopyearb.Utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {



    @Autowired
    private DBManager dbManager;

    @GetMapping("/get-categories")
    public List<Category> getCategories(){
        return this.dbManager.getAllCategories();
    }

    @GetMapping("/get-products-by-category-id")
    public List<Product> getProductByCategory(int categoryId){
      return this.dbManager.getProductsByCategoryId(categoryId);
    }

  @PostMapping("/add-product")
  public BasicResponse addProduct(@RequestBody Product product){ // שולח פרודאקט לפי בנאי דפולטיבי אם או לפני בנאי שבגדרנו ואז חייב בבקשה לצרך את כל השדות שבאותו בנאי
        // כששולחים בקשת פוסט זה מתחלק לחלק של הדר ובאדי - והפרודאקט שהשרת יקבל יהיה בחלק של הבאדי הבקשה ולכן שמים אנוטציה ריקווסט באדי. ככה אנחנו מכריחים אותו לקבל את הפרודאקט כבאדי.
      boolean successes = false;
      Integer errorCode = Constant.ERROR_ADD_PRODUCT;

      if (product!=null && product.getName()!=null && !product.getName().isEmpty()){ // חייב את התנאי האמצעי לפני האחרון כדי שהתכנית לא תקרוס - כי אם הפרודאקט לא נאל אבל השם שלו כן נאל ורוצים לבדוק אם השם ריק (תנאי שלישי כלומר אם שווה ל: "") - יקרוס לו לא הוקצאה לשם בכלל כתובת בזיכרון כי הוא נאל
            if (!this.dbManager.isProductExist(product.getName())){ // בדיקה לפי שם המוצר אם המותר כבר קיים. אם לא אז נכניס את המוצר לדאטה בייס
                if (this.dbManager.addProduct(product)){ // אם ההכנסה הצליחה (חזר טרו) אז יחזיר ריספונס true וארור קוד נאל (אחרת ההכנסה לא הצליחה וזה אומר שהמוצר כבר קיים - לפי הבדיקה במתודה שבאטה בייס)
                    successes = true;
                    errorCode = null;
                }
            }
        }
        return new BasicResponse(successes,errorCode); // תאורתית אפשר גם היה לעשות שיחזיר את הבאדי (הג׳ייסון) של מה שחזר כדי לראות מה הבעיה אבל יותר נוח ככה לדעת אביה אבל תכלס צריך לבחור לפי מה שיהיה נוח ללקוח ז״א מה שיהיה לו מובן
  }


























    @PostConstruct
    //הפונקציה תקרא אוטומטית שהתוכנית עולה בלי שנזמן אותה
    public void init(){

    }

    @RequestMapping("/say-hello")
    public String  sayHello(){
       return "Hello";
    }



    @PostMapping ("/register-user")
    public BasicResponse register(@RequestBody User user){
        boolean successes =  false;
        Integer errorCode = Constant.ERROR_REGISTER;
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
