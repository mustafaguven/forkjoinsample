package main;

public class Invoice {

    private final int id;
    private final String name;
    private InvoiceState state;

    public Invoice(int id, String name, InvoiceState state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public InvoiceState getState() {
        return state;
    }

    @Override
    public String toString() {
        return "main.Invoice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
