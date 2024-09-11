package logic;

import java.util.Vector;
/**
 * Representa una reserva en un sistema de gestión de mesas.
 * La clase almacena la información de una reserva, incluyendo el nombre del cliente, la hora y la fecha de la reserva,
 * así como la mesa asignada.
 */

public class Reservation {

    private static int idCounter = 0;
    private int idReservation;
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

    private int numPeople;
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

    public Reservation(String nameCustomer, String hour, String date, int assignedTable, int numPeople) {
        this.idReservation = ++idCounter;
        this.nameCustomer = nameCustomer;
        this.hour = hour;
        this.date = date;
        this.assignedTable = assignedTable;
        this.numPeople = numPeople;
        reservations.add(this);
    }

    public int getIdReservation(){
        return idReservation;
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
     *Establece el nuevo nombre del cliente.
     * @param nameCustomer Recibe el nuevo nombre del cliente.
     */

    public void setNameCustomer(String nameCustomer){
        this.nameCustomer = nameCustomer;
    }

    /**
     * Obtiene la mesa asignada para la reserva.
     *
     * @return La mesa asignada.
     */

    public int getAssignedTable() {
        return assignedTable;
    }

    /**
     * Obtiene la lista de reservas actuales.
     *
     * <p>Este método devuelve una referencia al vector que contiene todas las reservas actuales en el sistema.</p>
     *
     * @return Un {@code Vector} de objetos {@code Reservation} que representa todas las reservas.
     */
    public static Vector<Reservation> getReservations(){
        return reservations;
    }

    /**
     * Establece la mesa asignada para una reserva.
     *
     * <p>Este método asigna un número de mesa a la reserva actual. El número de mesa debe ser un valor válido
     * dentro del rango de mesas disponibles en el restaurante.</p>
     *
     * @param assignedTable El número de mesa a asignar. Debe ser un valor entero que represente una mesa válida.
     */
    public void setAssignedTable(int assignedTable){
        this.assignedTable = assignedTable;
    }

    /**
     * Obtiene el número de personas para la reserva.
     *
     * <p>Este método devuelve el número de personas para la reserva actual. El número de personas representa
     * la cantidad de personas que asistirán a la reserva.</p>
     *
     * @return Un entero que representa el número de personas en la reserva.
     */
    public int getNumPeople(){
        return numPeople;
    }

    /**
     * Establece el número de personas para la reserva.
     *
     * <p>Este método establece el número de personas para la reserva actual. El número de personas debe ser un valor entero
     * positivo que indica cuántas personas asistirán a la reserva.</p>
     *
     * @param numPeople El número de personas para la reserva. Debe ser un valor entero positivo.
     */
    public void setNumPeople(int numPeople){
        this.numPeople = numPeople;
    }

}
