package igu;
import java.util.Scanner;
import java.util.Vector;

import logic.*;

public class Interface {
    static Scanner entrance = new Scanner(System.in);
    public Vector<Customer> customers;

    public void customers(){
        this.customers = new Vector<>(20);
    }

    public static String receptionistData(){
        String name;
        System.out.println("========================================");
        System.out.println("   Bienvenido al Sistema de Reservas   ");
        System.out.println("========================================");
        System.out.print("Ingrese el nombre del recepcionista: ");
        name = entrance.nextLine();

        return name;
    }


    public static int tableData(){
        int totalTables;
        System.out.print("Ingrese el numero de mesas totales del restaurante: ");
        totalTables = entrance.nextInt();

        return totalTables;
    }

    public static String todayDate(){
        String date;
        System.out.print("Ingrese la fecha de hoy(ejemplo: 04/07/2024): ");
        date = entrance.next();
        return date;
    }

    public void mainMenu(String name){
        byte selection;
        boolean check = false;

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
            System.out.println("║  6. Salir.                           ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Seleccione una opción: ");
            selection = entrance.nextByte();

            switch(selection){
                case 1:
                    Main.menuControl(selection);
                    break;
                case 2:
                    Main.menuControl(selection);
                    break;
                case 3:
                    Main.menuControl(selection);
                    break;
                case 4:
                    Main.menuControl(selection);
                    break;
                case 5:
                    check = true;
                    break;
                default:
                    System.out.println("✘ Opción no válida. Intente nuevamente.");
                    break;
            }

        }while (check == false);

    }

    public void iguRegisterReservation(){
        Scanner entrance = new Scanner(System.in);
        String name;
        String phoneNumber;
        String hour;
        String date;
        int numPeople;
        int assignedTable;

        System.out.println("========================================");
        System.out.println("   REGISTRAR RESERVACION  ");
        System.out.println("========================================");
        System.out.print("Ingrese el nombre del cliente: ");
        name = entrance.nextLine();
        System.out.print("Ingrese el numero de telefono del cliente: ");
        phoneNumber = entrance.nextLine();
        //customers.add(new Customer(name, phoneNumber));
        Customer customer = new Customer(name, phoneNumber);

        System.out.print("Ingrese la hora(ejemplo: 02:30 pm): ");
        hour = entrance.nextLine();
        System.out.print("Ingrese la fecha(ejemplo: 05/07/2024): ");
        date = entrance.nextLine();
        System.out.print("Ingrese el numero de personas: ");
        numPeople = entrance.nextInt();
        assignedTable = Restaurant.findFreeTable(numPeople);
        if(assignedTable != 0){
            Reservation reservation = new Reservation(name, hour, date, assignedTable);
            System.out.println("========================================");
            System.out.println("   RESERVA CREADA EXITOSAMENTE ");
            System.out.println("========================================");
        }else{
            System.out.println("============================================================");
            System.out.println("   NO HAY MESAS DISPONIBLES PARA ESE NUMERO DE PERSONAS ");
            System.out.println("============================================================");
        }


    }

    public void iguConsultReservation(Vector<Reservation> reservations, String date){
        boolean anyReservation = false;

        System.out.println("========================================");
        System.out.println("      RESERVAS PARA LA FECHA: " + date);
        System.out.println("========================================");

        for (Reservation reservationI : reservations) {
            // Comparamos la fecha de la reserva con la fecha dada
            if (reservationI.getDate().equals(date)) {
                System.out.println("----------------------------------------");
                System.out.println(" Cliente:     " + reservationI.getNameCustomer());
                System.out.println(" Hora:        " + reservationI.getHour());
                System.out.println(" Fecha:       " + reservationI.getDate());
                System.out.println(" Mesa Asignada: Mesa " + reservationI.getAssignedTable());
                System.out.println("----------------------------------------");
                anyReservation = true;
            }
        }

        if (anyReservation == false) {
            System.out.println(" No hay reservas para la fecha " + date);
        }

        System.out.println("========================================");
    }

    public void iguShowReservations(Vector<Reservation> reservations){
        boolean anyReservation = false;

        System.out.println("========================================");
        System.out.println("      TODAS LAS RESERVAS ACTIVAS: " );
        System.out.println("========================================");

        for (Reservation reservationI : reservations) {
                System.out.println("----------------------------------------");
                System.out.println(" Cliente:     " + reservationI.getNameCustomer());
                System.out.println(" Hora:        " + reservationI.getHour());
                System.out.println(" Fecha:       " + reservationI.getDate());
                System.out.println(" Mesa Asignada: Mesa " + reservationI.getAssignedTable());
                System.out.println("----------------------------------------");
                anyReservation = true;
        }

        if (anyReservation == false) {
            System.out.println(" No hay reservas. ");
        }

        System.out.println("========================================");
    }

}
