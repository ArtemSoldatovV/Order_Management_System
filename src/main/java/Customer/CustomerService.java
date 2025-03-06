package Customer;

import Product.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

@Autowired
private CustomerRepository customerRepository;
    @Autowired
    private MappingUtils mp;
    private String name = "Алёшин";
//    private String patr = "Алекссевич";
//    private String phoneNumber = "+75666789090";
    public void makeCustomer(List<CustomerDTO> customers){//изменить
        customers.forEach(
                customer->
                {
                    customer.setName(name);
                });
    }
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream().map(mp::mapToCustomerDTO).collect(Collectors.toList());
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(String name, Long id, Customer updatedCustomer) {
        if (customerRepository.existsById(id)) {
            updatedCustomer.setName(name);
            return customerRepository.save(updatedCustomer);
        } else {
            throw new RuntimeException("Customer not found!");
        }
    }

    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }
}