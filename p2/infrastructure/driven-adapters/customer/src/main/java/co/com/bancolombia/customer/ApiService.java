package co.com.bancolombia.customer;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ApiService implements CustomerRepository {

    @Override
    public Mono<Customer> getCustomer(String name) {
        //return Mono.just(Customer.builder().name(name).surname("Iturbide").build());
       return  Mono.defer( () -> Mono.just(Customer.builder().name(name).surname("Iturbide").build()));
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

    @Override
    public Flux<Customer> getCustomers() {

         Mono<Customer> mono1= Mono.just(Customer.builder()
                         .name("nombre1")
                         .surname("apellido1")
                         .build());

        Mono<Customer> mono2= Mono.just(Customer.builder()
                .name("nombre2")
                .surname("apellido2")
                .build());

        Mono<Customer> mono3= Mono.just(Customer.builder()
                .name("nombre3")
                .surname("apellido3")
                .build());

        Flux<Customer> res = Flux.merge (mono1, mono2, mono3);

        return res;
    }
}
