package Customer;

import Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
//определяется интерфейс Spring Data repository для модели Customer.Customer
//тут в автоматическом порядке создаются: findAll, save и прочии
//Customize Toolbar…
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}