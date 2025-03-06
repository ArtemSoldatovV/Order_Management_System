package Order;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import Customer.Customer;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    @NotNull(message = "Id не может быть пустым")
    private Long Id;

    @NotNull(message = "customerId не может быть пустым")
    private Customer customerId;

    @NotEmpty(message = "Список productId не может быть пустым")
    private List<Long> productId;


    public void setId(Long orderId) {
        this.Id=orderId;
    }

    public void setCustomer(Customer customerId) {
        this.customerId=customerId;
    }
    public Long getId(){return this.Id;}
    public Customer getCustomer(){return this.customerId;}

    public void setQuantity(Integer quantity) {//решение от IntelliJ IDEA
    }
}
//enum OrderStatus {//решение от IntelliJ IDEA
//    DELIVERED,
//    CREATED,
//    CANCELED
//}
