package Customer;

import jakarta.persistence.*;

import java.util.List;

import Order.Order;

//класс Клиент

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @SuppressWarnings("unused")
    private String name;

    //тут реализовано множество заказов к одному клиенту
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;

    public void setId(Long id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }

    public long getId(){
        return this.id;
    }
    public String getName(){
         return this.name;
    }
}