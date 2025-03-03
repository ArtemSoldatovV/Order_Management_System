package Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    //возвращает список всех сущностей
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    //возвращает сущност по id
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
    //добавить клиента
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    //изменение клиента
    public Customer updateCustomer(String name, Long id, Customer updatedCustomer) {
        if (customerRepository.existsById(id)) {
            updatedCustomer.setName(name);
            return customerRepository.save(updatedCustomer);
        } else {
            throw new RuntimeException("Customer.Customer not found!");
        }
    }
    //удаление клиента
    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Customer.Customer not found with id: " + id);
        }
    }
}