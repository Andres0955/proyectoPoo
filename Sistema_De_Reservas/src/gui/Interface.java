package gui;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;
import java.util.Iterator;

import logic.*;

/**
 * Proporciona una interfaz de usuario para gestionar reservas en el sistema.
 * <p>
 * La clase {@code Interface} contiene métodos para registrar, consultar, mostrar, cancelar
 * y modificar reservas. Utiliza la consola para interactuar con el usuario, y mantiene
 * una lista de clientes y una interfaz de usuario interactiva.
 * </p>
 */

public class Interface {
    static Scanner entrance = new Scanner(System.in);

    /**
     * Lista de clientes del sistema.
     * <p>
     * Inicialmente se crea un vector con capacidad para 20 clientes.
     * </p>
     */
    public Vector<Customer> customers;

    /**
     * Inicializa la lista de clientes con una capacidad inicial de 20.
     * <p>
     * Este método es utilizado para configurar la lista de clientes cuando se crea
     * una instancia de la interfaz.
     * </p>
     */
    public void customers(){
        this.customers = new Vector<>(20);
    }

    /**
     * Solicita al usuario el nombre del recepcionista.
     * <p>
     * Muestra un mensaje de bienvenida y solicita el nombre del recepcionista a través de la consola.
     * </p>
     *
     * @return El nombre ingresado por el recepcionista.
     */
    public static String receptionistData(){
        String name;
        System.out.println("========================================");
        System.out.println("   Bienvenido al Sistema de Reservas   ");
        System.out.println("========================================");
        System.out.print("Ingrese el nombre del recepcionista: ");
        name = entrance.nextLine();

        return name;
    }

    /**
     * Solicita al usuario el número total de mesas en el restaurante.
     *
     * @return El número total de mesas ingresado por el usuario.
     */
    public static int tableData(){
        int totalTables = 0;
        boolean check = false;

        while(check == false) {
            try {
                System.out.print("Ingrese el numero de mesas totales del restaurante: ");
                totalTables = entrance.nextInt();
                check = true;
            } catch (InputMismatchException e) {
                System.out.println("✘ Entrada no válida. Por favor, ingrese un número.");
                entrance.next();
                check = false;
            }
        }

        return totalTables;
    }

