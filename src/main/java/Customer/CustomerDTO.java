package Customer;

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
public class CustomerDTO {

    @NotNull(message = "Идентификатор (id) не может быть пустым")
    private Long id; // Изменено на id

    @NotNull(message = "Имя (name) не может быть пустым")
    private String name;

    @NotNull(message = "Список (ordersid) не может быть пустым") // Добавлено для проверки на null
    @NotEmpty(message = "Список ordersid не может быть пустым")
    private List<Order> ordersid;

    // Удалены геттеры и сеттеры, так как они генерируются Lombok

    // Удален пустой геттер для id
        public long getId(){
            return this.id; // Изменено на this.id
        }

//     Исправленный метод getName
        public String getName(){
            return this.name;
        }
}
