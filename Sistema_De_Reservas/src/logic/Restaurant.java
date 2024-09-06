package logic;
import java.util.Vector;

public class Restaurant {
    private int numTables;
    private static Vector<Tables> tables;

    public Restaurant(int numTables) {
        this.tables = new Vector<>(numTables);

        // Creando mesas rotando la capacidad (2, 4, 6 personas) usando vector
        int[] capacities = {2, 4, 6};
        for (int i = 0; i < numTables; i++) {
            int capacity = capacities[i % 3];
            tables.add(new Tables(i + 1, capacity));
        }
    }

    public static Tables findFreeTable(int numPeople){
        for(Tables tableI : tables)
            if (tableI.getCapacity() >= numPeople && tableI.getStatus() == true) {
                return tableI;
            }
        return null;
    }

    public int getNumTables() {
        return numTables;
    }

}
