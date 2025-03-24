package Customer;

import MappingUtils.MappingUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Customer.Customer;

import Order.Order;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MappingUtils mappingUtils;

    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream()
                .map(mappingUtils::mapToCustomerDTO)
                .collect(Collectors.toList());
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void makeCustomer(List<CustomerDTO> customers) {
        if (customers == null) {
            customers = new ArrayList<>();
        }

        customers.forEach(customer -> {
            Long generatedId = generateUniqueId(); // Замените на метод, генерирующий уникальный идентификатор
            String name = "Bob";  // Возможно, следует передавать как параметр
            List<Order> orders = List.of(); // Возможно, следует передавать как параметр

            customer.setId(generatedId);
            customer.setName(name);
            customer.setOrdersid(orders);
        });
        // save to repository if needed
    }


    @Transactional
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public Customer updateCustomer(String name, Long id, Customer updatedCustomer) {
        updatedCustomer.setName(name);
        return customerRepository.save(updatedCustomer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    // Пример метода для генерации уникального идентификатора
    private Long generateUniqueId() {
        // Логика для генерации уникального ID
        return System.currentTimeMillis(); // Пример (на самом деле нужно лучшая реализация)
    }
}