package logic;

import igu.*;

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

    public void cancelReservation(){}

    public void modifyReservation(){}

    public void consultReservation(){}
}