    /**
     * Muestra el menú principal de la aplicación y permite al usuario seleccionar una opción.
     * <p>
     * Dependiendo de la opción seleccionada, se llama a diferentes métodos para gestionar
     * reservas. El menú se muestra en un bucle hasta que el usuario elige salir.
     * </p>
     *
     * @param name El nombre del recepcionista que se muestra en el saludo.
     */
    public void mainMenu(String name){
        byte userChoice;
        boolean check = false;

        System.out.println("======================================================================\n");
        System.out.println("Hola " + name + "!");

        do {
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║         SISTEMA DE RESERVAS          ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  1. Registrar reserva.               ║");
            System.out.println("║  2. Mostrar reservas del dia.        ║");
            System.out.println("║  3. Mostrar todas reservada.         ║");
            System.out.println("║  4. Cancelar reserva.                ║");
            System.out.println("║  5. Modificar reserva.               ║");
            System.out.println("║  6. Mostrar mesas disponibles.       ║");
            System.out.println("║  7. Salir.                           ║");
            System.out.println("╚══════════════════════════════════════╝");

            try {
                System.out.print("Seleccione una opción: ");
                userChoice = entrance.nextByte();

                if (userChoice > 0 && userChoice <= 6) {
                    Main.menuControl(userChoice);
                } else if (userChoice == 7) {
                    check = true;
                } else {
                    System.out.println("✘ Opción no válida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("✘ opción no válida. Por favor, ingrese un número.");
                entrance.next();
            }


        }while (check == false);

    }

    /**
     * Registra una nueva reserva solicitando la información al usuario.
     * <p>
     * Recoge detalles como nombre del cliente, número de teléfono, hora, fecha, número de personas
     * y mesa asignada. Si hay una mesa disponible, se crea una reserva; de lo contrario, se informa
     * al usuario que no hay mesas disponibles.
     * </p>
     */
    public void iguRegisterReservation(){
        Scanner entrance = new Scanner(System.in);
        String name;
        String phoneNumber = "ERROR";
        String hour = "ERROR";
        String date = "ERROR";
        int numPeople = 0;
        int assignedTable;
        boolean checkPhone = false;
        boolean checkHour = false;
        boolean checkDate = false;
        boolean checkNumPeople = false;

        System.out.println("========================================");
        System.out.println("   REGISTRAR RESERVACION  ");
        System.out.println("========================================");
        System.out.print("Ingrese el nombre del cliente: ");
        name = entrance.nextLine();
        while(checkPhone == false){
            System.out.print("Ingrese el numero de telefono del cliente: ");
            phoneNumber = entrance.nextLine();
            if(phoneNumber.length() == 10){
                checkPhone = true;
            }else{
                System.out.println("✘ Ingrese un numero valido.");
            }
        }

        //customers.add(new Customer(name, phoneNumber));
        Customer customer = new Customer(name, phoneNumber);
        while(checkHour == false){
            System.out.print("Ingrese la hora(ejemplo: 02:30 pm): ");
            hour = entrance.nextLine();
            if(hour.length() == 8){
                checkHour = true;
            }else{
                System.out.println("✘ Ingrese una hora valida, como se muestra en el ejemplo.");
            }

        }

        while(checkDate == false){
            System.out.print("Ingrese la fecha(ejemplo: 2024-09-02): ");
            date = entrance.nextLine();
            if(date.length() == 10){
                checkDate = true;
            }else {
                System.out.println("✘ Ingrese una fecha valida, como se muestra en el ejemplo.");
            }
        }

        while (checkNumPeople == false){

            try {
                System.out.print("Ingrese el numero de personas: ");
                numPeople = entrance.nextInt();
                if (numPeople > 0){
                    checkNumPeople = true;
                }else {
                    System.out.println("✘ Ingrese un numero de personas valido.");
                    
                }
            }catch(InputMismatchException e){
                System.out.println("✘ Por favor ingrese un numero.");
                entrance.next();
            }
        }




        assignedTable = Restaurant.findFreeTable(numPeople);
        if(assignedTable != 0){
            Reservation reservation = new Reservation(name, hour, date, assignedTable, numPeople);
            System.out.println("========================================");
            System.out.println("   RESERVA CREADA EXITOSAMENTE ");
            System.out.println("========================================");
        }else{
            System.out.println("============================================================");
            System.out.println("   NO HAY MESAS DISPONIBLES PARA ESE NUMERO DE PERSONAS ");
            System.out.println("============================================================");
        }


    }

    /**
     * Consulta las reservas para una fecha específica.
     * <p>
     * Recorre la lista de reservas y muestra aquellas que coinciden con la fecha proporcionada.
     * Si no hay reservas para la fecha dada, se informa al usuario.
     * </p>
     *
     * @param reservations La lista de reservas a consultar.
     * @param date La fecha para la cual se desean consultar las reservas.
     */
    public void iguConsultReservation(Vector<Reservation> reservations, String date){
        boolean anyReservation = false;

        System.out.println("==============================================");
        System.out.println("   RESERVAS PARA EL DIA DE HOY: " + date);
        System.out.println("==============================================");

        for (Reservation reservationI : reservations) {
            if (reservationI.getDate().equals(date)) {
                System.out.println("----------------------------------------");
                System.out.println(" Id de la reserva:     " + reservationI.getIdReservation());
                System.out.println(" Cliente:     " + reservationI.getNameCustomer());
                System.out.println(" Hora:        " + reservationI.getHour());
                System.out.println(" Fecha:       " + reservationI.getDate());
                System.out.println(" Numero de personas:    " + reservationI.getNumPeople());
                System.out.println(" Mesa Asignada: Mesa " + reservationI.getAssignedTable());
                System.out.println("----------------------------------------");
                anyReservation = true;
            }
        }

        if (anyReservation == false) {
            System.out.println(" ✘ No hay reservas para la fecha " + date);
        }

        System.out.println("========================================");
    }

    /**
     * Muestra todas las reservas activas.
     * <p>
     * Recorre la lista de reservas y muestra cada una de ellas.
     * Si no hay reservas, se informa al usuario.
     * </p>
     *
     * @param reservations La lista de reservas a mostrar.
     */
    public void iguShowReservations(Vector<Reservation> reservations){
        boolean anyReservation = false;

        System.out.println("========================================");
        System.out.println("      TODAS LAS RESERVAS ACTIVAS: " );
        System.out.println("========================================");

        for (Reservation reservationI : reservations) {
                System.out.println("----------------------------------------");
            System.out.println(" Id de las reserva:     " + reservationI.getIdReservation());
                System.out.println(" Cliente:     " + reservationI.getNameCustomer());
                System.out.println(" Hora:        " + reservationI.getHour());
                System.out.println(" Fecha:       " + reservationI.getDate());
                System.out.println(" Numero de personas:    " + reservationI.getNumPeople());
                System.out.println(" Mesa Asignada: Mesa " + reservationI.getAssignedTable());
                System.out.println("----------------------------------------");
                anyReservation = true;
        }

        if (anyReservation == false) {
            System.out.println(" ✘ No hay reservas. ");
        }

        System.out.println("========================================");
    }

/**
 * Cancela una reserva existente.
 * <p>
 * Solicita al usuario el nombre del cliente, la fecha y la mesa asignada para la reserva
 * que desea cancelar. Busca la reserva en la lista y, si la encuentra, la elimina.
 * Si no se encuentra la reserva, se informa al usuario.
 * </p>
 *
 * @param reservations La lista de reservas donde se busca la reserva a cancelar.
 * */
    public void iguCancelReservation(Vector<Reservation> reservations){
        String name;
        int idReservation = 0;
        int assignedTable;
        boolean found = false;
        boolean checkId = false;
        Iterator<Reservation> iterator = reservations.iterator();
        Vector<Tables> modifyTables = Restaurant.getTables();
        Tables modifyTable;



        System.out.println("========================================");
        System.out.println("   CANCELAR RESERVACION  ");
        System.out.println("========================================");
        System.out.print("Ingrese el nombre del cliente: ");
        name = entrance.next();

        while (checkId == false){
            try{
                System.out.print("Ingrese el Id de la reserva: ");
                idReservation = entrance.nextInt();
                if(idReservation > 0){
                    checkId = true;
                }else {
                    System.out.println("✘ El id de la reserva es un numero mayor que 0.");
                }
            }catch(InputMismatchException e){
                System.out.println("✘ Ingrese un numero.");
                entrance.next();
            }

        }


        while(iterator.hasNext() == true) {
            Reservation reservationI = iterator.next();
            if (reservationI.getNameCustomer().equals(name) && reservationI.getIdReservation() == idReservation){
                assignedTable = reservationI.getAssignedTable();
                modifyTable = modifyTables.get(assignedTable-1);
                modifyTable.releaseTable();
                iterator.remove();
                found = true;
                System.out.println("========================================");
                System.out.println("   RESERVA CANCELADA EXITOSAMENTE ");
                System.out.println("========================================");
            }
        }

        if(found == false) {
            System.out.println("=================================================================");
            System.out.println("   NO SE ENCONTRO NINGUNA MESA CON LOS DATOS SUMINISTRADOS ");
            System.out.println("=================================================================");
        }

    }

    /**
     * Permite modificar una reserva ya existente en el sistema.
     * <p> Si la reserva no se encuentra, le informa al usuario que dicha reserva no existe.
     * @param reservations Una lista de reservas en el sistema, que se utilizará para buscar y modificar la reserva deseada.
     */
    public void iguModifyReservation(Vector<Reservation> reservations){
        String name;
        boolean found = false;
        boolean check = false;
        boolean checkId = false;
        int idReservation = 0;
        byte userChoice;
        String newPhoneNumber;

        System.out.print("Ingrese el nombre del cliente: ");
        name = entrance.next();

        while (checkId == false){
            try{
                System.out.print("Ingrese el Id de la reserva: ");
                idReservation = entrance.nextInt();
                if(idReservation > 0){
                    checkId = true;
                }else {
                    System.out.println("✘ El id de la reserva es un numero mayor que 0.");
                }
            }catch(InputMismatchException e){
                System.out.println("✘ Ingrese un numero.");
                entrance.next();
            }

        }

        for(Reservation reservationI : reservations){
            if(reservationI.getNameCustomer().equals(name) && reservationI.getIdReservation() == idReservation){
                do {
                    try {
                    System.out.println("╔══════════════════════════════════════╗");
                    System.out.println("║  ¿Que informacion desea modificar?   ║");
                    System.out.println("╠══════════════════════════════════════╣");
                    System.out.println("║  1. Nombre.                          ║");
                    System.out.println("║  2. Hora.                            ║");
                    System.out.println("║  3. Fecha.                           ║");
                    System.out.println("║  4. Numero de personas.              ║");
                    System.out.println("╚══════════════════════════════════════╝");
                    System.out.print("Seleccione una opción: ");
                    userChoice = entrance.nextByte();

                        switch (userChoice) {
                            case 1:
                                modifyName(reservationI);
                                check = true;
                                break;
                            case 2:
                                modifyHour(reservationI);
                                check = true;
                                break;
                            case 3:
                                modifyDate(reservationI);
                                check = true;
                                break;
                            case 4:
                                modifyNumPeople(reservationI);
                                check = true;
                                break;
                            default:
                                System.out.println("✘ Opción no válida. Intente nuevamente.");
                        }
                    }catch (InputMismatchException e) {
                        System.out.println("✘ opción no válida. Por favor, ingrese un número.");
                        entrance.next();
                    }

                }while(check == false);

                found = true;
                break;
            }
        }

        if(found == false){
            System.out.println("=================================================================");
            System.out.println("   NO SE ENCONTRO NINGUNA RESERVA CON LOS DATOS SUMINISTRADOS ");
            System.out.println("=================================================================");
        }
    }
    /**
     * Modifica el nombre del cliente en una reserva existente.
     *
     * Este método solicita al usuario que ingrese un nuevo nombre para el cliente,
     * lee la entrada del usuario y actualiza el nombre del cliente en el objeto
     * de reserva proporcionado.
     *
     * <p>El método realiza los siguientes pasos:</p>
     * <ol>
     *     <li>Solicita al usuario que ingrese el nuevo nombre del cliente.</li>
     *     <li>Lee la entrada del usuario.</li>
     *     <li>Actualiza el nombre del cliente en el objeto de reserva.</li>
     *     <li>Imprime un mensaje de confirmación indicando que la modificación se
     *         ha realizado exitosamente.</li>
     */
    public void modifyName(Reservation reservationI){
        System.out.print("Ingrese el nuevo nombre del cliente: ");
        entrance.nextLine();
        String newNameCustomer = entrance.nextLine();   
        reservationI.setNameCustomer(newNameCustomer);
        System.out.println("========================================");
        System.out.println("   MODIFICACION REALIZADA EXITOSAMENTE ");
        System.out.println("========================================");
    }
    /**
     * Modifica la hora en una reserva existente.
     *
     * Este método solicita al usuario que ingrese una nueva hora para la reserva,
     * lee la entrada del usuario y actualiza la hora en el objeto de reserva
     * proporcionado.
     *
     * <p>El método realiza los siguientes pasos:</p>
     * <ol>
     *     <li>Solicita al usuario que ingrese la nueva hora.</li>
     *     <li>Lee la entrada del usuario.</li>
     *     <li>Actualiza la hora en el objeto de reserva.</li>
     *     <li>Imprime un mensaje de confirmación indicando que la modificación se
     *         ha realizado exitosamente.</li>
     * </ol>
     **/
    public void modifyHour(Reservation reservationI){
        System.out.print("Ingrese la nueva hora: ");
        entrance.nextLine();
        String newHour = entrance.nextLine();
        reservationI.setHour(newHour);
        System.out.println("========================================");
        System.out.println("   MODIFICACION REALIZADA EXITOSAMENTE ");
        System.out.println("========================================");
    }
    /**
     * Modifica la fecha en una reserva existente.
     *
     * Este método solicita al usuario que ingrese una nueva fecha para la reserva,
     * lee la entrada del usuario y actualiza la fecha en el objeto de reserva
     * proporcionado. La fecha debe ser ingresada en el formato "aaaa-mm-dd".
     *
     * <p>El método realiza los siguientes pasos:</p>
     * <ol>
     *     <li>Solicita al usuario que ingrese la nueva fecha en el formato "aaaa-mm-dd".</li>
     *     <li>Lee la entrada del usuario.</li>
     *     <li>Actualiza la fecha en el objeto de reserva.</li>
     *     <li>Imprime un mensaje de confirmación indicando que la modificación se
     *         ha realizado exitosamente.</li>
     * </ol>
     */
    public void modifyDate(Reservation reservationI){
        System.out.print("Ingrese la nueva fecha(ejemplo: 2024-09-02): ");
        entrance.nextLine();
        String newDate = entrance.nextLine();
        reservationI.setDate(newDate);
        System.out.println("========================================");
        System.out.println("   MODIFICACION REALIZADA EXITOSAMENTE ");
        System.out.println("========================================");
    }
    /**
     * Modifica el número de personas en una reserva existente y ajusta la mesa asignada si es necesario.
     *
     * Este método solicita al usuario que ingrese un nuevo número de personas para la reserva,
     * y actualiza el número de personas en el objeto de reserva. Si el nuevo número de personas
     * es mayor que el número actual, se realiza una reasignación de mesa:
     * <ul>
     *     <li>Libera la mesa actualmente asignada.</li>
     *     <li>Busca una nueva mesa adecuada para el nuevo número de personas.</li>
     *     <li>Actualiza la mesa asignada en la reserva.</li>
     * </ul>
     *
     * <p>El método realiza los siguientes pasos:</p>
     * <ol>
     *     <li>Solicita al usuario que ingrese el nuevo número de personas.</li>
     *     <li>Compara el nuevo número de personas con el número actual.</li>
     *     <li>Si el nuevo número de personas es mayor, libera la mesa asignada y busca una nueva mesa adecuada.</li>
     *     <li>Actualiza el número de personas y la mesa asignada en el objeto de reserva.</li>
     *     <li>Imprime un mensaje de confirmación indicando que la modificación se
     *         ha realizado exitosamente.</li>
     * </ol>
     */
    public void modifyNumPeople(Reservation reservationI){
        Vector<Tables> modifyTables = Restaurant.getTables();
        int assignedTable = reservationI.getAssignedTable();

        System.out.print("Ingrese el numero de personas: ");
        int newNumPeople = entrance.nextInt();
        if (reservationI.getNumPeople() > newNumPeople) {
            reservationI.setNumPeople(newNumPeople);
            Tables modifyTable = modifyTables.get(assignedTable-1);
            modifyTable.releaseTable();
            int newAssignedTable = Restaurant.findFreeTable(newNumPeople);
            reservationI.setAssignedTable(newAssignedTable);
        }
        reservationI.setNumPeople(newNumPeople);
        System.out.println("========================================");
        System.out.println("   MODIFICACION REALIZADA EXITOSAMENTE ");
        System.out.println("========================================");
    }
    /**
     * Muestra en la consola una lista de mesas libres a partir de una lista de mesas proporcionada.
     *
     * Este método recorre una colección de objetos {@code Tables} y muestra la información de cada mesa
     * que tiene el estado libre (representado por {@code true}). La información que se imprime incluye el ID
     * y la capacidad de la mesa.
     *
     * El formato de la salida en la consola es el siguiente:
     *
     * ----------------------------------------
     *  Id de la mesa:     [ID de la mesa]
     *  Capacidad de la mesa:     [Capacidad de la mesa]
     * ----------------------------------------
     *
     * @param tables Una colección de objetos {@code Tables} que representa todas las mesas disponibles.
     *               Cada objeto de la colección debe tener un método {@code getStatus()} que devuelve un
     *               valor booleano que indica si la mesa está libre, y métodos {@code getId()} y
     *               {@code getCapacity()} para obtener el ID y la capacidad de la mesa, respectivamente.
     *
     * @see Tables
     */
    public void iguShowFreeTables(Vector<Tables> tables) {
        for(Tables tableI : tables){
            if(tableI.getStatus() == true){
                System.out.println("----------------------------------------");
                System.out.println(" Id de la mesa:     " + tableI.getId());
                System.out.println(" Capacidad de la mesa:     " + tableI.getCapacity());

                System.out.println("----------------------------------------");
            }
        }
    }
}
