package Order;

import Customer.Customer;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import Product.Product;

//Заказ
@Entity
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "customer_id", nullable = false)
//    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @Enumerated(EnumType.STRING)

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    // Constructors, getters, and setters

    public Order() {
        this.creationDate = LocalDate.now(); // устанавливаем дату создания при создании заказа
    }

    public void setId(Long orderId) {
        this.id=orderId;
    }

}