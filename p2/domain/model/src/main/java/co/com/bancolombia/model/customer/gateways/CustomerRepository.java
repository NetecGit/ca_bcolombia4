package co.com.bancolombia.model.customer.gateways;

import co.com.bancolombia.model.customer.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository {
    Mono<Customer> getCustomer(String name);
    Mono<Customer> getLongName (String name, String surname);

    // Agregado para mostrar el uso de Flux
    Flux<Customer> getCustomers();


}
