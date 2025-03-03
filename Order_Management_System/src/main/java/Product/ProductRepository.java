package Product;

import org.springframework.data.jpa.repository.JpaRepository;
//определяется интерфейс Spring Data repository для модели Customer.Customer
//тут в автоматическом порядке создаются: findAll, save и прочии
public interface ProductRepository extends JpaRepository<Product, Long> {

}