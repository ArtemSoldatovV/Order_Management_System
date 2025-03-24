package Order;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import Customer.Customer;
import Product.Product;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDTO {

    @NotNull(message = "Id не может быть пустым")
    private Long id; // изменено Id на id

    @NotNull(message = "Customer ID не может быть пустым")
    private Long customerId; // изменено с Customer на Long

    @NotEmpty(message = "Список productId не может быть пустым")
    private List<Product> productId;

    private Integer quantity; // добавлено поле quantity

    // Убраны кастомные геттеры и сеттеры для id и customerId
}
//enum OrderStatus {//решение от IntelliJ IDEA
//    DELIVERED,
//    CREATED,
//    CANCELED
//}
