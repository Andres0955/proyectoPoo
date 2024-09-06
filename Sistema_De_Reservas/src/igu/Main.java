package igu;
import logic.*;
import java.util.Vector;

public class Main {
    static Receptionist receptionist = new Receptionist();

    public static void main(String[] args) {

        Interface interface1 = new Interface();
        receptionist.setName(Interface.receptionistData());
        Restaurant restaurant = new Restaurant(Interface.tableData(), Interface.todayDate());
        System.out.println(restaurant.getDate());
        interface1.mainMenu(receptionist.getName());


    }

    public static void menuControl(int userChoice){

        switch(userChoice){
            case 1:
                receptionist.registerReservation();
                break;
            case 2:
                receptionist.consultReservationToday();
                break;
            case 3:
                receptionist.showAllReservations();
                break;
            case 4:
                receptionist.cancelReservation();
                break;
            case 5:



        }

    }
}
