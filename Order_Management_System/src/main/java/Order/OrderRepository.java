package Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;
//определяется интерфейс Spring Data repository для модели Customer.Customer
//тут в автоматическом порядке создаются: findAll, save и прочии
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
    List<Order> findByCustomerId(Long customerId);
    List<Order> findByStatus(String status);
    List<Order> findByDate(LocalDate date);
}