package logic;
import java.util.Vector;

/**
 * Representa un restaurante con una colección de mesas.
 * <p>
 * La clase {@code Restaurant} gestiona una colección de mesas y proporciona métodos
 * para encontrar mesas libres y obtener información sobre el número de mesas y la fecha
 * del restaurante.
 * </p>
 */

public class Restaurant {

    /**
     * Número total de mesas en el restaurante.
     */
    private int numTables;

    /**
     * Fecha asociada al restaurante (por ejemplo, fecha actual de la reserva).
     */
    private static String date;

    /**
     * Lista estática de mesas en el restaurante.
     * <p>
     * Esta lista se inicializa en el constructor y contiene todas las mesas del restaurante.
     * </p>
     */
    private static Vector<Tables> tables;

    /**
     * Crea una nueva instancia del restaurante con el número de mesas especificado y la fecha dada.
     * <p>
     * Inicializa la lista de mesas y crea mesas con capacidades rotativas (2, 4, 6 personas) usando
     * un vector. Cada mesa recibe un identificador único comenzando desde 1.
     * </p>
     *
     * @param numTables El número total de mesas en el restaurante.
     * @param date La fecha asociada al restaurante.
     */
    public Restaurant(int numTables, String date) {
        this.tables = new Vector<>(numTables);
        this.date = date;

        // Creando mesas rotando la capacidad (2, 4, 6 personas) usando vector
        int[] capacities = {2, 4, 6};
        for (int i = 0; i < numTables; i++) {
            int capacity = capacities[i % 3];
            tables.add(new Tables(i + 1, capacity));
        }
    }

    public static int findFreeTable(int numPeople){
        for(Tables tableI : tables)
            if (tableI.getCapacity() >= numPeople && tableI.getStatus() == true) {
                return tableI.getId();
            }
        return 0;
    }

    public int getNumTables() {
        return numTables;
    }

    public static String getDate(){
        return date;
    }

}
