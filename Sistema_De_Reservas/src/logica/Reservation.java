package logica;

public class Reservation {
    private String hour;
    private String date;
    private int assignedTable;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAssignedTable() {
        return assignedTable;
    }

    public void setAssignedTable(int assignedTable) {
        this.assignedTable = assignedTable;
    }

    public void confirmReservation() {}

    public void cancelReservation() {}

}
