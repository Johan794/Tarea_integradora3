package model;

public abstract class Coach extends Employee {

    private int experienceYears;


    /**
     * Constructor of the object Coach <br>
     * @param name , the name of the coach
     * @param id , the id 
     * @param salary . the salary
     * @param experienceYears , the experience years
     */
    public Coach(String name, String id, double salary, int experienceYears) {
        super(name, id, salary);
        this.experienceYears = experienceYears;

    }

    public int getExperienceYears() {
        return experienceYears;
    }

   


    /**
     * Method: infoEmployee <br>
     * This method let the user know all the information of this employee <br>
     * <b> pre: <br>
     * <b> pos: <br>
     * @return String , with all the info of the employee
     */
    @Override
    public String infoEmployee() {
        return super.infoEmployee();
    }

    

}
