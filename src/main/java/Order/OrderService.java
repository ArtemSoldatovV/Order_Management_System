package Order;

import Product.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MappingUtils mappingUtils;


    private Integer quantity = 10;
    public void makeOrder(List<OrderDTO> orders){
        orders.forEach(
                order->order.setQuantity(quantity)//решение от IntelliJ IDEA
        );
    }
    public List<OrderDTO> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(mappingUtils::mapToOrderDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> findByCustomerId(Long customerId) {
        List<Order> orders = orderRepository.findByCustomerId(customerId);//
        List<OrderDTO> orderDTO =orders.stream()
                .map(mappingUtils::mapToOrderDTO)
                .collect(Collectors.toList());
        return orderDTO;
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = mappingUtils.mapToOrder(orderDTO);
        Order savedOrder = orderRepository.save(order);
        return mappingUtils.mapToOrderDTO(savedOrder);
    }

    public OrderDTO updateOrder(Long orderId, OrderDTO updatedOrderDTO) {
        if (orderRepository.existsById(orderId)) {
            updatedOrderDTO.setId(orderId);
            Order updatedOrder = mappingUtils.mapToOrder(updatedOrderDTO);
            Order savedOrder = orderRepository.save(updatedOrder);
            return mappingUtils.mapToOrderDTO(savedOrder);
        } else {
            throw new RuntimeException("Order not found");
        }
    }

    public void deleteOrder(Long orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
        } else {
            throw new RuntimeException("Order not found");
        }
    }

    public List<OrderDTO> findByStatus(String status) {
        List<Order> orders = orderRepository.findByStatus(status);//
        List<OrderDTO> ordersDTO = orders.stream()
                .map(mappingUtils::mapToOrderDTO)
                .collect(Collectors.toList());
        return ordersDTO;
    }

    public List<OrderDTO> findByDate(LocalDate date) {
        List<Order> orders = orderRepository.findByDate(date);//
        List<OrderDTO> ordersDTO =orders.stream()
                .map(mappingUtils::mapToOrderDTO)
                .collect(Collectors.toList());
        return ordersDTO;
    }

    public List<OrderDTO> getAllOrders() {
        return findAll();
    }
}