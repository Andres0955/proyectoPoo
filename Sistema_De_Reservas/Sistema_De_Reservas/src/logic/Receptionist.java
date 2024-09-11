package logic;

import gui.*;

/**
 * Representa un recepcionista en el sistema de reservas del restaurante.
 * <p>
 * La clase {@code Receptionist} proporciona métodos para gestionar reservas a través
 * de una interfaz. Permite registrar, consultar, mostrar, cancelar y modificar reservas.
 * </p>
 */

public class Receptionist {

    /**
     * Instancia de la interfaz de usuario que proporciona métodos para gestionar reservas.
     */
    Interface interface2 = new Interface();

    /**
     * Nombre del recepcionista.
     */
    private String name;

    /**
     * Obtiene el nombre del recepcionista.
     *
     * @return El nombre del recepcionista.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del recepcionista.
     *
     * @param name El nuevo nombre del recepcionista.
     */
    public void setName(String name ) {
        this.name = name;
    }

    /**
     * Registra una nueva reserva utilizando la interfaz de usuario.
     * <p>
     * Este método llama al método {@code iguRegisterReservation} de la instancia de {@code Interface}
     * para permitir al recepcionista registrar una nueva reserva en el sistema.
     * </p>
     */
    public void registerReservation(){
        interface2.iguRegisterReservation();
    }

    /**
     * Consulta las reservas para el día actual.
     * <p>
     * Este método llama al método {@code iguConsultReservation} de la instancia de {@code Interface},
     * pasando la lista de reservas obtenidas desde la clase {@code Reservation} y la fecha actual
     * desde la clase {@code Restaurant}.
     * </p>
     */
    public void consultReservationToday(){
        interface2.iguConsultReservation(Reservation.getReservations(), Restaurant.getDate());
    }

    /**
     * Muestra todas las reservas registradas.
     * <p>
     * Este método llama al método {@code iguShowReservations} de la instancia de {@code Interface},
     * pasando la lista de reservas obtenidas desde la clase {@code Reservation}.
     * </p>
     */
    public void showAllReservations(){
        interface2.iguShowReservations(Reservation.getReservations());
    }

    /**
     * Cancela una reserva existente.
     * <p>
     * Este método llama al método {@code iguCancelReservation} de la instancia de {@code Interface},
     * pasando la lista de reservas obtenidas desde la clase {@code Reservation}.
     * </p>
     */
    public void cancelReservation(){
        interface2.iguCancelReservation(Reservation.getReservations());
    }

    /**
     * Modifica una reserva existente.
     * <p>
     * Este método llama al método {@code iguModifyReservation} de la instancia de {@code Interface},
     * pasando la lista de reservas obtenidas desde la clase {@code Reservation}.
     * </p>
     */

    public void modifyReservation(){
        interface2.iguModifyReservation(Reservation.getReservations());
    }
}
