public class CustomerService {

    private CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }
}