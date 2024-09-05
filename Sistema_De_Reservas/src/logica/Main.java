package logica;
import igu.*;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Receptionist receptionist = new Receptionist();

        receptionist.setName(Interface.mainData1());
        restaurant.setNumTables(Interface.mainData2());


    }
}
