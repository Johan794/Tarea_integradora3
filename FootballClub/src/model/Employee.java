package model;

/**
 * description of class Employee 
 *
 * @author Johan Ricardo
 * @version 
 */
public abstract class Employee {
    private String name;
    private String id;
    private double salary;
    
    private Status employeeStatus;

    //corregir la parte del Emun;
    public Employee(String name, String id, double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.employeeStatus = Status.ACTIVE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Status getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String newStatus) {
        this.employeeStatus = Status.valueOf(newStatus);
    }

    public String infoEmployee(){
        String info="";
        info+="[*] Employee's name: "+name+"\n"+
              "[*] Employee's id: "+id+"\n"+
              "[*] Employee's current Salary: "+salary+"\n"+
              "[*] Employee's satus: "+employeeStatus.toString()+"\n";
        return info;
    }

    
}
