package co.com.bancolombia.model.customer.gateways;

import co.com.bancolombia.model.customer.Customer;

public abstract interface CustomerRepository {

    // Interface publica
    public abstract Customer getCustomer (String name);
    Customer getLongName (String name, String surname);
    boolean addCustomer (String name, String surname);

    // Metodo
    String ping (String name);
}
