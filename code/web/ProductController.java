/** UPLOAD TO GITHUB */

package web;

import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    
    @RequestMapping("/product")
    String showProduct(Model model){
        model.addAttribute("brand", "iCoffee"); //${brand} will need to be added to html file to show the value 
        String[] products = {"Latte", "Mocha", "Expresso"};
        model.addAttribute("data", products);
            return "product";
    }
    
    //Example receive variable
    @RequestMapping("/cashier")
    String showCashier(Model model, String price, String input)  { //add string price to receive the variables
        model.addAttribute("brand", "iCoffee");     //brand name
        model.addAttribute("total", "...");         //receive variable from html
        try {
            double p = Double.valueOf(price);           //parse string to double
            model.addAttribute("total", p * 1.08); //business logic
        } catch (Exception e) { }

            
        return "cashier";
    }
    
    @RequestMapping("/search-product")
    String showSearch(Model model, String product)
    {
        String [] data = {"Latte", "Mocha", "Green Tea"};
        String result = "Not Available.";
        model.addAttribute("brand", "iCoffee");
        model.addAttribute("result", "...");
        if(product != null) {
            for (int i = 0; i < data.length; i++)
            {
                if(data[i].equals(product)) { result = "Available"; }
            }
            model.addAttribute("result", result);
        }

        return "search"; 
    }

}
