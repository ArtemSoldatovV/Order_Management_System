package Customer;

import org.springframework.data.jpa.repository.JpaRepository;
//определяется интерфейс Spring Data repository для модели Customer.Customer
//тут в автоматическом порядке создаются: findAll, save и прочии
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}