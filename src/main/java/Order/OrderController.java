package Order;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody @Valid OrderDTO order) {
        OrderDTO newOrder = orderService.createOrder(order);
        return ResponseEntity.ok(newOrder);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderDTO>> getOrdersByCustomer(@PathVariable Long customerId) {
        List<OrderDTO> orders = orderService.findByCustomerId(customerId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<OrderDTO>> filterOrders(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) LocalDate date) {
        List<OrderDTO> orders;
        if (status != null) {
            orders = orderService.findByStatus(status);
        } else if (date != null) {
            orders = orderService.findByDate(date);
        } else {
            orders = orderService.getAllOrders();
        }
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody @Valid OrderDTO order) {
        OrderDTO updatedOrder = orderService.updateOrder(id, order);
        return ResponseEntity.ok(updatedOrder);
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//    }
}