package igu;
import logic.*;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        int selectionMenu;

        Receptionist receptionist = new Receptionist();
        Interface interface1 = new Interface();
        receptionist.setName(Interface.receptionistData());
        Restaurant restaurant = new Restaurant(Interface.tableData());
        selectionMenu = interface1.mainMenu(receptionist.getName());


        switch(selectionMenu){
            case 1:
                receptionist.registerReservation();
            break;
        }


    }
}
