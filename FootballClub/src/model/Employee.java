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

   
    public Employee(String name, String id, double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.employeeStatus = Status.ACTIVE;
        
    }

    public Status getStatus(){
        return employeeStatus;
    }
    
    public String getName() {
        return name;
    }

   
    public String getId() {
        return id;
    }

    
    public double getSalary() {
        return salary;
    }
    
    public void setEmployeeStatus(String newStatus) {
        this.employeeStatus = Status.valueOf(newStatus);
    }
    /**
     * Method: infoEmployee <br>
     * This method let the user know all the information of this employee <br>
     * <b> pre: <br>
     * <b> pos: <br>
     * @return String , with all the info of the employee
     */
    public String infoEmployee(){
        String info="";
        info+="[*] Employee's name: "+name+"\n"+
              "[*] Employee's id: "+id+"\n"+
              "[*] Employee's current Salary: "+salary+"\n"+
              "[*] Employee's satus: "+employeeStatus.toString()+"\n";
        return info;
    }

    
}
