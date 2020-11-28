package model;
import java.util.ArrayList;

public class Club {
    private String name;
    private String nit;
    private String creationDate;

    private Office offices[][];
    private DressingRoom dressingRooms[][];
    private ArrayList<Employee> employees;

    public Club(String name, String nit, String creationDate) {
        this.name = name;
        this.nit = nit;
        this.creationDate = creationDate;
        offices= new Office[6][6];
        dressingRooms = new DressingRoom[7][6];
    }

    
}
