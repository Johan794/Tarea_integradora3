package model;

public abstract class Coach extends Employee{
   
    private int experienceYears;

    public Coach(String name, String id, double salary, String status, int experienceYears){
        super(name, id, salary, status);
        this.experienceYears=experienceYears;

    }

    /**
     * @return int return the experienceYears
     */
    public int getExperienceYears() {
        return experienceYears;
    }

    /**
     * @param experienceYears the experienceYears to set
     */
    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

}
