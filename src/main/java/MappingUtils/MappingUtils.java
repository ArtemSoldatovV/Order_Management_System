package MappingUtils;

import Customer.CustomerDTO;
import Order.OrderDTO;
import Order.Order;
import Customer.Customer;
import Product.Product;
import Product.ProductDTO;
import org.springframework.stereotype.Service;


@Service
public class MappingUtils {
    public ProductDTO mapToProductDTO(Product product){
        ProductDTO pDTO = new ProductDTO();
        pDTO.setId(product.getId());
        pDTO.setName(product.getName());
        pDTO.setPrice(product.getPrice());
        return pDTO;
    }
    public CustomerDTO mapToCustomerDTO(Customer customer){
        CustomerDTO cDTO = new CustomerDTO();
        cDTO.setId(customer.getId());
        cDTO.setName(customer.getName());
        return cDTO;
    }
    public OrderDTO mapToOrderDTO(Order order){
        OrderDTO oDTO = new OrderDTO();
        oDTO.setId(order.getId());
        return oDTO;
    }
    public Product mapToProduct(ProductDTO pDTO){
        Product product = new Product();
        product.setId(pDTO.getId());
        product.setName(pDTO.getName());
        product.setPrice(pDTO.getPrice());
        return product;
    }
    public Customer mapToCustomer(CustomerDTO cDTO){
        Customer customer = new Customer();
        customer.setId(cDTO.getId());
        customer.setName(cDTO.getName());
        return customer;
    }
    public Order mapToOrder(OrderDTO oDTO){
        Order order = new Order();
        order.setId(oDTO.getId());
        return order;
    }

}