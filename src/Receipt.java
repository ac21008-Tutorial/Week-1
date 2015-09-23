import java.util.Date;

public class Receipt {

    public final int id;
    public String name;
    public Date time;
    public String description;
    public double total;

    public Receipt() {
        this.id = -1;
    }

    public Receipt(int id) {
        this.id = id;
    }

    public Receipt(int id, String name, Date time, String description, double total) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.description = description;
        this.total = total;
    }

    public String toString() {
        return "Receipt[" + id + "/" + name + "/" + total +"/" + time + "]";
    }

}
