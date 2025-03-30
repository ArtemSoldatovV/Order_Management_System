package MappingUtils;

import Customer.CustomerDTO;
import Order.OrderDTO;
import Order.Order;
import Customer.Customer;
import Product.Product;
import Product.ProductDTO;
import Client.Client;
import Client.ClientDTO;
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
    public Product mapToProduct(ProductDTO pDTO){
        Product product = new Product();
        product.setId(pDTO.getId());
        product.setName(pDTO.getName());
        product.setPrice(pDTO.getPrice());
        return product;
    }
    public CustomerDTO mapToCustomerDTO(Customer customer){
        CustomerDTO cDTO = new CustomerDTO();
        cDTO.setId(customer.getId());
        cDTO.setName(customer.getName());
        return cDTO;
    }
    public Customer mapToCustomer(CustomerDTO cDTO){
        Customer customer = new Customer();
        customer.setId(cDTO.getId());
        customer.setName(cDTO.getName());
        return customer;
    }
    public OrderDTO mapToOrderDTO(Order order){
        OrderDTO oDTO = new OrderDTO();
        oDTO.setId(order.getId());
        return oDTO;
    }
    public Order mapToOrder(OrderDTO oDTO){
        Order order = new Order();
        order.setId(oDTO.getId());
        return order;
    }
    public ClientDTO mapToUserDTO(Client user){
        ClientDTO userDTO = new ClientDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setPatronymic(user.getPatronymic());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setRegistration_date(user.getRegistration_date());
        return userDTO;
    }
    public Client mapToUser(ClientDTO userDTO){
        Client user = new Client();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setPatronymic(userDTO.getPatronymic());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRegistration_date(userDTO.getRegistration_date());
        return user;
    }
}