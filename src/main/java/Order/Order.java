package Order;

import Customer.Customer;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;


import Product.Product;
import lombok.Data;
//Заказ
@Entity
@Table(name="Orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
//    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "order_product",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
//    private List<Product> products;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    // Конструктор без параметров
    public Order() {
        this.creationDate = LocalDate.now(); // устанавливаем дату создания при создании заказа
    }

    // Геттеры и сеттеры
    public void setId(Long orderId) {
        this.id = orderId;
    }

    public void setCustomer(Customer customer) { // Переименовано
        this.customer = customer;
    }

    public Long getId() { // Переименовано
        return this.id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}