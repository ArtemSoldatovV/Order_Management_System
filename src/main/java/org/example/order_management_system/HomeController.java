package org.example.order_management_system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    String stub = "";
//    Customer customer = new Customer(1L,"bob");
//    CustomerController c = new CustomerController();
//    CustomerService c = new CustomerService();
//

    //h1 - big h2 - small
    //сделать валидация
    //сделать бордор сервис

    @RequestMapping("/")
    public String Home() {
        String htmlContent = "<html>\n" +
                "<head>\n" +
                "<title>Главная страница</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h3>"+"Количество клиентов: "+"</h3>\n" +
                "<h3>"+"Количество заказов: "+"</h3>\n" +
                "<h3>"+"Общая сумма всех заказов: "+"</h3>\n" +
                "</body>\n" +
                "</html>";
        return htmlContent ;
    }
    @RequestMapping("/Client_management")
    public String Client_management() {
        String htmlContent = "<html>\n" +
                "<head>\n" +
                "<title>Главная страница</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h3>"+"Количество клиентов: "+"</h3>\n" +
                "<h3>"+"Количество заказов: "+"</h3>\n" +
                "<h3>"+"Общая сумма всех заказов: "+"</h3>\n" +
                "</body>\n" +
                "</html>";
        return htmlContent;
    }
    @RequestMapping("/Order_management")
    public String Order_management() {
        return stub;
    }
    @RequestMapping("/Product_management")
    public String Product_management() {
        return stub;
    }
}