package co.com.bancolombia.customer;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ApiService implements CustomerRepository {

    @Override
    public Mono<Customer> getCustomer(String name) {
        return Mono.just(Customer.builder().name(name).surname("Iturbide").build());
    }

    @Override
    public Mono<Customer> getLongName(String name, String surname) {
        return Mono.just(
                Customer.builder()
                        .name(name)
                        .surname(surname)
                        .build()
        );
    }
}
