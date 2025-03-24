package Product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import Order.Order;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    @NotNull(message = "id не может быть пустым")
    private Long id;

    @NotNull(message = "name не может быть пустым")
    private String name;

    @NotNull(message = "price не может быть пустым")
    private Double price;

    @NotNull(message = "Список orderIds не может быть null")
    @NotEmpty(message = "Список orderIds не может быть пустым")
    private List<Order> orderIds; // Переименовано для лучшей читаемости
}
