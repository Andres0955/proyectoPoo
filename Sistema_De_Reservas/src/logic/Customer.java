package logic;

import java.util.Vector;

/**
 * Representa un cliente en el sistema.
 * <p>
 * La clase {@code Customer} encapsula la información básica de un cliente, incluyendo
 * su nombre y número de teléfono. También mantiene una lista estática de todos los clientes
 * registrados en el sistema.
 * </p>
 */

public class Customer {

    /**
     * Nombre del cliente.
     */
    private String name;

    /**
     * Número de teléfono del cliente.
     */
    private String phoneNumber;

    /**
     * Lista estática de todos los clientes registrados en el sistema.
     * <p>
     * Esta lista se actualiza automáticamente cuando se crea un nuevo cliente,
     * añadiendo el cliente recién creado a la lista.
     * </p>
     */
    public static Vector<Customer> customers = new Vector<>();

    /**
     * Crea un nuevo cliente con el nombre y el número de teléfono especificados.
     * <p>
     * El cliente creado se añade automáticamente a la lista de clientes {@code customers}.
     * </p>
     *
     * @param name El nombre del cliente.
     * @param phoneNumber El número de teléfono del cliente.
     */
    public Customer(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        customers.add(this);
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente.
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica el nombre del cliente de un objeto Customer existente.
     * @param name nuevo nombre del cliente.
     */

    public void setName(String name){
        this.name = name;
    }

    /**
     * Modifica el numero de telefono del cliente de un objeto Customer existente.
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

}
