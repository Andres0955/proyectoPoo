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
        System.out.print("Ingrese el nombre del recepcionista o administrador: ");
        name = entrance.nextLine();

        return name;
    }

    public static int tableData(){
        int totalTables;
        System.out.print("Ingrese el numero de mesas totales del restaurante: ");
        totalTables = entrance.nextInt();

        return totalTables;
    }

    public int mainMenu(String name){
        byte selection;
        boolean check = false;

        System.out.println("Hola " + name + "!");

        do {
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║         SISTEMA DE RESERVAS          ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  1. Registrar reserva.               ║");
            System.out.println("║  2. Reservadas del dia.              ║");
            System.out.println("║  3. Cancelar reserva.                ║");
            System.out.println("║  4. Modificar reserva.               ║");
            System.out.println("║  5. Salir.                            ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Seleccione una opción: ");
            selection = entrance.nextByte();

            switch(selection){
                case 1:
                    check = true;
                    return selection;
                case 2:
                    check = true;
                    return selection;
                case 3:
                    check = true;
                    return selection;
                case 4:
                    check = true;
                    return selection;
                case 5:
                    check = true;
                    return selection;
                default:
                    System.out.println("✘ Opción no válida. Intente nuevamente.");
            }

        }while (check == false);

        return 0;
    }

    public void iguRegisterReservation(){
        Scanner entrance = new Scanner(System.in);
        String name;
        String phoneNumber;
        String hour;
        String date;
        int numPeople;
        Tables assignedTable;

        System.out.println("========================================");
        System.out.println("   REGISTRAR RESERVACION  ");
        System.out.println("========================================");
        System.out.println("Ingrese el nombre del cliente: ");
        name = entrance.nextLine();
        System.out.println("Ingrese el numero de telefono del cliente: ");
        phoneNumber = entrance.nextLine();
        customers.add(new Customer(name, phoneNumber));

        System.out.print("Ingrese la hora(h:m): ");
        hour = entrance.nextLine();
        System.out.print("Ingrese la date(a,m,d): ");
        date = entrance.nextLine();
        System.out.print("Ingrese el numero de personas: ");
        numPeople = entrance.nextInt();
        assignedTable = Restaurant.findFreeTable(numPeople);
        if(assignedTable != null){
            Reservation reservation = new Reservation(name, hour, date, assignedTable);
            System.out.println("========================================");
            System.out.println("   RESERVA CREADA EXITOSAMENTE ");
            System.out.print("========================================");
        }

    }
}
