package model;

/**
 * description of class Employee 
 *
 * @author grid24
 * @version 
 */
public abstract class Employee {
    private String name;
    private String id;
    private double salary;
    
    private Status employeeStatus;

    //corregir la parte del Emun;
    public Employee(String name, String id, double salary, String status){
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.employeeStatus = employeeStatus;
    }

    
}
