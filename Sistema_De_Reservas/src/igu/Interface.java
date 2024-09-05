package igu;
import java.util.Scanner;
import logica.Receptionist;

public class Interface {
    static Scanner entrance = new Scanner(System.in);

    public static String mainData1(){
        String name;
        System.out.println("==================================");
        System.out.println("   Bienvenido al Sistema de Reservas   ");
        System.out.println("==================================");
        System.out.println("Ingrese el nombre del recepcionista o administrador: ");
        name = entrance.nextLine();

        return name;
    }

    public static int mainData2(){
        int totalTables;
        System.out.println("Ingrese el numero de mesas totales del restaurante: ");
        totalTables = entrance.nextInt();

        return totalTables;
    }

    public void mainMenu(String name){
        byte selection;

        System.out.println("Hola " + name + "!");

        do {
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║         SISTEMA DE RESERVAS          ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  1. Registrar reserva                ║");
            System.out.println("║  2. Ver mesas reservadas             ║");
            System.out.println("║  3. Cancelar reserva                 ║");
            System.out.println("║  4. Modificar reserva                ║");
            System.out.println("║  5. Salir                            ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Seleccione una opción: ");
            selection = entrance.nextByte();

            switch(selection){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("✘ Opción no válida. Intente nuevamente.");
            }

        }while (selection != 5);

    }
}
