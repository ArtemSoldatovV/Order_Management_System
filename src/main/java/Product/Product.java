package Product;

import java.util.List;

import Order.Order;
import jakarta.persistence.*;
import lombok.Data;
//Продукты
@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Double price;

//    @ManyToMany(mappedBy = "products")
//    private List<Order> orders;

    // Конструктор по умолчанию
    public Product() {
    }

    // Конструктор с параметрами
    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    // Геттеры и сеттеры
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    // Геттеры и сеттеры для списка orders
//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }
}