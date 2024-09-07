package logic;

/**
 * Representa una mesa en un sistema de reservas.
 * <p>
 * La clase {@code Tables} encapsula los detalles de una mesa, incluyendo su identificador,
 * capacidad y estado (asignada o libre). Proporciona métodos para obtener y modificar
 * estos valores, así como para asignar o liberar la mesa.
 * </p>
 */

public class Tables {
    //Si la mesa esta libre el valor que tendra el atributo status es true, de lo contrario tendra un false.
    /**
     * Identificador único de la mesa.
     */
    private int id;

    /**
     * Capacidad máxima de la mesa (número de personas que puede acomodar).
     */
    private int capacity;

    /**
     * Estado de la mesa. {@code true} si la mesa está asignada, {@code false} si está libre.
     */
    private boolean status;

    /**
     * Crea una nueva mesa con el identificador y la capacidad especificados.
     * <p>
     * Inicialmente, la mesa está disponible para ser asignada (estado {@code true}).
     * </p>
     *
     * @param id El identificador único de la mesa.
     * @param capacity La capacidad máxima de la mesa.
     */
    public Tables(int id, int capacity){
        this.id = id;
        this.capacity = capacity;
        this.status = true;
    }

    /**
     * Obtiene el identificador de la mesa.
     *
     * @return El identificador de la mesa.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la mesa.
     *
     * @param id El nuevo identificador de la mesa.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la capacidad máxima de la mesa.
     *
     * @return La capacidad máxima de la mesa.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Establece la capacidad máxima de la mesa.
     *
     * @param capacity La nueva capacidad máxima de la mesa.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Obtiene el estado actual de la mesa.
     * <p>
     * Devuelve {@code true} si la mesa está asignada, {@code false} si está libre.
     * </p>
     *
     * @return El estado actual de la mesa.
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * Marca la mesa como asignada (ocupada).
     * <p>
     * Cambia el estado de la mesa a {@code true}, indicando que está en uso.
     * </p>
     */
    public void assignedTable(){
        this.status = false;
    }

    /**
     * Marca la mesa como libre.
     * <p>
     * Cambia el estado de la mesa a {@code false}, indicando que está disponible para nuevas reservas.
     * </p>
     */
    public void releaseTable(){
        this.status = true;
    }
}
