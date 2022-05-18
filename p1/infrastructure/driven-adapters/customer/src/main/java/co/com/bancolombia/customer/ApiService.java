package co.com.bancolombia.customer;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService implements CustomerRepository {
    // 10 ... Integer.MAX_VALUE
    private final static List<Customer> lista = new ArrayList<>();  // Memoria

    @Override
    public Customer getCustomer(String name) {
        return Customer.builder().surname("Iturbide").name(name).build();
    }

    @Override
    public Customer getLongName(String name, String surname) {
        return Customer.builder().name(name).surname(surname).build();
    }

    @Override
    public boolean addCustomer(String name, String surname) {
        // Java es muy "verboso"
        Customer customer = Customer.builder().name(name).surname(surname).build();
        return lista.add(customer);
    }

    @Override
    public String ping(String name) {
        return "Hola " + name + "!!!!";
    }
}
