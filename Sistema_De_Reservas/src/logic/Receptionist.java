package logic;

import igu.*;

import java.util.Vector;

public class Receptionist {
    Interface interface2 = new Interface();
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name ) {
        this.name = name;
    }

    public void registerReservation(){
        interface2.iguRegisterReservation();
    }

    public void consultReservationToday(){
        interface2.iguConsultReservation(Reservation.getReservations(), Restaurant.getDate());
    }

    public void showAllReservations(){
        interface2.iguShowReservations(Reservation.getReservations());
    }

    public void cancelReservation(){
        interface2.igu
    }

    public void modifyReservation(){}
}
