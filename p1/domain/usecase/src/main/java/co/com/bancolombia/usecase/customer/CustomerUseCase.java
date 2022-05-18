package co.com.bancolombia.usecase.customer;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerUseCase {
    // Servicio es adaptar, dentro del negocio
    private final CustomerRepository service;

    public Customer getCustomer (String name) {
        // Poner la lógica de negocio
        return service.getCustomer(name);
    }

    public Customer getLong (String name, String surname) {
        return service.getLongName (name, surname);
    }

    public String ping (String name) {
        return service.ping(name);
    }

    public boolean addCustomer (String name, String surname) {
        return service.addCustomer(name,surname);
    }

}
