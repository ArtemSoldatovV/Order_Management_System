package Order;

import MappingUtils.MappingUtils;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MappingUtils mappingUtils;

    public OrderService(OrderRepository orderRepository, MappingUtils mappingUtils) {
        this.orderRepository = orderRepository;
        this.mappingUtils = mappingUtils;
    }

    private Integer quantity = 10; // Если нужно, можно передавать это значение в методы

    public void makeOrder(List<OrderDTO> orders) {
        orders.forEach(order -> order.setQuantity(quantity));
    }

    public List<OrderDTO> findAll() {
        return orderRepository.findAll().stream()
                .map(mappingUtils::mapToOrderDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> findByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId).stream()
                .map(mappingUtils::mapToOrderDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = mappingUtils.mapToOrder(orderDTO);
        try {
            Order savedOrder = orderRepository.save(order);
            return mappingUtils.mapToOrderDTO(savedOrder);
        } catch (Exception e) {
            throw new RuntimeException("Error saving the order", e);
        }
    }

    public OrderDTO updateOrder(Long orderId, OrderDTO updatedOrderDTO) {

            updatedOrderDTO.setId(orderId);
            Order updatedOrder = mappingUtils.mapToOrder(updatedOrderDTO);
            try {
                Order savedOrder = orderRepository.save(updatedOrder);
                return mappingUtils.mapToOrderDTO(savedOrder);
            } catch (Exception e) {
                throw new RuntimeException("Error updating the order", e);}


    }

    public void deleteOrder(Long orderId) {

            orderRepository.deleteById(orderId);

    }

    public List<OrderDTO> findByStatus(String status) {
        return orderRepository.findByStatus(status).stream()
                .map(mappingUtils::mapToOrderDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> findByDate(LocalDate date) {
        return orderRepository.findByDate(date).stream()
                .map(mappingUtils::mapToOrderDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getAllOrders() {
        return findAll();
    }
}