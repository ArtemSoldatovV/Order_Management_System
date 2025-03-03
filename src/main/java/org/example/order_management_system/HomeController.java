package org.example.order_management_system;

import Customer.Customer;
import Customer.CustomerController;
import Customer.CustomerService;
import Order.OrderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    public CustomerController C_Controller = new CustomerController();

    //h1 - big h2 - small
    @RequestMapping("/")
    public String home() {
        long id_c =1;
        String htmlContent = "<html>\n" +
                "<head>\n" +
                "<title>Главная страница</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h3>"+ C_Controller.getCustomerById(id_c) +"</h3>\n" +
                "</body>\n" +
                "</html>";
        return htmlContent ;
        }
//    @RequestMapping("/text")
//    public String home_not() {
//            return htmlContent;
//        }
}