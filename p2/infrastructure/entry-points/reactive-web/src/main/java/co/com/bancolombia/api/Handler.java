package co.com.bancolombia.api;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import co.com.bancolombia.usecase.customer.CustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final CustomerUseCase useCase;
    private static final Logger LOGGER = LoggerFactory.getLogger(Handler.class);

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        String name = serverRequest.pathVariable("name");
        Mono<Customer> mono = useCase.getCustomer(name);
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(mono,Customer.class);   // Programación funcional / notation fluent
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        String name = serverRequest.pathVariable("name");
        String surname = serverRequest.pathVariable("surname");
        LOGGER.info ("::: {} {} ::::", name, surname);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(useCase.getLongName(name, surname),Customer.class);   // Programación funcional / notation fluent
    }


    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // Webflux Spring
        return serverRequest
                .bodyToMono(Customer.class)
                .flatMap(cc -> Mono.just(useCase.getLongName(cc.getName(),cc.getSurname())))   // Expresión Lambda
                .flatMap(dd -> ServerResponse.ok()
                                             .contentType(MediaType.APPLICATION_JSON)
                                             .body(Mono.just(dd),Customer.class));
    }
}
