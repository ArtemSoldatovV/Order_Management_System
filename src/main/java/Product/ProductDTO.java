package Product;

import Customer.Customer;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @NotNull(message = "Id не может быть пустым")
    private Long Id;

    @NotNull(message = "name не может быть пустым")
    private String name;

    @NotNull(message = "price не может быть пустым")
    private Double price;

    @NotEmpty(message = "Список ordersid не может быть пустым")
    private List<Long> ordersid;

    public void setQuantity(Integer quantity) {
    }
}
