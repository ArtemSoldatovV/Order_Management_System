package Product;

import java.util.List;

import Order.Order;
import jakarta.persistence.*;
//Продукты
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;
    public void setID(Long id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPrice(Double price){
        this.price=price;
    }
    public Long getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public Double getPrice(){
        return this.price;
    }
}