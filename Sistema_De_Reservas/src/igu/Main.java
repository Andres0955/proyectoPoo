package igu;
import logic.*;
import java.util.Vector;

public class Main {

    /** Objeto {@code Receptionist} para gestionar reservas. */
    static Receptionist receptionist = new Receptionist();

    /**
     * Método principal de la aplicación.
     * Inicializa el objeto {@code Receptionist} con los datos obtenidos de la interfaz,
     * crea una instancia de {@code Restaurant} y muestra la fecha actual del restaurante.
     * Luego, llama al menú principal de la interfaz para que el usuario seleccione una opción
     */
    public static void main(String[] args) {

        Interface interface1 = new Interface();
        receptionist.setName(Interface.receptionistData());
        Restaurant restaurant = new Restaurant(Interface.tableData(), Interface.todayDate());
        System.out.println(restaurant.getDate());
        interface1.mainMenu(receptionist.getName());


    }

    /**
     * Controla el menú basado en la opción seleccionada por el usuario.
     *
     * <p>Este método delega la acción adecuada al objeto {@code Receptionist} en función
     * de la opción seleccionada:</p>
     * <ul>
     *   <li>Opción 1: Llama a {@code receptionist.registerReservation()} para registrar una nueva reserva.</li>
     *   <li>Opción 2: Llama a {@code receptionist.consultReservationToday()} para consultar las reservas del día.</li>
     *   <li>Opción 3: Llama a {@code receptionist.showAllReservations()} para mostrar todas las reservas.</li>
     *   <li>Opción 4: Llama a {@code receptionist.cancelReservation()} para cancelar una reserva.</li>
     *   <li>Opción 5: Llama a {@code receptionist.modifyReservation()} para modificar una reserva existente.</li>
     * </ul>
     *
     * @param userChoice La opción seleccionada por el usuario en el menú.
     */
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
                receptionist.modifyReservation();
                break;
        }

    }
}
