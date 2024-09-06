package logic;

public class Tables {
    private int id;
    private int capacity;
    private boolean status;

    public Tables(int id, int capacity){
        this.id = id;
        this.capacity = capacity;
        this.status = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean getStatus() {
        return status;
    }


    public void assignedTable(){
        this.status = true;
    }

    public void releaseTable(){
        this.status = false;
    }
}
