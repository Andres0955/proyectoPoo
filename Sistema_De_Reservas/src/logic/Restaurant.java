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
    private static int numTables;

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
        this.numTables = numTables;
        this.tables = new Vector<>(numTables);
        this.date = date;

        int[] capacities = {2, 4, 6};
        for (int i = 0; i < numTables; i++) {
            int capacity = capacities[i % 3];
            tables.add(new Tables(i + 1, capacity));
        }
    }

    /**
     * Busca una mesa libre que pueda acomodar al número de personas especificado.
     * <p>
     * Recorre la lista de mesas y devuelve el identificador de la primera mesa disponible
     * que tiene suficiente capacidad para el número de personas. Devuelve {@code 0} si no
     * hay ninguna mesa disponible que cumpla con los requisitos.
     * </p>
     *
     * @param numPeople El número de personas que deben ser acomodadas.
     * @return El identificador de una mesa libre que puede acomodar al número de personas especificado,
     *         o {@code 0} si no se encuentra ninguna mesa adecuada.
     */
    public static int findFreeTable(int numPeople){
        for(Tables tableI : tables)
            if (tableI.getCapacity() >= numPeople && tableI.getStatus() == true) {
                tableI.assignedTable();
                return tableI.getId();
            }
        return 0;
    }

    /**
     * Obtiene el número total de mesas en el restaurante.
     *
     * @return El número total de mesas en el restaurante.
     */
    public int getNumTables() {
        return numTables;
    }

    /**
     * Obtiene la fecha asociada al restaurante.
     *
     * @return La fecha asociada al restaurante.
     */
    public static String getDate(){
        return date;
    }

    /**
     * Permite obtener el vector desde otra clase para poder ser modificado.
     * @return El vector con las mesas creadas.
     */
    public static Vector<Tables> getTables() {
        return tables;
    }

}
