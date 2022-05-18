package co.com.bancolombia.api;
import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.usecase.customer.CustomerUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final CustomerUseCase useCase;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiRest.class);

    @GetMapping(path = "/path")
    public String commandName() {
        return "Hello World";
    }

    @GetMapping(path="/ping/{name}")
    public String ping (@PathVariable String name) {
        return useCase.ping(name);
    }

    @GetMapping(path = "/customer/{name}")
    public Customer getCustomer (@PathVariable String name) {
        return useCase.getCustomer(name);
    }

    @GetMapping(path ="/customer/{name}/{surname}")
    public Customer getLongName (@PathVariable String name, @PathVariable String surname) {
        Customer customer = useCase.getLong(name, surname);

        // Mapeo o lógica adicional o a través de algún helper
        customer.setName(customer.getName().toUpperCase());
        customer.setSurname(customer.getSurname().toUpperCase());

        return customer;
    }

    // Sería útil usar el método POST, para enviar en el JSON la petición
    @PostMapping("/customer-add")
    public boolean putCustomer (@RequestBody Customer customer) {
        String name = customer.getName();
        String surname = customer.getSurname();
        LOGGER.info("::: Mesaje ::: {} {}", name, surname);
        return useCase.addCustomer(name,surname);
    }
}
