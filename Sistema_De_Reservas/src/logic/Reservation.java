package logic;

import java.util.Vector;
/**
 * Representa una reserva en un sistema de gestión de mesas.
 * La clase almacena la información de una reserva, incluyendo el nombre del cliente, la hora y la fecha de la reserva,
 * así como la mesa asignada.
 */

public class Reservation {
    /**
     * Nombre del cliente que hizo la reserva.
     */
    private String nameCustomer;
    /**
     * Hora de la reserva.
     */
    private String hour;
    /**
     * Fecha de la reserva.
     */
    private String date;
    /**
     * Mesa asignada a la reserva.
     */
    private int assignedTable;
    /**
     * Lista estática de todas las reservas.
     * Se utiliza para gestionar y almacenar todas las reservas realizadas.
     */
    private static Vector<Reservation> reservations = new Vector<>();

    /**
     * Crea una nueva reserva con la información proporcionada.
     *
     * @param nameCustomer El nombre del cliente que hace la reserva.
     * @param hour La hora de la reserva.
     * @param date La fecha de la reserva.
     * @param assignedTable La mesa asignada para la reserva.
     */

    public Reservation(String nameCustomer, String hour, String date, int assignedTable) {
        this.nameCustomer = nameCustomer;
        this.hour = hour;
        this.date = date;
        this.assignedTable = assignedTable;
        reservations.add(this);
        mostrarReservas();
    }
    /**
     * Obtiene la hora de la reserva.
     *
     * @return La hora de la reserva.
     */

    public String getHour() {
        return hour;
    }

    /**
     * Establece la hora de la reserva.
     *
     * @param hour La nueva hora de la reserva.
     */

    public void setHour(String hour) {
        this.hour = hour;
    }

    /**
     * Obtiene la fecha de la reserva.
     *
     * @return La fecha de la reserva.
     */

    public String getDate() {
        return date;
    }

    /**
     * Establece la fecha de la reserva.
     *
     * @param date La nueva fecha de la reserva.
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Obtiene el nombre del cliente.
     * @return El nombre del cliente como una cadena de texto.
     */

    public String getNameCustomer() {
        return nameCustomer;

    }

    /**
     * Obtiene la mesa asignada para la reserva.
     *
     * @return La mesa asignada.
     */

    public int getAssignedTable() {
        return assignedTable;
    }

    public static Vector<Reservation> getReservations(){
        return reservations;
    }


    /**
     * Confirma la reserva. Este método no está implementado en esta versión.
     */

    public void confirmReservation() {}

    /**
     * Cancela la reserva. Este método no está implementado en esta versión.
     */

    public void cancelReservation() {}

    /**
     * Muestra una lista de las reservas.
     */

    public static void mostrarReservas() {
        for (Reservation reserva : reservations) {
            System.out.println("Reserva: " + reserva.nameCustomer + ", Hora: " + reserva.hour +
                    ", Fecha: " + reserva.date + ", Mesa asignada: " + reserva.assignedTable);
        }

    }
}
