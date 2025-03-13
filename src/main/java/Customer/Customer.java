package Customer;

import jakarta.persistence.*;

import java.util.List;

import Order.Order;
import lombok.Data;
//класс Клиент

@Entity
@Table(name = "customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")  // Добавлено для определения соответствия с колонкой в БД
    private String name;

    // здесь реализовано множество заказов к одному клиенту
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Order> orders;

    // Конструктор без параметров
    public Customer() {}

    public Customer(Long id,String name) {
        this.id=id;
        this.name=name;
    }

    // Геттеры и сеттеры
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() { // Изменён тип возвращаемого значения на Long
        return this.id;
    }

    public String getName() {
        return this.name;
    }

//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }
}