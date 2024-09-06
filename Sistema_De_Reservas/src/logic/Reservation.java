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
    private Tables assignedTable;
    /**
     * Lista estática de todas las reservas.
     * Se utiliza para gestionar y almacenar todas las reservas realizadas.
     */
    private static Vector<Reservation> reservations;

    public Reservation(String nameCustomer, String hour, String date, Tables assignedTable) {
        this.nameCustomer = nameCustomer;
        this.hour = hour;
        this.date = date;
        this.assignedTable = assignedTable;
        reservations.add(this);

    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Tables getAssignedTable() {
        return assignedTable;
    }

    public void setAssignedTable(Tables assignedTable){
        this.assignedTable = assignedTable;
    }

    public void confirmReservation() {}

    public void cancelReservation() {}

}
