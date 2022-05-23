package co.com.bancolombia.usecase.customer;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CustomerUseCase {
    private final CustomerRepository cs;

    public Mono<Customer> getCustomer (String name){

        return cs.getCustomer(name);
    }

    public Mono<Customer>  getLongName (String name, String surname) {

        return cs.getLongName(name, surname);
    }

    public Flux<Customer> getAllCustomers () {

        return cs.getCustomers();
    }

    public String getPing (String name, String surname) {

        return name + " " + surname;
    }

}
